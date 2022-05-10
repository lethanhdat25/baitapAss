package com.example.spring_based.Student_Grade;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentGradeId implements Serializable {
    @Column(name = "gradeId")
    private Integer gradeId;

    @Column(name = "studentId")
    private Integer studentId;
}
