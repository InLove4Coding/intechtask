package subscriber.Service;

import org.springframework.stereotype.Service;
import subscriber.model.ActionTable;

@Service
public class RecieveService {

    ReceiveActionMes receiveActionMes;

    public RecieveService(ReceiveActionMes receiveActionMes) {
        this.receiveActionMes = receiveActionMes;
    }

    public void saveReceiveMessageToDb(ActionTable actionTable) {
        receiveActionMes.save(actionTable);
    }
}
