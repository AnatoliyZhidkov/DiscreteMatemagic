package com.discret.service;

import com.discret.entity.Role;
import com.discret.entity.Student;
import com.discret.repository.RoleRepository;
import com.discret.repository.StudentsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StuduntService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Student student = studentsRepository.findByLogin(login);

        if(student == null){
            throw new UsernameNotFoundException("Student not found");
        }
        return student;
    }

    public Student findStudentById(Long studentId){
        Optional<Student> studentFromDb = studentsRepository.findById(studentId);
        return studentFromDb.orElse(new Student());
    }

    public List<Student> allStudents(){
        return studentsRepository.findAll();
    }

    public boolean saveStudent(Student student){

        Student studentFromDb = studentsRepository.findByLogin(student.getLogin());

        if (studentFromDb != null){
            return false;
        }

        student.setRoles(Collections.singleton(new Role(1L,"ROLE_STUDENT")));
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        studentsRepository.save(student);
        return true;

    }

    public boolean deleteStudent(Long studentId){
        if (studentsRepository.findById(studentId).isPresent()){
            studentsRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
    public List<Student> studentGetList(Long idMin){
        return em.createQuery("SELECT s FROM student s WHERE s.id > :paramId", Student.class)
                .setParameter("paramId", idMin).getResultList();
    }

}
