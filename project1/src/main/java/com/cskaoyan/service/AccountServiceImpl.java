package com.cskaoyan.service;

import com.cskaoyan.bean.Account;
import com.cskaoyan.bean.Message;
import com.cskaoyan.exception.ParameterException;
import com.cskaoyan.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountMapper accountMapper;
    @Override
    public int register(Account account) throws Exception {
        //首先查看用户名是否存在
        int num=accountMapper.usernameExist(account.getUsername());
        if (num>0){
            throw new ParameterException("用户名已经存在",account.getUsername());
        }
        int i = accountMapper.insertAccount(account);
        return i;
    }
    @Override
    public boolean login(Account account) {
        Integer login = accountMapper.login(account);
        if (login==null){
            return false;
        }
        return true;
    }

    @Override
    public Account showInfo(Integer id) {
        Account account = accountMapper.getAccountById(id);
        return account;
    }

    @Override
    public void leaveMessage(String message, Account account) {
        accountMapper.leaveMessage(message,account.getUsername());
    }

    @Override
    public Message[] checkMessage() {
        return accountMapper.checkMessage();
    }
}
