package com.discret.service.test;


import com.discret.entity.test.Partition;
import com.discret.repository.test.PartitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatitionService {
    private final PartitionRepository partitionRepository;

    public boolean savePartition(String partition){
        partitionRepository.save(new Partition(partition));
        return true;
    }

    public List<Partition> findAll(){
        return partitionRepository.findAll();
    }

    public Partition findById(Long id){
        return partitionRepository.findById(id).orElse(null);
    }

    public void deletePartition(Long partitionId) {
        partitionRepository.deleteById(partitionId);
    }
}
