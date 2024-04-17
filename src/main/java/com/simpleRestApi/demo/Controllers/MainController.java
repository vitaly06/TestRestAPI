package com.simpleRestApi.demo.Controllers;
import com.simpleRestApi.demo.DAO.PersonDAO;
import com.simpleRestApi.demo.Models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    PersonDAO personDAO;
    @ResponseBody
    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<Person> hello(){
        return personDAO.getUsers();
    }


}
