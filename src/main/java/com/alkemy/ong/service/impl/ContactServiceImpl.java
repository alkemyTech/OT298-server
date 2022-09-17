package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.ContactDTO;
import com.alkemy.ong.mapper.ContactMapper;
import com.alkemy.ong.model.Contact;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactMapper contactMapper;

    @Transactional
    @Override
    public ContactDTO save (ContactDTO dto){
        Contact contact = contactMapper.contactDTOToContact(dto);
        Contact savedContact = contactRepository.save(contact);
        return contactMapper.contactToContactDTO(savedContact);
    }

    public List<ContactDTO> getAll (){
        List<Contact> contactList = contactRepository.findAll();
        List<ContactDTO> contactDTOList = new ArrayList<>();
        for (Contact contact : contactList){
            contactDTOList.add(this.contactMapper.contactToContactDTO(contact));
        }
        return contactDTOList;
    }

    public void deleteById (Long id){
        contactRepository.deleteById(id);
    }
}
