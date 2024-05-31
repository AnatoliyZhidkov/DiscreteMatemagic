package com.discret.service;

import com.discret.repository.StudentsGroupsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentGroupsService {

    private final StudentsGroupsRepository studentsGroupsRepository;

    public String getGroupnameById(Long id){

        return studentsGroupsRepository.getGroupnameById(id);
    }

}
