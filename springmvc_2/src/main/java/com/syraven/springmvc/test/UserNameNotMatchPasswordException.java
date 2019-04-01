/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserNameNotMatchPasswordException
 * Author:   Raven
 * Date:     2019/4/1 15:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.syraven.springmvc.test;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Raven
 * @create 2019/4/1
 * @since 1.0.0
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户名和密码不匹配！")
public class UserNameNotMatchPasswordException extends  RuntimeException {

    private static final long serialVersionUID = 1033616117787441377L;

}
