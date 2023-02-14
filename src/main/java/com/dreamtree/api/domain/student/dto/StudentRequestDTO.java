package com.dreamtree.api.domain.student.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO extends PageRequestDTO {

    String keyword;

    String condition;
}
