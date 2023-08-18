package com.example.testcontainer.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "dummy")
public class Dummy {
    @Id
    @GeneratedValue(generator = "SEQ_POLICIES")
    @GenericGenerator(name = "SEQ_POLICIES", strategy = "uuid2")
    private UUID id;

    private String text;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
