package com.acme.identityreconciliation.service;
import com.acme.identityreconciliation.entities.Contact;
import com.acme.identityreconciliation.payloads.ContactDto;
import com.acme.identityreconciliation.payloads.ContactResponse;
import com.acme.identityreconciliation.payloads.ContactResponseDto;
import com.acme.identityreconciliation.repo.ContactRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactDto createContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setEmail(contactDto.getEmail());
        contact.setPhoneNumber(contactDto.getPhoneNumber());
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        // Check if a contact with the same email or phoneNumber already exists
        Contact existingContact = contactRepo.findFirstByEmailOrPhoneNumber(contactDto.getEmail(), contactDto.getPhoneNumber());
        if (existingContact != null) {
            // Set the linkedId of the new contact to the id of the existing contact
            contact.setLinkedId(existingContact.getId());
            contact.setLinkPrecedence(Contact.LinkPrecedence.SECONDARY);
        }
        Contact addedContact=this.contactRepo.save(contact);
        return this.modelMapper.map(addedContact,ContactDto.class);
    }

    @Override
    public ContactResponseDto getAllContact() {
        List<Contact> contacts =this.contactRepo.findAll();
        ContactResponse contactResponse=this.modelMapper.map(contacts,ContactResponse.class);
        contactResponse.setPrimaryContactId(contacts.get(0).getId());
        List<Integer> secondaryContactIds = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();
        Set<String> uniqueEmails = new HashSet<>();
        Set<String> uniquePhoneNumbers = new HashSet<>();
        for (Contact contact : contacts) {
            emails.add(contact.getEmail());
            phoneNumbers.add(contact.getPhoneNumber());
            if (!uniqueEmails.add(contact.getEmail()) || !uniquePhoneNumbers.add(contact.getPhoneNumber())) {
                secondaryContactIds.add(contact.getId());
            }
        }
        contactResponse.setEmails(emails);
        contactResponse.setPhoneNumbers(phoneNumbers);
        contactResponse.setSecondaryContactIds(secondaryContactIds);
        ContactResponseDto responseDto = new ContactResponseDto();
        responseDto.setContactResponse(contactResponse);
        return responseDto;
    }
}
