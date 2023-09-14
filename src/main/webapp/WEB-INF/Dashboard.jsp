<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>dashboard</title>
</head>
<body>
           <div id="wrapper">
             <header>
                    <%
                        Account acc = (Account) request.getAttribute("user");
                        String roleName= (String) request.getAttribute("rolename");
                        if(acc !=null)
                        {
                        %>

                       <h3>xin chao: <%=acc.getFullName()%></h3>
                 <ul>

                 </ul>
                 <li>username:<%=acc.getFullName()%></li>
                 <li>email:<%=acc.getEmail()%></li>
                 <li>phone:<%=acc.getPhone()%></li>
                 <li>role:<%=roleName%></li>
                   <%
                       }
                    %>




             </header>
        <form id="content">
            <%

                ArrayList<Account> accounts = (ArrayList<Account>) request.getAttribute("users");
                System.out.println("view:>>>"+accounts);
                if(accounts !=null && accounts.size()>0)
                {

                    System.out.println("aloaloalo");
                    %>


            <table  class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">username</th>
                    <th scope="col">email</th>
                    <th scope="col">phone</th>
                    <th scope="col">status</th>
                </tr>
                </thead>
               <tbody>
               <%


                   for (Account x:
                           accounts) {
               %>
               <tr>
                   <th scope="row"><%=x.getAccountId()%></th>
                   <td><%=x.getFullName()%></td>
                   <td><%=x.getEmail()%></td>
                   <td><%=x.getPhone()%></td>
                   <td><%=x.getStatus()%></td>
               </tr>
               <%
                   }

               %>

               </tbody>
            </table>
            <%

            }
            else
            {

            %>

            <%
                }
            %>

        </form>



           </div>
</body>
</html>