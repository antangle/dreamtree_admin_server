package com.dreamtree.api.domain.parent.dto;

import com.dreamtree.api.common.dto.PageRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/** 최서연 ver.0.1 **/
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ParentInfoReqDTO extends PageRequestDTO {

    String keyword;

    // 학부모 회원 조회 검색 조건 ex) nickname, email...
    String condition;

    String order;

    public String[] getCondition() {
        return condition.trim().length() == 0 ? null : condition.split(",");
    }

    public String getKeyword() {
        return keyword.trim().length() == 0 ? null : keyword;
    }
}
