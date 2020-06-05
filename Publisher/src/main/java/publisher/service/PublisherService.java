package publisher.service;

import publisher.model.MessageDto;

public interface PublisherService {
        void sendMessage(MessageDto messageDto);
}
