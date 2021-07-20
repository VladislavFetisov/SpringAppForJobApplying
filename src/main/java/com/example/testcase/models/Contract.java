package com.example.testcase.models;

import com.example.testcase.models.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId;

    @Enumerated(value = EnumType.STRING)
    private Status status;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "request_id")
//    private Request request;
}
