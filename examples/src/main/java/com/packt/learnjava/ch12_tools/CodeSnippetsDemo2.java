package com.packt.learnjava.ch12_tools;
/** This class shows example of the code snippets
 *  embedded in the API documentation.
 * Use the following command to generate API docs from the examples directory:
 * javadoc -d ~/apidoc --snippet-path src/main/java/com/packt/learnjava/ch12_tools/snippet-files src/main/java/com/packt/learnjava/ch12_tools/CodeSnippetsDemo2.java
 *
 * Class usage example:
 * {@snippet :
 *   // @highlight substring="cs" region="example1"
 *   var cs = new CodeSnippetsDemo();
 *   cs.method();
 *   // @end region="example1"
 * }
 * And here is a reference to another class doc:
 * {@snippet class="CodeSnippets"}
 *
 * or we can refer another code region only
 * {@snippet class=CodeSnippets region=snippet1}
 *
 * It is possible to refer to non-code file, too.
 * For example, imagine we want to show certain properties
 * used by this class as follows:
 * {@snippet file='demo.properties' region=prop1}
 */
public class CodeSnippetsDemo2 {
    /**
     * This is default constructor
     */
    public CodeSnippetsDemo2(){}
    /**
     * This is example of a code snippet embedded in the method description:
     * {@snippet lang = "java":
     * CodeSnippetsDemo codeSnippetsDemo = new CodeSnippetsDemo();
     * codeSnippetsDemo.method();  // @highlight substring="method()"
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
