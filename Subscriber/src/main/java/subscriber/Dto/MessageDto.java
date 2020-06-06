package subscriber.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

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

}
