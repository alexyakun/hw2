package ru.mpei.hw2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "otchestvo", nullable = false)
    private String otchestvo;
    @Column(name = "group_name", nullable = false)
    private String groupName;
    @Column(name = "year_in", nullable = false)
    private int year;
    @ManyToMany(fetch = FetchType.LAZY /*, cascade = CascadeType.PERSIST*/)
    // Задает таблицу связей между таблицами для хранения родительской и связанной сущностью
    @JoinTable(name = "students_marks", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "marks_id"))
    private List<Mark> marks;

}
