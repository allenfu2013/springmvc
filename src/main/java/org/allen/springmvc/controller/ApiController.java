package org.allen.springmvc.controller;

import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.utils.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ApiController {

    @RequestMapping("/api/**/*")
    @ResponseBody
    public ApiResponseDTO dataApi(HttpServletRequest request, HttpServletResponse response) {
        String api = (String) request.getAttribute("api");
        String authCode = (String) request.getAttribute("authCode");
        Logger.info(this, String.format("api=%s, authCode=%s", api, authCode));
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setRetCode("00");
        apiResponseDTO.setRetMsg("success");
        return apiResponseDTO;
    }

    /**
     * Spring MVC对于url的匹配采用的是一种叫做“最精确匹配的方式”, 所有api都配置不到時才进入此方法
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("*")
    @ResponseBody
    public ApiResponseDTO apiNotFound(HttpServletRequest request, HttpServletResponse response) {
        Logger.info(this, String.format("request: %s", request.getRequestURI()));
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setRetCode("10");
        apiResponseDTO.setRetMsg("api not found, please see api doc");
        return apiResponseDTO;
    }
}
