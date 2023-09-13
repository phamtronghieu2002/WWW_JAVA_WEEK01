package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories;

import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db.ConnectDB;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleRepositories {

    Connection con;


    public  RoleRepositories()
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


}
