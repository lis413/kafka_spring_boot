package ru.lis154.kafka_spring_boot.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSec {

    Long id;
    String firstName;
    String lastName;
    String email;


}
