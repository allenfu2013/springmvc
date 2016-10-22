package org.allen.springmvc.controller;

import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.utils.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PingController {

    @RequestMapping(value = "ping", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponseDTO ping() {
        Logger.info(this, String.format("[ping] springmvc is running..."));
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setRetCode("00");
        apiResponseDTO.setRetMsg("springmvc is running...");
        int i = 1/0;
        return apiResponseDTO;
    }
}
