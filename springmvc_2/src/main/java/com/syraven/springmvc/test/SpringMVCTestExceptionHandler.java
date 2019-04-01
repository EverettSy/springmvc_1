/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExceptionHandler
 * Author:   Raven
 * Date:     2019/4/1 15:14
 * Description: 异常处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br>
 * 〈异常处理类〉
 *
 * @author Raven
 * @create 2019/4/1
 * @since 1.0.0
 */
@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringMVCTestExceptionHandler.class);

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        LOGGER.info("->>>>>出异常了："+ex);
        System.out.println(("->>>>>出异常了："+ex));
       ModelAndView mv = new ModelAndView("error");
       mv.addObject("exception",ex);
       return mv;
    }
}
