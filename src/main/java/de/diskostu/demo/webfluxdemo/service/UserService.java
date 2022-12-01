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


    public Mono<User> addUser(final User user) {
        return userRepository.save(user);
    }


    public Mono<User> updateUser(final User userWithNewData) {
        return userRepository
                .findById(userWithNewData.getId())
                .switchIfEmpty(Mono.error(new Exception("user with id %d not found".formatted(userWithNewData.getId()))))
                .map(existingUser -> {
                    existingUser.setName(userWithNewData.getName());
                    existingUser.setSurname(userWithNewData.getSurname());
                    existingUser.setUsername(userWithNewData.getUsername());
                    existingUser.setEmail(userWithNewData.getEmail());
                    existingUser.setPassport(userWithNewData.getPassport());
                    return existingUser;
                })
                .flatMap(userRepository::save);
    }


    public Mono<Void> deleteUser(final long id) {
        return userRepository.deleteById(id)
                             .switchIfEmpty(Mono.error(new Exception("user with id %d not found".formatted(id))));
    }
}
