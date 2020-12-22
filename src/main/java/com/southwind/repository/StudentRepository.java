package com.southwind.repository;

import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    Collection<Student> findAll();
    Student findByID(long id);
    void saveOrUpdate(Student student);
    void deleteByID(long id);
}
