package com.cskaoyan.service;

import com.cskaoyan.bean.Account;
import com.cskaoyan.bean.Message;
import com.cskaoyan.exception.ParameterException;

public interface AccountService {
    public int register(Account account) throws ParameterException, Exception;
    public boolean login(Account account);
    public Account showInfo(Integer id);

    void leaveMessage(String message, Account account);

    Message[] checkMessage();
}
