package intech.service.impl;

import intech.model.MessageDto;
import intech.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class PublisherServiceImpl implements PublisherService {

    private final RestTemplate restTemplate;

    @Autowired
    public PublisherServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public void sendMessage(MessageDto messageDto) {

    }
}
