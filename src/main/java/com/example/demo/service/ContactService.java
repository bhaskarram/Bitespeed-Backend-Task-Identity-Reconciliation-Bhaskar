package com.example.demo.service;

import com.example.demo.dto.ContactResponseDto;
import com.example.demo.dto.ContactRequestDto;


public interface ContactService {

    ContactResponseDto createContact(ContactRequestDto contactRequestDto);
}
