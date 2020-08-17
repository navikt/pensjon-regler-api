package no.nav.service.pensjon.regler.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Generate html documentation similar to javadoc for a Blaze Advisor repository.
 * Uses XSLT to transform the Blaze Advisor source files to html. Generates
 * documentation for the following source file types: ruleset, function,
 * class, ruleflow.
 *
 * @author Steinar Hjellvik (Decisive AS)
 */
public class BlazeDoc {

    private final String srlXslFilename = "Srl2Html.xsl";
    private final String flowXslFilename = "Flow2Html.xsl";
    private final String projXslFilename = "Proj2Html.xsl";
    private final String projectsFrameXslFilename = "ProjectsFrame.xsl";
    private final String overviewFrameXslFilename = "OverviewSummary.xsl";
    private final String elementsFrameXslFilename = "ElementsFrame.xsl";
    private Transformer srlTransformer = null;
    private Transformer flowTransformer = null;
    private Transformer projTransformer = null;
    private TransformerFactory transfact;
    private List<RepositoryElement> projectList;
    private List<RepositoryElement> elementList;
    private File documentationRoot;
    private File typeLookupFile;

    public BlazeDoc()
            throws TransformerConfigurationException, IOException
    {
        System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
        transfact = TransformerFactory.newInstance();
        srlTransformer = initTransformer(srlXslFilename);
        flowTransformer = initTransformer(flowXslFilename);
        projTransformer = initTransformer(projXslFilename);
        projectList = new ArrayList<RepositoryElement>();
        elementList = new ArrayList<RepositoryElement>();
    }

    private Transformer initTransformer(String xslFilename)
            throws TransformerConfigurationException, IOException {
        InputStream xsltFile = null;
        try {
            xsltFile = new ClassPathResource(xslFilename).getInputStream();
            Source xsltSource = new StreamSource(xsltFile);
            return transfact.newTransformer(xsltSource);
        } catch (TransformerConfigurationException ex){
            System.err.println("XSLT problem with file: " + xslFilename);
            ex.printStackTrace();
            throw(ex);
        } catch (IOException ex){
            System.err.println("Problems opening XSLT file: " + xslFilename);
            ex.printStackTrace();
            throw(ex);
        }
    }

    private Transformer getTransformer(RepositoryElement.SourceCategory sourceType)
    {
        if (sourceType == RepositoryElement.SourceCategory.RULESET
                || sourceType == RepositoryElement.SourceCategory.FUNCTION
                || sourceType == RepositoryElement.SourceCategory.CLASS) {
            return srlTransformer;
        } else if (sourceType == RepositoryElement.SourceCategory.RULEFLOW) {
            return flowTransformer;
        } else if (sourceType == RepositoryElement.SourceCategory.PROJECT) {
            return projTransformer;
        } else {
            return null;
        }
    }

    /**
     * Output html files for repository elements are put in subfolders
     * according to project name.
     *
     * @param element
     * @return
     */
    private File getDestinationFile(RepositoryElement element){
        File destDir;
        if (element.sourceType == RepositoryElement.SourceCategory.PROJECT) {
            destDir = new File(this.documentationRoot + "\\" + element.ideName);
        } else if (element.project != null){
            destDir = new File(this.documentationRoot + "\\" + element.project.ideName);
        } else {
            destDir = new File(this.documentationRoot + "\\");
        }
        if (!destDir.exists()){
            boolean created = destDir.mkdir();
        }
        File destFile = new File(destDir.getAbsolutePath() + "\\" + element.ideName + ".html");
        return destFile;
    }

    /**
     * Produce html documentation for a repository element.
     *
     * @param element
     * @return
     */
    private File element2html(RepositoryElement element)
    {
        try {
            Source xmlSource = new StreamSource(element.file.toURI().toString());
            File destFile = getDestinationFile(element);
            Result xmlDestination = new StreamResult(destFile.toURI().toString());
            Transformer transformer = getTransformer(element.sourceType);
            if (transformer != null) {
                if (element.sourceType == RepositoryElement.SourceCategory.PROJECT) {
                    transformer.setParameter("projectName", element.ideName);
                } else {
                    transformer.setParameter("typeLookupFile", typeLookupFile.toURI().toString());
                }
                transformer.transform(xmlSource, xmlDestination);
            }
            return destFile;
        } catch (TransformerException e) {
            System.err.println("Problems transforming file:" + element.file.getAbsolutePath());
        }
        return null;
    }

    /**
     * Produce content file for the project list frame (top left frame).
     *
     * @param projectList
     * @throws IOException
     * @throws TransformerException
     */
    private void projectList2html(List<RepositoryElement> projectList)
            throws IOException, TransformerException {
        StringBuilder buf = new StringBuilder();
        buf.append("<list>");
        for (RepositoryElement element : projectList){
            buf.append("<project>" + element.ideName + "</project>");
        }
        buf.append("</list>");
        Source xmlSource = new StreamSource(new StringReader(buf.toString()));
        File destFile = new File(this.documentationRoot + "\\projects-frame.html");
        Result xmlDestination = new StreamResult(destFile.toURI().toString());
        Transformer transformer = initTransformer(projectsFrameXslFilename);
        transformer.transform(xmlSource, xmlDestination);
    }

    /**
     * Produce content file for the overview frame (right frame).
     *
     * @param projectList
     * @throws IOException
     * @throws TransformerException
     */
    private void overview2html(List<RepositoryElement> projectList)
            throws IOException, TransformerException {
        StringBuilder buf = new StringBuilder();
        buf.append("<list>");
        for (RepositoryElement element : projectList){
            buf.append("<project>");
            buf.append("<name>" + element.ideName + "</name>");
            buf.append("<directory>" + element.dirName + "</directory>");
            buf.append("</project>");
        }
        buf.append("</list>");
        Source xmlSource = new StreamSource(new StringReader(buf.toString()));
        File destFile = new File(this.documentationRoot + "\\overview-summary.html");
        Result xmlDestination = new StreamResult(destFile.toURI().toString());
        Transformer transformer = initTransformer(overviewFrameXslFilename);
        transformer.transform(xmlSource, xmlDestination);
    }

    /**
     * Produce content file for the element list frame (bottom left frame).
     *
     * @param elementList
     * @throws IOException
     * @throws TransformerException
     */
    private void elementList2html(List<RepositoryElement> elementList)
            throws IOException, TransformerException {
        StringBuilder buf = new StringBuilder();
        buf.append("<list>");
        for (RepositoryElement element : elementList) {
            buf.append("<element type='");
            buf.append(element.sourceType.name());
            if (element.project != null) {
                buf.append("' project='");
                buf.append(element.project.ideName);
            }
            buf.append("'>");
            buf.append(element.ideName);
            buf.append("</element>");
        }
        buf.append("</list>");
        Source xmlSource = new StreamSource(new StringReader(buf.toString()));
        File destFile = new File(this.documentationRoot + "\\elements-frame.html");
        Result xmlDestination = new StreamResult(destFile.toURI().toString());
        Transformer transformer = initTransformer(elementsFrameXslFilename);
        transformer.transform(xmlSource, xmlDestination);
    }

    /**
     * Output xml file for looking up element types and the project
     * the type belongs to.
     *
     * @param elementList
     * @throws IOException
     */
    private void outputElementList(List<RepositoryElement> elementList)
        throws IOException
    {
        StringBuilder buf = new StringBuilder();
        buf.append("<elementlist>\n");
        for (RepositoryElement element : elementList) {
            buf.append("<element type='");
            buf.append(element.sourceType.name());
            if (element.project != null) {
                buf.append("' project='");
                buf.append(element.project.ideName);
            }
            buf.append("'>");
            buf.append(element.ideName);
            buf.append("</element>\n");
        }
        buf.append("</elementlist>\n");

        typeLookupFile = new File(this.documentationRoot + "\\elements-list.xml");
        FileChannel fc = new FileOutputStream(typeLookupFile).getChannel();
        fc.write(ByteBuffer.wrap(buf.toString().getBytes(Charset.forName("UTF-8"))));
        fc.close();
    }

    /**
     * Generate HTML documentation to given output directory for a rule repository starting with
     * given repository root directory.
     *
     * @param repoRoot
     * @param outputDirectory
     * @throws IOException
     */
    public void generateDocumentation(File repoRoot, File outputDirectory)
            throws IOException, TransformerException, InvocationTargetException {
        this.documentationRoot = outputDirectory;
        if (!documentationRoot.exists()){
            boolean created = documentationRoot.mkdir();
            //System.out.println("Created output dir: " + created);
        }
        RepositoryInventory inventory = new RepositoryInventory();
        inventory.findRepositoryElements(repoRoot);
        inventory.outputInventory(inventory);
        Iterator<RepositoryElement> iterator = inventory.repositoryElements.iterator();

        while (iterator.hasNext()) {
            RepositoryElement element = iterator.next();
            if (element.sourceType == RepositoryElement.SourceCategory.PROJECT){
                projectList.add(element);
            } else if (element.sourceType != null){
                elementList.add(element);
            }
        }

        Collections.sort(projectList);
        projectList2html(projectList);
        overview2html(projectList);

        Collections.sort(elementList);
        elementList2html(elementList);
        outputElementList(elementList);

        iterator = inventory.repositoryElements.iterator();

        while (iterator.hasNext()){
            RepositoryElement element = iterator.next();
            File outFile = element2html(element);
            final String output;
            if (outFile != null) {
                output = "Wrote " + outFile.getAbsolutePath() + "\n";
            } else {
                output = "Failed to transform " + element.ideName + "\n";
            }
            System.out.println(output);
        }

        FileCopyUtils.copy(new BufferedInputStream(new ClassPathResource("index.html").getInputStream()),
                new BufferedOutputStream(new FileOutputStream(new File(outputDirectory + "\\index.html"))));
        FileCopyUtils.copy(new BufferedInputStream(new ClassPathResource("stylesheet.css").getInputStream()),
                new BufferedOutputStream(new FileOutputStream(new File(outputDirectory + "\\stylesheet.css"))));
    }

    public static void main(String[] args)
            throws Exception {

        if (args.length != 2) {
            System.out.println("Usage: BlazeDoc <blazeRepositoryPath> <outputPath>");
            System.exit(-1);
        } else {
            File repo = new File(args[0]);
            if (!repo.exists()) {
                System.out.println("Repository path does not exist: " + repo.getAbsolutePath());
                System.exit(-1);
            }
            BlazeDoc doc = new BlazeDoc();
            //doc.generateDocumentation(new File(".\\repository\\prepo\\nav-pensjon-teknisk\\nav-pensjon-regler-arligopptjening-tek"),
            //doc.generateDocumentation(new File(".\\repository\\prepo"), new File(System.getenv("TEMP") + "\\BlazeDoc"));
            doc.generateDocumentation(repo, new File(args[1]));
        }
    }
}
