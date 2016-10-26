package org.allen.springmvc.filter;

import com.alibaba.fastjson.JSON;
import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.utils.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class AccessFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authCode = request.getParameter("authCode");
        String api = request.getPathInfo();
        request.setAttribute("api", api);
        request.setAttribute("authCode", authCode);
        Logger.info(this, String.format("authCode=%s, api=%s", authCode, api));
        if (authCode == null) {
            ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
            apiResponseDTO.setRetCode("10");
            apiResponseDTO.setRetMsg("Unauthorized");
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(apiResponseDTO));
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
