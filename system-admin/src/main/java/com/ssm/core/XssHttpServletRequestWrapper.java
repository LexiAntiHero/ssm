package com.ssm.core;

import com.ssm.util.XssUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final HttpServletRequest orgRequest;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        orgRequest = request;
    }

    // Override these methods and handle XSS
    @Override
    public String getParameter(String name) {
        return XssUtil.xssEncode(super.getParameter(XssUtil.xssEncode(name)));
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = super.getParameterMap();
        Map<String, String[]> newParameterMap = new HashMap<>(8);
        for(Map.Entry<String, String[]> entry : parameterMap.entrySet()){
            // Process the key for XSS
            String newKey = XssUtil.xssEncode(entry.getKey());
            // Process the value for XSS
            String[] params = entry.getValue();
            String[] newParams = new String[params.length];
            for (int i = 0; i < params.length; i++) {
                newParams[i] = XssUtil.xssEncode(params[i]);
            }
            newParameterMap.put(newKey, newParams);
        }
        return newParameterMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] parameterValues = super.getParameterValues(XssUtil.xssEncode(name));
        String[] newParams = new String[parameterValues.length];
        for (int i = 0; i < parameterValues.length; i++) {
            newParams[i] = XssUtil.xssEncode(parameterValues[i]);
        }
        return newParams;
    }

    // If you want to use the original request in the future, you can get it through this method
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }
}

