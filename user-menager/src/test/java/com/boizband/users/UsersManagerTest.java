package com.boizband.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class UsersManagerTest {

    private UsersManager usersManager;

    public UsersManagerTest(){
    }

    @Before
    public void setUp(){
        usersManager = new UsersManager();
    }
    @Test
    public void shouldAddUser(){
        //given
        Assertions.assertThat(usersManager.search("").length).isEqualTo(0);
        //when
        usersManager.add(new User(1, 18, "firstname", "lastname", "phone number"));
        //then
        Assertions.assertThat(usersManager.search("").length).isEqualTo(1);

    }
    @Test
    public void shouldDeleteUser(){
        usersManager.add(new User(1, 18, "firstname", "lastname", "phone number"));
        Assertions.assertThat(usersManager.search("").length).isEqualTo(1);
        //when
        usersManager.delete(1);
        //then
        Assertions.assertThat(usersManager.search("").length).isEqualTo(0);
    }
    @Test
    public void shouldUpdateUserFirstName(){
        //given
        User user = new User(1, 18, "firstname", "lastname", "phonenumber");
        usersManager.add(user);
        Assertions.assertThat(usersManager.search("").length).isEqualTo(1);
        //when
        user.setFirstName("newName");
        usersManager.update(user);
        //then
        Assertions.assertThat(usersManager.search("").length).isEqualTo(1);
        User updatedUser = usersManager.search("")[0];
        Assertions.assertThat(updatedUser.getFirstName()).isEqualTo("newName");
    }
}