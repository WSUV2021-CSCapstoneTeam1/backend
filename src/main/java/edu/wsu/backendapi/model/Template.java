package edu.wsu.backendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("document")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Template {
    private String accountId;
    private Boolean active;
    private Boolean global;
    private String globalResourceName;
    private String name;
    private String lookup;
    private String type;
    private String text;
    private String extension;
    private String contentType;

    //GET
    public String getAccountId() {
        return accountId;
    }

    public Boolean getActive() {
        return active;
    }

    public Boolean getGlobal() {
        return global;
    }

    public String getGlobalResourceName() {
        return globalResourceName;
    }

    public String getName() {
        return name;
    }

    public String getLookup() {
        return lookup;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getExtension() {
        return extension;
    }

    public String getContentType() {
        return contentType;
    }


    //SET
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setGlobal(Boolean global) {
        this.global = global;
    }

    public void setGlobalResourceName(String globalResourceName) {
        this.globalResourceName = globalResourceName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLookup(String lookup) {
        this.lookup = lookup;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setContentType(String contentType) { this.contentType = contentType; }
}
