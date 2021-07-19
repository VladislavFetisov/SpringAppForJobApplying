package com.example.testcase.dto;

import com.example.testcase.models.Contract;
import com.example.testcase.models.Request;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ContractDto {
    private Long contractId;
    private String loanSum;
    private String monthsAmount;

    private String clientName;
    private String clientSurname;
    private String clientMiddleName;

    private Contract.Status status;

    public static ContractDto from(Contract contract) {
        return ContractDto.builder()
                .contractId(contract.getContractId())
                .loanSum(contract.getRequest().getLoanSum())
                .monthsAmount(contract.getRequest().getMonthsAmount())
                .clientName(contract.getRequest().getClient().getName())
                .clientSurname(contract.getRequest().getClient().getSurname())
                .clientMiddleName(contract.getRequest().getClient().getMiddleName())
                .status(contract.getStatus())
                .build();
    }

    public static List<ContractDto> from(List<Contract> contracts) {
        return contracts.stream().map(ContractDto::from).collect(Collectors.toList());
    }
}
