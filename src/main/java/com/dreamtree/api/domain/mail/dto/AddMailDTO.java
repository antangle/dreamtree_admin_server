package com.dreamtree.api.domain.mail.dto;

import lombok.*;

/*** 임성현 ver.0.1 ***/

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
