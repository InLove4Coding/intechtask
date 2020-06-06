package subscriber.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import subscriber.Dto.MessageDto;
import subscriber.Service.RecieveService;
import subscriber.model.ActionTable;
import subscriber.model.Message;

@RestController
@RequestMapping(path = "api/subscriber/v1")
public class SubscriberController {

    RecieveService actionsMessageRepo;

    public SubscriberController(RecieveService actionsMessageRepo) {
        this.actionsMessageRepo = actionsMessageRepo;
    }

    @PostMapping(path = "/receiveMessage")
    void recieveMessage(@RequestBody MessageDto messageDto) {
        ActionTable actionTable = Message.getActionTable(messageDto);
        actionsMessageRepo.saveReceiveMessageToDb(actionTable);
    }
}
