package com.discret.repository.test;

import com.discret.entity.test.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    @Query("select q from Question q where q.test.Id = ?1")
    List<Question> findAllByTestId(Long id);
}
