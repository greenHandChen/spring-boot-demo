package com.ceh.springboot8_6_2.dto;

/**
 * Created by enHui.Chen on 2018/1/29 0029.
 */
public class Student {
    private Long id;
    private String score;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
