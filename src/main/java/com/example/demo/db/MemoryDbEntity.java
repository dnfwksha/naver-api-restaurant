package com.example.demo.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class MemoryDbEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer index;
}
