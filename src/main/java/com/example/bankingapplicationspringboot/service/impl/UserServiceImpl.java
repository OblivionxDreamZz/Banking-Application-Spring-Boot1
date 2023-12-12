package com.example.bankingapplicationspringboot.service.impl;

import com.example.bankingapplicationspringboot.dto.AccountInfo;
import com.example.bankingapplicationspringboot.dto.BankResponse;
import com.example.bankingapplicationspringboot.dto.UserRequest;
import com.example.bankingapplicationspringboot.repository.UserRepository;
import com.example.bankingapplicationspringboot.utilities.AccountUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest)
    {
        //Create an account and saving new user into the database
        //Check if user already has an account

        if(userRepository.existsByEmail(userRequest.getEmail()))
        {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXITS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User newUser = new User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativeNumber())
                .status("ACTIVE")
                .build();

        User savedUser = userRepository.save(newUser);
        return  BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_EXITS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance)
                        .accountNumber(savedUser.getAccountNumber)
                        .accountName(savedUser.getFirstName() + "" + getLastName + " " + getOtherName())
                        .build())
                .build();

    }
}
