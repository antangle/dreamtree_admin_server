package com.dreamtree.api.domain.student.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/*** 임성현 ver.0.1 ***/

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO extends PageRequestDTO {

    String keyword;

    String condition;

    public String[] getCondition() {

        return condition.trim().length() == 0 ? null : condition.split(",");

    }
}
