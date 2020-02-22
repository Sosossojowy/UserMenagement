package com.boizband.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ListUsersManagerTest {

    private ListUsersManager listUsersManager;

    public ListUsersManagerTest() {
    }

    @Before
    public void setUp() {
        listUsersManager = new ListUsersManager();
    }

    @Test
    public void shouldAddUser() {
        //given
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(0);
        //when
        listUsersManager.add(new User("1", 18, "firstname", "lastname", "phone number"));
        //then
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(1);

    }

    @Test
    public void shouldDeleteUser() {
        listUsersManager.add(new User("1", 18, "firstname", "lastname", "phone number"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(1);
        //when
        listUsersManager.delete("1");
        //then
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(0);
    }


    @Test
    public void shouldUpdateUserFirstName() {
        //given
        User user = new User("1", 18, "firstname", "lastname", "phonenumber");
        listUsersManager.add(user);
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(1);
        //when
        user.setFirstName("newName");
        listUsersManager.update(user);
        //then
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(1);
        User updatedUser = listUsersManager.search("").get(0);
        Assertions.assertThat(updatedUser.getFirstName()).isEqualTo("newName");
    }

    @Test
    public void shouldSearchByFirstName() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("Karol");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getFirstName()).isEqualTo("Karol");
    }

    @Test
    public void shouldSearchByPartOfFirstName() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("aro");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getFirstName()).isEqualTo("Karol");
    }

    @Test
    public void shouldSearchByLastName() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("Strasburger");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getLastName()).isEqualTo("Strasburger");
    }

    @Test
    public void shouldSearchByPartOfLastName() {
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("rasburg");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getLastName()).isEqualTo("Strasburger");
    }

    @Test
    public void shouldSearchByPhoneNumber() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("799887665");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getPhoneNumber()).isEqualTo("799887665");
    }

    @Test
    public void shouldSearchByPartOfPhoneNumber() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("98876");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getPhoneNumber()).isEqualTo("799887665");
    }

    @Test
    public void shouldSearchByAge() {
        //given
        listUsersManager.add(new User("1", 25, "Karol", "Strasburger", "799887665"));
        listUsersManager.add(new User("2", 35, "Paulina", "Kuc", "666888999"));
        Assertions.assertThat(listUsersManager.search("").size()).isEqualTo(2);
        //when
        List<User> result = listUsersManager.search("25");
        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(1);
        User userFromResult = result.get(0);
        Assertions.assertThat(userFromResult.getAge()).isEqualTo(25);
    }
}
