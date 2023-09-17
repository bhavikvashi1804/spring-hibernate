package com.bhavik;

import org.springframework.beans.factory.annotation.Value;

public class AppData {

    @Value("${application-alternative-name:'springApp'}")
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
