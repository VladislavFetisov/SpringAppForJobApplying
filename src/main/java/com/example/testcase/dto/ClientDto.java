package com.example.testcase.dto;

import com.example.testcase.models.Client;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class ClientDto {
    private String name;
    private String surname;
    private String middleName;
    private String telephoneNumber;
    private String passportSeries;
    private String passportNumber;
    public static  ClientDto from(Client client) {
        return ClientDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .middleName(client.getMiddleName())
                .passportNumber(client.getPassportNumber())
                .passportSeries(client.getPassportSeries())
                .telephoneNumber(client.getTelephoneNumber())
                .build();
    }

    public static List<ClientDto> from(List<Client> buildings) {
        return buildings.stream().map(ClientDto::from).collect(Collectors.toList());
    }
}
