package com.staxter.model;

/**
 * Created by Denys on 2017-05-20.
 */
public class FaultResponse {
    private String code;
    private String description;

    public FaultResponse() {
    }

    public FaultResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
