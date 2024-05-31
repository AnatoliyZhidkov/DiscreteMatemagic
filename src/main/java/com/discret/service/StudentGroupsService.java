package com.discret.service;

import com.discret.entity.Student_Groups;
import com.discret.repository.StudentsGroupsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

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

}
