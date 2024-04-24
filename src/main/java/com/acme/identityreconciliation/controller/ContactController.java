package com.acme.identityreconciliation.controller;
import com.acme.identityreconciliation.payloads.ContactDto;
import com.acme.identityreconciliation.payloads.ContactResponse;
import com.acme.identityreconciliation.payloads.ContactResponseDto;
import com.acme.identityreconciliation.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/identityReconciliation/")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/identity")
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto) {
        ContactDto createContact =this.contactService.createContact(contactDto);
        return new ResponseEntity<ContactDto>(createContact, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactResponseDto> getContact(@PathVariable String id) {
        return ResponseEntity.ok(this.contactService.getAllContact());
    }

//    @PostMapping("/identity")
//    public ResponseEntity<ContactResponse> createContact(@RequestBody ContactDto contactDto) {
//        // Call the service method to create the contact
//        ContactDto createdContact = contactService.createContact(contactDto);
//

//        // Populate the response object
//        ContactResponse response = new ContactResponse();
//        response.setPrimaryContactId(createdContact.getId());
//        response.setEmails(Collections.singletonList(createdContact.getEmail()));
//        response.setPhoneNumbers(Collections.singletonList(createdContact.getPhoneNumber()));
//        // You need to populate secondaryContactIds based on your business logic
//
//        // Return the response
//        return ResponseEntity.ok(response);
//    }

}
