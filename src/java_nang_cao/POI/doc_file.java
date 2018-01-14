/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_nang_cao.POI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * – XSSFWorkbook: đây là tập tin Excel
 *
 * – XSSFSheet: trong mỗi Workbook sẽ chia làm nhiều sheet
 *
 * – Row: trong mỗi worksheet có nhiều dòng
 *
 * – Cell: mỗi Row lại được chia thành các cột
 */
public class doc_file {

    private static void readFromFileExcel() {
        try {
            //Đầu tiên, bạn cần trỏ đến tập tin Excel
            FileInputStream file = new FileInputStream(new File("E:/nhanvien.xlsx"));

            /**
             * Tiếp tuc, bạn cần tạo ra XSSFWorkbook và XSSFSheet
             * Một Workbook sẽ có nhiều Sheet nên bạn cần gọi phương thức, getSheetAt(locaiton) nhằm để bạn có thể lấy đúng Sheet tương ứng.
             */
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //Giờ là phần lấy dữ liệu từ các dòng và cột ra.
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                }
                System.out.println(".");
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFromFileExcel();
    }
}
