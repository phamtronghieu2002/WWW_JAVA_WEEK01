package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories;

import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db.ConnectDB;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountRepositories {

    Connection con;


    public  AccountRepositories()
    {
        con= ConnectDB.getInstance().getConnection();
    }

    public Account checkLogin(String username, String password)
    {
        Account acc= null;

        try {
            String sql = "select * from account  where  full_name=?  and password=? ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                acc=new Account(((ResultSet) rs).getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));



            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return acc;



    }

    public ArrayList<Account> getUsers()
    {
        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            String sql = "select * from account";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
             accounts.add(new Account(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }


    public boolean addAccount(Account acc) {

        try {
            String sql = "insert into account (account_id,full_name,password,email,phone,status) values (?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,acc.getAccountId());
            stm.setString(2,acc.getFullName());
            stm.setString(3,acc.getPassword());
            stm.setString(4,acc.getEmail());
            stm.setString(5,acc.getPhone());
            stm.setInt(6,acc.getStatus());

            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
