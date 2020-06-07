package subscriber.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subscriber.Service.SubscribeService;
import subscriber.model.Message;

@RestController
@RequestMapping(path = "api/subscriber/v1")
public class SubscriberController {

    private final SubscribeService subscribeService;

    public SubscriberController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    @PostMapping(path = "/receiveMessage")
    void receiveMessage(@RequestBody Message message) {


        subscribeService.handleMessage(message);

    }
}
