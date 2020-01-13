package com.fengf.common;

import lombok.Data;

import java.util.List;

/**
 * 分页结果对象,这里以layui框架的table为标准
 *
 * @author wangfan
 * @date 2017-7-24 下午4:28:59
 */
@Data
public class PageResult<T> {

    private int code; // 状态码, 0 表示成功

    private String msg;  // 提示信息

    private long count; // 总数量, bootstrapTable是total

    private int page;

    private int size;

    private List<T> data; // 当前数据, bootstrapTable是rows

    public PageResult() {
    }

    public PageResult(List<T> rows) {
        this.data = rows;
        this.count = rows.size();
        this.code = 0;
        this.msg = "";
    }

    public PageResult(List<T> rows, long total) {
        this.count = total;
        this.data = rows;
        this.code = 0;
        this.msg = "";
    }


}
