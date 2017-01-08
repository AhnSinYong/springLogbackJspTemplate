package com.ahn.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ahnsy on 2017-01-08.
 */
public class User {
    @NotNull
    @Size(min=4, max=10, message="아이디는 4자에서 10자 사이로 입력하세요!")
    private String id;

    @NotNull(message="이름을 입력하세요!")
    @Size(max=10, message="한글이름은 공백포함 5자, 영문은 공백포함 10자 사이로 입력하세요!")
    private String name;

    @NotNull
    @Size(min=6, max=20, message="비밀번호는 6자에서 20자 사이로 입력하세요!")
    private String password;

    @Min(1)
    @Max(200)
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
