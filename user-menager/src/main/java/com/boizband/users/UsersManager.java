package com.boizband.users;

import com.boizband.users.errors.UserNotFoundException;

import java.util.List;

public interface UsersManager {

    User add(User user);

    void delete(String userId);

    User update(User userForUpdate) throws UserNotFoundException;

    List<User> search(final String pattern);

    User searchById(final String userId);
}
