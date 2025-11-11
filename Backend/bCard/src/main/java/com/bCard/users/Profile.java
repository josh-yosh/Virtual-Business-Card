package com.bCard.users;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Profile {
    @Id
    private long id;
    private String name;
    private String email;
    private String phoneNumber;

}

