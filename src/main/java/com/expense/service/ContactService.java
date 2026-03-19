package com.expense.service;

import java.util.List;

import com.expense.entity.Contact;
import com.expense.request.ContactReq;

public interface ContactService {

    List<Contact> getAllContact();

    Contact addContact(ContactReq req);

    Contact getById(Long id);

    Contact update(Long id, ContactReq req);

    void delete(Long id);

}