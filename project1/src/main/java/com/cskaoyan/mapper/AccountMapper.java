package com.cskaoyan.mapper;

import com.cskaoyan.bean.Account;
import com.cskaoyan.bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountMapper {
    public int insertAccount(@Param("account") Account account);
    public Account getAccountById(@Param("id") int id);
    public Integer login(@Param("account") Account account);
    int usernameExist(@Param("username") String username);

    void leaveMessage(@Param("message") String message, @Param("username") String username);

    Message[] checkMessage();
}
