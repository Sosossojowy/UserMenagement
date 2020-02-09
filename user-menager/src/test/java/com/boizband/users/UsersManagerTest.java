package com.boizband.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UsersManagerTest {

    private UsersManager usersManager;

    public UsersManagerTest() {
    }

    @Before
    public void setUp() {
        usersManager = new UsersManager();
    }

    @Test
    public void shouldAddUser() {
        //given
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(0);
        //when
        usersManager.add(new User(1, 18, "firstname", "lastname", "phone number"));
        //then
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(1);

    }

    @Test
    public void shouldDeleteUser() {
        usersManager.add(new User(1, 18, "firstname", "lastname", "phone number"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(1);
        //when
        usersManager.delete(1);
        //then
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(0);
    }


    @Test
    public void shouldUpdateUserFirstName() {
        //given
        User user = new User(1, 18, "firstname", "lastname", "phonenumber");
        usersManager.add(user);
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(1);
        //when
        user.setFirstName("newName");
        usersManager.update(user);
        //then
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(1);
        User updatedUser = usersManager.search("").get(0);
        Assertions.assertThat(updatedUser.getFirstName()).isEqualTo("newName");
    }

    @Test
    public void shouldSearchByFirstName() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("Karol");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getFirstName()).isEqualTo("Karol");
    }

    @Test
    public void shouldSearchByPartOfFirstName() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("aro");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getFirstName()).isEqualTo("Karol");
    }

    @Test
    public void shouldSearchByLastName() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("Strasburger");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getLastName()).isEqualTo("Strasburger");
    }

    @Test
    public void shouldSearchByPartOfLastName() {
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("rasburg");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getLastName()).isEqualTo("Strasburger");
    }

    @Test
    public void shouldSearchByPhoneNumber() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("799887665");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getPhoneNumber()).isEqualTo("799887665");
    }

    @Test
    public void shouldSearchByPartOfPhoneNumber() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("98876");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getPhoneNumber()).isEqualTo("799887665");
    }

    @Test
    public void shouldSearchByAge() {
        //given
        usersManager.add(new User(1, 25, "Karol", "Strasburger", "799887665"));
        usersManager.add(new User(2, 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(usersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = usersManager.search("25");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getAge()).isEqualTo(25);
    }
}
