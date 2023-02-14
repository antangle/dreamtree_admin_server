package com.dreamtree.api.domain.request.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RequestReqDTO extends PageRequestDTO {

    String keyword;

    // 학부모 회원 조회 검색 조건 ex) nickname, email...
    String condition;

    public String[] getKeyword() {
        return condition.trim().length() == 0 ? null : condition.split(",");
    }

    public String getCondition() {
        return keyword.trim().length() == 0 ? null : keyword;
    }

}