package com.nnk.springboot;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void userTest() {
        User user = new User();
        user.setUsername("testUsername");
        user.setFullname("test");
        user.setRole("ADMIN");
        user.setPassword("123");

        // Save
        user = userRepository.save(user);
        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getUsername().equals("testUsername"));

        // Update
        user.setUsername("testUsername Update");
        user = userRepository.save(user);
        Assert.assertTrue(user.getUsername().equals("testUsername Update"));

        // Find
        List<User> listResult = userRepository.findAll();
        Assert.assertTrue(listResult.size() > 0);

        // Delete
        Integer id = user.getId();
        userRepository.delete(user);
        Optional<User> userList = userRepository.findById(id);
        Assert.assertFalse(userList.isPresent());
    }
}
