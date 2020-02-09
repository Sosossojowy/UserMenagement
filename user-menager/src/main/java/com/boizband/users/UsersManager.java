package com.boizband.users;

import java.util.List;

public interface UsersManager {

    void add(User user);

    void delete(int userId);

    void update(User userForUpdate);

    List<User> search(final String pattern);

    User searchId(final int userId);
}
