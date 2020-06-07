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
import subscriber.Service.PurchaseRepository;
import subscriber.dto.MessageActionType;
import subscriber.model.Message;

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

        Message message = new Message();
        message.setMsisdn(777);
        message.setAction(MessageActionType.PURCHASE);
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));

        ObjectMapper OBJECT_MAPPER = new ObjectMapper();


        mockMvc.perform(MockMvcRequestBuilders.post("/api/subscriber/v1/receiveMessage")
                .content(OBJECT_MAPPER.writeValueAsString(message)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        ;
        Assertions.assertEquals(purchaseRepository.count(),1);
    }
}