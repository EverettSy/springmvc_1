/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SpringMVCTest
 * Author:   YuSong
 * Date:     2019/2/7 19:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.test;

import com.syraven.springmvc.crud.dao.EmployeeDao;
import com.syraven.springmvc.crud.entiy.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/2/7
 * @since 1.0.0
 */
@Controller
public class SpringMVCTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringMVCTest.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ResourceBundleMessageSource messageSource;


    /*@ExceptionHandler({RuntimeException.class})
    public ModelAndView handleArithmeticException2(Exception ex){
        LOGGER.info("[出异常了]："+ex);
        System.out.println("[出异常了]："+ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }*/
    /**
     * 1. 在@ExceptionHandler 方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
     * 2. @ExceptionHandler 方法的入参中不能传入Map.若希望把异常信息传到页面上，需要使用ModelAndView 作为返回值
     * 3. @ExceptionHandler 方法标记的异常有优先级的问题。
     * 4. @ControllerAdvice 标记的类中查找@ExceptionHandler标记的方法处理异常
     */
    /*@ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        LOGGER.info("出异常了："+ex);
       ModelAndView mv = new ModelAndView("error");
       mv.addObject("exception",ex);
       return mv;
    }*/

    @RequestMapping("/testExceptionHandlerResolverExceptionResolver")
    private String testExceptionHandlerResolverExceptionResolver(@RequestParam("i") int i){
        LOGGER.info("result: "+(10/i));
        return "success";
    }

    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc
    ) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        return "success";
    }

    @RequestMapping("/i18n")
    public String testI18n(Locale locale) {
        String val = messageSource.getMessage("il8n.user", null, locale);
        System.out.println(val);
        return "i18n";
    }

    /**
     * 下载 files/abc.txt文件
     * ResponseEntity<T>用于作为处理方法的返回值</>
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws Exception {
        byte[] body = null;
        ServletContext servletContext = session.getServletContext();
        InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=abc.txt");

        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }

    /**
     * 上传文件方法
     *
     * @param body
     * @return
     */
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println(body);
        return "helloworld! " + new Date();
    }

    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson() {
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee) {
        System.out.println("save: " + employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }
}
