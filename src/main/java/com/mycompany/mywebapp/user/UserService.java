package com.mycompany.mywebapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws Exception {
        Optional result = repo.findById(id);
        System.out.println(result);
        if (result.isPresent()) {
            User user = (User) result.get();
            return user;
        }
        throw new Exception("Could not find user with ID " + id);
    }

    public void delete(Integer id) throws Exception {
        if (id == null || id <= 0 || repo.findById(id).isEmpty()) {
            throw new Exception("Could not find user with ID " + id);
        }
        repo.deleteById(id);
    }
}