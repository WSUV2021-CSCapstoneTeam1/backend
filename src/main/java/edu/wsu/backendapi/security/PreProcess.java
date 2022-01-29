package edu.wsu.backendapi.security;
import edu.wsu.backendapi.model.Sku;
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

        return true;
    }

    public Boolean PreProcessSku(Sku skuIn) {
        if (!(skuIn.getPackageId() == null)) {
            System.out.println("PackageID: " + skuIn.getPackageId());
            return false;
        }
        if (!(skuIn.getProductId() instanceof String)) {
            System.out.println("ProductId: " + skuIn.getProductId());
            return false;
        }
        if (!(skuIn.getActive() instanceof Boolean)) {
            System.out.println("Active: " + skuIn.getActive());
            return false;
        }

        try{
            Integer.parseInt(skuIn.getMinSLA());
        }catch(Exception e ){
            System.out.println("MaxItems: " + skuIn.getMaxItems());
            return false;
        }

        if (!(skuIn.getCode() instanceof String)) {
            System.out.println("Code: " + skuIn.getCode());
            return false;
        }
        if (!(skuIn.getMinSLA() instanceof String)) {
            System.out.println("minSLA: " + skuIn.getMinSLA());
            return false;
        }
        if (!(skuIn.getDescription() instanceof String)) {
            System.out.println("Description: " + skuIn.getDescription());
            return false;
        }
        /*
        if (!(skuIn.getSLADuration() instanceof String)) {
            System.out.println("SLADuration: " + skuIn.getSLADuration());
            return false;
        }
        */

        if (!(skuIn.getUnitCost() instanceof String)) {
            System.out.println("UnitCost: " + skuIn.getUnitCost());
            return false;
        }
        if (!(skuIn.getUnitPrice() instanceof String)) {
            System.out.println("UnitPrice: " + skuIn.getUnitPrice());
            return false;
        }

        return true;
    }
}
