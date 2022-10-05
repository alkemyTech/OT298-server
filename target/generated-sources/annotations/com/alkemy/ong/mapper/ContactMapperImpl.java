package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.ContactDTO;
import com.alkemy.ong.model.Contact;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class ContactMapperImpl implements ContactMapper {

    @Override
    public ContactDTO contactToContactDTO(Contact entity) {
        if ( entity == null ) {
            return null;
        }

        ContactDTO contactDTO = new ContactDTO();

        contactDTO.setId( entity.getId() );
        contactDTO.setName( entity.getName() );
        contactDTO.setPhone( entity.getPhone() );
        contactDTO.setEmail( entity.getEmail() );
        contactDTO.setMessage( entity.getMessage() );

        return contactDTO;
    }

    @Override
    public Contact contactDTOToContact(ContactDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Contact contact = new Contact();

        contact.setId( dto.getId() );
        contact.setName( dto.getName() );
        contact.setPhone( dto.getPhone() );
        contact.setEmail( dto.getEmail() );
        contact.setMessage( dto.getMessage() );

        return contact;
    }
}
