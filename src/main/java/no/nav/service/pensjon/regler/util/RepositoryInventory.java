package no.nav.service.pensjon.regler.util;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Look up source files in a Blaze Advisor rule repository and create a collection
 * of metadata for all source files found. Significant source files are for now
 * of types: ruleset, ruleflow, function, class and proejct. Source files that are
 * instances of an RMA template are skipped. BrUnit tests are also skipped.
 *
 * @author Steinar Hjellvik (Decisive AS)
 */
public class RepositoryInventory {
    private static String xmlDecl = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n";
    private String[] excludeDirs = {"prepo\\nav-pensjon-test", "prepo\\system", "prepo\\nav-pensjon-komponenttest"};
    public TreeSet<RepositoryElement> repositoryElements;
    public HashMap<File, RepositoryElement> projectMap;
    private FileFilter getOnlyFiles;
    private FileFilter getOnlyDirs;

    public RepositoryInventory() throws IOException{
        this.repositoryElements = new TreeSet<RepositoryElement>(new Comparator<RepositoryElement>() {
            @Override
            public int compare(RepositoryElement p1, RepositoryElement p2) {
                if (p1.guid != null && p2.guid != null) {
                    return p1.guid.compareTo(p2.guid);
                } else return -1;
            }
        });
        this.projectMap = new HashMap<File, RepositoryElement>();
        getOnlyFiles = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };
        getOnlyDirs = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory()){
                    for (String exclude : excludeDirs){
                        if (pathname.getPath().contains(exclude)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        };
    }

    /**
     * Recursive method to read all source files in a rule repository file system.
     * Uses prefix traversal: process files first, then subdirectories.
     *
     * @param file
     * @throws IOException
     */
    public void findRepositoryElements(File file) throws IOException {
        if (!file.isDirectory()) {
            if (file.getName().endsWith(".innovator_attbs")){
                processSourceFile(file);
                return;
            }
        } else {
            File[] list = file.listFiles(getOnlyFiles);
            if (list != null) {
                for (File f : list) {
                    findRepositoryElements(f);
                }
            }
            list = file.listFiles(getOnlyDirs);
            if (list != null) {
                for (File f : list) {
                    findRepositoryElements(f);
                }
            }
        }
        return;
    }

    /**
     * Process source files found:
     * - read properties from .innovator_attbs file
     * - determine source category
     * - find which project it belongs to
     * - add to collection of repository elements only if:
     *      -- not BrUnit (testRole is false)
     *      -- not template instance (contentType is fixed)
     *      -- and has both a guid and type (excludes directories).
     * @param sourceFile
     * @throws IOException
     */
    private void processSourceFile(File sourceFile)
            throws IOException {
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream(sourceFile), Charset.forName("UTF-8")));
        RepositoryElement element = readInnovatorAttributeFile(sourceFile, properties);
        findSourceCategory(element);
        if (element.sourceType != null
                && element.sourceType == RepositoryElement.SourceCategory.PROJECT){
            this.projectMap.put(element.file.getParentFile(), element);
        } else {
            findProject(element);
        }
        if (element.guid != null
                && element.type != null
                && element.contentType.compareTo("Fixed") == 0
                && element.testRole == false
                && isSystemElement(properties) == false) {
            repositoryElements.add(element);
        }
    }

    /**
     * Parse an innovator_attbs file and populate a RepositoryElement
     * with the information found.
     *
     * @param file
     * @throws IOException
     */
    private RepositoryElement readInnovatorAttributeFile(File file, Properties properties) {

        RepositoryElement element = new RepositoryElement();
        element.guid = properties.getProperty("guid");
        element.fileName = file.getName().replaceAll(".innovator_attbs", "");
        element.file = new File(file.getAbsolutePath().replaceAll(".innovator_attbs", ""));
        element.dirName = file.getParent();
        element.ideName = properties.getProperty("innovatorDisplayName");
        element.type = properties.getProperty("type");
        element.contentType = properties.getProperty("contentType");
        String testRole = properties.getProperty("managementProperty.Test Role");
        if (testRole != null && (testRole.compareTo("Test") == 0 || testRole.compareTo("SetUp") == 0)) {
            element.testRole = true;
        }
        return element;
    }

    /**
     * Identify elements in the repository system directory.
     *
     * @param properties
     * @return
     */
    private boolean isSystemElement(Properties properties) {
        String isSystemDir = properties.getProperty("isSystemDirectory");
        boolean isSystemElement = false;
        if (isSystemDir != null && isSystemDir.compareTo("true") == 0){
            isSystemElement = true;
        }
        String isSystemTemplate = properties.getProperty("isSystemTemplate");
        if (isSystemTemplate != null && isSystemTemplate.compareTo("true") == 0){
            isSystemElement = true;
        }
        return isSystemElement;
    }

    /**
     * Identify significant source types:
     *  - Ruleset
     *  - Function
     *  - Class
     *  - Ruleflow
     *  - Project
     *
     * @param element
     */
    private void findSourceCategory(RepositoryElement element) {
        if (element.type != null) {
            if (element.type.compareTo("SRL Ruleset") == 0) {
                element.sourceType = RepositoryElement.SourceCategory.RULESET;
            } else if (element.type.compareTo("SRL Function") == 0) {
                element.sourceType = RepositoryElement.SourceCategory.FUNCTION;
            } else if (element.type.compareTo("SRL Class") == 0) {
                element.sourceType = RepositoryElement.SourceCategory.CLASS;
            } else if (element.type.compareTo("Ruleflow") == 0) {
                element.sourceType = RepositoryElement.SourceCategory.RULEFLOW;
            } else if (element.type.compareTo("Project") == 0) {
                element.sourceType = RepositoryElement.SourceCategory.PROJECT;
            }
        }
    }

    /**
     * Try to find project element that this element belongs to by
     * matching parent directory of element and project.
     *
     * @param element
     */
    private void findProject(RepositoryElement element){
        if (element.file != null){
            File parentDir = element.file.getParentFile();
            element.project = this.projectMap.get(parentDir);
            while (element.project == null && parentDir != null) {
                parentDir = parentDir.getParentFile();
                element.project = this.projectMap.get(parentDir);
            }
        }
    }

    public int findRepositoryUsage(File file, RepositoryElement element){
        int retval = 0;

        if (!file.isDirectory()){
            if (!file.getName().endsWith(".innovator_attbs")
                    && file.getName().compareTo(element.fileName) != 0){
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
                    String line;
                    do {
                        line = reader.readLine();
                        if (line != null && line.indexOf(element.ideName) > 0){
                            retval += 1;
                            break;
                        }
                    } while (line != null);
                    reader.close();
                } catch (FileNotFoundException ex){

                } catch (IOException ex){

                }
            }
        } else {
            File[] list = file.listFiles();
            if (list != null){
                for (File f : list){
                    retval += findRepositoryUsage(f, element);
                }
            }
        }
        return retval;
    }

    public void outputInventory(Object obj) {
        BufferedWriter out = null;
        try {
            XStream xstream = new XStream();
            xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
            String xml = xmlDecl + xstream.toXML(obj);
            File tempfile = File.createTempFile("Repository_inventory", ".xml");
            out = new BufferedWriter(new FileWriter(tempfile));
            out.write(xml);
            out.close();
            System.out.println("Wrote " + tempfile.getPath());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            RepositoryInventory inventory = new RepositoryInventory();
            //inventory.findRepositoryElements(inventory.repositoryRootDirectory);
            Iterator<RepositoryElement> iterator = inventory.repositoryElements.iterator();
            while (iterator.hasNext()){
                RepositoryElement element = iterator.next();
                //System.out.println(element.srlName + " " + element.srlType);
                if (element.type.compareTo("SRL Ruleset") == 0
                        || element.type.compareTo("SRL Function") == 0){
              //      int use = inventory.findRepositoryUsage(inventory.repositoryRootDirectory, element);
              //      System.out.println(element.type + " " + element.ideName + " Usage = " + use);
                }
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
