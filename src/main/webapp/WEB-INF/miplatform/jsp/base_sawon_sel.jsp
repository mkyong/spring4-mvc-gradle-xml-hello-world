<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.tobesoft.platform.*" %>
<%@ page import="com.tobesoft.platform.data.*" %>
<%@ page import = "java.io.*" %>

<%@ page contentType="text/xml; charset=utf-8" %>
<%! 
/*********** 공통함수 *************/
// ResultSet 값 가져오기, 단, "null"을 ""로
public String  rsGet(ResultSet rs, String id) throws Exception
{
	if( rs.getString(id) == null )
		return "";
	else
		return rs.getString(id);
} 

// 한글 조회조건 처리용 함수
public static String EucToUni(String s) 
{
	String result = "";

	try {
		result = new String(s.getBytes("8859_1"), "EUC-KR");
	} catch(Exception e) {
		System.out.println(e);
	}

	return result;
}
%>

<%
/****** Service API 초기화 ******/
VariableList vl = new VariableList();
DatasetList  dl = new DatasetList();
%>

<%
/******* JDBC Connection *******/
Connection conn = null;
Statement  stmt = null;
ResultSet  rs   = null;
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=EDU","edu","edu");
stmt = conn.createStatement();

try {
/******* SQL 실행 *************/
String name = request.getParameter("name");
String SQL;
if( name.equals("") == true )
	SQL="select * from base_sawon_U"; 
else
	SQL="select * from base_sawon_U where name like '" + EucToUni(name) + "%%'"; 
rs = stmt.executeQuery(SQL);

/********* Dataset 생성 ************/
Dataset ds = new Dataset("ds_sawon");
ds.addColumn("name",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("sabun",ColumnInfo.CY_COLINFO_STRING, 5);
ds.addColumn("dept",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("jikgup",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("gender",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("ipsa_date",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("marry",ColumnInfo.CY_COLINFO_STRING, 20);
ds.addColumn("email",ColumnInfo.CY_COLINFO_STRING, 50);
ds.addColumn("smemo",ColumnInfo.CY_COLINFO_STRING, 100);
while(rs.next())
{
	int row = ds.appendRow();
	ds.setColumn(row, "name", rsGet(rs, "name"));
	ds.setColumn(row, "sabun", rsGet(rs, "sabun"));	
	ds.setColumn(row, "dept", rsGet(rs, "dept"));
	ds.setColumn(row, "jikgup", rsGet(rs, "jikgup"));
	ds.setColumn(row, "gender", rsGet(rs, "gender"));	
	ds.setColumn(row, "ipsa_date", rsGet(rs, "ipsa_date"));
	ds.setColumn(row, "marry", rsGet(rs, "marry"));
	ds.setColumn(row, "email", rsGet(rs, "email"));
	ds.setColumn(row, "smemo", rsGet(rs, "smemo"));
}

/********* 생성된 Dataset을 DatasetList에 추가 ************/
dl.addDataset(ds);

/********* 변수를 VariableList에 추가 ************/
vl.addStr("ErrorCode", "0");
vl.addStr("ErrorMsg", "SUCC");
}
/********* Error처리 ************/
catch(SQLException e) {
vl.addStr("ErrorCode", "-1");
vl.addStr("ErrorMsg", e.getMessage());
}
%>

<%
/******** JDBC Close *******/
	if ( stmt != null ) try { stmt.close(); } catch (Exception e) {}
	if ( conn != null ) try { conn.close(); } catch (Exception e) {}
%>

<%
/******** 결과 XML 생성 및 Web Server로 전달 ******/
	out.clearBuffer();
	PlatformResponse pRes = new PlatformResponse(response, PlatformRequest.XML, "utf-8");
	pRes.sendData(vl, dl);
%>