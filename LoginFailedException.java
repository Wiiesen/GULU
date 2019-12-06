package com.itranswarp.learnjava;

import java.util.Scanner;
import java.util.stream.BaseStream;

public interface LoginFailedException {
    public static <UserNotFoundException> void main(String[] args) throws UserNotFoundException {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入：");

        int num1 = scanner.nextInt();
        if (num1 < 1) {
            throw new UserNotFoundException("自定义");
        }
    }
}
