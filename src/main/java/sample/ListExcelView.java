package sample;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ListExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> map,
			HSSFWorkbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + map.get("filename")+".xlsx" + "\";");
		response.setContentType("Application/Msexcel");
	}


	
}
