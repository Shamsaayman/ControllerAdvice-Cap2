package org.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TeamLead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID ;
//    @NotEmpty(message = "name should be not empty")
//    @Size(min = 4 , message = "username should be more than 4 char")
//    @Column(columnDefinition = "varchar(5) not null")
    private String name ;
//    @NotNull(message = "experience should be not empty")
//    @Column(columnDefinition = "int not null ")
    private Integer experience ;
//    @Email
//    @NotEmpty(message = "email should be not empty")
//    @Column(columnDefinition = "varchar(10) not null unique")
    private String email ;
//    @Column(columnDefinition = "varchar(5) ")
    private String status;

}
