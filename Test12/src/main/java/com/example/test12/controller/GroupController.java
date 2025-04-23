package com.example.test12.controller;


import com.example.test12.dto.AddGroupRequestDto;
import com.example.test12.dto.GroupResponseDto;
import com.example.test12.entity.Group;
import com.example.test12.service.GroupService;
import liquibase.integration.spring.SpringLiquibase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {


    @Autowired
    private GroupService groupService;

    @GetMapping("/{id}")
    public GroupResponseDto getGroups(@RequestParam int id) {
        return groupService.get(id); //zalupaosla
    }


    @PostMapping
    public void add(@RequestBody AddGroupRequestDto addGroupRequestDto){
        groupService.add(addGroupRequestDto);
    }

    @GetMapping
    public List<String> getAllGroupsNumber() {
        return groupService.getAllGroupNumber();
    }


}
