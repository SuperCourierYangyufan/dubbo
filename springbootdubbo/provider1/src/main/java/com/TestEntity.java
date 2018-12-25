package com;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by YangYuFan on 2018/12/25.
 */
@Entity
@Table(name = "test", schema = "java", catalog = "")
public class TestEntity {
    private long uuid;
    private Integer age;
    private String password;
    private Double price;
    private Timestamp time;
    private String username;

    @Id
    @Column(name = "uuid", nullable = false)
    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 11)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 11)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return uuid == that.uuid &&
                Objects.equals(age, that.age) &&
                Objects.equals(password, that.password) &&
                Objects.equals(price, that.price) &&
                Objects.equals(time, that.time) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, age, password, price, time, username);
    }
}
