package com.discret.DTO;

import com.discret.entity.test.QuestionSession;
import lombok.Data;

import java.util.List;

@Data
public class TestSubmissionDTO {

    private List<AnswerDTO> answers;

}