package org.allen.springmvc.handler;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.allen.springmvc.utils.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object object,
                                         Exception exception) {

        Logger.info(this, String.format("api:%s, obj:%s, e:%s", request.getRequestURI(), object, exception));
        ModelAndView mv = new ModelAndView();

        // process according specified exception
        /*if (exception instanceof RuntimeException) {
            ...
        } else if() {

        }*/


        FastJsonJsonView view = new FastJsonJsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("retCode", "99");
        attributes.put("retMsg", "SystemError");
        view.setAttributesMap(attributes);
        mv.setView(view);
        return mv;
    }
}
