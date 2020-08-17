<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="xhtml" omit-xml-declaration="yes" doctype-system="about:legacy-compat" encoding="UTF-8" indent="yes" escape-uri-attributes="no"/>

    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="X-UA-Compatible" content="IE=EDGE,chrome=IE7"/>
                <meta charset='UTF-8'/>
                <title>All repository elements</title>
                <link rel="stylesheet" type="text/css" href="stylesheet.css" title="Style"/>
            </head>
            <body bgcolor="white">
                <table border="0" width="100%" summary="">
                    <tr>
                        <td style="nowrap">
                            <p/>
                            <font size="+1" class="frameheadingfont">
                                <b>Ruleflows</b>
                            </font>
                            <br/><br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/element[@type='RULEFLOW']"/>
                            </font>
                            <br/>
                            <font size="+1" class="frameheadingfont">
                                <b>Rulesets</b>
                            </font>
                            <br/><br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/element[@type='RULESET']"/>
                            </font>
                            <br/>
                            <font size="+1" class="frameheadingfont">
                                <b>Functions</b>
                            </font>
                            <br/><br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/element[@type='FUNCTION']"/>
                            </font>
                            <br/>
                            <font size="+1" class="frameheadingfont">
                                <b>Classes</b>
                            </font>
                            <br/><br/>
                            <font class="frameitemfont">
                                <xsl:apply-templates select="list/element[@type='CLASS']"/>
                            </font>
                            <br/>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="element">
        <xsl:variable name="typename" select="node()"/>
        <xsl:variable name="projname" select="@project"/>
        <a href="{$projname}/{$typename}.html" title="{$typename}" target="elementFrame"><xsl:value-of select="$typename"/></a>
        <br/>
    </xsl:template>
</xsl:stylesheet>