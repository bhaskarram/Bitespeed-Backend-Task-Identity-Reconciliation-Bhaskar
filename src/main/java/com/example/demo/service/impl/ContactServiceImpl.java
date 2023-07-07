package com.example.demo.service.impl;

import com.example.demo.dto.ContactDto;
import com.example.demo.dto.ContactRequestDto;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactDto createContact(ContactRequestDto contactRequestDto) {

        //Convert DTO to entity
        Contact contact = new Contact();
        contact.setPhoneNumber(contactRequestDto.getPhoneNumber());
        contact.setEmail(contactRequestDto.getEmail());
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        contact.setLinkPrecedence("Primary");

        Contact newContact = contactRepository.save(contact);

        //Convert entity to DTO

        ContactDto contactResponse = new ContactDto();
        contactResponse.setPrimaryContatctId(newContact.getId());
        contactResponse.setEmails(newContact.getEmail());
        contactResponse.setPhoneNumbers(newContact.getPhoneNumber());
        return contactResponse;
    }
}
