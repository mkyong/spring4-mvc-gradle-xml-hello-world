<%@ page import="java.util.*,java.text.*"%>
<%
int i, j;
String head = "";

head += "CSV:utf-8\n";
head += "ErrorCode=0,ErrorMsg=SUCC\n";
head += "Dataset:output\n";
head += "col1:String(20),col2:String(20),col3:String(20)\n";
out.write(head);

String data = "";
for( i = 0 ; i < 1000 ; i++ )
{
	// Record 값 생성
	data = "";
	for( j = 1 ; j <= 3 ; j++ )
		data += "col" + j + "_" + i + ",";
	data += "\n";
	
	// 1 Record Write
	out.write(data);
}
// Server Buffer Flush( 화면상의 Data처리 Block 단위와는 상관없음 )
// 이 경우는 WebServer의 Buffer Flush단위에 따라 처리됨
out.flush();

out.close();
%>