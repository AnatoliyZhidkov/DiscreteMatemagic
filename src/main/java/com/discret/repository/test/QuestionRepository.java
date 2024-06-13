package com.discret.repository.test;

import com.discret.entity.test.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("select q from Question q where q.test.Id = ?1 order by q.questionNumber")
    List<Question> findAllByTestIdOrderByQuestionNumber(Long id);

    Optional<List<Question>> findAllByTestId(Long testId);
}
