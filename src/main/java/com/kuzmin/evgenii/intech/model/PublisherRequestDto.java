package com.kuzmin.evgenii.intech.model;

import lombok.Data;

import java.util.Date;

@Data
public class PublisherRequestDto {

    long msisdn;
    MessageActionType action;
    Date timestamp;
}
