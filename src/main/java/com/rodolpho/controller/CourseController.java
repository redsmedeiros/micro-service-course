package com.rodolpho.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodolpho.model.Course;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @GetMapping
    public List<Course> list(){
        return null;
    }
    
}
