package com.dreamtree.api.domain.mail.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailRequestDTO extends PageRequestDTO {

    String mail;
}
