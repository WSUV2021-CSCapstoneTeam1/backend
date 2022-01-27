package edu.wsu.backendapi.security;

import edu.wsu.backendapi.model.Template;

public class PreProcess {
    public PreProcess() {}

    public int PreProcessTemplate(Template tempIn) {
        System.out.println("AccountID: " + tempIn.getAccountId());
        System.out.println("Name: " + tempIn.getName());
        System.out.println("Active: " + tempIn.getActive());
        System.out.println("Global: " + tempIn.getGlobal());
        System.out.println("Global Resource Name: " + tempIn.getGlobalResourceName());
        System.out.println("text: " + tempIn.getText());
        System.out.println("Extension: " + tempIn.getExtension());
        System.out.println("Content Type: " + tempIn.getContentType());
        System.out.println("Lookup: " + tempIn.getLookup());
        System.out.println("Type: " + tempIn.getType());
        return 1;
    }

    public <T> int PreProcessSku(Class<T> skuIn) {
        return 1;
    }
}
