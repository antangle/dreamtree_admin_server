package com.dreamtree.api.domain.mail.dto;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddMailDTO {

    String fromEmail;

    String toEmail;

    String title;

    String content;

}
