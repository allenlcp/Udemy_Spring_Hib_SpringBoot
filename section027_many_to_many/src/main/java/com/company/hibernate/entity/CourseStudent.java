package com.company.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_student")
public class CourseStudent {

    @Id
    @Column(name="course_id")
    private int courseId;

    @Id
    @Column(name="student_id")
    private int studentId;
}
