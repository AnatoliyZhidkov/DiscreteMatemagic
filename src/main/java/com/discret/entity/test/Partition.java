package com.discret.entity.test;


import com.discret.entity.Student_Groups;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Partition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String partitionName;



    @OneToMany(mappedBy = "partition",cascade = CascadeType.ALL)
    private List<Test> test;

    public Partition() {

    }
    public Partition(String partitionName) {
        this.partitionName = partitionName;
    }

}
