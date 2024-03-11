package com.packt.learnjava.ch12_tools;
/**
 * This is class that shows snippets usage
 * Use the following command to generate API docs from the examples directory:
 * javadoc -d ~/apidoc src/main/java/com/packt/learnjava/ch12_tools/CodeSnippetsDemo.java
 */
public class CodeSnippetsDemo {
    /**
     * This is default constructor
     */
    public CodeSnippetsDemo(){}
    /**
     * This is example of a code snippet embedded in the method description:
     * {@snippet lang="java" :
     * CodeSnippetsDemo codeSnippetsDemo = new CodeSnippetsDemo();
     * codeSnippetsDemo.method();  // @highlight substring="method()" type="highlighted"
     *}
     * And this is an example of properties snippet:
     * {@snippet lang=properties :
     * property1=some string
     * property2=42
     *}
     */
    public void method(){
    }
}
