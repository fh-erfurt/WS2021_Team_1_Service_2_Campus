package de.fherfurt.storage.repository;

import de.fherfurt.dataStorage.User;

import java.util.List;

public interface UsersRepository {

    List<User> getAllUsers();

    User getUser(Long userId);
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Long userId);
}
