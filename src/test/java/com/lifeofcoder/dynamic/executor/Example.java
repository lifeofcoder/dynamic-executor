package com.lifeofcoder.dynamic.executor;

import com.lifeofcoder.dynamic.executor.service.DynamicExecuteService;
import org.junit.Assert;
import org.junit.Test;

import java.net.URLClassLoader;

/**
 * 示例
 *
 * @author cdliuhaibo
 * @date 2019-11-28
 */
public class Example {
    @Test
    public void test() {
        //代码内容和MyClass.JAVA一样
        String code = "package com.jd.template.market.core.dynamic.executor;\r\n"
                     + "\r\n" + "public class MyClass {\r\n"
                     + "    public String say(String str) {\r\n"
                     + "        return \"hello\" + str;\r\n"
                     + "    }\r\n" + "\r\n"
                     + "    public static void main(String[] args) {\r\n"
                     + "        System.out.println(new MyClass().say(\"bbbbb\"));\r\n"
                     + "    }\r\n" + "}\r\n"
                     + "";

        URLClassLoader urlClassLoader = (URLClassLoader)this.getClass().getClassLoader();
        DynamicExecuteService dynamicExecuteService = new DynamicExecuteService(urlClassLoader);
        String response = dynamicExecuteService.executeDynamically(code);

        //内容是用println输出的， 所以输出内容会有一个换行符，需要去掉之后再做对比
        Assert.assertEquals("hellobbbbb", response.trim());
    }
}