package edu.wsu.backendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("document")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku {
    private String packageId;
    private String productId;
    private Boolean active;
    private int maxItems;
    private String code;
    private String minSLA;
    private String description;
    private String SLADuration;
    private String unitCost;
    private String unitPrice;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMinSLA() {
        return minSLA;
    }

    public void setMinSLA(String minSLA) {
        this.minSLA = minSLA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSLADuration() {
        return SLADuration;
    }

    public void setSLADuration(String SLADuration) {
        this.SLADuration = SLADuration;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
