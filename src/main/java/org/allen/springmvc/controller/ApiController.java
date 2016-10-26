package org.allen.springmvc.controller;

import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.utils.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api")
public class ApiController {

    @RequestMapping("/**/*")
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
}
