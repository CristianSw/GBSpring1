package lesson2.services;

import lesson2.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {
    private User currentUser;

    @PostConstruct
    public void init(){
        this.currentUser = new User("Bob");
    }
    public User getCurrentUser(){
        return currentUser;
    }
}
