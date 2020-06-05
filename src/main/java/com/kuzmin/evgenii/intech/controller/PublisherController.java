package com.kuzmin.evgenii.intech.controller;

import com.kuzmin.evgenii.intech.model.MessageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/publisher/v1")
public class PublisherController {


    @GetMapping(path = "/sendMessage")
    MessageDto sendMessage() {
        return new MessageDto();
    }

}
