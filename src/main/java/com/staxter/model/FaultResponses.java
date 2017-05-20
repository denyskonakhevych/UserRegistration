package com.staxter.model;

/**
 * Created by Denys on 2017-05-20.
 */
public enum FaultResponses {
    USER_ALREADY_EXISTS(new FaultResponse( "USER_ALREADY_EXISTS", "A user with the given username already exists"));

    private FaultResponse response;

    FaultResponses(FaultResponse response) {
        this.response = response;
    }

    public FaultResponse getResponse() {
        return response;
    }
}
