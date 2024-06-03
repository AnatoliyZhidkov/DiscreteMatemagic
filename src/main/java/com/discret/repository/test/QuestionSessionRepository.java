package com.discret.repository.test;

import com.discret.entity.test.QuestionSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionSessionRepository extends JpaRepository<QuestionSession,Long> {

}
