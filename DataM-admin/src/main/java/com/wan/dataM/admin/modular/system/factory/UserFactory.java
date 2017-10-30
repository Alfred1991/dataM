package com.wan.dataM.admin.modular.system.factory;


import com.wan.dataM.admin.common.persistence.model.User;
import com.wan.dataM.admin.modular.system.transfer.UserDto;
import org.springframework.beans.BeanUtils;


public class UserFactory {

    public static User createUser(UserDto userDto){
        if(userDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            return user;
        }
    }
}
