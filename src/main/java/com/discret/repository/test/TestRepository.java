package com.discret.repository.test;

import com.discret.entity.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {

   // Test findByModuleAndAndNumber(int Module,int Number);
    Optional<Test> findByModuleAndAndNumber(int Module, int Number);

    List<Test> findAllByModule(int Module);
}
