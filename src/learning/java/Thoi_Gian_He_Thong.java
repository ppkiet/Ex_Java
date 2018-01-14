/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Thoi_Gian_He_Thong {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        /**
         * thuc hien cac phuong thuc tai day       
         */
        // Thời gian chạy chương trình
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("time: "+time);
        //
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss ");
        Date date = new Date();
        String day = dateFormat.format(date);
        System.out.println(day);
    }
    
}
