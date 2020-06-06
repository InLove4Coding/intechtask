package subscriber.model;


import lombok.Data;
import subscriber.Dto.MessageActionType;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ACTIONS")
public class ActionTable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    Integer id;

    @Column(name = "MESSAGE_NUMBER")
    private int msisdn;

    @Column(name = "MESSAGE_TYPE")
    private MessageActionType action;

    @Column(name = "SEND_TIME")
    private Timestamp timestamp;

}
