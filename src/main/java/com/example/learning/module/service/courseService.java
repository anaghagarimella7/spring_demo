package com.example.learning.module.service;

import com.example.learning.module.entity.course;
import com.example.learning.module.repository.courseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class courseService {
    @Autowired
    courseRepository courseRepository;

    public List<course> getAllCourses()   
    {  
    List<course> courses =new ArrayList<course>();
    courseRepository.findAll().forEach(course -> courses.add(course));  
    return courses;  
    } 
    public void saveOrUpdate(course course)   
    {  
    courseRepository.save(course);  
    } 
    public course getCourseById(int id)   
    {  
    return courseRepository.findById(id).get();  
    }  
    public void delete(int id)   
    {  
     courseRepository.deleteById(id);  
    }  

    public long count(){
        return courseRepository.count();
    }
    public List<course> getMandatoryCourses(){
        List<course> mandatoryCourses=new ArrayList<course>();
        List<course> allCourses=getAllCourses();
        for(int i=0;i<allCourses.size();i++){
            if(allCourses.get(i).isCourseMandatory!=null && allCourses.get(i).isCourseMandatory){
                mandatoryCourses.add(allCourses.get(i));
                System.out.println(allCourses.get(i));
            }
        }
    
        return mandatoryCourses;
    }
    
}
