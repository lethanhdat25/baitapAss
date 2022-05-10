package com.example.spring_based.Student_Grade;

import com.example.spring_based.Grade.GradeEntity;
import com.example.spring_based.Student.StudentEntity;

import javax.persistence.*;

@Entity
@Table(name = "student_grade")
public class StudentGradeEntity {

    @EmbeddedId
    private StudentGradeId id;

    @ManyToOne
    @MapsId("gradeId")
    @JoinColumn(name = "gradeId")
    private GradeEntity grade;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    private StudentEntity student;


}
