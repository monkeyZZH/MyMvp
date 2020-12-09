package com.example.mymvp.RxJava.Net;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 17:14
 */
public class ResultException extends RuntimeException {

    private int errCode = 0;

    public ResultException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }
}