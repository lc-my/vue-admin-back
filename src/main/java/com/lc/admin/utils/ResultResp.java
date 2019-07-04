package com.lc.admin.utils;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lc.admin.constant.Code;
import com.lc.admin.constant.CommRespCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用web层数据返回格式
 *
 * @author ShuBifeng
 * @date 2017-05-10
 */
@ApiModel(description = "响应体")
@Data
public class ResultResp<T> implements Serializable {

    @ApiModelProperty(value = "状态码", required = true, example = "100")
    protected Integer code;

    @ApiModelProperty(value = "状态描述", required = false, example = "ok")
    protected String desc;

    /**
     * 当出现错误时,该节点值会存在,返回定位时间戳,可用于查日志位置
     */
    @ApiModelProperty(value = "响应时间戳(出现错误时有值)", required = false, example = "1519460902", hidden = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected Long timestamp;

    @ApiModelProperty(value = "返回数据", required = false)
    @JsonAlias({"datas", "result", "data"})
    protected T result;


    private ResultResp() {

    }
    /**
     * 构造函数（业务处理成功时）
     *
     * @param code
     * @param desc
     * @param result
     */
    private ResultResp(Integer code, String desc, T result) {
        this.code = code;
        this.desc = desc;
        this.result = result;
    }


    /**
     * 构造函数（业务处理异常失败时需传时间戳，方便定位问题）
     *
     * @param code
     * @param desc
     * @param result
     * @param timestamp
     */
    private ResultResp(Integer code, String desc, T result, Long timestamp) {
        this.code = code;
        this.desc = desc;
        this.result = result;
        this.timestamp = timestamp;
    }


    /**
     * 正常返回（无业务数据返回）
     *
     * @return
     */
    public static <T> ResultResp<T> ok() {
        return new ResultResp(CommRespCode.SUCCESS.getCode(), CommRespCode.SUCCESS.getDesc(), null);
    }

    /**
     * 正常返回（有业务数据返回）
     *
     * @return
     */
    public static <T> ResultResp<T> ok(T result) {
        return new ResultResp(CommRespCode.SUCCESS.getCode(), CommRespCode.SUCCESS.getDesc(), result);
    }

    /**
     * 正常返回（自定义返回码，并返回业务数据）
     *
     * @param code
     * @param result 无需业务数据返回时请填写null
     * @return
     */
    public static <T> ResultResp<T> ok(Code code, T result) {
        return new ResultResp(code.getCode(), code.getDesc(), result);
    }

    /**
     * 正常返回（自定义返回信息，并返回业务数据）
     *
     * @param msg
     * @param result 无需业务数据返回时请填写null
     * @return
     */
    public static <T> ResultResp<T> ok(String msg, T result) {
        return new ResultResp(CommRespCode.SUCCESS.getCode(), msg, result);
    }

    /**
     * 默认通用的错误返回
     *
     * @return
     */
    public static <T> ResultResp<T> fail() {
        return fail(CommRespCode.FAIL);
    }

    /**
     * 默认通用的错误返回（返回编码使用默认编码，错误信息重写）
     *
     * @return
     */
    public static <T> ResultResp<T> fail(String msg) {
        return new ResultResp(CommRespCode.FAIL.getCode(), msg, null, System.currentTimeMillis());
    }

    /**
     * 错误返回（自定义）
     *
     * @return
     */
    public static <T> ResultResp<T> fail(Code code) {
        return new ResultResp(code.getCode(), code.getDesc(), null, System.currentTimeMillis());
    }

    /**
     * 错误返回（自定义）
     *
     * @return
     */
    public static <T> ResultResp<T> fail(Code code, String msg) {
        return new ResultResp(code.getCode(), msg, null, System.currentTimeMillis());
    }

    /**
     * 分页信息转换模型
     *
     * 如果还有其他分页模型，请自行增加转化构造函数
     *
     * /
     *  /*  public static void main(String args[]){
     com.github.pagehelper.PageInfo pageInfo = new com.github.pagehelper.PageInfo();
     pageInfo.setPageNum(1);
     pageInfo.setPageSize(10);
     pageInfo.setTotal(101);
     Pages p = new Pages(pageInfo);
     pageInfo.setList(Lists.newArrayList("ss","3"));
     pageInfo = null;
     ResultResp s = ResultResp.ok();
     s.setListAndPageInfo(null);

     System.out.println(s.toString());

     }*/

}