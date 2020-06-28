package publisher.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import publisher.model.MessageDto;
import publisher.service.PublisherService;

@Service
@Slf4j
public class PublisherServiceImpl implements PublisherService {

    private final RestTemplate restTemplate;
    //TODO: Доделать url
    @Value("${subscriber.url}")
    private String url;

    @Autowired
    public PublisherServiceImpl(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Override
    public void sendMessage(MessageDto messageDto) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MessageDto> httpEntity = new HttpEntity<>(messageDto, httpHeaders);
        log.info("Отправляем сообщение в Subscriber {}", messageDto);
        restTemplate.postForEntity(url, httpEntity, String.class);
    }
}
