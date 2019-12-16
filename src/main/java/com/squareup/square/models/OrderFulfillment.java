package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class OrderFulfillment {

    @JsonCreator
    public OrderFulfillment(
            @JsonProperty("uid") String uid,
            @JsonProperty("type") String type,
            @JsonProperty("state") String state,
            @JsonProperty("metadata") Map<String, String> metadata,
            @JsonProperty("pickup_details") OrderFulfillmentPickupDetails pickupDetails,
            @JsonProperty("shipment_details") OrderFulfillmentShipmentDetails shipmentDetails) {
        this.uid = uid;
        this.type = type;
        this.state = state;
        this.metadata = metadata;
        this.pickupDetails = pickupDetails;
        this.shipmentDetails = shipmentDetails;
    }

    private final String uid;
    private final String type;
    private final String state;
    private final Map<String, String> metadata;
    private final OrderFulfillmentPickupDetails pickupDetails;
    private final OrderFulfillmentShipmentDetails shipmentDetails;

    @Override
    public int hashCode() {
        return Objects.hash(uid, type, state, metadata, pickupDetails, shipmentDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderFulfillment)) {
            return false;
        }
        OrderFulfillment orderFulfillment = (OrderFulfillment) o;
        return Objects.equals(uid, orderFulfillment.uid) &&
            Objects.equals(type, orderFulfillment.type) &&
            Objects.equals(state, orderFulfillment.state) &&
            Objects.equals(metadata, orderFulfillment.metadata) &&
            Objects.equals(pickupDetails, orderFulfillment.pickupDetails) &&
            Objects.equals(shipmentDetails, orderFulfillment.shipmentDetails);
    }

    /**
     * Getter for Uid.
     * Unique ID that identifies the fulfillment only within this order.
     */
    @JsonGetter("uid")
    public String getUid() { 
        return this.uid;
    }

    /**
     * Getter for Type.
     * The type of fulfillment.
     */
    @JsonGetter("type")
    public String getType() { 
        return this.type;
    }

    /**
     * Getter for State.
     * The current state of this fulfillment.
     */
    @JsonGetter("state")
    public String getState() { 
        return this.state;
    }

    /**
     * Getter for Metadata.
     * Application-defined data attached to this fulfillment. Metadata fields are intended
     * to store descriptive references or associations with an entity in another system or store brief
     * information about the object. Square does not process this field; it only stores and returns it
     * in relevant API calls. Do not use metadata to store any sensitive information (personally
     * identifiable information, card details, etc.).
     * Keys written by applications must be 60 characters or less and must be in the character set
     * `[a-zA-Z0-9_-]`. Entries may also include metadata generated by Square. These keys are prefixed
     * with a namespace, separated from the key with a ':' character.
     * Values have a max length of 255 characters.
     * An application may have up to 10 entries per metadata field.
     * Entries written by applications are private and can only be read or modified by the same
     * application.
     * See [Metadata](https://developer.squareup.com/docs/build-basics/metadata) for more information.
     */
    @JsonGetter("metadata")
    public Map<String, String> getMetadata() { 
        return this.metadata;
    }

    /**
     * Getter for PickupDetails.
     * Contains details necessary to fulfill a pickup order.
     */
    @JsonGetter("pickup_details")
    public OrderFulfillmentPickupDetails getPickupDetails() { 
        return this.pickupDetails;
    }

    /**
     * Getter for ShipmentDetails.
     * Contains details necessary to fulfill a shipment order.
     */
    @JsonGetter("shipment_details")
    public OrderFulfillmentShipmentDetails getShipmentDetails() { 
        return this.shipmentDetails;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .type(getType())
            .state(getState())
            .metadata(getMetadata())
            .pickupDetails(getPickupDetails())
            .shipmentDetails(getShipmentDetails());
            return builder;
    }

    public static class Builder {
        private String uid;
        private String type;
        private String state;
        private Map<String, String> metadata;
        private OrderFulfillmentPickupDetails pickupDetails;
        private OrderFulfillmentShipmentDetails shipmentDetails;

        public Builder() { }

        public Builder uid(String value) {
            uid = value;
            return this;
        }
        public Builder type(String value) {
            type = value;
            return this;
        }
        public Builder state(String value) {
            state = value;
            return this;
        }
        public Builder metadata(Map<String, String> value) {
            metadata = value;
            return this;
        }
        public Builder pickupDetails(OrderFulfillmentPickupDetails value) {
            pickupDetails = value;
            return this;
        }
        public Builder shipmentDetails(OrderFulfillmentShipmentDetails value) {
            shipmentDetails = value;
            return this;
        }

        public OrderFulfillment build() {
            return new OrderFulfillment(uid,
                type,
                state,
                metadata,
                pickupDetails,
                shipmentDetails);
        }
    }
}