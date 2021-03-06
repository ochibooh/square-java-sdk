package com.squareup.square.models;

import java.util.Objects;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;

public class PaymentRefund {

    @JsonCreator
    public PaymentRefund(
            @JsonProperty("id") String id,
            @JsonProperty("amount_money") Money amountMoney,
            @JsonProperty("status") String status,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("app_fee_money") Money appFeeMoney,
            @JsonProperty("processing_fee") List<ProcessingFee> processingFee,
            @JsonProperty("payment_id") String paymentId,
            @JsonProperty("order_id") String orderId,
            @JsonProperty("reason") String reason,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.status = status;
        this.locationId = locationId;
        this.amountMoney = amountMoney;
        this.appFeeMoney = appFeeMoney;
        this.processingFee = processingFee;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final String id;
    private final String status;
    private final String locationId;
    private final Money amountMoney;
    private final Money appFeeMoney;
    private final List<ProcessingFee> processingFee;
    private final String paymentId;
    private final String orderId;
    private final String reason;
    private final String createdAt;
    private final String updatedAt;

    @Override
    public int hashCode() {
        return Objects.hash(id, amountMoney, status, locationId, appFeeMoney, processingFee, paymentId, orderId, reason, createdAt, updatedAt);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PaymentRefund)) {
            return false;
        }
        PaymentRefund paymentRefund = (PaymentRefund) o;
        return Objects.equals(id, paymentRefund.id) &&
            Objects.equals(amountMoney, paymentRefund.amountMoney) &&
            Objects.equals(status, paymentRefund.status) &&
            Objects.equals(locationId, paymentRefund.locationId) &&
            Objects.equals(appFeeMoney, paymentRefund.appFeeMoney) &&
            Objects.equals(processingFee, paymentRefund.processingFee) &&
            Objects.equals(paymentId, paymentRefund.paymentId) &&
            Objects.equals(orderId, paymentRefund.orderId) &&
            Objects.equals(reason, paymentRefund.reason) &&
            Objects.equals(createdAt, paymentRefund.createdAt) &&
            Objects.equals(updatedAt, paymentRefund.updatedAt);
    }

    /**
     * Getter for Id.
     * Unique ID for this refund, generated by Square.
     */
    @JsonGetter("id")
    public String getId() { 
        return this.id;
    }

    /**
     * Getter for Status.
     * The refund's status:
     * - `PENDING` - awaiting approval
     * - `COMPLETED` - successfully completed
     * - `REJECTED` - the refund was rejected
     * - `FAILED` - an error occurred
     */
    @JsonGetter("status")
    public String getStatus() { 
        return this.status;
    }

    /**
     * Getter for LocationId.
     * Location ID associated with the payment this refund is attached to.
     */
    @JsonGetter("location_id")
    public String getLocationId() { 
        return this.locationId;
    }

    /**
     * Getter for AmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount_money")
    public Money getAmountMoney() { 
        return this.amountMoney;
    }

    /**
     * Getter for AppFeeMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("app_fee_money")
    public Money getAppFeeMoney() { 
        return this.appFeeMoney;
    }

    /**
     * Getter for ProcessingFee.
     * Processing fees and fee adjustments assessed by Square on this refund.
     */
    @JsonGetter("processing_fee")
    public List<ProcessingFee> getProcessingFee() { 
        return this.processingFee;
    }

    /**
     * Getter for PaymentId.
     * The ID of the payment assocated with this refund.
     */
    @JsonGetter("payment_id")
    public String getPaymentId() { 
        return this.paymentId;
    }

    /**
     * Getter for OrderId.
     * The ID of the order associated with the refund.
     */
    @JsonGetter("order_id")
    public String getOrderId() { 
        return this.orderId;
    }

    /**
     * Getter for Reason.
     * The reason for the refund.
     */
    @JsonGetter("reason")
    public String getReason() { 
        return this.reason;
    }

    /**
     * Getter for CreatedAt.
     * Timestamp of when the refund was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() { 
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * Timestamp of when the refund was last updated, in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() { 
        return this.updatedAt;
    }

 
    public Builder toBuilder() {
        Builder builder = new Builder(id,
            amountMoney)
            .status(getStatus())
            .locationId(getLocationId())
            .appFeeMoney(getAppFeeMoney())
            .processingFee(getProcessingFee())
            .paymentId(getPaymentId())
            .orderId(getOrderId())
            .reason(getReason())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    public static class Builder {
        private String id;
        private Money amountMoney;
        private String status;
        private String locationId;
        private Money appFeeMoney;
        private List<ProcessingFee> processingFee;
        private String paymentId;
        private String orderId;
        private String reason;
        private String createdAt;
        private String updatedAt;

        public Builder(String id,
                Money amountMoney) {
            this.id = id;
            this.amountMoney = amountMoney;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }
        public Builder amountMoney(Money value) {
            amountMoney = value;
            return this;
        }
        public Builder status(String value) {
            status = value;
            return this;
        }
        public Builder locationId(String value) {
            locationId = value;
            return this;
        }
        public Builder appFeeMoney(Money value) {
            appFeeMoney = value;
            return this;
        }
        public Builder processingFee(List<ProcessingFee> value) {
            processingFee = value;
            return this;
        }
        public Builder paymentId(String value) {
            paymentId = value;
            return this;
        }
        public Builder orderId(String value) {
            orderId = value;
            return this;
        }
        public Builder reason(String value) {
            reason = value;
            return this;
        }
        public Builder createdAt(String value) {
            createdAt = value;
            return this;
        }
        public Builder updatedAt(String value) {
            updatedAt = value;
            return this;
        }

        public PaymentRefund build() {
            return new PaymentRefund(id,
                amountMoney,
                status,
                locationId,
                appFeeMoney,
                processingFee,
                paymentId,
                orderId,
                reason,
                createdAt,
                updatedAt);
        }
    }
}
