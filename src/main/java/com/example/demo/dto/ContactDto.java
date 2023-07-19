package com.example.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ContactDto {
    private int primaryContatctId;
    private Set<String> emails;
    private Set<String> phoneNumbers;
    private List<Integer> secondaryContactIds;
}
