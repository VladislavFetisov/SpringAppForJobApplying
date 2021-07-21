package com.example.testcase.models;

import com.example.testcase.models.enums.MaritalStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
@EqualsAndHashCode(exclude = {"requests"})
@ToString(exclude = {"requests"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String name;

    @NotEmpty(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String surname;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String middleName;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String telephoneNumber;

    @Size(min = 4 ,max = 4,message ="Серия состоит из 4 цифр" )
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String passportSeries;

    @Size(min = 6 ,max = 6,message ="Номер состоит из 6 цифр" )
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String passportNumber;

    @NotBlank(message = "Не должно быть пустым")
    private String dateOfPassportReceiving;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String company;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String workRole;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String workPeriodInDays;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String country;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String region;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String city;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[А-яA-z]*", message = "Поле должно состоять только из букв")
    private String street;
    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String homeNumber;
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String flatNumber;


    @Enumerated(value = EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotBlank(message = "Не должно быть пустым")
    @Pattern(regexp = "[0-9]*", message = "Поле должно состоять только из цифр")
    private String creditAmount;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Request> requests = new HashSet<>();
}
