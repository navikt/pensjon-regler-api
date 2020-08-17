<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fn="http://www.w3.org/2005/xpath-functions"
                xmlns:emath="http://exslt.org/math"
                xmlns:xlink="http://www.w3.org/1999/xhtml"
                xmlns:tree="http://www.ora.com/XSLTCookbook/ns/tree"
                xmlns:template="http://www.blazesoft.com/template"
                xmlns:instantiation="http://www.blazesoft.com/instantiation"
                xmlns:flow="http://www.blazesoft.com/flow">

    <xsl:output method="xhtml" omit-xml-declaration="yes" doctype-system="about:legacy-compat" encoding="UTF-8" indent="yes" escape-uri-attributes="no"/>

    <xsl:param name="typeLookupFile"/>

    <xsl:variable name="repoelements" select="fn:document($typeLookupFile)"/>

    <!--<xsl:include href="exslt-math.xsl"/>-->
    <xsl:function name="emath:max">
        <xsl:param name="nodes"/>
        <xsl:choose>
            <xsl:when test="not($nodes)">
                <xsl:value-of select="number('NaN')"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:for-each select="$nodes">
                    <xsl:sort order="descending" data-type="number"/>
                    <xsl:if test="position() = 1">
                        <xsl:value-of select="number(.)"/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:function>

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

    <xsl:template match="flow:ruleflow">
        <h1>Ruleflow <xsl:value-of select="flow:name"/></h1>
        <xsl:value-of select="flow:comment"/>
        <xsl:if test="flow:event">
            <h2>Implementation arguments:</h2>
            <xsl:element name="a">
                <xsl:attribute name="href"><xsl:value-of select="flow:event/flow:name"/>.html</xsl:attribute>
                <xsl:value-of select="flow:event/flow:name"/>
            </xsl:element>
        </xsl:if>
        <br/>
        <h2>Variables</h2>
        <table id="Flow_variables" border="1">
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Initial value</th>
            </tr>
            <xsl:for-each select="flow:variable">
                <tr>
                    <td class="value">
                        <xsl:value-of select="flow:name"/>
                    </td>
                    <td class="value">
                        <xsl:apply-templates select="flow:type"/>
                    </td>
                    <td>
                        <xsl:value-of select="flow:value"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
        <br/>

        <xsl:variable name="ruleFlow">
            <xsl:apply-templates select="flow:flow" mode="layout"/>
        </xsl:variable>
        <!--<xsl:copy-of select="$ruleFlow"/>-->

        <xsl:variable name="maxypos" select="count(flow:flow//flow:task) * 35"/>
        <xsl:variable name="maxxpos" select="500 + count(flow:flow//flow:boolean-decision) * 20"/>
        <svg width="{$maxxpos}" height="{$maxypos}" xmlns:xlink="http://www.w3.org/1999/xlink">
            <!--<xsl:apply-templates select="flow:flow" mode="draw"/>-->
            <xsl:apply-templates select="$ruleFlow" mode="draw"/>
        </svg>
    </xsl:template>

    <!--*********************************************
    First iteration to calcultate layout of ruleflow
    ***********************************************-->

    <xsl:template match="flow:flow" mode="layout">
        <xsl:variable name="subTree">
            <xsl:apply-templates mode="layout"/>
        </xsl:variable>

        <!--Non-leaf nodes are assigned the sum of their child weights -->
        <xsl:variable name="thisWeight"
                      select="sum($subTree/*/@tree:WEIGHT)"/>

        <xsl:variable name="maxDepth">
            <xsl:value-of select="emath:max($subTree/*/@tree:MAXDEPTH)"/>
        </xsl:variable>

        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:attribute name="tree:WEIGHT">
                <xsl:value-of select="$thisWeight"/>
            </xsl:attribute>
            <xsl:attribute name="tree:MAXDEPTH">
                <xsl:value-of select="$maxDepth"/>
            </xsl:attribute>
            <xsl:copy-of select="$subTree"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="flow:boolean-decision" mode="layout">
        <xsl:variable name="subTree">
            <xsl:apply-templates mode="layout"/>
        </xsl:variable>

        <!--Non-leaf nodes are assigned the sum of their child weights -->
        <xsl:variable name="thisWeight"
                      select="sum($subTree/*/@tree:WEIGHT)"/>

        <xsl:variable name="maxDepth">
            <xsl:value-of select="emath:max($subTree/*/@tree:MAXDEPTH)"/>
        </xsl:variable>

        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:attribute name="tree:WEIGHT">
                <xsl:value-of select="$thisWeight"/>
            </xsl:attribute>
            <xsl:attribute name="tree:MAXDEPTH">
                <xsl:value-of select="$maxDepth"/>
            </xsl:attribute>
            <xsl:copy-of select="$subTree"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="flow:loop" mode="layout">
        <xsl:variable name="subTree">
            <xsl:apply-templates mode="layout"/>
        </xsl:variable>

        <!--Non-leaf nodes are assigned the sum of their child weights -->
        <xsl:variable name="thisWeight"
                      select="sum($subTree/*/@tree:WEIGHT)"/>

        <xsl:variable name="maxDepth">
            <xsl:value-of select="emath:max($subTree/*/@tree:MAXDEPTH)"/>
        </xsl:variable>

        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <xsl:attribute name="tree:WEIGHT">
                <xsl:value-of select="$thisWeight"/>
            </xsl:attribute>
            <xsl:attribute name="tree:MAXDEPTH">
                <xsl:value-of select="$maxDepth"/>
            </xsl:attribute>
            <xsl:copy-of select="$subTree"/>
        </xsl:copy>
    </xsl:template>

    <!--Layout leaf nodes -->
    <xsl:template match="flow:task" mode="layout">
        <xsl:variable name="depth" select="count(ancestor-or-self::flow:*)"/>
        <xsl:copy>
            <xsl:copy-of select="@*"/>
            <!--Leaf nodes are assigned weight 1 -->
            <xsl:attribute name="tree:WEIGHT">
                <xsl:value-of select="1"/>
            </xsl:attribute>
            <xsl:attribute name="tree:MAXDEPTH">
                <xsl:value-of select="$depth"/>
            </xsl:attribute>
            <xsl:copy-of select="node()"/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="flow:name" mode="layout">
        <xsl:copy-of select="."/>
    </xsl:template>

    <xsl:template match="flow:test" mode="layout">
        <xsl:copy-of select="."/>
    </xsl:template>

    <xsl:template match="flow:variable" mode="layout">
        <xsl:copy-of select="."/>
    </xsl:template>

    <xsl:template match="flow:modify" mode="layout">
        <xsl:copy-of select="."/>
    </xsl:template>

    <!--******************************
    Second iteration to draw ruleflow
    ********************************-->

    <xsl:template match="flow:flow" mode="draw">
        <xsl:apply-templates mode="draw"/>
    </xsl:template>

    <xsl:template match="flow:boolean-decision" mode="draw">
        <xsl:variable name="xpos" select="(count(ancestor-or-self::*)) * 20"/>
        <xsl:variable name="sekvens">
            <xsl:number count="flow:task|flow:boolean-decision" level="any"/>
        </xsl:variable>
        <xsl:variable name="ypos" select="$sekvens * 30"/>
        <xsl:variable name="yposRect" select="$ypos - 15"/>
        <g transform="rotate(45, {$xpos}, {$yposRect})">
            <rect x="{$xpos}" y="{$yposRect}" width="10" height="10" style="fill:pink;fill-opacity:0.9;stroke-width:1;stroke:black"/>
        </g>
        <text x="{$xpos}" y="{$ypos}" fill="red" font-family="monospace"><xsl:value-of select="flow:name"/></text>

        <xsl:for-each select="flow:flow">
            <g transform="translate({count(preceding-sibling::flow:flow) * 30}, 0)">
                <xsl:apply-templates select="." mode="draw"/>
            </g>
        </xsl:for-each>
        <!--<xsl:apply-templates select="flow:flow"/>-->
    </xsl:template>

    <xsl:template match="flow:loop" mode="draw">
        <xsl:apply-templates select="flow:flow" mode="draw"/>
    </xsl:template>

    <xsl:template match="flow:task" mode="draw">
        <xsl:variable name="xpos" select="(count(ancestor-or-self::*)) * 20"/>
        <xsl:variable name="sekvens">
            <xsl:number count="flow:task|flow:boolean-decision" level="any"/>
        </xsl:variable>
        <xsl:variable name="ypos" select="$sekvens * 30"/>
        <xsl:variable name="yposRect" select="$ypos - 15"/>
        <xsl:variable name="widthRect" select="fn:string-length(flow:name) * 10"/>

        <xsl:variable name="impl" select="flow:implementation"/>
        <xsl:variable name="typeFound" select="$repoelements/elementlist/element[node()=$impl]"/>

        <xsl:if test="exists($typeFound)">
            <xsl:element name="a">
                <xsl:attribute name="href">../<xsl:value-of select="$typeFound/@project"/>/<xsl:value-of select="$impl"/>.html</xsl:attribute>
                <rect x="{$xpos}" y="{$yposRect}" width="{$widthRect}" height="20" style="fill:pink;fill-opacity:0.9;stroke-width:1;stroke:black"/>
                <text x="{$xpos}" y="{$ypos}" fill="red" font-family="monospace"><xsl:value-of select="flow:name"/></text>
            </xsl:element>
        </xsl:if>
        <xsl:if test="empty($typeFound)">
            <a xlink:href="{$impl}.html">
                <rect x="{$xpos}" y="{$yposRect}" width="{$widthRect}" height="20" style="fill:pink;fill-opacity:0.9;stroke-width:1;stroke:black"/>
                <text x="{$xpos}" y="{$ypos}" fill="red" font-family="monospace"><xsl:value-of select="flow:name"/></text>
            </a>
        </xsl:if>
        <xsl:variable name="xpostPath" select="$xpos + 0.5 * $widthRect"/>
        <xsl:variable name="yposPath" select="$yposRect + 20"/>
        <path d="M {$xpostPath} {$yposPath} V {$yposPath + 15}" stroke="black" stroke-width="2"/>
    </xsl:template>

    <xsl:template match="flow:type" mode="draw">
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

    <xsl:template match="template:tab" mode="draw">
        <xsl:text>&#160;&#160;&#160;</xsl:text>
    </xsl:template>

    <xsl:template match="template:br" mode="draw"/>

</xsl:stylesheet>