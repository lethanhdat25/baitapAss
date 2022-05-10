package com.example.spring_based.Card;

import com.example.spring_based.Person.PersonEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class CardEntity {
    @Id
    private Integer id;
    private String card_number;
    @OneToOne(mappedBy = "cardEntity")
    private PersonEntity personEntity;
}
