package com.example.spring_study_hw2.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TextDTO {

    public TextDTO(String text) {
        this.text = text;
    }

    String text;
}
