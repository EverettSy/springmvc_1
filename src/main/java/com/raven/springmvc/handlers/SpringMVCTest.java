/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpringMVCTest
 * Author:   Raven
 * Date:     2019/1/3 17:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.springmvc.handlers;

import com.raven.springmvc.entites.User;
import javafx.scene.shape.VLineTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/3
 * @since 1.0.0
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    @RequestMapping("/testPojo")
    private String testPojo(User user) {
        System.out.println("testPojo:"+user);
        return SUCCESS;
    }

    /**
     * 了解：
     *
     * @param ssesionid
     * @return
     * @CookieValue:映射一个cookie值，属性同@RequestParm
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String ssesionid) {
        System.out.println("testCookieValue:" + ssesionid);
        return SUCCESS;
    }

    /**
     * 用法同@RequestParam
     *
     * @param AL
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Language") String AL) {
        System.out.println("testRequestHeader,Accept-Language" + AL);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数
     * value 值即请求参数的参数名
     * required 该参数是否必须，默认为true
     * defaultValue请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username") String user,
                                   @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam,username: " + user + " age: " + age);
        return SUCCESS;
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id) {
        System.out.println("testRest Get:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest Post");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest DELETE:" + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest PUT:" + id);
        return SUCCESS;
    }

    /**
     * @param id
     * @return
     * @PathVariable 可以来映射URL中占位符到目标方法的参数中。
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable:" + id);
        return SUCCESS;
    }

    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;

    }

    /**
     * 了解：可以使用params 和headers来更加精确的映射请求,params 和headers支持简单的表达式
     *
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = {"username", "age!=10"}, headers = {"Accept-Language=en-US,zh;q=0.9"})
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 常用：使用method属性来指定请求方式
     *
     * @return
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 1. @RequestMapping 除了修饰方法，还可以修饰类
     * 2.
     * 1)、类定义处：提供初步的请求映射信息。相对于WEB应用的根目录
     * 2)、方法定义处：提供进一步的细分映射信息。
     * 相对于类定义处的URL。若类定义处未标注@RequestMapping
     * 则方法处标注的URL相对于WEB应用根目录
     *
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}