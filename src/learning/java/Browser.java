/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.io.IOException;

class Browser {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rTime = Runtime.getRuntime();
        String url = "E:/netbean/Learning%20java/test.html";
        String browser = "C:\\Users\\PC\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe ";
        Process pc = rTime.exec(browser + url);
        pc.waitFor();
    }

}
