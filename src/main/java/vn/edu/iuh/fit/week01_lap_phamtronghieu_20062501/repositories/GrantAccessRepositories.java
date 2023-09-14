package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories;

import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db.ConnectDB;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.GrantAccess;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GrantAccessRepositories {

    Connection con;


    public GrantAccessRepositories()
    {
        con= ConnectDB.getInstance().getConnection();
    }

    public Role getRoleByUid (String uid)
    {Role role= null;

        try {
            String sql = "SELECT r.role_id,r.role_name,r.description,r.`status` from grant_access  g INNER JOIN role r ON r.role_id=g.role_id WHERE g.account_id=?  ";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, uid);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
             String roleid=rs.getString(1);
             String accountId=rs.getString(2);
             boolean is_grant= rs.getBoolean(3);
             String note="";

               role = new Role(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;



    }


}
