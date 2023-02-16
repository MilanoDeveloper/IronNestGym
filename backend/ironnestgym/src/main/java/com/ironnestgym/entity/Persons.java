package com.ironnestgym.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_persons")
public class Persons {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    private String  personName;
    private String  personAddress;
    private String  personCode;
    private String  email;
    private String  userName;
    private String  password;
    private String  gender;
    private Integer age;

}
