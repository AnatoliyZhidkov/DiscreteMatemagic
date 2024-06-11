package com.discret.service.student;

import com.discret.entity.Role;
import com.discret.entity.Student;
import com.discret.entity.Student_Groups;
import com.discret.repository.RoleRepository;
import com.discret.repository.StudentsGroupsRepository;
import com.discret.repository.StudentsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class StudentService implements UserDetailsService {



    @PersistenceContext
    private EntityManager em;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    StudentsGroupsRepository studentsGroupsRepository;

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


    @Transactional
    public boolean updateStudent(Long Id,String login, String password, String lastName, String firstName, String middleName, String roleName , Long groupId){

        this.studentsRepository.findById(Id)
                .ifPresentOrElse(student -> {
                            student.setLogin(login);
                            student.setPassword(bCryptPasswordEncoder.encode(password));
                            student.setLastName(lastName);
                            student.setFirstName(firstName);
                            student.setMiddleName(middleName);
                            student.setStudent_groups(
                                    studentsGroupsRepository.findById(groupId)
                                        .orElseThrow(() -> new IllegalArgumentException("Invalid group ID: " + groupId)));
                            Set<Role> roles = new HashSet<>();
                            roles.add(roleRepository.findByName(roleName));
                            student.setRoles(roles);
                        }  ,() -> {throw new NoSuchElementException();}
                        );

        return true;

    }


    @Transactional
    public boolean saveStudent(String login, String password, String lastName, String firstName, String middleName, String roleName , Long groupId){

        Student studentFromDb = studentsRepository.findByLogin(login);

        if (studentFromDb != null){

            return false;
        }

        Student student = new Student();
        student = setStudent(student, login, password, lastName, firstName, middleName, roleName, groupId);
        studentsRepository.save(student);
        return true;

    }

    private Student setStudent(Student student,String login, String password, String lastName, String firstName, String middleName, String roleName , Long groupId){

        Student_Groups studentGroup = studentsGroupsRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid group ID: " + groupId));
        Role role = roleRepository.findByName(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Invalid role: " + roleName);
        }
        student.setLogin(login);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setStudent_groups(studentGroup);
        student.setPassword(bCryptPasswordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        student.setRoles(roles);
        return student;
    }


    @Transactional
    public boolean deleteStudent(Long studentId){
        if (studentsRepository.findById(studentId).isPresent()){
            studentsRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
    public List<Student> studentGetListByGroup(Long grId){
        return em.createQuery("SELECT s FROM student s WHERE s.student_groups.id = :paramId", Student.class)
                .setParameter("paramId", grId).getResultList();
    }

    @Transactional
    public boolean changePassword(Student student, String newPassword){

        student.setPassword(bCryptPasswordEncoder.encode(newPassword));
        studentsRepository.save(student);
        return true;
    }


    public boolean checkPassword(Student student, String passwordFromDB) {
        return bCryptPasswordEncoder.matches(passwordFromDB,student.getPassword());
    }


}
