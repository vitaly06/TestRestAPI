package com.simpleRestApi.demo.Controllers;
import com.simpleRestApi.demo.DAO.PersonDAO;
import com.simpleRestApi.demo.Models.Person;
import com.simpleRestApi.demo.utill.PersonNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class MainController {

    @Autowired
    PersonDAO personDAO;
    @GetMapping("/getUsers")
    public List<Person> hello(){
        return personDAO.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public Person getUser(@PathVariable("id") int id){
        return personDAO.getUser(id);
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Person person,
                                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){
                errorMessage.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotCreatedException(errorMessage.toString());
        }
        personDAO.addUser(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /*@ExceptionHandler
    private ResponseEntity<PersonNotCreatedException> handlerException(PersonNotCreatedException e){

    }*/
}
