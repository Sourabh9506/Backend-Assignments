package com.acme.identityreconciliation.service;

import com.acme.identityreconciliation.payloads.ContactDto;
import com.acme.identityreconciliation.payloads.ContactResponse;
import com.acme.identityreconciliation.payloads.ContactResponseDto;

public interface ContactService {

    ContactDto createContact(ContactDto contactDto);

    ContactResponseDto getAllContact();
}
