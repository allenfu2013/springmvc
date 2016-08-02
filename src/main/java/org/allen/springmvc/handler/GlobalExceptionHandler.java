package org.allen.springmvc.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by allen on 16/8/3.
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object object, Exception exception) {
        System.out.println("!!!!!!!!!");
        ModelAndView mv = new ModelAndView();
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType("application/json;charset=UTF-8"); //设置ContentType
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write("{\"success\":false,\"msg\":\"" + exception.getMessage() + "\"}");
        } catch (IOException e) {

        }
        return mv;
    }
}
