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

    @Query("select q.questionNumber from Question q where q.test.Id = ?1 order by q.questionNumber desc LIMIT 1")
    Optional<Integer> maxQuestionNumberByTestId(Long testId);

    Optional<Integer> countByTestIdAndQuestionNumber(Long testId, int questionNumber);

    @Query("select q from Question q where q.test.Id = ?1 and q.questionNumber = ?2 order by random() LIMIT 1")
    Optional<Question> findByTestIdAndQuestionNumberOrderByRandom(Long testId, int questionNumber);
}
