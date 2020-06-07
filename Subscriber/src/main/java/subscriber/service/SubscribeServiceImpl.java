package subscriber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import subscriber.dto.MessageActionType;
import subscriber.model.MessageConvertor;

@Service
@Slf4j
public class SubscribeServiceImpl implements SubscribeService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriberRepository subscriberRepository;

    public SubscribeServiceImpl(PurchaseRepository purchaseRepository, SubscriberRepository subscriberRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public void handleMessage(MessageConvertor messageConvertor) {

        if (messageConvertor.getAction() == MessageActionType.PURCHASE) {
            purchaseRepository.save(messageConvertor.convertToPurchaseEntity());
            log.info("Сообщение {} - сохранено в таблицу PURCHASE", messageConvertor);
        } else {
            subscriberRepository.save(messageConvertor.convertToSubscriptionEntity());
            log.info("Сообщение {} - сохранено в таблицу SUBSCRIPTION", messageConvertor);

        }

    }
}
