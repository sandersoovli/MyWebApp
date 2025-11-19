package com.mycompany.mywebapp.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 45, nullable = false, name = "firstname")
    private String firstName;

    @Column(length = 45, nullable = false, name = "lastname")
    private String lastName;

}
