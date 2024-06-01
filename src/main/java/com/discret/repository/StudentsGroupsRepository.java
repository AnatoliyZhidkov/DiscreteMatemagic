package com.discret.repository;

import com.discret.entity.Student_Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsGroupsRepository extends CrudRepository<Student_Groups, Long> {

    String getGroupnameById(Long id);

    List<Student_Groups> findAll();

    Student_Groups findByGroupnameAndAndGroupNumber(String groupname, int groupNumber);


}
