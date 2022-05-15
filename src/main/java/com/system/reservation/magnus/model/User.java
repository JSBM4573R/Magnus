package com.system.reservation.magnus.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author JSBM
 */

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "User", indexes =  @Index(name = "index_email", columnList = "user_email", unique = true))
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_name", nullable = false, length = 45)
    private String name;
    @NonNull
    @Column(name = "user_email", nullable = false, length = 50)
    private String email;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 35)
    private String password;
}
