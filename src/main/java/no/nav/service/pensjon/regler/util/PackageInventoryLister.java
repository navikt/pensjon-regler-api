package no.nav.service.pensjon.regler.util;

import no.nav.domain.pensjon.regler.GuiPrompt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.*;

/**
 * List all classes in a given package and subpackages.
 * For each class list all public properties (get/set methods).
 *
 * Ref. https://dzone.com/articles/get-all-classes-within-package
 */
public class PackageInventoryLister {

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws java.io.IOException
     */
    private static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        List<Class> classes = new ArrayList<Class>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

/**
    private static TreeSet<String> findProperties(Class clz){
        TreeSet<String> props = new TreeSet<String>();
        //List<Method> methods = Arrays.asList(clz.getMethods());
        List<Method> methods = Arrays.asList(clz.getDeclaredMethods());
        for (Method m : methods){
            String name = m.getName();
            if (name.startsWith("get") && name.compareTo("getClass") != 0){
                Class cl = m.getReturnType();
                props.add(cl.getSimpleName() + " " + name.substring(3));
            } else if (name.startsWith("is")){
                Class cl = m.getReturnType();
                props.add(cl.getSimpleName() + " " + name.substring(2));
            } else if (name.startsWith("set")){
                Class[] cl = m.getParameterTypes();
                props.add(cl[0].getSimpleName() + " " + name.substring(3));
            }
        }
        return props;
    }

    public void dumpDomainContents() {
        try {
            List<Class> classes = this.getClasses("no.nav.domain.pensjon.regler");
            Collections.sort(classes, new Comparator<Class>() {
                @Override
                public int compare(Class object1, Class object2) {
                    return object1.getSimpleName().compareTo(object2.getSimpleName());
                }
            });
            for (Class c : classes){
                String name = c.getSimpleName();
                /**
                 * Alle domain klasser som ikke er interface, abstract,
                 * exception, test, cti

                if (!Modifier.isAbstract(c.getModifiers())
                        && !Modifier.isInterface(c.getModifiers())
                        && !Exception.class.isAssignableFrom(c)
                        && name != null
                        && name != ""
                        && !name.endsWith("Test")
                        && !name.endsWith("Cti")) {
                    TreeSet<String> props = findProperties(c);
                    if (!props.isEmpty()) {
                        System.out.println(name + " : ");
                        Iterator<String> iter = props.iterator();
                        while (iter.hasNext()){
                            String prop = iter.next();
                            if (!prop.endsWith("AsArray")
                                    && prop.indexOf("PREG_") < 0) {
                                System.out.println("    " + prop);
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
**/

    /**
     * Get all public properties (get/set/is) of a domain class.
     * Inherited properties are included.
     * Omits PREG_ and AsArray properties.
     *
     * @param clz
     * @param element
     */
    private void findProperties(Class clz, PackageInventoryElement element){
        //List<Method> methods = Arrays.asList(clz.getDeclaredMethods());
        List<Method> methods = Arrays.asList(clz.getMethods());
        for (Method m : methods){
            String name = m.getName();
            if (name.startsWith("get")
                    && name.compareTo("getClass") != 0
                    && !name.endsWith("AsArray")
                    && name.indexOf("PREG_") < 0){
                Class cl = m.getReturnType();
                PackageInventoryProperty prop = new PackageInventoryProperty();
                prop.propertyNavn = name.length() > 4 ? name.substring(3,4).toLowerCase() + name.substring(4) : name.substring(3).toLowerCase();
                prop.propertyType = cl.getSimpleName();
                prop.propertyClass = cl;
                prop.prompt = prop.propertyNavn;
                element.properties.add(prop);
            } else if (name.startsWith("is")
                    && name.indexOf("PREG_") < 0){
                Class cl = m.getReturnType();
                PackageInventoryProperty prop = new PackageInventoryProperty();
                prop.propertyNavn = name.length() > 3 ? name.substring(2,3).toLowerCase() + name.substring(3) : name.substring(2).toLowerCase();
                prop.propertyType = cl.getSimpleName();
                prop.propertyClass = cl;


                prop.prompt = prop.propertyNavn;
                element.properties.add(prop);
            } else if (name.startsWith("set")
                    && name.indexOf("PREG_") < 0){
                Class[] cl = m.getParameterTypes();
                PackageInventoryProperty prop = new PackageInventoryProperty();
                prop.propertyNavn = name.length() > 4 ? name.substring(3,4).toLowerCase() + name.substring(4) : name.substring(3).toLowerCase();
                prop.propertyType = cl[0].getSimpleName();
                prop.propertyClass = cl[0];
                prop.prompt = prop.propertyNavn;
                element.properties.add(prop);
            }
        }
    }

    /**
     * If class property has custom annotation @GuiPrompt
     * then assign the annotation string value to prompt.
     *
     * @param clz
     * @param element
     */
    private void findPrompt(Class clz, PackageInventoryElement element) {
        List<Field> fields = Arrays.asList(clz.getDeclaredFields());
        for (Field f : fields) {
            String name = f.getName();
            if (f.getAnnotation(GuiPrompt.class) != null) {
                String prompt = f.getAnnotation(GuiPrompt.class).prompt();
                Iterator<PackageInventoryProperty> iterator = element.properties.iterator();
                while (iterator.hasNext()) {
                    PackageInventoryProperty property = iterator.next();
                    if (property.propertyNavn.compareTo(name) == 0) {
                        property.prompt = prompt;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Get a list of all domain classes and their properties.
     * Does not include classes that are of type interface,
     * abstract, exception, test, cti or belongs to
     * package no.nav.domain.pensjon.regler.beregning.penobjekter.
     *
     * @param pakkeNavn
     * @return
     */
    public List<PackageInventoryElement> getPackageInventoryList(String pakkeNavn) {
        try {
            List<PackageInventoryElement> retval = new ArrayList<PackageInventoryElement>();
            List<Class> classes = this.getClasses(pakkeNavn);
            Collections.sort(classes, new Comparator<Class>() {
                @Override
                public int compare(Class object1, Class object2) {
                    return object1.getSimpleName().compareTo(object2.getSimpleName());
                }
            });
            for (Class c : classes){
                String klassname = c.getSimpleName();

                if (!Modifier.isAbstract(c.getModifiers())
                        && !Modifier.isInterface(c.getModifiers())
                        && !Exception.class.isAssignableFrom(c)
                        && c.getPackage().getName().compareTo("no.nav.domain.pensjon.regler.beregning.penobjekter") != 0
                        && klassname != null
                        && klassname != ""
                        && !klassname.endsWith("Test")
                        && !klassname.endsWith("Cti")) {
                    PackageInventoryElement element = new PackageInventoryElement();
                    element.klasseNavn = klassname;
                    findProperties(c, element);
                    if (!element.properties.isEmpty()) {
                        findPrompt(c, element);
                        retval.add(element);
                    }
                }
            }
            return retval;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
