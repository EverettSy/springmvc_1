/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeController
 * Author:   Raven
 * Date:     2019/1/18 11:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.crud.controller;

import com.syraven.springmvc.crud.dao.DepartmentDao;
import com.syraven.springmvc.crud.dao.EmployeeDao;
import com.syraven.springmvc.crud.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/18
 * @since 1.0.0
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping(value = "emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employeeMap",employeeDao.getAll());
        return "list";
    }
}