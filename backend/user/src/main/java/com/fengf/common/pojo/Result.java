package com.fengf.common.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.val;

@ApiModel(value = "数据返回包装模型", description = "数据返回包装模型")
public class Result<T> {

    @ApiModelProperty(value="状态码", required = true)
    public Integer status;
    @ApiModelProperty(value="错误信息", required = false)
    public String message;
    @ApiModelProperty(value="数据", required = false)
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
