package com.ZenPack.model;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String emailId;
    private String userType;
    private DateTime loginAt;
//    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    private DateTime createdAt;
//
//    private DateTime updatedAt;

//    @PrePersist
//    public void onSave(){
//        // create at and update at
//        DateTime currentDateTime = new DateTime();
//
//        this.createdAt = currentDateTime;
//        this.updatedAt = currentDateTime;
//    }
//
//    @PostPersist
//    public void onUpdate(){
//        // update at
//        DateTime currentDateTime = new DateTime();
//
//        this.updatedAt = currentDateTime;
//    }
}
