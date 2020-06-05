package com.kuzmin.evgenii.intech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Random;


/**
 * <b>Dto содержащее структуру данных отправляемых сообщений</b>.
 *
 * @author KuzminEY
 */
@Data
public class MessageDto {
    //Уникальный номер абонента
    private int msisdn;
    // Тип сообщения.
    private MessageActionType action;
    // Время(UNIX timestamp)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Timestamp timestamp;

    public MessageDto() {
        //Пусть будет номер от 0 до 1000
        this.msisdn = new Random().nextInt(1001);

        if (new Random().nextInt(2) == 1) {
            this.action = MessageActionType.PURCHASE;
        } else this.action = MessageActionType.SUBSCRIPTION;
        this.timestamp = new Timestamp(System.currentTimeMillis());;
    }
}
