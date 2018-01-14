/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_nang_cao.POI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
– XSSFWorkbook: đây là tập tin Excel

– XSSFSheet: trong mỗi Workbook sẽ chia làm nhiều sheet

– Row: trong mỗi worksheet có nhiều dòng

– Cell: mỗi Row lại được chia thành các cột
 */
public class Ghi_file {

    private static void writeToFileExcel() {
        
        //Đầu tiên, bạn cần tạo một XSSFWorkbook rỗng
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        //Sau đó, bạn lại tạo một  XSSFSheet rỗng, như ví dụ mình đặt tên là  Nhân viên
        XSSFSheet sheet = workbook.createSheet("Nhân viên");
        
        //Bây giờ, mình sẽ tạo HashMap chứa dữ liệu thông tin như mã học sinh, họ tên, ngày sinh… chẳng hạn.
        HashMap<String, Object[]> data = new HashMap<>();
        data.put("1", new Object[]{"STT", "Mã học sinh", "Họ và tên", "Ngày sinh"});
        data.put("2", new Object[]{1, 17030001, "Trương Tùng Dương", "20/10/1990"});
        data.put("3", new Object[]{2, 17030002, "Nguyễn Công Minh", "10/11/1993"});
        data.put("4", new Object[]{3, 17030003, "Ninh Văn Luyến", "03/12/1995"});
        
        //Tiếp theo, để ghi dữ liệu xuống tập tin Excel bạn sử dụng Cell và Row
        int rownum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet()) {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (Object obj : entry.getValue()) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Cuối cùng,  FileOutputStream để tạo đường dẫn lưu tập tin, gọi hàm  write()  để ghi dữ liệu.
            FileOutputStream out = new FileOutputStream(new File("E:/nhanvien.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        writeToFileExcel();
    }
}
