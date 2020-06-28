package subscriber.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subscriber.model.MessageConvertor;
import subscriber.service.SubscribeService;

@RestController
@RequestMapping(path = "api/subscriber/v1")
@Slf4j
public class SubscriberController {

    private final SubscribeService subscribeService;

    public SubscriberController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @PostMapping(path = "/receiveMessage")
    void receiveMessage(@RequestBody MessageConvertor messageConvertor) {

        log.info("Принятое сообщение от Publisher: {}", messageConvertor);

        subscribeService.handleMessage(messageConvertor);
    }
}
