<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.models.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>dashboard</title>
</head>
<body>
<div id="wrapper">
    <header>
        <div class="container">
            <%
                Account acc = (Account) request.getAttribute("user");
                String roleName = (String) request.getAttribute("rolename");
                System.out.println("view 0:>>>" + acc);
                if (acc != null) {
            %>

            <h3>xin chao: <%=acc.getFullName()%>
            </h3>
            <ul>

            </ul>
            <li>username:<%=acc.getFullName()%>
            </li>
            <li>email:<%=acc.getEmail()%>
            </li>
            <li>phone:<%=acc.getPhone()%>
            </li>
            <li>role:<%=roleName%>
            </li>
            <%
                }
            %>

        </div>

    </header>
    <form action="ControllerServlet" method="post" id="content">
        <%

            ArrayList<Account> accounts = (ArrayList<Account>) request.getAttribute("users");
            System.out.println("view:>>>" + accounts);
            if (accounts != null) {

                System.out.println("aloaloalo");

        %>

        <div id="wrapper_add" class="mt-3 mb-3">

            <div class="container">
                <h2 class="text-center">Manage User</h2>
                <div class="row">

                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">id</label>
                            <input name="id" type="text" class="form-control"
                            >

                        </div>
                    </div>


                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">password</label>
                            <input name="password" type="password" class="form-control"
                            >

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">username</label>
                            <input name="username" type="text" class="form-control"
                            >

                        </div>
                    </div>


                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">phone</label>
                            <input name="phone" type="text" class="form-control"
                            >

                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">email</label>
                            <input name="email" type="email" class="form-control"
                            >

                        </div>

                    </div>

                    <div class="col-md-4">
                        <div class="mb-3">
                            <label class="form-label">status</label>
                            <input disabled="disabled" value="1" name="status" type="text" class="form-control"
                            >

                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4">
                        <div class="mb-3">
                            <select name="role" class="form-select" aria-label="Default select example">


                                <%
                                    ArrayList<Role> roles = (ArrayList<Role>) request.getAttribute("roles");

                                    if (roles != null && roles.size() > 0) {

                                        for (Role x :
                                                roles) {


                                %>
                                <option value=<%= x.getRoleId()%>><%= x.getRoleName() %>
                                </option>

                                <%
                                        }
                                    }
                                %>


                            </select>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <button type="submit" name="action" value="addUser" class="btn btn-primary">Submit</button>
                </div>
            </div>


            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">username</th>
                        <th scope="col">email</th>
                        <th scope="col">phone</th>
                        <th scope="col">status</th>
                        <th scope="col">actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%


                        for (Account x :
                                accounts) {
                    %>
                    <tr>
                        <th scope="row"><%=x.getAccountId()%>
                        </th>
                        <td><%=x.getFullName()%>
                        </td>
                        <td><%=x.getEmail()%>
                        </td>
                        <td><%=x.getPhone()%>
                        </td>
                        <td><%=x.getStatus()%>
                        </td>
                        <td style="display: flex;gap: 20px">
                            <div>
                                <input type="text" hidden="hidden" name="id_user" value=<%=x.getAccountId()%>>
                                <button class="btn btn-danger" name="action" value="removeUser">Remove</button>
                            </div>
                            <div>
                                <input type="text" hidden="hidden" name="id_user" value=<%=x.getAccountId()%>>
                                <button class="btn btn-primary" name="action" value="UpdateUser">update</button>
                            </div>
                        </td>
                    </tr>
                    <%
                        }

                    %>

                    </tbody>
                </table>
                    <%

} else {

%>

                    <%
    }
%>

    </form>
</div>


</div>
</body>
</html>