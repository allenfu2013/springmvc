package org.allen.springmvc.interceptor;

import org.allen.springmvc.exception.UnanthorizeException;
import org.allen.springmvc.utils.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessInterceptor implements HandlerInterceptor {

    // 在业务处理器处理请求之前被调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String api = request.getPathInfo();
        String authCode = request.getParameter("authCode");
        Logger.info(this, String.format("api=%s, authCode=%s, object=%s", api, authCode, o));
        if (authCode == null) {
            throw new UnanthorizeException();
        }
        request.setAttribute("api", api);
        request.setAttribute("authCode", authCode);
        return true;
    }

    // 在业务处理器处理请求执行完成后,生成视图之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        Logger.info(this, String.format("@@@@@@@@@@@@@@@@@@@@@@"));
    }

    // 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        Logger.info(this, String.format("######################"));
    }
}
