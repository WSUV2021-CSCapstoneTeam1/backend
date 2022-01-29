package edu.wsu.backendapi.security;
import edu.wsu.backendapi.model.Template;

public class PreProcess {
    public PreProcess() {}

    public Boolean PreProcessTemplate(Template tempIn) {
        if (!(tempIn.getAccountId() instanceof String)) {
            System.out.println("AccountID: " + tempIn.getAccountId());
            return false;
        }
        if (!(tempIn.getName() instanceof String)) {
            System.out.println("Name: " + tempIn.getName());
            return false;
        }
        if (!(tempIn.getActive() instanceof Boolean)) {
            System.out.println("Active: " + tempIn.getActive());
            return false;
        }
        if (!(tempIn.getGlobalRead() instanceof Boolean)) {
            System.out.println("Global Read: " + tempIn.getGlobalRead());
            return false;
        }
        if (!(tempIn.getGlobalResourceName() instanceof String)) {
            System.out.println("Global Resource Name: " + tempIn.getGlobalResourceName());
            return false;
        }
        if (!(tempIn.getText() instanceof String)) {
            System.out.println("text: " + tempIn.getText());
            return false;
        }
        if (!(tempIn.getExtension() instanceof String)) {
            System.out.println("Extension: " + tempIn.getExtension());
            return false;
        }
        if (!(tempIn.getContentType() instanceof String)) {
            System.out.println("Content Type: " + tempIn.getContentType());
            return false;
        }
        if (!(tempIn.getLookup() instanceof String)) {
            System.out.println("Lookup: " + tempIn.getLookup());
            return false;
        }
        if (!(tempIn.getType() instanceof String)) {
            System.out.println("Type: " + tempIn.getType());
            return false;
        }


        //tempIn.getText().replaceAll("\\n","");

        return true;
    }
}
