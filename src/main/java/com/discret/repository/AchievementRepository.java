package com.discret.repository;

import com.discret.entity.Achievement;
import com.discret.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    Achievement findByName(String name);
}
