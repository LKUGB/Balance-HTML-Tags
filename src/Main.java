/**
 * Program to read an HTML file as a string and check to
 * see if tags that are supposed to be paired are balanced.
 *
 * Initial developer:  Stan Thomas
 * Illustrates use of:  String, StringBuilder, RegEx, TreeSet, Stack
 *
 * Modified and submitted by:
 *
 * Honor statement:
 *
 */

// Imports
import java.util.regex.*;
import java.util.Stack;
import java.util.*;
import java.io.FileReader;

public class Main{

    /**
     * Method to read the SelfClosingTags file and return a Set of
     * Strings corresponding to the HTML SelfClosingTags
     * @return
     */
    private static Set<String> readTags2Skip(){
        // create a Set of tags to be ignored when scanning HTML file
        // the file is named SelfClosingTags
        Set<String> taglist = new TreeSet<String>();

        // TODO

        return taglist;
    }

    public static void main(String args[]){

        // read names of SelfClosingTags from file and create a Set
        Set<String> selfClosingTags = readTags2Skip();

        // TODO
        // ask user for a URL, including http:// or https://
        // read the URL and use a method in the ReadWebPage class
        // to read the web page into a String

        // TODO
        // Remove HTML comments from the String containing the HTML
        // The Regex pattern will match HTML comments

        // TODO
        // compile a Pattern to match HTML tags
        // the RegEx to match HTML tags is "<(/?)([a-zA-Z]+)"
        // Details will be discussed in class
        //
        // In order to use this Pattern repeatedly you need to create
        // a Matcher object.  Examples given in class.
        // using a regular expression, set up a matcher for finding
        // a "<tag" or "</tag" in the web page. This Matcher object
        // must be used inside a loop to find the tags one by one

        // TODO
        // create an empty Stack

        // TODO
        // Repeatedly use the find() method for Matchers to locate
        // tags. Note that using the pattern identified above, the
        // tag will be identified as the matcher's group(2)

        // TODO
        // use the Stack .push() and .pop() methods to determine whether
        // or not the tags in the file are paired correctly. Any tag in
        // the selfClosingTags Set should be ignored.

        // TODO
        // If the Stack is empty the tags were balanced, else they were not.
        // Report the results with messages such as the following.  Your
        // variable names may be different.

        //System.out.println("Analysis of " + URLname);
        //System.out.println("The HTML tags are" +
        //                     (myStack.empty() ? "" : " not") + " balanced.");
    }
}