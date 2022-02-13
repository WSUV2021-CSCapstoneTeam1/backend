package edu.wsu.backendapi.security;
import edu.wsu.backendapi.model.Sku;
import edu.wsu.backendapi.model.Template;

public class PreProcess {
    public PreProcess() {}

    public static Boolean PreProcessTemplate(Template tempIn) throws Exception {
        if (!(tempIn.getAccountId() instanceof String)) {
            System.out.println("AccountID: " + tempIn.getAccountId());
            throw new Exception();
        }
        if (!(tempIn.getName() instanceof String)) {
            System.out.println("Name: " + tempIn.getName());
            throw new Exception();
        }
        if (!(tempIn.getActive() instanceof Boolean)) {
            System.out.println("Active: " + tempIn.getActive());
            throw new Exception();
        }
        if (!(tempIn.getGlobalRead() instanceof Boolean)) {
            System.out.println("Global Read: " + tempIn.getGlobalRead());
            throw new Exception();
        }
        if (!(tempIn.getGlobalResourceName() instanceof String)) {
            System.out.println("Global Resource Name: " + tempIn.getGlobalResourceName());
            throw new Exception();
        }
        if (!(tempIn.getText() instanceof String)) {
            System.out.println("text: " + tempIn.getText());
            throw new Exception();
        }
        if (!(tempIn.getExtension() instanceof String)) {
            System.out.println("Extension: " + tempIn.getExtension());
            throw new Exception();
        }
        if (!(tempIn.getContentType() instanceof String)) {
            System.out.println("Content Type: " + tempIn.getContentType());
            throw new Exception();
        }
        if (!(tempIn.getLookup() instanceof String)) {
            System.out.println("Lookup: " + tempIn.getLookup());
            throw new Exception();
        }
        if (!(tempIn.getType() instanceof String)) {
            System.out.println("Type: " + tempIn.getType());
            throw new Exception();
        }

        return true;
    }

    public static Boolean PreProcessSku(Sku skuIn) throws Exception {
        if (!(skuIn.getPackageId() == null)) {
            System.out.println("PackageID: " + skuIn.getPackageId());
            throw new Exception();
        }
        if (!(skuIn.getProductId() instanceof String)) {
            System.out.println("ProductId: " + skuIn.getProductId());
            throw new Exception();
        }
        if (!(skuIn.getActive() instanceof Boolean)) {
            System.out.println("Active: " + skuIn.getActive());
            throw new Exception();
        }

        try{
            Integer.parseInt(skuIn.getMinSLA());
        }catch(Exception e ){
            System.out.println("MaxItems: " + skuIn.getMaxItems());
            throw new Exception();
        }

        if (!(skuIn.getCode() instanceof String)) {
            System.out.println("Code: " + skuIn.getCode());
            throw new Exception();
        }
        if (!(skuIn.getMinSLA() instanceof String)) {
            System.out.println("minSLA: " + skuIn.getMinSLA());
            throw new Exception();
        }
        if (!(skuIn.getDescription() instanceof String)) {
            System.out.println("Description: " + skuIn.getDescription());
            throw new Exception();
        }
        /*
        if (!(skuIn.getSLADuration() instanceof String)) {
            System.out.println("SLADuration: " + skuIn.getSLADuration());
            throw new Exception();
        }
        */

        if (!(skuIn.getUnitCost() instanceof String)) {
            System.out.println("UnitCost: " + skuIn.getUnitCost());
            throw new Exception();
        }
        if (!(skuIn.getUnitPrice() instanceof String)) {
            System.out.println("UnitPrice: " + skuIn.getUnitPrice());
            throw new Exception();
        }

        return true;
    }
}
