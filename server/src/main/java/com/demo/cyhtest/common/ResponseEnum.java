package com.demo.cyhtest.common;

/**
 * @Author: chenyuhao
 * @Date: 2019/10/28 17:30
 * @Version 1.0
 */
public enum ResponseEnum implements IResultEnum{

    //系统响应参数枚举值
    R0001("0001","系统异常"),
    D0001("d001","默认[待修改]-主键不能为空"),
    D0002("d002","默认[待修改]-信息不能为空"),
    D0003("d003","默认[待修改]-查询条件不能为空"),
    D0004("d004","默认[待修改]-删除信息失败"),
    D0005("d005","默认[待修改]-新增信息失败"),
    D0006("d006","默认[待修改]-更新信息失败"),;

    private String code;
    private String msg;
    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
