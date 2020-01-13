package com.fengf.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Result<T> {

    public Integer status;
    public String message;
    public T data;

    public Result(T data) {
        this.status = 0;
        this.message = null;
        this.data = data;
    }
    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

//    public String toString() {
//        return ""
//    }

    @JsonIgnore
    public Boolean isOk(){
        return status == 0;
    }


    @JsonIgnore
    public Boolean isNotOk(){
        return status != 0;
    }

}
