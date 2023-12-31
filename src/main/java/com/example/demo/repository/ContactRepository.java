package com.example.demo.repository;

import com.example.demo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {


    List<Contact> findByPhoneNumber(String phoneNo);

    List<Contact> findByEmail(String email);

}
