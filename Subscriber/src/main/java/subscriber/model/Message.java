package subscriber.model;


import lombok.Data;
import subscriber.dto.MessageActionType;

import java.sql.Timestamp;

@Data
public class Message {

    private int msisdn;
    private MessageActionType action;
    private Timestamp timestamp;

    public PurchaseEntity convertToPurchaseEntity() {

        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setMsisdn(msisdn);
        purchaseEntity.setAction(action);
        purchaseEntity.setTimestamp(timestamp);

        return purchaseEntity;

    }

    public SubscriptionEntity convertToSubscriptionEntity() {

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setMsisdn(msisdn);
        subscriptionEntity.setAction(action);
        subscriptionEntity.setTimestamp(timestamp);

        return subscriptionEntity;

    }
}
