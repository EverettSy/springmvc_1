/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: EmployeeDao
 * Author:   Raven
 * Date:     2019/1/17 17:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.crud.dao;

import com.syraven.springmvc.crud.entiy.Department;
import com.syraven.springmvc.crud.entiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/17
 * @since 1.0.0
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employeeMap = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<Integer, Employee>();

        employeeMap.put(1001, new Employee(1001, "E-AA", "SY75955@163.com", 1, new Department(101, "D-AA")));
        employeeMap.put(1002, new Employee(1002, "E-BB", "SY759551@163.com", 1, new Department(102, "D-BB")));
        employeeMap.put(1003, new Employee(1003, "E-CC", "SY759552@163.com", 0, new Department(103, "D-CC")));
        employeeMap.put(1004, new Employee(1004, "E-DD", "SY7595523@163.com", 0, new Department(104, "D-DD")));
        employeeMap.put(1005, new Employee(1005, "E-EE", "SY7595543@163.com", 1, new Department(105, "D-EE")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment()));
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

    public Employee get(Integer id) {
        return employeeMap.get(id);
    }

    public void delete(Integer id) {
        employeeMap.remove(id);
    }
}