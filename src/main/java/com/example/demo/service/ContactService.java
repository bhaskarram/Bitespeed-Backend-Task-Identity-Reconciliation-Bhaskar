package com.example.demo.service;

import com.example.demo.dto.ContactDto;
import com.example.demo.dto.ContactRequestDto;
import org.springframework.stereotype.Service;


public interface ContactService {

    ContactDto createContact(ContactRequestDto contactRequestDto);
}
