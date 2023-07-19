package com.example.demo.controller;

import com.example.demo.dto.ContactResponseDto;
import com.example.demo.dto.ContactRequestDto;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identify")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponseDto> createUser(@RequestBody ContactRequestDto contactRequestDto){
        return new ResponseEntity<>(contactService.createContact(contactRequestDto), HttpStatus.OK);
    }
}
