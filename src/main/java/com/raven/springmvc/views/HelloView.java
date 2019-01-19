/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloView
 * Author:   Raven
 * Date:     2019/1/16 16:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.springmvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Raven
 * @create 2019/1/16
 * @since 1.0.0
 */
@Component
public class HelloView implements View {


    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
            httpServletResponse.getWriter().print("hello ,view,time: "+new Date());
    }
}