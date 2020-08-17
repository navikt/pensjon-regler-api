<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

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
                    <tr>
                        <td style="nowrap">
                            <p/>
                            <font size="+1" class="frameheadingfont">
                                <b>Projects</b>
                            </font>
                            <br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list"/>
                            </font>
                            <br/>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="project">
        <xsl:variable name="projname" select="node()"/>
        <a href="{$projname}/{$projname}.html" title="{$projname}" target="elementFrame"><xsl:value-of select="$projname"/></a>
        <br/>
    </xsl:template>
</xsl:stylesheet>