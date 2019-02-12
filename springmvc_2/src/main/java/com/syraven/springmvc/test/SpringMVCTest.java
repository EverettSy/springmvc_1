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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

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

    @Autowired
    private EmployeeDao employeeDao;


    @ResponseBody
    @RequestMapping("/testJson")
    public Collection<Employee> testJson(){
        return employeeDao.getAll();
    }

    @RequestMapping("/testConversionServiceConverer")
    public String testConverter(@RequestParam("employee") Employee employee){
        System.out.println("save: "+employee);
        employeeDao.save(employee);

        return "redirect:/emps";
    }
}