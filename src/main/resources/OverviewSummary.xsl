<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/xpath-functions">

    <xsl:output method="xhtml" omit-xml-declaration="yes" doctype-system="about:legacy-compat" encoding="UTF-8" indent="yes" escape-uri-attributes="no"/>

    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="X-UA-Compatible" content="IE=EDGE,chrome=IE7"/>
                <meta charset='UTF-8'/>
                <title>Project List</title>
                <link rel="stylesheet" type="text/css" href="stylesheet.css" title="Style"/>
            </head>
            <body bgcolor="white">
                <table border="0" width="100%" summary="">
                    <tr bgcolor="#CCCCFF" class="TableHeadingColor">
                        <th align="left" colspan="2">
                            <font size="+2">
                                <b>Rule service projects</b>
                            </font>
                        </th>
                    </tr>
                    <tr>
                        <td style="nowrap">
                            <p/>
                            <font size="+1" class="frameheadingfont">
                                <b>Projects</b>
                            </font>
                            <br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/project/directory[fn:contains(text(),'nav-pensjon-regeltjenester')]"/>
                            </font>
                            <br/>
                        </td>
                    </tr>
                </table>
                <br/><br/>
                <table border="0" width="100%" summary="">
                    <tr bgcolor="#CCCCFF" class="TableHeadingColor">
                        <th align="left" colspan="2">
                            <font size="+2">
                                <b>Rule component projects</b>
                            </font>
                        </th>
                    </tr>
                    <tr>
                        <td style="nowrap">
                            <p/>
                            <font size="+1" class="frameheadingfont">
                                <b>Projects</b>
                            </font>
                            <br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/project/directory[fn:contains(text(),'nav-pensjon-teknisk')]"/>
                            </font>
                            <br/>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="project/directory[fn:contains(text(),'nav-pensjon-regeltjenester')]">
        <tr bgcolor="white" class="TableRowColor">
            <td width="20%">
                <b>
                    <xsl:element name="a">
                        <xsl:attribute name="href"><xsl:value-of select="../name"/>/<xsl:value-of select="../name"/>.html</xsl:attribute>
                        <xsl:attribute name="target">elementFrame</xsl:attribute>
                        <xsl:value-of select="../name"/>
                    </xsl:element>
                </b>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="project/directory[fn:contains(text(),'nav-pensjon-teknisk')]">
        <tr bgcolor="white" class="TableRowColor">
            <td width="20%">
                <b>
                    <xsl:element name="a">
                        <xsl:attribute name="href"><xsl:value-of select="../name"/>/<xsl:value-of select="../name"/>.html</xsl:attribute>
                        <xsl:attribute name="target">elementFrame</xsl:attribute>
                        <xsl:value-of select="../name"/>
                    </xsl:element>
                </b>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>