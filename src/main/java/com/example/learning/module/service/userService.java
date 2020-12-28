package com.example.learning.module.service;

import com.example.learning.module.entity.course;
import com.example.learning.module.entity.user;
import com.example.learning.module.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class userService {
    @Autowired
    userRepository userRepository;

    public List<user> getAllUserCourses()   
    {  
    List<user> userCourses =new ArrayList<user>();
    userRepository.findAll().forEach(userCourse -> userCourses.add(userCourse));  
    return userCourses;  
    } 
    public void saveOrUpdate(user userCourse)   
    {  
        userRepository.save(userCourse);  
    } 
    public List<course> getMandatoryCourses(int id){
        List<course> mandatoryCourses=new ArrayList<course>();

        course newCourse =new course();
        newCourse.courseName="Information Security"; newCourse.courseType="Technical";
        newCourse.courseDuration="13 hours";
        mandatoryCourses.add(newCourse);
        userRepository.findById(id).get().getCourses();
        return mandatoryCourses;

    }
    public user getUserCourseById(int id)   
    {  
    return userRepository.findById(id).get();  
       
    }  
    public void delete(int id)   
    {  
        userRepository.deleteById(id);  
    }  

    public void deleteUserCourse(int id,course course){
        System.out.println(course);
        user oldUserCourses=userRepository.findById(id).get();
        List<course> oldCourses=oldUserCourses.getCourses();
        oldCourses.remove(course);
        oldUserCourses.setCourses(oldCourses);
        userRepository.save(oldUserCourses);
    }
  
}
