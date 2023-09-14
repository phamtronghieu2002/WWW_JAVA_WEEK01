package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.GrantAccess;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Role;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories.AccountRepositories;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories.GrantAccessRepositories;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories.RoleRepositories;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/ControllerServlet"})
public class ControllerServlet  extends HttpServlet {


  private  AccountRepositories AccRepo = new AccountRepositories();
  private RoleRepositories RollRepo= new RoleRepositories();
  private GrantAccessRepositories GrantRepo=  new GrantAccessRepositories();
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

     private  void setHeaderContent(HttpServletRequest req,Account acc ,String nameRole)
     {
         req.setAttribute("user",acc);
         req.setAttribute("rolename",nameRole);
     }

    private void CRUD(HttpServletRequest req,HttpServletResponse resp,String action) throws IOException, ServletException {
        HttpSession session=req.getSession(false);
        if(session!=null){

            String roleName =(String)session.getAttribute("roleName");
            Account acc = (Account)session.getAttribute("userLogin");





            switch (action) {
                case "Create":

                    setHeaderContent(req,acc,roleName);

                    req.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(req, resp);

                    break;
                case  "Delete":

                    break;

                case "Update":

                    break;
                default:

            }



        }
        else {
            resp.getWriter().println("please login !!!");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getParameter("action");



        if(action.equalsIgnoreCase("login"))
           {
               String username=req.getParameter("username");
               String password=req.getParameter("password");
               Account acc = AccRepo.checkLogin(username,password);

               if(acc ==null)
               {
                   resp.getWriter().println("wrong password or username !!");
               }else {


                   String uid= acc.getAccountId();
                   Role role = GrantRepo.getRoleByUid(uid);



                    if(role!=null)
                    {



                         String nameRole= role.getRoleName();
                         //store session
                        HttpSession session=req.getSession();
                        session.setAttribute("userLogin",acc);
                        session.setAttribute("roleName",nameRole);
                        //store table log

                        //
                        setHeaderContent(req,acc,nameRole);


                        req.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(req, resp);
                         if(nameRole.equalsIgnoreCase("administrator"))
                         {


                             ArrayList<Account> accounts= AccRepo.getUsers();
                             req.setAttribute("users",accounts);
                             req.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(req, resp);
                         }
                         else {

                             req.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(req, resp);
                         }


                    }
                    else {
                        resp.getWriter().println("can not access !! !");
                    }

               }
           }else if(action.equalsIgnoreCase("addUser"))
           {
               CRUD(req,resp,"Create");
           }
           else if(action.equalsIgnoreCase("removeUser"))
           {
               CRUD(req,resp,"Delete");
           }
           else if(action.equalsIgnoreCase("EditUser"))
           {
               CRUD(req,resp,"Update");
           }

            
    }
}
