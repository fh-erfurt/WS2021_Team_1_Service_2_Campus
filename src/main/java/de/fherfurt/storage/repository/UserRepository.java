package de.fherfurt.storage.repository;

import de.fherfurt.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAllUsers();

    User getUser(long userId);
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long userId);
}
