package com.dreamtree.api.domain.lesson.dto;

import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.progress.dto.PostProgressReqDTO;
import lombok.*;
//이승윤 ver0.1
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonApplyReqDTO {

    AddMailDTO mail;

    PostProgressReqDTO progress;

}
