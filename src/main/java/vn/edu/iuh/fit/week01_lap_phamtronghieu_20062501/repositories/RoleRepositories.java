package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories;

import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db.ConnectDB;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleRepositories {

    Connection con;


    public  RoleRepositories()
    {
        con= ConnectDB.getInstance().getConnection();
    }




}
