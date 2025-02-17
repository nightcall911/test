package com.example.test12.service;

import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.GroupResponseDto;
import com.example.test12.dto.StudentResponseDto;
import com.example.test12.entity.Group;
import com.example.test12.entity.Student;
import com.example.test12.repository.GroupRepository;
import com.example.test12.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void add(AddGroupRequestDto addGroupRequestDto) {
        Group group = new Group();
        group.setGroupNumber(addGroupRequestDto.getNumber());
        groupRepository.save(group);
    }

    @Override
    public GroupResponseDto get(int id) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        Optional<Group> group = groupRepository.findById(id);
        groupResponseDto.setId(id);
        groupResponseDto.setNumber(group.get().getGroupNumber());
        List<String> studentsName = new ArrayList<>();
        for (Student student : studentRepository.findAll()) {
            if(student.getGroup().getGroupNumber().equals(group.get().getGroupNumber())) {
               studentsName.add(student.getSurname());
            }
        }
        groupResponseDto.setStudentNames(studentsName);
        return groupResponseDto;
    }


    @Override
    public List<String> getAllGroupNumber() {
        List<Group> groups = groupRepository.findAll();
        List<String> groupNumbers = groups.stream()
                .map(Group::getGroupNumber)
                .toList();
        return groupNumbers;
    }
}
