/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author PC
 */
public class Method {

    public String Bodau(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }
//-----------------------------------------------------------

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
//-----------------------------------------------------------

    public boolean isValidName(String name) {
//        String regx = "^[a-zA-Z \\-\\.\\']*$";
        String regx = "^[a-zA-Z \\-\\.\\'\\á\\à\\ả\\ã\\ạ\\ă\\ắ\\ằ\\ẳ\\ẵ\\ặ\\â\\ấ\\ầ\\ẩ\\ẫ\\ậ\\Á\\À\\Ả\\Ã\\Ạ\\Ă\\Ắ\\Ằ\\Ẳ\\Ẵ\\Ặ\\Â\\Ấ\\Ầ\\Ẩ\\Ẫ\\Ậ\\é\\è\\ẻ\\ẽ\\ẹ\\ê\\ế\\ề\\ể\\ễ\\ệ\\É\\È\\Ẻ\\Ẽ\\Ẹ\\Ê\\Ế\\Ề\\Ể\\Ễ\\Ệ\\í\\ì\\ỉ\\ĩ\\ị\\Í\\Ì\\Ỉ\\Ĩ\\Ị\\ó\\ò\\ỏ\\õ\\ọ\\ô\\ố\\ồ\\ổ\\ỗ\\ộ\\ơ\\ớ\\ờ\\ở\\ỡ\\ợ\\Ó\\Ò\\Ỏ\\Õ\\Ọ\\Ô\\Ố\\Ồ\\Ổ\\Ỗ\\Ộ\\Ơ\\Ớ\\Ờ\\Ở\\Ỡ\\Ợ\\ú\\ù\\ủ\\ũ\\ụ\\ư\\ứ\\ừ\\ử\\ữ\\ự\\Ú\\Ù\\Ủ\\Ũ\\Ụ\\Ư\\Ứ\\Ừ\\Ử\\Ữ\\Ự\\ý\\ỳ\\ỷ\\ỹ\\ỵ\\Ý\\Ỳ\\Ỷ\\Ỹ\\Ỵ\\đ\\Đ]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
//-----------------------------------------------------------

    // Bắt lỗi tiếng việt có dấu
    public static boolean isUTF8MisInterpreted(String input) {
        return isUTF8MisInterpreted(input, "Windows-1252");
    }

    public static boolean isUTF8MisInterpreted(String input, String encoding) {

        CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
        CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
        ByteBuffer tmp;
        try {
            tmp = encoder.encode(CharBuffer.wrap(input));
        } catch (CharacterCodingException e) {
            return false;
        }

        try {
            decoder.decode(tmp);
            return true;
        } catch (CharacterCodingException e) {
            return false;
        }
    }
//-----------------------------------------------------------

    public static long Count_file_in_folder(String path) throws IOException {
        long count = Files.list(Paths.get(path)).count();
        return count;
    }

    public void Move_file(String from, String to) {
        try {
            File afile = new File(from);
            if (afile.renameTo(new File(to + afile.getName()))) {
                System.out.println("File is moved successful!");
            } else {
                System.out.println("File is failed to move!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
