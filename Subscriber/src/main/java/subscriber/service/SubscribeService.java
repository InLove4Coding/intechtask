package subscriber.service;

import subscriber.model.MessageConvertor;

public interface SubscribeService {
    void handleMessage(MessageConvertor messageConvertor);
}
