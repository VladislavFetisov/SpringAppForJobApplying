package com.example.testcase.models;

import com.example.testcase.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "credit_app_users",uniqueConstraints=
@UniqueConstraint(columnNames={"login"}))
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @NotNull
    String login;
    @NotNull
    String password;
}
