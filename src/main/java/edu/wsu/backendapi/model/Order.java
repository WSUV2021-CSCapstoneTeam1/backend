package edu.wsu.backendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    @JsonProperty("destination") Destination destination = new Destination();
    @JsonProperty("orderData") OrderData orderData;

    private static class Destination {
        @JsonProperty("name") private String name;
    }

    public void setDestinationName(String name) {
        destination.name = name;
    }

    private static class OrderData {
        @JsonProperty("sourceOrderId") private String sourceOrderId;
        @JsonProperty("items") private List<Item> itemsLists;
        @JsonProperty("shipments") private List<Shipment> shipmentList;

        private static class Item {
            @JsonProperty("sku") private String sku;
            @JsonProperty("components") private List<Component> componentsList;
            @JsonProperty("sourceItemId") private String sourceItemId;
            @JsonProperty("shipmentIndex") private int shipmentIndex;

            private static class Component {
                @JsonProperty("code") private String code;
                @JsonProperty("fetch") private Boolean fetch;
                @JsonProperty("path") private String path;
                @JsonProperty("sourceComponentId") private String sourceComponentId;
            }
        }

        private static class Shipment {
            @JsonProperty("shipmentIndex") private int shipmentIndex;
            @JsonProperty("shipTo") private ShipTo shipTo;
            @JsonProperty("carrier") private Carrier carrier;

            private static class ShipTo {
                @JsonProperty("name") private String name;
                @JsonProperty("companyName") private String companyName;
                @JsonProperty("address1") private String address1;
                @JsonProperty("town") private String town;
                @JsonProperty("postcode") private String postcode;
                @JsonProperty("isoCountry") private String isoCountry;
            }

            private static class Carrier {
                @JsonProperty("code") private String code;
                @JsonProperty("service") private String service;
                @JsonProperty("alias") private String alias;
                @JsonProperty("serviceId") private String serviceId;
            }
        }
    }
}
