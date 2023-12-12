package com.example.bankingapplicationspringboot.utilities;

import java.time.Year;

public class AccountUtils
{

    public static final String ACCOUNT_EXITS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already exits";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account successfully created";


    public static String generateAccountNumber()
    {
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        //Generate a random number between min and max

        int randNumber = (int)Math.floor(Math.random() * (max - min + 1 ) + min);

        //Convert current year and random number to dtrings, then do concatination

        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();

        return accountNumber.append(year).append(randomNumber).toString();

    }


}
