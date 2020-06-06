package publisher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import publisher.model.MessageDto;
import publisher.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final RestTemplate restTemplate;

    @Autowired
    public PublisherServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MessageDto> httpEntity = new HttpEntity<>(messageDto, httpHeaders);
        restTemplate.postForEntity("http://localhost:8080/api/subscriber/v1/receiveMessage", httpEntity, String.class);
    }

}
