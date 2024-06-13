package com.discret.repository.test;

import com.discret.entity.test.Partition;
import com.discret.entity.test.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartitionRepository extends JpaRepository<Partition, Long> {


}
