package com.dreamtree.api.domain.lesson.dto;

import com.dreamtree.api.domain.mail.dto.AddMailDTO;
import com.dreamtree.api.domain.progress.dto.PostProgressReqDTO;
import lombok.*;

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
