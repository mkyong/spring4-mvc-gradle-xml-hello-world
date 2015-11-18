<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import = "java.io.*" %>

<%@ page contentType="text/xml; charset=utf-8" %>

<%
/****** Service API 초기화 ******/
VariableList vl = new VariableList();
DatasetList  dl = new DatasetList();
String char_set = "utf-8";
PlatformResponse pRes;
%>

<%
/********* Layout생성 ************/
Dataset ds = new Dataset("output", char_set);
ds.addColumn("col1",ColumnInfo.CY_COLINFO_STRING, (short)20);
ds.addColumn("col2",ColumnInfo.CY_COLINFO_STRING, (short)20);
ds.addColumn("col3",ColumnInfo.CY_COLINFO_STRING, (short)20);
int i, row;
for( i = 0 ; i < 2 ; i++ )
{
	row = ds.appendRow();
	ds.setColumn(row, "col1", new Variant("col1_"+i));
	ds.setColumn(row, "col2", new Variant("col2_"+i));
	ds.setColumn(row, "col3", new Variant("col3_"+i));
}
dl.addDataset("output", ds);

vl.addStr("ErrorCode", "0");
vl.addStr("ErrorMsg", "SUCC");
%>

<%
/******** 결과 Write ******/
String format = request.getParameter("format");
if( format.equals("XML") == true )
{
	pRes = new PlatformResponse(response, PlatformRequest.XML , char_set);
}
else
{
	pRes = new PlatformResponse(response, PlatformRequest.ZLIB_COMP , char_set);
}
pRes.sendData(vl, dl);
%>
