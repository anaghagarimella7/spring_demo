package com.example.learning.module.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
@Table(name="competency")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, property = "competencyId")
public class competency {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name = "competencyId")
    public int competencyId;

    @Column
    public String competencyName;
    @Column
    public String competencyType;
    public int getCompetencyId(){
        return competencyId;
    }

    public String getCompetencyName(){
        return competencyName;
    }

    public String getCompetencyType(){
        return competencyType;
    }
   
    public void setCompetencyId(int competencyId){
        this.competencyId=competencyId;
    }

    public void setCompetencyName(String name){
        this.competencyName=name;
    }

    public void setCompetencyType(String type){
        this.competencyType=type;
    }
   
}
