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
@SessionAttributes(value = {"user"}, types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    private static final String SUCCESS = "success";

    @RequestMapping("/testView")
    public String testView() {
        System.out.println("testView");
        return "helloView";
    }

    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver() {
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    /**
     * 1. 有@ModelAttribute 标记的方法，会在每个目标方法执行之前被SpringMVC调用！
     * 2. @ModelAttribute 注解也可以来修饰目标方法POJO类型的入参，其value属性值有如下作用
     * 1). SpringMVC 会使用value 属性值在在implicitModel中查找对应的对象，若存在则会直接传入目标方法的入参中，
     * 2). SpringMVC 会————value为key,POJO 类型的对象为value，存入到request中。
     *
     * @param id
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map<String, Object> map) {
        System.out.println("modelAttribute method");
        if (id != null) {
            //模拟从数据库中获取数据
            User user = new User(1, "Raven", "12345", "sy7509977423@163.com", 12);
            System.out.println("从数据库中获取一个对象：" + user);

            map.put("user", user);

        }

    }

    /**
     * 运行流程：
     * 1. 执行@ModelAttribute 修饰的方法：从数据库中取出对象,把对象放入Map中.键为：user
     * 2. SpringMVC 从Map 中取出User对象，并把表单的请求参数赋给该User对象的对应属性。
     * 3. SpringMVC 把上述对象传入目标方法的参数。
     * <p>
     * 注意：@ModelAttribute修饰的方法中年，放入到 Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致。
     * <p>
     * SpringMVC 确定目标方法POJO类型入参的过程
     * 1. 确定一个key:
     * 1). 若目标方法的POJO的参数木有使用@ModelAttribute 作为修饰，则key 为POJO类名第一个字母的小写
     * 2). 若使用了@ModelAttribute 来修饰，则key为@ModelAttribute注解的value属性值
     * 2. 在implicitModel 中查找key对应的对象，若存在，则作为入参传入
     * 1). 若在 @ModelAttribute 标记的方法中在Map 中保存过，且key和1确定的key一致，则会获取到。
     * <p>
     * 3. 在implicitModel 中不存在key对应的对象，则检查当前的Handler是否使用@SessionAttributes 注解修饰,
     * 若使用了该注解，且@SessionAttributes 注解的value 属性值中包含了key,则会从HttpSession中获取
     * key所对应的value 值，若存在则直接传入到目标方法的入参中，若不存在则抛出异常
     * 4. 若handler 没有标识@SessionAttributes 注解或@SessionAttributes注解的value值中不包含key,则会
     * 通过反射来创建POJO类型的参数，传入为目标方法的参数
     * 5. SpringMVC 会把key POJO类型的对象 保存到impicitModel中，进而会保存到request中。
     * <p>
     * 源码分析流程
     *
     * @param user
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user) {
        System.out.println("修改: " + user);
        return SUCCESS;
    }

    /**
     * @param map
     * @return
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外，（实际上使用的是value属性值）
     * 还可以通过模型的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性)
     * <p>
     * 注意：该注解只能放到类上，不能放到方法上
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map) {
        User user = new User("Tom", "12334", "xjjfdjf@qq.com", 15);
        map.put("user", user);
        map.put("school", "abotr");
        return SUCCESS;
    }

    /**
     * 目标方法可以添加Map类型的参数(实际上也可以是Model类型或ModelMap类型)的参数
     *
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        System.out.println(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Mono", "Mike"));
        return SUCCESS;
    }

    /**
     * 目标方法的返回值可以是ModelAndView类型
     * 其中可以包含视图和模型信息
     * SpringMvc会把ModelAndView的model中的数据放入到request域对象中
     *
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