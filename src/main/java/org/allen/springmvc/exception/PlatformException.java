package org.allen.springmvc.exception;

public class PlatformException extends RuntimeException {

    private String retCode = "01";
    private String retMsg = "Server internal error occur";

    public PlatformException(Throwable e) {
        super(e);
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
