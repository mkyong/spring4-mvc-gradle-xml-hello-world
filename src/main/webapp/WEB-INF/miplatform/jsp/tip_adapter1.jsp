<%@ page contentType="text/xml; charset=utf-8" %>

<%
	String	in_var;
	in_var = request.getParameter("in_var");
	if( in_var.equals("") == true )
		return;
%>
<?xml version="1.0" encoding="utf-8"?>
<root>
        <params>
			<param id="ErrorCode">0</param>
			<param id="ErrorMsg">SUCC</param>
        </params>
		<dataset id="output1">
			<colinfo id="col1" size="255" type="STRING"/>
			<colinfo id="col2" size="255" type="STRING"/>
			<colinfo id="col3" size="255" type="STRING"/>
			<record>
				<col1>A</col1>
				<col2>B</col2>
				<col3>C</col3>
			</record>
			<record>
				<col1>D</col1>
				<col2>E</col2>
				<col3>F</col3>
			</record>
			<record>
				<col1>G</col1>
				<col2>H</col2>
				<col3>I</col3>
			</record>
		</dataset>
</root>

