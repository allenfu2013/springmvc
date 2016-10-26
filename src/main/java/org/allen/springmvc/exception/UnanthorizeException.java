package org.allen.springmvc.exception;

public class UnanthorizeException extends RuntimeException {

    private String retCode = "10";
    private String retMsg = "Unanthorize";

    public UnanthorizeException() {
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
