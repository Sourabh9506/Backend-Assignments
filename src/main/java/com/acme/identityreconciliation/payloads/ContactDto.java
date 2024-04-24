package com.acme.identityreconciliation.payloads;

import com.acme.identityreconciliation.entities.Contact;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private Integer id;

    private String phoneNumber;

    private String email;

    private Integer linkedId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    private Contact.LinkPrecedence linkPrecedence;
}
