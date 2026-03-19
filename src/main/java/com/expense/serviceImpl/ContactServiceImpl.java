package com.expense.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.entity.Contact;
import com.expense.repository.ContactRepository;
import com.expense.request.ContactReq;
import com.expense.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repo;

    @Override
    public List<Contact> getAllContact() {
        return repo.findAll();
    }

    @Override
    public Contact addContact(ContactReq req) {
        Contact contact = new Contact();
        contact.setName(req.getName());
        contact.setEmail(req.getEmail());
        contact.setPhone(req.getPhone());
        contact.setAddress(req.getAddress());
        contact.setCategory(req.getCategory());
        return repo.save(contact);
    }

    @Override
    public Contact getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public Contact update(Long id, ContactReq req) {
        Contact contact = repo.findById(id).orElseThrow();
        contact.setName(req.getName());
        contact.setEmail(req.getEmail());
        contact.setPhone(req.getPhone());
        contact.setAddress(req.getAddress());
        contact.setCategory(req.getCategory());
        return repo.save(contact);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}