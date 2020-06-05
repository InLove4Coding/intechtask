package intech.controller;

import intech.model.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/publisher/v1")
@Slf4j
public class PublisherController {


    @GetMapping(path = "/sendMessage")
    MessageDto sendMessage() {
        MessageDto messageDto = new MessageDto();
        log.info("Формирование нового сообщения: {}", messageDto);
        return messageDto;
    }

}
