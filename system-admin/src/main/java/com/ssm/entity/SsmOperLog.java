package com.ssm.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Operation Log(SsmOperLog)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public class SsmOperLog implements Serializable {
    private static final long serialVersionUID = -94647117105646879L;
/**
     * Log ID
     */
    private Integer operId;
/**
     * Operation Module
     */
    private String title;
/**
     * Business Type
     */
    private String businessType;
/**
     * API Method
     */
    private String method;
/**
     * Request Method
     */
    private String requestMethod;
/**
     * Operator
     */
    private String operName;
/**
     * Request URL
     */
    private String operUrl;
/**
     * Operation Address
     */
    private String operIp;
/**
     * Operation Status
     */
    private Integer status;
/**
     * Error Message
     */
    private String errormsg;
/**
     * Operation Time
     */
    private Date opertime;


    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public Date getOpertime() {
        return opertime;
    }

    public void setOpertime(Date opertime) {
        this.opertime = opertime;
    }

}

