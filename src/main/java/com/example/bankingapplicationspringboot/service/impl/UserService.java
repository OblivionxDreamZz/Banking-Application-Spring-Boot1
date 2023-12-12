package com.example.bankingapplicationspringboot.service.impl;

import com.example.bankingapplicationspringboot.dto.BankResponse;
import com.example.bankingapplicationspringboot.dto.UserRequest;
import lombok.Builder;
import lombok.Data;


public interface UserService
{
    BankResponse createAccount(UserRequest userRequest);


}
