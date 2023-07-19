package com.example.demo.service.impl;

import com.example.demo.dto.ContactResponseDto;
import com.example.demo.dto.ContactRequestDto;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }



    @Transactional
    @Override
    public ContactResponseDto createContact(ContactRequestDto contactRequestDto) {

        List<Contact> existingContact = findExistingContact(contactRequestDto);
        List<Contact> contactList= contactRepository.findByPhoneNumber(contactRequestDto.getPhoneNumber());
        
        if(!existingContact.isEmpty()){
          Contact contact = new Contact();
          contact.setPhoneNumber(contactRequestDto.getPhoneNumber());
          contact.setEmail(contactRequestDto.getEmail());
          contact.setUpdatedAt(LocalDateTime.now());
          contact.setLinkedId(contactList.get(0).getId());
          contact.setLinkPrecedence("Secondary");

          Contact newContacts = contactRepository.save(contact);


          ContactResponseDto contactResponse = new ContactResponseDto();
          contactResponse.setPrimaryContatctId(newContacts.getId());

          Set<String> emails = new HashSet<>();
          emails.add(newContacts.getEmail());

          for (Contact value : contactList) {
              emails.add(value.getEmail());
          }

          contactResponse.setEmails(emails);

          Set<String> numbers = new HashSet<>();
          numbers.add(newContacts.getPhoneNumber());
          for (Contact value : contactList) {
              numbers.add(value.getPhoneNumber());
          }

          contactResponse.setPhoneNumbers(numbers);

          contactResponse.setSecondaryContactIds(Collections.singletonList(contactList.get(0).getId()));
          return contactResponse;
        }
      else {
          Contact contact = new Contact();
          contact.setPhoneNumber(contactRequestDto.getPhoneNumber());
          contact.setEmail(contactRequestDto.getEmail());
          contact.setCreatedAt(LocalDateTime.now());
          contact.setUpdatedAt(LocalDateTime.now());
          contact.setLinkPrecedence("Primary");

          Contact newContacts = contactRepository.save(contact);

          ContactResponseDto contactResponse = new ContactResponseDto();
          contactResponse.setPrimaryContatctId(newContacts.getId());
          contactResponse.setEmails(Collections.singleton(newContacts.getEmail()));
          contactResponse.setPhoneNumbers(Collections.singleton(newContacts.getPhoneNumber()));
          return contactResponse;
      }
    }

   //Find the existing phoneNo and email
    private List<Contact> findExistingContact(ContactRequestDto newContact) {
        if (newContact.getPhoneNumber() != null) {
            return contactRepository.findByPhoneNumber(newContact.getPhoneNumber());
        } else if (newContact.getEmail() != null) {
            return contactRepository.findByEmail(newContact.getEmail());
        }
        return null;
    }
}
