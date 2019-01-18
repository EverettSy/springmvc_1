/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DepartmentDao
 * Author:   Raven
 * Date:     2019/1/18 10:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.crud.dao;

import com.syraven.springmvc.crud.entiy.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/18
 * @since 1.0.0
 */
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<Integer,Department>();

        departmentMap.put(101,new Department(101,"D-AA"));
        departmentMap.put(102,new Department(102,"D-BB"));
        departmentMap.put(103,new Department(103,"D-CC"));
        departmentMap.put(104,new Department(103,"D-DD"));
        departmentMap.put(105,new Department(103,"D-EE"));

    }

    public Collection<Department> getDepartments(){
        return departmentMap.values();
    }

    public Department getDepartment(Department id){
        return departmentMap.get(id);
    }

}