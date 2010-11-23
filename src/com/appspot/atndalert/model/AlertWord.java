package com.appspot.atndalert.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(kind = "AlertWord", schemaVersion = 1)
public class AlertWord {
    @Attribute(primaryKey = true)
    private Key key;
    private String loginName;
    private String mailAddress;
    private String alertWord;
    @Attribute(version = true)
    private long entityVersion;
    
    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getAlertWord() {
        return alertWord;
    }

    public void setAlertWord(String alertWord) {
        this.alertWord = alertWord;
    }

    public long getEntityVersion() {
        return entityVersion;
    }

    public void setEntityVersion(long entityVersion) {
        this.entityVersion = entityVersion;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

}
