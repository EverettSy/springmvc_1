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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/3
 * @since 1.0.0
 */
@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外，（实际上使用的是value属性值）
     * 还可以通过模型的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性)
     *
     * 注意：该注解只能放到类上，不能放到方法上
     * @param map
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String  testSessionAttributes(Map<String,Object> map){
        User user = new User("Tom","12334","xjjfdjf@qq.com","15");
        map.put("user",user);
        map.put("school","abotr");
        return SUCCESS;
    }

    /**
     * 目标方法可以添加Map类型的参数(实际上也可以是Model类型或ModelMap类型)的参数
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom","Mono","Mike"));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * SpringMvc会把ModelAndView的model中的数据放入到request域对象中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);

        //添加模型数据 ModelAndView 中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

    /**
     * @param request
     * @param response
     * @param out
     * @throws IOException
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + "," + response);
        out.write("hello springmvc");
        // return SUCCESS;
    }

    /**
     * SpringMvc 会按请求参数名和POJO 属性名进行自动匹配，
     * 自动为该对象填充属性值。支持级联属性。
     * 如：dept。deptId、dept.address.tel等
     *
     * @param user
     * @return
     */
    @RequestMapping("/testPojo")
    private String testPojo(User user) {
        System.out.println("testPojo:" + user);
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