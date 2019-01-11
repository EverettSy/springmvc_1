/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   Raven
 * Date:     2019/1/10 10:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.springmvc.entites;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/10
 * @since 1.0.0
 */
@Data
public class User {

    private String username;
    private String password;
    private String email;
    private String age;
    private Address address;

    public User(String username, String password, String email, String age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }


    public User() {
    }
}