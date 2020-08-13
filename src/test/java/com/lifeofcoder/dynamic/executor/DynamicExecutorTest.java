package com.lifeofcoder.dynamic.executor;

import com.lifeofcoder.dynamic.executor.bytecode.InjectionSystem;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Unit test for simple App.
 */
public class DynamicExecutorTest {
    @Test
    public void testFullFunction() throws InterruptedException {
        //代码内容和MyClass.JAVA一样
        String src = "package com.jd.template.market.core.dynamic.executor;\r\n"
                     + "\r\n" + "public class MyClass {\r\n"
                     + "    public String say(String str) {\r\n"
                     + "        return \"hello\" + str;\r\n"
                     + "    }\r\n" + "\r\n"
                     + "    public static void main(String[] args) {\r\n"
                     + "        System.out.println(new MyClass().say(\"bbbbb\"));\r\n"
                     + "    }\r\n" + "}\r\n"
                     + "";

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintWriter out = new PrintWriter(buffer, true);

        byte[] classBytes = DynamicLoaderEngine.compile(src, out, null);
        byte[] injectedClass = ClassInjector.injectSystem(classBytes);

        InjectionSystem.inject(null, new PrintStream(buffer, true), null);
        DynamicClassLoader classLoader = new DynamicClassLoader(this.getClass().getClassLoader());
        DynamicLoaderEngine.executeMain(classLoader, injectedClass, out);

        Assert.assertEquals("hellobbbbb", buffer.toString());
    }
}
