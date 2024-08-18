package com.next.bakery.security.service.implementation;

import com.next.bakery.security.entity.User;
import com.next.bakery.security.repository.UserRepository;
import com.next.bakery.security.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        User example = new User();
        example.setUsername(username);
        example.setPassword(password);
        example.setStatus(1);

        Example<User> query = Example.of(example, matcher);
        var result = userRepository.findOne(query);

        return result.isPresent() ? result.get().getName() : "authentication failed";
    }
}
