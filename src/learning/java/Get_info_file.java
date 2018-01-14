package learning.java;

import java.io.File;
import java.text.SimpleDateFormat;
import static org.apache.commons.io.FilenameUtils.getBaseName;
import static org.apache.commons.io.FilenameUtils.getExtension;
import static org.apache.commons.io.FilenameUtils.isExtension;
import static org.apache.commons.io.FilenameUtils.removeExtension;
import static org.apache.commons.io.FilenameUtils.wildcardMatch;

public class Get_info_file {

    public static void main(String[] args) {
//        String path = "E:\\Project Video\\hoan thanh\\Happy new year 2016.mp4";
        String path = "D:\\Public\\Anniversary (Beethoven).mp3";
        File file = new File(path);

        String ext = getExtension(path);
        System.out.println("Đuôi file : " + ext);

        System.out.println("Khong lay ten duoi : " + removeExtension(path));
        System.out.println("Kiem tra duoi : " + isExtension(path, "mp4"));
        System.out.println("Tim kiem 1 tu trong chuoi : " + wildcardMatch(path, "*Happy*"));
        System.out.println("Chi lay ten file : " + getBaseName(path));

        if (file.exists()) {
            double bytes = file.length();
            double kilobytes = (bytes / 1024);
//            double megabytes = (kilobytes / 1024);
            double megabytes = ((double) Math.round((kilobytes / 1024) * 100) / 100);
            double gigabytes = (megabytes / 1024);
            double terabytes = (gigabytes / 1024);
//            double petabytes = (terabytes / 1024);
//            double exabytes = (petabytes / 1024);
//            double zettabytes = (exabytes / 1024);
//            double yottabytes = (zettabytes / 1024);

            System.out.println("bytes : " + bytes);
            System.out.println("kilobytes : " + kilobytes);
            System.out.println("megabytes : " + megabytes);
            System.out.println("gigabytes : " + gigabytes);
            System.out.println("terabytes : " + terabytes);
//            System.out.println("petabytes : " + petabytes);
//            System.out.println("exabytes : " + exabytes);
//            System.out.println("zettabytes : " + zettabytes);
//            System.out.println("yottabytes : " + yottabytes);
        } else {
            System.out.println("File does not exists!");
        }
        double bytes = file.getFreeSpace();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        double gigabytes = (megabytes / 1024);
        double round = (double) Math.round(gigabytes * 100) / 100;

        System.out.println("Dung lượng trống ổ đĩa: " + file.getFreeSpace());

        double bytes2 = file.getTotalSpace();
        double kilobytes2 = (bytes2 / 1024);
        double megabytes2 = (kilobytes2 / 1024);
        double gigabytes2 = (megabytes2 / 1024);
        double round2 = (double) Math.round(gigabytes2 * 100) / 100;
        System.out.println("Dung lượng ổ đĩa: " + round2);

//        double bytes3 = file.getUsableSpace();
//        double kilobytes3 = (bytes3 / 1024);
//        double megabytes3 = (kilobytes3 / 1024);
//        double gigabytes3 = (megabytes3 / 1024);
//        double round3 = (double) Math.round(gigabytes3 * 100) / 100;
//        System.out.println("Dung lượng đã sử dụng: " + file.getUsableSpace());

        System.out.println("Folder chua file: " + file.getParent());
        //--------------------------------------------------------------
        //--------------------------------------------------------------
        System.out.println("Before Format : " + file.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("After Format : " + sdf.format(file.lastModified()));

    }
}
