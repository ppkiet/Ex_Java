/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 * A complete Java class that demonstrates how to create an HTML viewer with
 * styles, using the JEditorPane, HTMLEditorKit, StyleSheet, and JFrame.
 *
 * @author alvin alexander, devdaily.com.
 *
 */
public class HtmlEditorKitTest {

    public static void main(String[] args) {
        new HtmlEditorKitTest();
    }

    public HtmlEditorKitTest() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // create jeditorpane
                JEditorPane jEditorPane = new JEditorPane();

                // make it read-only
                jEditorPane.setEditable(false);

                // create a scrollpane; modify its attributes as desired
                JScrollPane scrollPane = new JScrollPane(jEditorPane);

                // add an html editor kit
                HTMLEditorKit kit = new HTMLEditorKit();
                jEditorPane.setEditorKit(kit);

                // add some styles to the html
                StyleSheet styleSheet = kit.getStyleSheet();
                styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
                styleSheet.addRule("h1 {color: blue;}");
                styleSheet.addRule("h2 {color: #ff0000;}");
                styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

                // create some simple html as a string
                String htmlString
                        = "<html>\n"
                        + "Create table with using different font styles and colors:\n"
                        + "<h1>C-#corner.com</h1>\n"
                        + "<table border=3 margin=3>\n"
                        + "<tr>\n"
                        + "<td><font color=red>1</font></td>\n"
                        + "<td><font color=blue>2</font></td>\n"
                        + "<td><font color=green>3</font></td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td><font size=-2>4</font></td>\n"
                        + "<td><font size=+2>5</font></td>\n"
                        + "<td><i>6</i></td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td><b>7</b></td>\n"
                        + "<td>8</td>\n"
                        + "<td>9</td>\n"
                        + "</tr>\n"
                        + "</table>";

                // create a document, set it on the jeditorpane, then add the html
                Document doc = kit.createDefaultDocument();
                jEditorPane.setDocument(doc);
                jEditorPane.setText(htmlString);

                // now add it all to a frame
                JFrame j = new JFrame("HtmlEditorKit Test");
                j.getContentPane().add(scrollPane, BorderLayout.CENTER);

                // make it easy to close the application
                j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // display the frame
                j.setSize(new Dimension(300, 200));

                // pack it, if you prefer
                j.pack();

                // center the jframe, then make it visible
                j.setLocationRelativeTo(null);
                j.setVisible(true);
            }
        });
    }
}
