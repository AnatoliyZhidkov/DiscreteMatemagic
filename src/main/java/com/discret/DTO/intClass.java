//package com.discret.DTO;
//
//import com.discret.entity.Achievement;
//import com.discret.entity.Student;
//import com.discret.repository.StudentsRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//@RequiredArgsConstructor
//@Component
//public class intClass {
//    private final StudentsRepository studentsRepository;
//    @PostConstruct
//    public void init() {
//        Student student = studentsRepository.findByLogin("admin");
//
//        Achievement achievement = new Achievement();
//        achievement.setName("Один маленький шаг");
//        achievement.setStudents(List.of(student));
//        achievementRepository.save(achievement);
//    }
//
//}
