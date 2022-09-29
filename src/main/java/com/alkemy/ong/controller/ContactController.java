package com.alkemy.ong.controller;

import com.alkemy.ong.dto.ContactDTO;
import com.alkemy.ong.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ContactController {

    @Autowired
    private IContactService contactService;

    @PostMapping("/contacts")
    public ResponseEntity<ContactDTO> saveContact(@Valid @RequestBody ContactDTO contactDTO) {
        ContactDTO savedContact = contactService.save(contactDTO);
        return ResponseEntity.ok(savedContact);
    }
}
