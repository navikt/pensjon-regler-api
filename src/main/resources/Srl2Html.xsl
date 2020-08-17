<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/xpath-functions"
                xmlns:template="http://www.blazesoft.com/template"
                xmlns:instantiation="http://www.blazesoft.com/instantiation"
                xmlns:srl="http://www.blazesoft.com/srl">

    <xsl:output method="xhtml" omit-xml-declaration="yes" doctype-system="about:legacy-compat" encoding="UTF-8" indent="yes" escape-uri-attributes="no"/>

    <xsl:param name="typeLookupFile"/>

    <xsl:variable name="repoelements" select="fn:document($typeLookupFile)"/>

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
                    code {
                        white-space: pre-line;
                    }
                </style>
            </head>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="instantiation:instantiation"/>
    <xsl:template match="template:ide-name"/>
    <xsl:template match="template:family"/>

    <xsl:template match="template:template/template:content">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="srl:ruleset">
        <h1>Ruleset <xsl:value-of select="srl:name"/></h1>
        <b>Execution mode:</b> <xsl:value-of select="srl:functional-execution-mode"/><br/>
        <b>Comment:</b> <xsl:value-of select="srl:comment"/><br/>
        <b>Returns:</b> <xsl:apply-templates select="srl:array"/><xsl:apply-templates select="srl:type"/><br/>
        <xsl:apply-templates select="srl:parameters"/>
        <xsl:apply-templates select="srl:ruleset-body"/>
    </xsl:template>

    <xsl:template match="srl:function">
        <h1>Function <xsl:value-of select="srl:name"/></h1>
        <b>Comment:</b> <xsl:value-of select="srl:comment"/><br/>
        <b>Returns:</b> <xsl:apply-templates select="srl:array"/><xsl:apply-templates select="srl:type"/><br/>
        <xsl:apply-templates select="srl:parameters"/>
        <br/>
        <table id="Function_body" border="1">
            <tr><th>Function Body</th></tr>
            <tr><td><xsl:apply-templates select="srl:body"/></td></tr>
        </table>
    </xsl:template>

    <xsl:template match="srl:class">
        <h1>Class <xsl:value-of select="srl:name"/></h1>
        <br/>
        <pre><xsl:value-of select="srl:comment"/></pre>
        <br/>
        <h2>Properties</h2>
        <table id="Class_properties" border="1">
            <tr>
                <th>Name</th>
                <th>Type</th>
            </tr>
            <xsl:for-each select="srl:properties/srl:property">
            <tr>
                <td class="value">
                    <xsl:value-of select="srl:name"/>
                </td>
                <td class="value">
                    <xsl:apply-templates select="srl:type"/>
                    <xsl:apply-templates select="srl:array"/>
                </td>
            </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="srl:ruleset-body">
        <xsl:if test="srl:variable">
            <h2>Variables</h2>
            <table id="Ruleset_variables" border="1">
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Initial value</th>
                </tr>
                <xsl:for-each select="srl:variable">
                    <tr>
                        <td class="value">
                            <xsl:value-of select="srl:name"/>
                        </td>
                        <td class="value">
                            <xsl:apply-templates select="srl:type"/>
                            <xsl:apply-templates select="srl:array"/>
                        </td>
                        <td class="value">
                            <code>
                                <xsl:apply-templates select="srl:initializer"/>
                            </code>
                        </td>
                    </tr>
                </xsl:for-each>
                <xsl:for-each select="srl:pattern">
                    <tr>
                        <td class="value">
                            <xsl:value-of select="srl:name"/>
                        </td>
                        <td class="value">
                            <xsl:apply-templates select="srl:type"/>
                        </td>
                        <td class="value">
                            <code>is any
                                <xsl:value-of select="srl:type"/>
                                in
                                <xsl:value-of select="srl:collection"/>
                                such that {
                                <xsl:value-of select="srl:constraint"/>
                                }
                            </code>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
            <br/>
        </xsl:if>
        <h2>Rules</h2>
        <table id="Ruleset" border="1">
            <tr>
                <th>Name</th>
                <th>Body</th>
                <th>Comment</th>
            </tr>
            <xsl:for-each select="srl:rule">
                <tr>
                    <td class="value">
                        <xsl:value-of select="srl:name"/>
                    </td>
                    <td class="value">
                        <xsl:apply-templates select="srl:body"/>
                    </td>
                    <td class="value">
                        <xsl:value-of select="srl:comment"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="srl:parameters">
        <h2>Parameters</h2>
        <table id="Ruleset_params" border="1">
            <tr>
                <th>Name</th>
                <th>Type</th>
            </tr>
            <xsl:for-each select="srl:parameter">
                <tr>
                    <td class="value">
                        <xsl:value-of select="srl:name"/>
                    </td>
                    <td>
                        <xsl:apply-templates select="srl:type"/>
                        <xsl:apply-templates select="srl:array"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="srl:body">
        <xsl:variable name="regelbody">
            <xsl:apply-templates/>
        </xsl:variable>
        <code>
            <xsl:call-template name="regeltekst">
                <xsl:with-param name="tekst" select="$regelbody"/>
            </xsl:call-template>
        </code>
    </xsl:template>

    <xsl:template name="regeltekst">
        <xsl:param name="tekst"/>
        <xsl:variable name="tekst1">
            <xsl:value-of select="fn:replace($tekst,'log_debug\([^;]*\);[ \r\n]*', '')"/>
        </xsl:variable>
        <xsl:variable name="tekst2">
            <xsl:value-of select="fn:replace($tekst1,'log_formel[^;]*\);[ \r\n]*', '')"/>
        </xsl:variable>
        <xsl:value-of select="$tekst2"/>
    </xsl:template>

    <xsl:template match="srl:type">
        <xsl:variable name="typename" select="node()"/>
        <xsl:variable name="typeFound" select="$repoelements/elementlist/element[node()=$typename]"/>

        <xsl:if test="exists($typeFound)">
            <xsl:element name="a">
                <xsl:attribute name="href">../<xsl:value-of select="$typeFound/@project"/>/<xsl:value-of select="$typename"/>.html</xsl:attribute>
                <xsl:value-of select="$typename"/>
            </xsl:element>
        </xsl:if>
        <xsl:if test="empty($typeFound)">
            <xsl:value-of select="$typename"/>
        </xsl:if>
    </xsl:template>

    <xsl:template match="srl:array">
        Array of <xsl:apply-templates select="srl:type"/>
    </xsl:template>

    <xsl:template match="template:tab">
        <xsl:text>&#160;&#160;&#160;</xsl:text>
    </xsl:template>

    <xsl:template match="template:br"/>

</xsl:stylesheet>