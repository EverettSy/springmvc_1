/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloWorld
 * Author:   Raven
 * Date:     2019/1/3 16:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/3
 * @since 1.0.0
 */
@Controller
public class HelloWorld {

    /**
     * 1. 使用@RequestMapping 注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图,对于InternalResourceViewResolver视图解析器,会做如下的解析：
     * 通过prefix + returnVal + 后缀 这样的方式得到实际的物理视图,然后做转发操作
     *
     * /WEB-INF/views/success.jsp
     *
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("Hello World");
        return "success";
    }
}