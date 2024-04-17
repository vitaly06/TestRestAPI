package com.simpleRestApi.demo.DAO;

import com.simpleRestApi.demo.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonDAO(){
        jdbcTemplate = null;
    }

    public int addUser(Person person){
        return jdbcTemplate.update("INSERT INTO users(name, surname, age) VALUES(?, ?, ?)", person.getName(), person.getSurname(), person.getAge());
    }

    public List<Person> getUsers(){
        return jdbcTemplate.query("SELECT * FROM users", new PersonMapper());
    }
}
