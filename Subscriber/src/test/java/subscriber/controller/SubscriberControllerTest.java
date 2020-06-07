package subscriber.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import subscriber.dto.MessageActionType;
import subscriber.model.MessageConvertor;
import subscriber.service.PurchaseRepository;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SubscriberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Test
    void receiveMessage() throws Exception {

        MessageConvertor messageConvertor = new MessageConvertor();
        messageConvertor.setMsisdn(777);
        messageConvertor.setAction(MessageActionType.PURCHASE);
        messageConvertor.setTimestamp(new Timestamp(System.currentTimeMillis()));

        ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        // Проверяем все ли хорошо принимается на Subscribe
        mockMvc.perform(MockMvcRequestBuilders.post("/api/subscriber/v1/receiveMessage")
                .content(OBJECT_MAPPER.writeValueAsString(messageConvertor)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Т.к и база пустая и мы сохраняем первый раз, то должна быть ровно одная запись в бд.
        //по хорошему в тесте, должна быть чистая база. Если это невозможно, то этой проверки не будет.
        Assertions.assertEquals(purchaseRepository.count(),1);
    }
}