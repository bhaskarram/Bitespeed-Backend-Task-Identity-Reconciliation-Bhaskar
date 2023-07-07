package com.example.demo.controller;

import com.example.demo.dao.ContactDao;
import com.example.demo.model.IdentityRequest;
import com.example.demo.model.IdentityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private ContactDao contactDao;

    @PostMapping("/identify")
    public ResponseEntity<IdentityResponse> identifyContact(@RequestBody IdentityRequest request) {

        IdentityResponse response = new IdentityResponse();
        response.getContact().setPhoneNumber(String.valueOf(123));
        response.getContact().setEmail("primary@example.com");
        response.getContact().setLinkedId(1);

        return ResponseEntity.ok(response);
    }
}
