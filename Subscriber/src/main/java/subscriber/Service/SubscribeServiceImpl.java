package subscriber.Service;

import org.springframework.stereotype.Service;
import subscriber.dto.MessageActionType;
import subscriber.model.Message;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriberRepository subscriberRepository;

    public SubscribeServiceImpl(PurchaseRepository purchaseRepository, SubscriberRepository subscriberRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public void handleMessage(Message message) {

        if (message.getAction() == MessageActionType.PURCHASE) {
            purchaseRepository.save(message.convertToPurchaseEntity());
        } else {
            subscriberRepository.save(message.convertToSubscriptionEntity());

        }

    }
}
