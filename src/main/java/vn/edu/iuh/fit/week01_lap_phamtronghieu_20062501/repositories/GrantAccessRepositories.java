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

               role = new Role(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;



    }
    public boolean addGrantAccess(Account account,Role role) {

        try {
            String sql = "insert into grant_access (role_id,account_id,is_grant,note) values (?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,role.getRoleId());
            stm.setString(2,account.getAccountId());
            stm.setInt(3,1);
            stm.setString(4,"");
            if (stm.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}
