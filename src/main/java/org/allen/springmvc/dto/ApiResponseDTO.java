package org.allen.springmvc.dto;

public class ApiResponseDTO {

    private String retCode;

    private String retMsg;

    private Object data;

    public String getRetCode() {
        return retCode;
    }

    public ApiResponseDTO setRetCode(String retCode) {
        this.retCode = retCode;
        return this;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public ApiResponseDTO setRetMsg(String retMsg) {
        this.retMsg = retMsg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ApiResponseDTO setData(Object data) {
        this.data = data;
        return this;
    }
}
