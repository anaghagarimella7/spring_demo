package com.example.learning.module.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@Entity
@Table(name="user")
@JsonIdentityInfo(

        generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class user {
    @Id
    @Column
    public int userId;

     @OneToMany(targetEntity = course.class,cascade = CascadeType.ALL)
     private List<course> courses;

     @OneToMany(targetEntity = competency.class,cascade = CascadeType.ALL)
     private List<competency> competencies;

    public List<course> getCourses() {
        return courses;
    }

    public void setCourses(List<course> courses) {
        this.courses = courses;
    }
    public List<competency> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<competency> competencies) {
        this.competencies=competencies;
    }
    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }
}
