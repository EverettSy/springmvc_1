/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Employee
 * Author:   Raven
 * Date:     2019/1/17 17:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.crud.entiy;

import lombok.Data;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/17
 * @since 1.0.0
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Department department;
//    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;

    }

    public Employee(){

    }


}