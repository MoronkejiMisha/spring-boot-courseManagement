package com.Project.CourseManagement.controllers;

import com.Project.CourseManagement.dto.CreatorDto;
import com.Project.CourseManagement.dto.CreatorResponseDto;
import com.Project.CourseManagement.services.CreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CreatorController {
    private final CreatorService creatorService;
    @GetMapping("/creators")
    public List<CreatorResponseDto> getCreators(){
        return creatorService.findAllCreators();
    }

    @PostMapping("/creators")
    public void saveCreator(@RequestBody CreatorDto creatorDto){
        creatorService.addCreator(creatorDto);
    }
    @GetMapping("/creators/firstname/{creator-firstname}")
    public List<CreatorResponseDto> getCreatorByFirstName(@PathVariable("creator-firstname") String name){
        return creatorService.findCreatorByFirstName(name);
    }
    @GetMapping("/creators/lastname/{creator-lastname}")
    public List<CreatorResponseDto> getCreatorByLastName(@PathVariable("creator-lastname") String name){
        return creatorService.findCreatorByLastName(name);
    }
    @GetMapping("/creators/{creator-Id}")
    public CreatorResponseDto getCreatorById(@PathVariable("creator-Id") Integer id){
        return creatorService.findCreatorById(id);
    }
    @DeleteMapping("/creators/{creator-id}/delete")
    public void deleteCreator(@PathVariable("creator-id") Integer id){
        creatorService.deleteCreator(id);
    }
}
