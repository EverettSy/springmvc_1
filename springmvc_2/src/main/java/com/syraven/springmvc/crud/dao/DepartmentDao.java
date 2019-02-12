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

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));

    }

    public Collection<Department> getDepartments() {
        return departments.values();
    }

    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}