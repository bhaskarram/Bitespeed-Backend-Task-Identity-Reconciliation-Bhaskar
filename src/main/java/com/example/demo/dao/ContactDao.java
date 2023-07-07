package com.example.demo.dao;

import com.example.demo.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactDao extends CrudRepository<Contact,Integer> {
}
