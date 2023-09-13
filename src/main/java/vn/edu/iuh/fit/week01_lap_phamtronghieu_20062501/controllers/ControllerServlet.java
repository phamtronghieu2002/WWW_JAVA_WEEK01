package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account;
import vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.repositories.AccountRepositories;

import java.io.IOException;

@WebServlet(urlPatterns = {"/ControllerServlet"})
public class ControllerServlet  extends HttpServlet {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username=req.getParameter("username");
             String password=req.getParameter("password");

        AccountRepositories AccRepo = new AccountRepositories();
        Account acc = AccRepo.checkLogin(username,password);
                if(acc ==null)
                {
                        resp.getWriter().println("wrong password or username !!");
                }else {
                    resp.getWriter().println(acc.toString());

                }
            
    }
}
