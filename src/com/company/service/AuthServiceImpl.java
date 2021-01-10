package com.company.service;

import com.company.util.Constants;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.util.Scanner;

public class AuthServiceImpl implements AuthService{
    @Override
    public void authentificate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        if(Constants.USERNAME.equals(username) && Constants.PASSWORD.equals(password)) {
            System.out.println("You are authenticated!");
        }else{
            System.out.println("Incorrect credentials!");
            authentificate();
        }
    }
}
