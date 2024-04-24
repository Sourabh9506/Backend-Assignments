package com.acme.identityreconciliation.repo;
import com.acme.identityreconciliation.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {

    Contact findFirstByEmailOrPhoneNumber(String email, String phoneNumber);


}
