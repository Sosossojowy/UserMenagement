package com.boizband.users.service;

import com.boizband.persistent.entity.UserEntity;
import com.boizband.users.User;
import org.springframework.beans.BeanUtils;

public class UsersConverter {
    public static UserEntity toPersistent(final User user) {
        final UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        return userEntity;
    }

    public static User toModel (final UserEntity user){
        final User userModel=new User();
        BeanUtils.copyProperties(user,userModel);
        return userModel;
    }
}
