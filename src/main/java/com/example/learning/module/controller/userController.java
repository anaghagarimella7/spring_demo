package com.example.learning.module.controller;

import com.example.learning.module.entity.course;
import com.example.learning.module.entity.user;
import com.example.learning.module.service.courseService;
import com.example.learning.module.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class userController {
    @Autowired
    userService userService;
    @Autowired
    courseService courseService;

    @GetMapping("/userCourses")
    public List<user> getAllUserCourses() {
        return userService.getAllUserCourses();
    }

    @PostMapping("/userCourses")
    private void saveCourse(@RequestBody user userCourses)  {     
        userService.saveOrUpdate(userCourses);
    }

    @GetMapping("/userCourses/{id}")
    private user Course(@PathVariable("id") int id)  {
        return userService.getUserCourseById(id);
    }

    @PostMapping("/userCourses/{id}")
    private void updateCourses(@PathVariable("id") int id, @RequestBody course course) {
        user oldUserCourses = userService.getUserCourseById(id);
        List<course> oldCourses = oldUserCourses.getCourses();
        oldCourses.add(course);
        oldUserCourses.setCourses(oldCourses);
        userService.saveOrUpdate(oldUserCourses);
    
    }
    @PutMapping("/userCourses/{id}")
    private void deleteUserCourse(@PathVariable("id") int id,@RequestBody course course)  {
    user oldUserCourses=userService.getUserCourseById(id);
    List<course> oldCourses= oldUserCourses.getCourses();
    for(int i=0;i<oldCourses.size();i++){
        if(oldCourses.get(i).courseId==course.getCourseId()){
            oldCourses.remove(oldCourses.get(i));
        }
    }
    oldUserCourses.setCourses(oldCourses);
    userService.saveOrUpdate(oldUserCourses);
    }

/*    @PutMapping("/userCourses/status/{id}")
    private void updateUserCourseStatus(@PathVariable("id") int id,@RequestBody course course,String status)  {
    user oldUserCourses=userService.getUserCourseById(id);
    List<course> oldCourses= oldUserCourses.getCourses();
    for(int i=0;i<oldCourses.size();i++){
        if(oldCourses.get(i).courseId==course.getCourseId()){
        }
    
        }
    oldUserCourses.setCourses(oldCourses);
    userService.saveOrUpdate(oldUserCourses);
}*/
}
