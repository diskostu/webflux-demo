package de.diskostu.demo.webfluxdemo.service;

import de.diskostu.demo.webfluxdemo.model.User;
import de.diskostu.demo.webfluxdemo.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Mono<User> getUserById(final long id) {
        return userRepository.findById(id);
    }


    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void addUser(final User user) {
        userRepository.save(user).subscribe();
    }
}
