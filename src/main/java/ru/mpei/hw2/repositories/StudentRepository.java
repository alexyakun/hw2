package ru.mpei.hw2.repositories;

import ru.mpei.hw2.domain.Student;

import java.util.List;

public interface StudentRepository {
    Student save(Student student);
    List<Student> findByGroup(String gname);
}
