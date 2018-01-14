/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author PC
 */
public class In_hoa_chu_dau {
   public static void main(String[] args) {
      String str = "phan phú kiệt";
//      System.out.println(str);
      StringBuffer stringbf = new StringBuffer();
      Matcher m = Pattern.compile("([a-z\\-\\.\\'\\á\\à\\ả\\ã\\ạ\\ă\\ắ\\ằ\\ẳ\\ẵ\\ặ\\â\\ấ\\ầ\\ẩ\\ẫ\\ậ\\Á\\À\\Ả\\Ã\\Ạ\\Ă\\Ắ\\Ằ\\Ẳ\\Ẵ\\Ặ\\Â\\Ấ\\Ầ\\Ẩ\\Ẫ\\Ậ\\é\\è\\ẻ\\ẽ\\ẹ\\ê\\ế\\ề\\ể\\ễ\\ệ\\É\\È\\Ẻ\\Ẽ\\Ẹ\\Ê\\Ế\\Ề\\Ể\\Ễ\\Ệ\\í\\ì\\ỉ\\ĩ\\ị\\Í\\Ì\\Ỉ\\Ĩ\\Ị\\ó\\ò\\ỏ\\õ\\ọ\\ô\\ố\\ồ\\ổ\\ỗ\\ộ\\ơ\\ớ\\ờ\\ở\\ỡ\\ợ\\Ó\\Ò\\Ỏ\\Õ\\Ọ\\Ô\\Ố\\Ồ\\Ổ\\Ỗ\\Ộ\\Ơ\\Ớ\\Ờ\\Ở\\Ỡ\\Ợ\\ú\\ù\\ủ\\ũ\\ụ\\ư\\ứ\\ừ\\ử\\ữ\\ự\\Ú\\Ù\\Ủ\\Ũ\\Ụ\\Ư\\Ứ\\Ừ\\Ử\\Ữ\\Ự\\ý\\ỳ\\ỷ\\ỹ\\ỵ\\Ý\\Ỳ\\Ỷ\\Ỹ\\Ỵ\\đ\\Đ])([a-z\\-\\.\\'\\á\\à\\ả\\ã\\ạ\\ă\\ắ\\ằ\\ẳ\\ẵ\\ặ\\â\\ấ\\ầ\\ẩ\\ẫ\\ậ\\Á\\À\\Ả\\Ã\\Ạ\\Ă\\Ắ\\Ằ\\Ẳ\\Ẵ\\Ặ\\Â\\Ấ\\Ầ\\Ẩ\\Ẫ\\Ậ\\é\\è\\ẻ\\ẽ\\ẹ\\ê\\ế\\ề\\ể\\ễ\\ệ\\É\\È\\Ẻ\\Ẽ\\Ẹ\\Ê\\Ế\\Ề\\Ể\\Ễ\\Ệ\\í\\ì\\ỉ\\ĩ\\ị\\Í\\Ì\\Ỉ\\Ĩ\\Ị\\ó\\ò\\ỏ\\õ\\ọ\\ô\\ố\\ồ\\ổ\\ỗ\\ộ\\ơ\\ớ\\ờ\\ở\\ỡ\\ợ\\Ó\\Ò\\Ỏ\\Õ\\Ọ\\Ô\\Ố\\Ồ\\Ổ\\Ỗ\\Ộ\\Ơ\\Ớ\\Ờ\\Ở\\Ỡ\\Ợ\\ú\\ù\\ủ\\ũ\\ụ\\ư\\ứ\\ừ\\ử\\ữ\\ự\\Ú\\Ù\\Ủ\\Ũ\\Ụ\\Ư\\Ứ\\Ừ\\Ử\\Ữ\\Ự\\ý\\ỳ\\ỷ\\ỹ\\ỵ\\Ý\\Ỳ\\Ỷ\\Ỹ\\Ỵ\\đ\\Đ]*)",
      Pattern.CASE_INSENSITIVE).matcher(str);
      while (m.find()) {
         m.appendReplacement(stringbf, 
         m.group(1).toUpperCase() + m.group(2).toLowerCase());
      }
      String a = m.appendTail(stringbf).toString();
      System.out.println(a);
   }
}


