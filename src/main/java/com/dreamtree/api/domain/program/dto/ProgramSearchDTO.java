package com.dreamtree.api.domain.program.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProgramSearchDTO extends PageRequestDTO{
    String keyword;

    String condition;

    String order;

    long subCategoryId;

    public String[] getCondition() {

        return condition.trim().length() == 0 ? null : condition.split(",");

    }

}
