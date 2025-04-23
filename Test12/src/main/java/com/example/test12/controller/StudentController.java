package com.example.test12.controller;

import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.AddStudentRequestDto;
import com.example.test12.dto.StudentResponseDto;
import com.example.test12.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
   private StudentService studentService; //pediks

    @GetMapping
    public StudentResponseDto get(@RequestParam int id) {
        return studentService.get(id);
    }

    @PostMapping
    public void add(@RequestBody AddStudentRequestDto addStudentRequestDto) {
        studentService.add(addStudentRequestDto);
    }

    @PatchMapping
    public void addStudentToGroup(@RequestParam int studentId, int groupId) {
        studentService.addStudentToGroup(studentId, groupId);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) {
        studentService.deleteStudent(id);
    }


}
