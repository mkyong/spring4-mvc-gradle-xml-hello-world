<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import = "java.io.*" %>

<%@ page contentType="text/xml; charset=utf-8" %>

<%! 
public String  rsGet(ResultSet rs, String id) throws Exception
{
	if( rs.getString(id) == null )
		return "";
	else
		return rs.getString(id);
} 
%>

<%
/****** Service API 초기화 ******/
VariableList vl = new VariableList();
DatasetList  dl = new DatasetList();
String char_set = "utf-8";
%>

<%
/******* JDBC Connection *******/
Connection conn = null;
Statement  stmt = null;
ResultSet  rs   = null;
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;;DatabaseName=EDU","edu","edu");
stmt = conn.createStatement();

try {
/******* SQL 실행 *************/
String start_sel_rowno = request.getParameter("start_sel_rowno");
String unit_sel_rownum = request.getParameter("unit_sel_rownum");
String SQL = "select * from sample_book_list";
SQL = SQL + " where rowno >= " + start_sel_rowno + " and rowno < (" + start_sel_rowno + " + " + unit_sel_rownum +" ) order by rowno asc"; 
rs = stmt.executeQuery(SQL);

/********* Dataset 생성 ************/
Dataset ds = new Dataset("ds_book", char_set);
ds.addColumn("rowno",ColumnInfo.CY_COLINFO_INT, (short)5);
ds.addColumn("book_nm",ColumnInfo.CY_COLINFO_STRING, (short)500);
ds.addColumn("editor_nm",ColumnInfo.CY_COLINFO_STRING, (short)200);
ds.addColumn("press_nm",ColumnInfo.CY_COLINFO_STRING, (short)100);
ds.addColumn("price",ColumnInfo.CY_COLINFO_INT, (short)10);
int row = 0;
while(rs.next())
{
	row = ds.appendRow();
	ds.setColumn(row, "rowno", new Variant(rsGet(rs, "rowno")));
	ds.setColumn(row, "book_nm", new Variant(rsGet(rs, "book_nm")));	
	ds.setColumn(row, "editor_nm", new Variant(rsGet(rs, "editor_nm")));
	ds.setColumn(row, "press_nm", new Variant(rsGet(rs, "press_nm")));
	ds.setColumn(row, "price", new Variant(rsGet(rs, "price")));
}

/********* 생성된 Dataset을 DatasetList에 추가 ************/
dl.addDataset("ds_book", ds);

/********* 변수를 VariableList에 추가 ************/
vl.addStr("ErrorCode", "0");
vl.addStr("ErrorMsg", "SUCC");
vl.addVariable("sel_rownum", row);
}
catch(SQLException e) {
vl.addStr("ErrorCode", "-1");
vl.addStr("ErrorMsg", e.getMessage());
vl.addVariable("sel_rownum", 0);
}
%>

<%
/******** JDBC Close *******/
	if ( stmt != null ) try { stmt.close(); } catch (Exception e) {}
	if ( conn != null ) try { conn.close(); } catch (Exception e) {}
%>

<%
/******** 결과 XML 생성 및 Web Server로 보내기 ******/
	out.clearBuffer();
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, char_set);
	pRes.sendData(vl, dl);
%>
