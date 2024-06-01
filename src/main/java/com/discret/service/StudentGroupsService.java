package com.discret.service;

import com.discret.entity.Student_Groups;
import com.discret.repository.StudentsGroupsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentGroupsService {

    private final StudentsGroupsRepository studentsGroupsRepository;

    public String getGroupnameById(Long id){

        return studentsGroupsRepository.getGroupnameById(id);
    }

    public List<Student_Groups> findAllGroups(){
        return studentsGroupsRepository.findAll();
    }

    public boolean createGroup(String groupname, int groupNumber){

        if(studentsGroupsRepository.findByGroupnameAndAndGroupNumber(groupname,groupNumber) != null){
            return false;
        }
        Student_Groups student_group = new Student_Groups();
        student_group.setGroupname(groupname);
        student_group.setGroupNumber(groupNumber);
        studentsGroupsRepository.save(student_group);
        return true;
    }

    @Transactional
    public boolean deleteGroup(String groupname, int groupNumber){
            Student_Groups student_groups = studentsGroupsRepository.findByGroupnameAndAndGroupNumber(groupname,groupNumber);
        if ( student_groups!= null){
            studentsGroupsRepository.deleteById(student_groups.getId());
            return true;
        }
        return false;
    }

}
