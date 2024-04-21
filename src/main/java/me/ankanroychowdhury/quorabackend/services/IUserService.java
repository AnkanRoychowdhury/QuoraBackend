package me.ankanroychowdhury.quorabackend.services;

import me.ankanroychowdhury.quorabackend.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IUserService {
    public Optional<User> getUserById(Long id);
    public User registerUser(User user) throws Exception;
    public User updateUserDetails(Long userId, User user)throws Exception;
}
