/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeConverter
 * Author:   YuSong
 * Date:     2019/2/7 19:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.converters;

import com.syraven.springmvc.crud.entiy.Department;
import com.syraven.springmvc.crud.entiy.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/2/7
 * @since 1.0.0
 */
@Component
public class EmployeeConverter implements Converter<String, Employee> {

    @Override
    public Employee convert(String s) {
        if (s != null) {
            String[] vals = s.split("-");
            if (vals != null && vals.length == 4) {
                String lastName = vals[0];
                String email = vals[1];
                Integer gender = Integer.parseInt(vals[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(vals[3]));

                Employee employee = new Employee(null,lastName,email,gender,department);
                System.out.println(s+"--convert--"+ employee);
                return employee;
            }
        }
        return null;
    }
}