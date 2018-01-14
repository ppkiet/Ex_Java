/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.java;


public class Delete_HTML_txt {

    public static String stripHtmlRegex(String source) {
	// Replace all tag characters with an empty string.
	return source.replaceAll("<.*?>", "");
    }

    public static String stripTagsCharArray(String source) {
	// Create char array to store our result.
	char[] array = new char[source.length()];
	int arrayIndex = 0;
	boolean inside = false;

	// Loop over characters and append when not inside a tag.
	for (int i = 0; i < source.length(); i++) {
	    char let = source.charAt(i);
	    if (let == '<') {
		inside = true;
		continue;
	    }
	    if (let == '>') {
		inside = false;
		continue;
	    }
	    if (!inside) {
		array[arrayIndex] = let;
		arrayIndex++;
	    }
	}
	// ... Return written data.
	return new String(array, 0, arrayIndex);
    }

    public static void main(String[] args) {

	final String html = "<p id=a>Sometimes, <b>simpler</b> is better, "
		+ "but <i>not</i> always.</p>";
	System.out.println(html);
	String test = stripHtmlRegex(html);
	System.out.println(test);
	String test2 = stripTagsCharArray(html);
	System.out.println(test2);
    }
}
