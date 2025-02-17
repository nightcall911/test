package com.example.test12.service;

import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.GroupResponseDto;

import java.util.List;


public interface GroupService {


    void add(AddGroupRequestDto addGroupRequestDto);


    GroupResponseDto get(int id);


    List<String> getAllGroupNumber();

}
