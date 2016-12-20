package org.allen.springmvc.controller;

import org.allen.springmvc.dto.ApiResponseDTO;
import org.allen.springmvc.entity.ValBean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class ValidateController {

    @RequestMapping(value = "changeLocale", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponseDTO changLocale(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam(value = "langType", defaultValue = "zh") String langType) {
        if (langType.equals("zh")) {
            Locale locale = new Locale("zh", "CN");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        } else if (langType.equals("en")) {
            Locale locale = new Locale("en", "US");
            (new CookieLocaleResolver()).setLocale(request, response, locale);
        } else {
            (new CookieLocaleResolver()).setLocale(request, response, LocaleContextHolder.getLocale());
        }
        return new ApiResponseDTO().setRetCode("00").setRetMsg("Success");
    }

    @RequestMapping(value = "validate", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponseDTO validate(@Valid @RequestBody ValBean bean, BindingResult result) {
        if (result.hasErrors()) {
            return new ApiResponseDTO().setRetCode("99").setRetMsg("System error").setData(getErrors(result));
        } else {
            // 业务逻辑
            return new ApiResponseDTO().setRetCode("00").setRetMsg("Success");
        }
    }

    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            System.out.println(String.format("field:%s, message:%s", error.getField(), error.getDefaultMessage()));
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }
}
