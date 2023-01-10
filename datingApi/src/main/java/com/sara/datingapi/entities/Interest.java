package com.sara.datingapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String likes;
    private String dislikes;
    private String hobbies;

    private String profileUrl;
    private String about;
    @Transient
    private int userAccountId;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserAccount userAccount;
}
