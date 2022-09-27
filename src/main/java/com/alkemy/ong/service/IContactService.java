package com.alkemy.ong.service;

import com.alkemy.ong.dto.ContactDTO;

import java.util.List;

public interface IContactService {

    ContactDTO save (ContactDTO dto);

    List<ContactDTO> getAll ();

    void deleteById (Long id);
}
