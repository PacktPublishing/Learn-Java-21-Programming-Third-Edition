import com.packt.learnjava.ch12_tools.CodeSnippetsDemo;

/**
 * This class is referred from another class API doc
 */
public class CodeSnippets {
    public void method2(){
        int x = 1, y = 2;

        if (x > y) {                     // @highlight substring="x"
            System.out.println("x > y"); // @replace substring='out' replacement=""
        }
        // @start region=snippet1
        var cs = new CodeSnippetsDemo(); // @link substring="method()" target="#method" type="link" :
        cs.method();
        // @end region=snippet1
        if (x > y) {                     // @highlight substring="y" :
            System.out.println("x > y"); // @highlight substring="print" type="highlighted"
        } else {
            System.out.println("x <= y");// @highlight substring="System" type="italic"
        }
        var z = "SomeString";            // @replace regex='\".*g\"' replacement="..."
        System.out.println(z);           // @highlight regex='S.*m'
        // @highlight substring="csd" type="highlighted" region=snippet2
        var csd = new CodeSnippetsDemo();
        csd.method();
        // @end region=snippet2
        System.out.println("The end");   // @link substring="System.out" target="System#out"
    }
}
