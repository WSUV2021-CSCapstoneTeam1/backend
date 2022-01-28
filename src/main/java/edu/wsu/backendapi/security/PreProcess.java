package edu.wsu.backendapi.security;

import edu.wsu.backendapi.model.Template;

public class PreProcess {
    public PreProcess() {}

    public int PreProcessTemplate(Template tempIn) {
        if (!(tempIn.getAccountId() instanceof String)) {
            System.out.println("AccountID: " + tempIn.getAccountId());
            return -1;
        }
        if (!(tempIn.getName() instanceof String)) {
            System.out.println("Name: " + tempIn.getName());
            return -1;
        }
        if (!(tempIn.getActive() instanceof Boolean)) {
            System.out.println("Active: " + tempIn.getActive());
            return -1;
        }
        if (!(tempIn.getGlobalRead() instanceof Boolean)) {
            System.out.println("Global Read: " + tempIn.getGlobalRead());
            return -1;
        }
        if (!(tempIn.getGlobalResourceName() instanceof String)) {
            System.out.println("Global Resource Name: " + tempIn.getGlobalResourceName());
            return -1;
        }
        if (!(tempIn.getText() instanceof String)) {
            System.out.println("text: " + tempIn.getText());
            return -1;
        }
        if (!(tempIn.getExtension() instanceof String)) {
            System.out.println("Extension: " + tempIn.getExtension());
            return -1;
        }
        if (!(tempIn.getContentType() instanceof String)) {
            System.out.println("Content Type: " + tempIn.getContentType());
            return -1;
        }
        if (!(tempIn.getLookup() instanceof String)) {
            System.out.println("Lookup: " + tempIn.getLookup());
            return -1;
        }
        if (!(tempIn.getType() instanceof String)) {
            System.out.println("Type: " + tempIn.getType());
            return -1;
        }
        return 1;
    }
}
