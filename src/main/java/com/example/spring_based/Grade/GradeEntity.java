package com.example.spring_based.Grade;

import com.example.spring_based.Student.StudentEntity;
import com.example.spring_based.Student_Grade.StudentGradeEntity;
import com.example.spring_based.Student_Grade.StudentGradeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL)
    private Set<StudentGradeEntity> StudentGrade;

    public GradeEntity(String name) {
        this.name = name;
    }
}
