package com.packt.learnjava.ch12_tools;
/** This class shows example of the code snippets
   embedded in the API documentation. For example, class usage:
 {@snippet :
  * // @highlight substring="cs" region="example1"
  * var cs = new CodeSnippetsDemo();
  * cs.method();
  * // @end region="example1"
  *}
 And here is a reference to another class doc
 {@snippet class="CodeSnippets"}

 or we can refer another code region only
 {@snippet class=CodeSnippets region=snippet1}

 It is possible to refer to non-code file, too.
 For example, imagine we want to show certain properties
 used by this class as follows:
 {@snippet file='demo.properties' region=prop1}
 */
public class CodeSnippetsDemo {
    /**
     * This is example of a code snippet embedded in the method description:
     *
     * {@snippet :
     * CodeSnippetsDemo codeSnippetsDemo = new CodeSnippetsDemo();
     * codeSnippetsDemo.method();
     *}
     */
    public void method(){
    }
}
