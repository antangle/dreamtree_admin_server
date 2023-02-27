package com.dreamtree.api.domain.progress.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayStatusReqDTO {

    private Long id;

    private String status;

}
