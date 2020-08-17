<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:instantiation="http://www.blazesoft.com/instantiation"
                xpath-default-namespace="http://www.blazesoft.com/instantiation">

    <xsl:param name="projectName"/>

    <xsl:output method="xhtml" omit-xml-declaration="yes" doctype-system="about:legacy-compat" encoding="UTF-8" indent="yes" escape-uri-attributes="no"/>

    <xsl:template match="/">
        <html>
            <head>
                <meta http-equiv="X-UA-Compatible" content="IE=EDGE,chrome=IE7"/>
                <meta charset='UTF-8'/>
                <style>
                    table {
                    border-collapse: collapse;
                    }
                    table, th, td {
                    border: 1.5px solid black;
                    }
                    th, td {
                    padding: 5px;
                    }
                    td {
                    vertical-align: top;
                    }
                    pre {
                    white-space: pre-line;
                    }
                </style>
            </head>
            <body>
                <h1>Project <xsl:value-of select="$projectName"/></h1>
                <xsl:apply-templates select="instantiation/instance/instance"/>
                <xsl:apply-templates select="instantiation/instance-list"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="instantiation/instantiation"/>

    <xsl:template match="instance[@ref='Comment']">
        <b>Comment:</b>&#160;<pre><xsl:value-of select="value"/></pre>
    </xsl:template>

    <xsl:template match="instance[@ref!='Comment']"/>

    <xsl:template match="instance-list[@ref='folders']">
        <h2>Folders</h2>
        <table id="Folders" border="1">
            <tr>
                <th>Name</th>
            </tr>
            <xsl:for-each select="item">
                <tr>
                    <td class="value">
                        <xsl:value-of select="value"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
        <br/>
    </xsl:template>

    <xsl:template match="instance-list[@ref='subprojects']">
        <h2>Subprojects</h2>
        <table id="Subprojects" border="1">
            <tr>
                <th>Name</th>
            </tr>
            <xsl:for-each select="item">
                <tr>
                    <td class="value">
                        <xsl:value-of select="value"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
        <br/>
    </xsl:template>

</xsl:stylesheet>