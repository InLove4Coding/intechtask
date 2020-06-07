package subscriber.model;


import lombok.Data;
import subscriber.dto.MessageActionType;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    long id;

    @Column(name = "MESSAGE_NUMBER")
    private int msisdn;

    @Column(name = "MESSAGE_TYPE")
    private MessageActionType action;

    @Column(name = "SEND_TIME")
    private Timestamp timestamp;

}
