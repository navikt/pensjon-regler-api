set PATH=%PATH%;C:\apps\SaxonHE9.6N\bin

Transform -t typeLookupFile=file:C:\data\preg\service\nav-service-pensjon-regler-tbom\src\test\resources\elements-list.xml -xsl:Flow2Html.xsl -s:C:\data\preg\repository\prepo\nav-pensjon-teknisk\nav-pensjon-regler-poengrekke-tek\Flyter\BeregnPoengrekkeFlyt

REM Transform -t typeLookupFile=file:C:\data\preg\service\nav-service-pensjon-regler-tbom\src\test\resources\elements-list.xml -xsl:Srl2Html.xsl -s:C:\data\preg\repository\prepo\nav-pensjon-teknisk\nav-pensjon-regler-beslutningsstotte-tek\Regler\BeregnForventetInntektRS