package com.example.spring_based.Student;

import com.example.spring_based.Student_Grade.StudentGradeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Integer id;
    private String name;
    private Integer age;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private Set<StudentGradeEntity> StudentGrade;

    public StudentEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
