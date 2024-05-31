package com.discret.repository;

import com.discret.entity.Student_Groups;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsGroupsRepository extends CrudRepository<Student_Groups, Long> {

    String getGroupnameById(Long id);
}
