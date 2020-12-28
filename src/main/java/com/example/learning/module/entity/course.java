package com.example.learning.module.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAutoConfiguration
@Entity
@Table(name="course")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, property = "courseId")
public class course {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column
    public int courseId;

    @Column
    public String courseName;
    @Column
    public String courseType;
    @Column
    public Date coursePublishedDate;
    @Column
    public Boolean isCourseMandatory;
    @Column
    public String courseDuration;
    @Column
    public Boolean certificateExists;
    
    public int getCourseId(){
        return courseId;
    }

    public String getCourseName(){
        return courseName;
    }
    public String getCourseDuration(){
        return courseDuration;
    }

    public String getCourseType(){
        return courseType;
    }

    public Boolean getIsCourseMandatory(){
        return isCourseMandatory;
    }
    public Boolean getCertificateExists(){
        return certificateExists;
    }

    public void setCertificateExists(Boolean exists){
        this.certificateExists=exists;
    }
    public Date getCoursePublishedDate(){
      return coursePublishedDate;
   }

   public void setCoursePublishedDate(Date date){
       this.coursePublishedDate=date;
   }

    public void setId(int courseId){
        this.courseId=courseId;
    }

    public void setCourseName(String name){
        this.courseName=name;
    }

    public void setCourseDuration(String duration){
        this.courseDuration=duration;
    }
    public void setCourseType(String type){
        this.courseType=type;
    }

    public void setIsCourseMandatory(Boolean bool){
        this.isCourseMandatory=bool;
    }
}
