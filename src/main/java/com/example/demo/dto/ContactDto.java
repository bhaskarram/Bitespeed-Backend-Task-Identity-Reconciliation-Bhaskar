package com.example.demo.dto;

import lombok.Data;

@Data
public class ContactDto {
    private int primaryContatctId;
    private String phoneNumbers;
    private String emails;
    private String secondaryContactIds;
}
