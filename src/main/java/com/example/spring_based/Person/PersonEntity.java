package com.example.spring_based.Person;

import com.example.spring_based.Card.CardEntity;

import javax.persistence.*;

@Entity
@Table(name = "persons")

public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user_name ;
    @OneToOne
    @JoinColumn(name = "card_id")
    private CardEntity cardEntity;
}
