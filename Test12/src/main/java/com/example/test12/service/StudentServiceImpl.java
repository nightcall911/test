package com.example.test12.service;

import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.AddStudentRequestDto;
import com.example.test12.dto.StudentResponseDto;
import com.example.test12.entity.Group;
import com.example.test12.entity.Student;
import com.example.test12.repository.GroupRepository;
import com.example.test12.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void add(AddStudentRequestDto addStudentRequestDto) {
        Student student = new Student();
        student.setSurname(addStudentRequestDto.getSurname());
        student.setGroup(groupRepository.findById(addStudentRequestDto.getGroupId()).get());
        studentRepository.save(student);
    }

    @Override
    public void addStudentToGroup(int studentId, int groupId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Group> group = groupRepository.findById(groupId);
        student.get().setGroup(group.get());
            studentRepository.save(student.get());
    }

    @Override
    public StudentResponseDto get(int id) {
        Optional<Student> student = studentRepository.findById(id);
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setSurname(student.get().getSurname());
        studentResponseDto.setId(student.get().getId());
        studentResponseDto.setGroupNumber(student.get().getGroup().getGroupNumber());
        return studentResponseDto;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
