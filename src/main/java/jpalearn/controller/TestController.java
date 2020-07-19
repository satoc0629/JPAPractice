package jpalearn.controller;

import jpalearn.entity.User;
import jpalearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll() {
        List<User> hierarchie = userRepository.findAll();

        return hierarchie;
    }

    @GetMapping("/find2Hierarchie")
    public List<User> find2Hierarchie() {
        List<User> hierarchie = userRepository.find2Hierarchie();

        return hierarchie;
    }
}
