package com.example.testcase.models;

import com.example.testcase.models.enums.Decision;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Enumerated(value = EnumType.STRING)
    private Decision decision;

    private String monthsAmount;

    private String loanSum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "request", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Contract contract;


}
