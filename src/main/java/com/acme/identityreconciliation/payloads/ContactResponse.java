package com.acme.identityreconciliation.payloads;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {

    private Integer primaryContactId;

    private List<String> emails;

    private List<String> phoneNumbers;

    private List<Integer> secondaryContactIds;
}
