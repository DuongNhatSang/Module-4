package com.codegym.model;

import javax.validation.constraints.*;

public class UserDTO {
    private long id;

    @NotBlank(message = "không được để trống")
    @Size(min = 5,max = 45,message = "độ dài tối thiểu 5, tối đa 45 ký tự")
    private String name;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^0[0-9]{9}",message = "Sđt không đúng định dạng")
    private String phoneNumber;

    @NotNull(message = "không được để trống")
    @Min(value = 18,message = "tuổi phải lớn hơn hoặc bằng 18")
    private int age;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[a-z]+[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+\\.*[a-zA-Z0-9]*)",message = "email không đúng định dạng")
    private String email;

    public UserDTO() {
    }

    public UserDTO(long id, @NotBlank @Size(min = 5, max = 45, message = "độ dài tối thiểu 5, tối đa 45 ký tự") String name, @NotBlank @Pattern(regexp = "^0[0-9]{9}", message = "Sđt không đúng định dạng") String phoneNumber, @NotNull @Min(value = 18, message = "tuổi phải lớn hơn hoặc bằng 18") int age, @NotBlank @Pattern(regexp = "[a-z]+[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+\\.*[a-zA-Z0-9]*)", message = "email không đúng định dạng") String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
