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
import java.util.Scanner;
import java.io.BufferedReader;
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
        Set<String> taglist = new TreeSet<>();

        // TODO
        String s; //declare empty string to temporarily save the string in a line
        try {
            FileReader fr = new FileReader("src/SelfClosingTags"); //include file name
            BufferedReader br = new BufferedReader(fr);

            //put s = br.readLine() inside the loop in order to update variable "s"
            while ((s = br.readLine()) != null) {
                taglist.add(s); //use add(E e) method to add the string to the set
            }
            fr.close(); //close the file
        }
        //jump to catch statement when error is found during the file read
        catch(Exception e){
            e.printStackTrace(); //print out the error message if the file not found exception occurs
        }
        return taglist;
    }

    public static void main(String[] args){

        // read names of SelfClosingTags from file and create a Set
        Set<String> selfClosingTags = readTags2Skip();

        // TODO
        // ask user for a URL, including http:// or https://
        // read the URL and use a method in the ReadWebPage class
        // to read the web page into a String
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter a URL to check the balance of its tags: ");
        String url = scnr.nextLine();
        String html = ReadWebPage.readWebPage(url); //call static method from ReadWebPage class


        // TODO
        // Remove HTML comments from the String containing the HTML
        // The Regex pattern "(?=<!--)([\\s\\S]*?)-->" will match HTML comments
        html = html.replaceAll( "(?=<!--)([\\s\\S]*?)-->", "");


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
        Pattern p = Pattern.compile("<(/?)([a-zA-Z]+)");
        Matcher m = p.matcher(html);


        // TODO
        // create an empty Stack
        Stack<String> myStack = new Stack<>();
        myStack.push("null"); //push an "null" string onto the stack to avoid EmptyStackException thrown by peek() method


        // TODO
        // Repeatedly use the find() method for Matchers to locate
        // tags. Note that using the pattern identified above, the
        // tag will be identified as the matcher's group(2)
        while(m.find()){


        // TODO
        // use the Stack .push() and .pop() methods to determine whether
        // or not the tags in the file are paired correctly. Any tag in
        // the selfClosingTags Set should be ignored.
            if(selfClosingTags.contains(m.group(2))) {
                continue; //if it is a selfClosingTag, we ignore and continue
            }
            else if(m.group(2).equals(myStack.peek())){
                myStack.pop(); //if it matches the top of the stack, we pop the stack
            }
            else{
                myStack.push(m.group(2)); //if it does not match, it should be pushed onto the stack
            }
        }

        if(myStack.size() == 1){ //if there is only "null" on the stack, we clear the stack and return balanced
            myStack.pop();
        }


        // TODO
        // If the Stack is empty the tags were balanced, else they were not.
        // Report the results with messages such as the following.  Your
        // variable names may be different.

        System.out.println("Analysis of " + url);
        System.out.println("The HTML tags are" + (myStack.empty() ? "" : " not") + " balanced.");
    }
}
