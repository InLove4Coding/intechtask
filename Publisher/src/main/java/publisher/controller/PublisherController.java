package publisher.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publisher.model.MessageDto;
import publisher.service.PublisherService;

@RestController
@RequestMapping(path = "api/publisher/v1")
@Slf4j
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(path = "/sendMessage")
    void sendMessage() {
        MessageDto messageDto = new MessageDto();
        log.info("Формирование нового сообщения: {}", messageDto);
        publisherService.sendMessage(messageDto);
    }

}
