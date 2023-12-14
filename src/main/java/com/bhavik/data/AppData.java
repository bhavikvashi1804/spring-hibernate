package com.bhavik.data;

import org.springframework.beans.factory.annotation.Value;

public class AppData {

    @Value("${application-alternative-name:springApp}")
    private String appName;

    @Value("${datasource.username}")
    private String dataSourceUserName;

    @Value("${datasource.psd}")
    private String dataSourcePsd;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDataSourceUserName() {
        return dataSourceUserName;
    }

    public void setDataSourceUserName(String dataSourceUserName) {
        this.dataSourceUserName = this.dataSourceUserName;
    }

    public void setDataSourcePsd(String dataSourcePsd) {
        this.dataSourcePsd = dataSourcePsd;
    }

    public String getDataSourcePsd() {
        return dataSourcePsd;
    }
}
