package org.hansei.toomanydo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Todo_entity {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String todo;
    private String deadline;
    private String username;
}
