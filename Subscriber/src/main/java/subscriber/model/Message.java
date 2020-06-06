package subscriber.model;


import lombok.Data;
import subscriber.Dto.MessageActionType;
import subscriber.Dto.MessageDto;

import java.sql.Timestamp;

@Data
public class Message {

    private int msisdn;
    private MessageActionType action;
    private Timestamp timestamp;

    public static ActionTable getActionTable(MessageDto messageDto) {

        ActionTable actionTable = new ActionTable();
        actionTable.setMsisdn(messageDto.getMsisdn());
        actionTable.setAction(messageDto.getAction());
        actionTable.setTimestamp(messageDto.getTimestamp());

        return actionTable;

    }
}
