package com.boizband.users;

import java.util.List;

public interface UsersManager {

    void add(User user);

    void delete(String userId);

    void update(User userForUpdate);

    List<User> search(final String pattern);

    User searchById(final String userId);
}
