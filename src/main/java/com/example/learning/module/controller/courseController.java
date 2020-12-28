package com.example.learning.module.controller;

import com.example.learning.module.entity.course;
import com.example.learning.module.service.courseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class courseController {
    @Autowired
    courseService courseService;
@GetMapping("/courses")  
public List<course> getAllCourses()   
{
    return courseService.getAllCourses();  
}  
@PostMapping("/courses")  
private int saveCourse(@RequestBody course course)   
{  
courseService.saveOrUpdate(course);  
return course.getCourseId();  
}
@GetMapping("/courses/{id}")  
private course Course(@PathVariable("id") int id)   
{  
    return courseService.getCourseById(id);  
} 
@PutMapping("/courses/{id}")  
private course updateCourse(@PathVariable("id") int id,@RequestBody course newCourse)   
{  
    course oldCourse=courseService.getCourseById(id);
    courseService.saveOrUpdate(oldCourse);
    return oldCourse;
} 
@DeleteMapping("/courses/{id}")  
private void deleteCourse(@PathVariable("id") int id)   
{  
 courseService.delete(id);  
}   
}
