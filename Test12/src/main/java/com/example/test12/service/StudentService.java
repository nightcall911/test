package com.example.test12.service;

import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.AddStudentRequestDto;
import com.example.test12.dto.StudentResponseDto;
import com.example.test12.entity.Student;

public interface StudentService {

    void add(AddStudentRequestDto addStudentRequestDto);

    void addStudentToGroup(int studentId, int groupId);

    StudentResponseDto get(int id);

    void deleteStudent(int id);


}
