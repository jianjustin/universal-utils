package org.jerry.light4j.utils.execl;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * execlπ§æﬂ¿‡
 * @author jian
 *
 */
public class ExeclUtils {

	public static void createExecl(String filePath){
		try {
		  XSSFWorkbook workbook = new XSSFWorkbook(); 
	      FileOutputStream out = new FileOutputStream(new File(filePath + "createworkbook.xlsx"));
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExeclUtils.createExecl("D://");
	}
}
