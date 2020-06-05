package subscriber.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subscriber.model.MessageDto;

@RestController
@RequestMapping(path = "api/subscriber/v1")
public class SubscriberController {


    @PostMapping(path = "/recieveMessage")
    void recieveMessage(@RequestBody MessageDto messageDto) {


        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
        System.out.println(messageDto);
    }
}
