package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db;

import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories.AccountRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {






        String username="Tran Trhi Met";
        String password="123";

        AccountRepositories AccRepo = new AccountRepositories();
        Account acc = AccRepo.checkLogin(username,password);
        if(acc ==null)
        {
           System.out.println("wrong password or username !!");
        }else {
            System.out.println(acc.toString());



    }
}}
