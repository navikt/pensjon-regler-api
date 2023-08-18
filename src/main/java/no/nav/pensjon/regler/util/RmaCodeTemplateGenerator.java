package no.nav.pensjon.regler.util;

import no.nav.pensjon.regler.domain.kode.TypeCti;

import java.io.*;
import java.util.*;

/**
 * Created by H116437 on 27.11.2015.
 */
public class RmaCodeTemplateGenerator {

    private PackageInventoryLister packageInventoryLister;
    private List<PackageInventoryElement> domainElements;
    private List<PackageInventoryElement> requestResponseElements;
    private Map<String, String> guidMap;
    private File rmaRootDirectory;


    public RmaCodeTemplateGenerator() {
        this.packageInventoryLister =  new PackageInventoryLister();
        this.domainElements = packageInventoryLister.getPackageInventoryList("no.nav.domain.pensjon.regler");
        this.requestResponseElements = packageInventoryLister.getPackageInventoryList("no.nav.service.pensjon.regler.to");
        this.guidMap = new HashMap<String, String>();
        this.rmaRootDirectory =  new File("C:\\data\\preg\\repository\\prepo\\nav-pensjon-test\\nav-pensjon-regler-rma-templates-test");
    }

    /**
     * Lag standard innledende xml for en code template.
     *
     * @param element
     * @return
     */
    private String getStandardPreamble(PackageInventoryElement element){
        StringBuilder preamble = new StringBuilder();

        preamble.append("<?xml version='1.0' encoding='UTF-8'?>\n");
        preamble.append("<template xmlns='http://www.blazesoft.com/template' name='" + element.klasseNavn + " Code Template'>\n");
        preamble.append(" <ide-name>" + element.klasseNavn + " Code Template</ide-name>\n");
        preamble.append(" <display-name>" + element.klasseNavn + "</display-name>\n");
        preamble.append(" <instantiation xmlns='http://www.blazesoft.com/instantiation' template='1ryqjy2wlawpW8dy391IVawONdo' name='Template' id='Template'>\n");
        preamble.append(" </instantiation>\n");
        preamble.append(" <instantiation xmlns='http://www.blazesoft.com/instantiation' template='18uqQPJXnTmKrAiLEOVcQMUAFmD' name='Entry' id='Entry'>\n");
        preamble.append("  <instance ref='Source Reference'>\n");
        preamble.append("   <instance ref='value'>\n");
        preamble.append("    <instance ref='locationVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("    <instance ref='repositoryNameVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("    <instance ref='versionVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("    <instance ref='filterVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("    <instance ref='releaseDateVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("    <instance ref='repositoryAccessVH'>\n");
        preamble.append("     <value></value>\n");
        preamble.append("    </instance>\n");
        preamble.append("   </instance>\n");
        preamble.append("  </instance>\n");
        preamble.append("  <instance ref='Simulation Role'>\n");
        preamble.append("   <instance ref='value'>\n");
        preamble.append("    <value><![CDATA[<None>]]></value>\n");
        preamble.append("   </instance>\n");
        preamble.append("  </instance>\n");
        preamble.append(" </instantiation>\n");

        return preamble.toString();
    }


    /**
     * Lag xml for deklarasjon av value holders.
     *
     * @param element
     * @return
     */
    private String getValueHolders(PackageInventoryElement element){
        StringBuilder valueHolders = new StringBuilder();

        valueHolders.append(" <parameters>\n");
        Iterator<PackageInventoryProperty> iterator = element.properties.iterator();
        while (iterator.hasNext()){
            PackageInventoryProperty property = iterator.next();
            String vhName = property.propertyNavn + "VH";
            String vhType = property.propertyType;
            if (isPrimitiveOrWrapper(property.propertyClass)
                    || Date.class.isAssignableFrom(property.propertyClass)){
                if (vhType.compareTo("int") == 0) {
                    vhType = "integer";
                } else if (vhType.compareTo("Integer") == 0){
                    vhType = "integer";
                } else if (vhType.compareTo("long") == 0){
                    vhType = "integer";
                } else if (vhType.compareTo("Long") == 0){
                    vhType = "integer";
                } else if (vhType.compareTo("Date") == 0){
                    vhType = "date";
                } else if (vhType.compareTo("double") == 0) {
                    vhType = "real";
                } else if (vhType.compareTo("Double") == 0){
                    vhType = "real";
                } else if (vhType.compareTo("Boolean") == 0) {
                    vhType = "boolean";
                } else if (vhType.compareTo("boolean") == 0) {
                    vhType = "boolean";
                }
            } else if (TypeCti.class.isAssignableFrom(property.propertyClass)){
                vhType = "";
            } else {
                String guid = guidMap.get(property.propertyType);
                if (guid != null){
                    valueHolders.append("  <parameter-list name='" + vhName + "' type='" + guid + "' ideName='" + vhName + "' min='0' max='1'>\n");
                    valueHolders.append("   <dynamic-arg name='requestVH' ref='requestVH' relative='false'/>");
                    valueHolders.append("  </parameter-list>\n");
                    continue;
                } else {
                    vhType = "";
                }
            }
            valueHolders.append("  <parameter-list name='" + vhName + "' type='" + vhType + "' ideName='" + vhName + "' min='0' max='1'>\n");
            valueHolders.append("  </parameter-list>\n");
        }
        String reqType = "";
        String respType = "";
        String guid = guidMap.get(element.klasseNavn);
        if (guid != null){
            reqType = guid + ".template1";
            respType = guid + ".template2";
        }
        valueHolders.append("  <parameter name='requestCodeVH' type='" + reqType + "' ideName='requestCodeVH'>\n");
        valueHolders.append("  </parameter>\n");
        valueHolders.append("  <parameter name='responseCodeVH' type='" + respType + "' ideName='responseCodeVH'>\n");
        valueHolders.append("  </parameter>\n");
        valueHolders.append("  <parameter-noninstantiable name='requestVH' type='boolean' mechanism='argument' repeatable='false' ideName='requestVH'>\n");
        valueHolders.append("  </parameter-noninstantiable>\n");
        valueHolders.append(" </parameters>\n");
        valueHolders.append(" <family>Code Template</family>\n");

        return valueHolders.toString();
    }


    /**
     * Lag xml for srl seksjon av code template.
     *
     * @param element
     * @return
     */
    private String getSrlSection(PackageInventoryElement element){
        StringBuilder srlSection = new StringBuilder();

        //srlSection.append("\n\nSRL SECTION:\n\n");

        srlSection.append(" <template:content xmlns:template='http://www.blazesoft.com/template' xmlns='http://www.blazesoft.com/srl' section='srl'>");
        srlSection.append("// START: " + element.klasseNavn + " Code Template\n");
        srlSection.append("<template:br/><template:if>\n");
        srlSection.append("<template:test><template:placeholder ref='requestVH' relative='false'/> = true</template:test>\n");
        srlSection.append("<template:then><template:placeholder ref='requestCodeVH' relative='false'/></template:then>\n");
        srlSection.append("</template:if>\n");
        srlSection.append("<template:br/><template:if>\n");
        srlSection.append("<template:test><template:placeholder ref='requestVH' relative='false'/> = false</template:test>\n");
        srlSection.append("<template:then><template:placeholder ref='responseCodeVH' relative='false'/></template:then>\n");
        srlSection.append("</template:if>");
        srlSection.append("<template:br/>");
        srlSection.append("// END: " + element.klasseNavn + " Code Template\n");
        srlSection.append(" </template:content>\n");

        return srlSection.toString();
    }

    /**
     * Lag xml for entity name del av code template.
     *
     * @param element
     * @return
     */
    private String getEntityName(PackageInventoryElement element){
        StringBuilder entityName = new StringBuilder();

        //entityName.append("\n\nENTITY NAME:\n\n");

        entityName.append(" <template:content xmlns:template='http://www.blazesoft.com/template' xmlns='' section='entity-name'>");
        entityName.append(element.klasseNavn);
        entityName.append("</template:content>\n");

        return entityName.toString();
    }

    /**
     * Lag xml for display delen av code template.
     *
     * @param element
     * @return
     */
    private String getDisplaySection(PackageInventoryElement element){
        StringBuilder displaySection = new StringBuilder();

        //displaySection.append("\n\nDISPLAY SECTION:\n\n");

        displaySection.append(" <template:content xmlns:template='http://www.blazesoft.com/template' xmlns='http://www.blazesoft.com/display' section='display'>");
        displaySection.append("<![CDATA[<h1>" + element.klasseNavn + "</h1>]]>\n");
        Iterator<PackageInventoryProperty> iterator = element.properties.iterator();
        while (iterator.hasNext()){
            PackageInventoryProperty property = iterator.next();
            displaySection.append("<template:br/><![CDATA[<div id=\"ledetekst\">"+ property.prompt + " :</div>");
            displaySection.append("<div id=\"inputfelt\">]]><placeholder ref='" + property.propertyNavn + "VH' relative='false'>\n");
            displaySection.append("<attribute>\n" +
                    "\t<attribute-name>none</attribute-name>\n" +
                    "\t<attribute-value>none</attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>rangeRole</attribute-name>\n" +
                    "\t<attribute-value>none</attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>style</attribute-name>\n" +
                    "\t<attribute-value>standardTextEdit</attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>readWriteProperty</attribute-name>\n" +
                    "\t<attribute-value>readNWrite</attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>selectionMethod</attribute-name>\n" +
                    "\t<attribute-value></attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>size</attribute-name>\n" +
                    "\t<attribute-value></attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>samePage</attribute-name>\n" +
                    "\t<attribute-value></attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>password</attribute-name>\n" +
                    "\t<attribute-value></attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>ref-type</attribute-name>\n" +
                    "\t<attribute-value>0</attribute-value>\n" +
                    "</attribute>\n" +
                    "<attribute>\n" +
                    "\t<attribute-name>linkSupport</attribute-name>\n" +
                    "\t<attribute-value></attribute-value>\n" +
                    "</attribute>\n" +
                    "</placeholder><![CDATA[</div><br/>]]>");
        }
        displaySection.append("</template:content>\n");

        return displaySection.toString();
    }

    /**
     * Bestem om klasse er en primitiv eller wrapper type.
     *
     * @param claz
     * @return
     */
    private boolean isPrimitiveOrWrapper(Class claz){
        return (claz.isPrimitive()
                || claz == Boolean.class
                || claz == Byte.class
                || claz == Character.class
                || claz == Integer.class
                || claz == Float.class
                || claz == Double.class
                || claz == Long.class
                || claz == Short.class);
    }

    /**
     * Lag request delen av en code template.
     *
     * @param element
     * @return
     */
    private String getRequestSrl(PackageInventoryElement element){
        StringBuilder requestSrl = new StringBuilder();

        //requestSrl.append("\n\nREQUEST SRL:\n\n");

        requestSrl.append(" <template name='template1'>\n");
        requestSrl.append("  <ide-name>Request Code Template</ide-name>\n");
        requestSrl.append("  <instantiation xmlns='http://www.blazesoft.com/instantiation' template='1ryqjy2wlawpW8dy391IVawONdo' name='Template' id='Template'>\n");
        requestSrl.append("  </instantiation>\n");
        requestSrl.append("  <family>Code Template</family>\n");
        requestSrl.append("  <template:content xmlns:template='http://www.blazesoft.com/template' xmlns='http://www.blazesoft.com/srl' section='srl'>");
        requestSrl.append(element.klasseNavn.toLowerCase() + " = a " + element.klasseNavn + " initially {\n");
        Iterator<PackageInventoryProperty> iterator = element.properties.iterator();
        while (iterator.hasNext()){
            PackageInventoryProperty property = iterator.next();
            if (isPrimitiveOrWrapper(property.propertyClass)) {
                requestSrl.append("<template:br/><template:tab/><template:if>\n");
                requestSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                requestSrl.append("<template:then>" + property.propertyNavn + " = <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>,</template:then>\n");
                requestSrl.append("</template:if>\n");
            } else if (Date.class.isAssignableFrom(property.propertyClass)){
                requestSrl.append("<template:br/><template:tab/><template:if>\n");
                requestSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                requestSrl.append("<template:then>" + property.propertyNavn + " = '<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>',</template:then>\n");
                requestSrl.append("</template:if>\n");
            } else if (TypeCti.class.isAssignableFrom(property.propertyClass)) {
                requestSrl.append("<template:br/><template:tab/><template:if>\n");
                requestSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                requestSrl.append("<template:then>" + property.propertyNavn + " = a " + property.propertyType + " initially { kode = <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/> as a string},</template:then>\n");
                requestSrl.append("</template:if>\n");
            }
        }
        requestSrl.append("<template:br/>};\n");

        iterator = element.properties.iterator();
        while (iterator.hasNext()){
            PackageInventoryProperty property = iterator.next();
            if (!isPrimitiveOrWrapper(property.propertyClass)
                    && !Date.class.isAssignableFrom(property.propertyClass)
                    && !TypeCti.class.isAssignableFrom(property.propertyClass)){
                requestSrl.append("<template:br/>\n");
                requestSrl.append("<template:br/>" + property.propertyType.toLowerCase() + " = null;\n");
                requestSrl.append("<template:br/><template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>\n");
                requestSrl.append("<template:br/>" + element.klasseNavn.toLowerCase() + "." + property.propertyNavn + " = " + property.propertyType.toLowerCase() + ";\n");
            }
        }
        requestSrl.append("  </template:content>\n");
        requestSrl.append(" </template>\n");

        return requestSrl.toString();
    }


    /**
     * Lag response delen av en code template.
     *
     * @param element
     * @return
     */
    private String getResponseSrl(PackageInventoryElement  element){
        StringBuilder responseSrl = new StringBuilder();

        //responseSrl.append("\n\nRESPONSE SRL:\n\n");

        responseSrl.append(" <template name='template2'>\n");
        responseSrl.append("  <ide-name>Response Code Template</ide-name>\n");
        responseSrl.append("  <instantiation xmlns='http://www.blazesoft.com/instantiation' template='1ryqjy2wlawpW8dy391IVawONdo' name='Template' id='Template'>\n");
        responseSrl.append("  </instantiation>\n");
        responseSrl.append("  <family>Code Template</family>\n");
        responseSrl.append("  <template:content xmlns:template='http://www.blazesoft.com/template' xmlns='http://www.blazesoft.com/srl' section='srl'>");
        responseSrl.append("Assert.assertTrue(\"" + element.klasseNavn + "\", " + element.klasseNavn.toLowerCase() + " is known and " + element.klasseNavn.toLowerCase() + " is not null);\n");
        responseSrl.append("<template:br/>\n");
        Iterator<PackageInventoryProperty> iterator = element.properties.iterator();
        while (iterator.hasNext()) {
            PackageInventoryProperty property = iterator.next();

            if (isPrimitiveOrWrapper(property.propertyClass)) {
                responseSrl.append("<template:br/><template:if>\n");
                responseSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                responseSrl.append("<template:then>Assert.assertEquals(\"" +
                        element.klasseNavn + ", " +
                        property.propertyNavn +
                        ": forventet = <template:placeholder ref='" +
                        property.propertyNavn +
                        "VH' relative='false'/>, fikk = \" " +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn +
                        ", <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>, " +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn +
                        ");</template:then>\n");
                responseSrl.append("</template:if>\n");
            } else if (Date.class.isAssignableFrom(property.propertyClass)) {
                responseSrl.append("<template:br/><template:if>\n");
                responseSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                responseSrl.append("<template:then>Assert.assertNotNull(\"" + element.klasseNavn + ", " + property.propertyNavn +
                        " : forventet = <template:placeholder ref='" + property.propertyNavn +
                        "VH' relative='false'/>, fikk = null\", " + element.klasseNavn.toLowerCase() + "." + property.propertyNavn + ");\n");
                responseSrl.append("<template:br/>Assert.assertTrue(\"" + element.klasseNavn + ", " + property.propertyNavn +
                        " : forventet = <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>, fikk = \"" +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn + " as a date, '<template:placeholder ref='" +
                        property.propertyNavn + "VH' relative='false'/>' = " + element.klasseNavn.toLowerCase() + "." + property.propertyNavn + " as a date);</template:then>\n");
                responseSrl.append("</template:if>\n");
            } else if (TypeCti.class.isAssignableFrom(property.propertyClass)) {
                responseSrl.append("<template:br/><template:if>\n");
                responseSrl.append("<template:test>\"<template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/><![CDATA[\" <> \"\"]]></template:test>\n");
                responseSrl.append("<template:then>Assert.assertNotNull(\"" + element.klasseNavn + ", " + property.propertyNavn +
                        " : forventet = <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>, fikk = null\"," +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn + ");\n");
                responseSrl.append("<template:br/>Assert.assertEquals(\"" + element.klasseNavn + ", " + property.propertyNavn +
                        " : forventet = <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>, fikk = \"" +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn +
                        ".kode, <template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/> as a string, " +
                        element.klasseNavn.toLowerCase() + "." + property.propertyNavn + ".kode);</template:then>\n");
                responseSrl.append("</template:if>\n");
            }
        }

        iterator = element.properties.iterator();
        while (iterator.hasNext()) {
            PackageInventoryProperty property = iterator.next();
            if (!isPrimitiveOrWrapper(property.propertyClass)
                    && !Date.class.isAssignableFrom(property.propertyClass)
                    && !TypeCti.class.isAssignableFrom(property.propertyClass)) {
                responseSrl.append("<template:br/>\n");
                responseSrl.append("<template:br/>" + property.propertyType.toLowerCase() + " = " + element.klasseNavn.toLowerCase() + "." + property.propertyNavn + ";\n");
                responseSrl.append("<template:br/><template:placeholder ref='" + property.propertyNavn + "VH' relative='false'/>\n");
                responseSrl.append("<template:br/>\n");
            }
        }
        responseSrl.append("  </template:content>\n");
        responseSrl.append(" </template>\n");

        return responseSrl.toString();
    }

    /**
     * Lag code template for alle domain klasser.
     * Skrives til filer på temp katalog.
     */
    private void generateRmaTemplates(){
        try {
            for (PackageInventoryElement element : domainElements) {
                String tempDir = System.getenv("TEMP");
                File outfile = new File(tempDir + "\\" + element.klasseNavn + ".xml");
                System.out.println("Writing file " + outfile.getAbsolutePath());
                BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
                out.write(getStandardPreamble(element));
                out.write(getValueHolders(element));
                out.write(getSrlSection(element));
                out.write(getEntityName(element));
                out.write(getDisplaySection(element));
                out.write(getRequestSrl(element));
                out.write(getResponseSrl(element));
                out.write("</template>\n");
                out.close();
            }
        } catch (IOException ex){
            System.out.println("IOexception :" + ex.getMessage());
        }
    }

    private boolean findTemplate4Element(File file, String element){
        if (element.compareTo(file.getName().replaceAll(" ", "")) == 0) {
            System.out.println("Funnet " + file.getAbsolutePath());
            return true;
        }
        File[] list = file.listFiles();
        if (list != null) {
            for (File f : list) {
                if (element.compareTo(f.getName().replaceAll(" ", "")) == 0) {
                    System.out.println("Funnet " + f.getAbsolutePath());
                    return true;
                } else {
                    if (findTemplate4Element(f, element) == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Sjekk om det finnes code template for alle domain klasser.
     *
     */
    private void reportMissingRmaTemplates(){
        File rmaRootDirectory = new File("C:\\data\\preg\\repository\\prepo\\nav-pensjon-test\\nav-pensjon-regler-rma-templates-test");
        for (PackageInventoryElement element : domainElements) {
            if (!findTemplate4Element(rmaRootDirectory, element.klasseNavn + "CodeTemplate")){
                System.out.println("Mangler template for : " + element.klasseNavn);
            }
        }
    }

    /**
     * Lag variabel deklarasjoner for alle domain klasser.
     * Skrives til fil på temp katalog.
     */
    private void generateRmaVariableDeclarations(){
        try {
            String tempDir = System.getenv("TEMP");
            File outfile = new File(tempDir + "\\" + "RmaDeklarasjoner" + ".xml");
            System.out.println("Writing file " + outfile.getAbsolutePath());
            BufferedWriter out = new BufferedWriter(new FileWriter(outfile));

            for (PackageInventoryElement element : domainElements) {
                out.write(element.klasseNavn.toLowerCase() + " is some " + element.klasseNavn + ";\n");
            }
            out.close();
        } catch (IOException ex){
            System.out.println("IOexception :" + ex.getMessage());
        }
    }

    private String findTemplateGuid(File file, String element) throws IOException {
        if (!file.isDirectory()) {
            if (file.getName().endsWith(".innovator_attbs")
                    && file.getName().replaceAll(" ", "").startsWith(element)
                    && file.getName().replaceAll(" ", "").indexOf("CodeTemplate") > 0) {
                System.out.println("Funnet " + file.getAbsolutePath());
                Properties properties = new Properties();
                properties.load(new FileInputStream(file));
                String guid = properties.getProperty("guid");
                System.out.println("GUID = " + guid);
                return guid;
            }
        } else {
            File[] list = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    String guid = findTemplateGuid(f, element);
                    if (guid != null){
                        return guid;
                    }
                }
            }
        }
        return null;
    }

    private void findTemplateGuids(){
        try {
            for (PackageInventoryElement element : domainElements) {
                String guid = findTemplateGuid(rmaRootDirectory, element.klasseNavn);
                if (guid != null){
                    guidMap.put(element.klasseNavn, guid);
                }
            }
        } catch (IOException ex){
            // do nothing.
        }
    }

    public static void main(String[] args){
        RmaCodeTemplateGenerator generator = new RmaCodeTemplateGenerator();
        generator.findTemplateGuids();
        generator.generateRmaTemplates();
        //generateRmaVariableDeclarations();
        //reportMissingRmaTemplates();
    }
}
