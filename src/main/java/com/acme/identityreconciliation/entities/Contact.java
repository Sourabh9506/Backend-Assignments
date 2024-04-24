package com.acme.identityreconciliation.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String phoneNumber;

    private String email;

    private Integer linkedId;

   private LocalDateTime createdAt;

   private LocalDateTime updatedAt;

   private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    private LinkPrecedence linkPrecedence;

    public enum LinkPrecedence {
        PRIMARY,
        SECONDARY,
    }

}
