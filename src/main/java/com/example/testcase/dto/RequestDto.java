package com.example.testcase.dto;

import com.example.testcase.models.Client;
import com.example.testcase.models.Request;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RequestDto {
    private Long requestId;

    private Request.Decision decision;

    private String monthsAmount;

    private String loanSum;

    private String clientName;
    private String clientSurname;
    private String clientMiddleName;

    public static RequestDto from (Request request){
        return RequestDto.builder()
                .requestId(request.getRequestId())
                .decision(request.getDecision())
                .monthsAmount(request.getMonthsAmount())
                .loanSum(request.getLoanSum())
                .clientName(request.getClient().getName())
                .clientSurname(request.getClient().getSurname())
                .clientMiddleName(request.getClient().getMiddleName())
                .build();
    }
    public static List<RequestDto> from(List<Request> requests) {
        return requests.stream().map(RequestDto::from).collect(Collectors.toList());
    }
}
