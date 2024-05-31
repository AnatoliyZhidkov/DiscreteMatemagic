package com.discret.controllers.payload;

import com.discret.entity.Student_Groups;

public record NewStudentPayload (

    String login,
    String password,
    String firstName,
    String middleName,
    String lastName,
    Student_Groups student_groups

){}

