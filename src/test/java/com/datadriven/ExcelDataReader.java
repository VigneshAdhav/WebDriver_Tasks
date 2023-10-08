package com.datadriven;

/*
 * import org.apache.poi.ss.usermodel.*; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class ExcelDataReader { public static Object[][] readTestData(String
 * filePath, String sheetName) throws Exception { FileInputStream excelFile =
 * new FileInputStream(filePath); Workbook workbook = new
 * XSSFWorkbook(excelFile); Sheet sheet = workbook.getSheet(sheetName); int
 * rowCount = sheet.getLastRowNum(); int colCount =
 * sheet.getRow(0).getLastCellNum(); Object[][] data = new
 * Object[rowCount][colCount];
 * 
 * for (int i = 0; i < rowCount; i++) { Row row = sheet.getRow(i + 1); // Skip
 * header row for (int j = 0; j < colCount; j++) { Cell cell = row.getCell(j);
 * if (cell == null) { data[i][j] = ""; } else {
 * cell.setCellType(CellType.STRING); data[i][j] = cell.getStringCellValue(); }
 * } }
 * 
 * return data; } }
 */
