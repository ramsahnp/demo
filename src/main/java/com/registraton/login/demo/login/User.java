package com.registraton.login.demo.login;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 145)
    private String email;

    @Column(nullable = false, unique = true, length = 245)
    private String password;

    @Column(nullable = false, length = 145)
    private String firstName;

    @Column(nullable = false, length = 145)
    private String lastName;

}
