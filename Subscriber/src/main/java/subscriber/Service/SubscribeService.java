package subscriber.Service;

import subscriber.model.Message;

public interface SubscribeService {
    void handleMessage(Message message);

}
