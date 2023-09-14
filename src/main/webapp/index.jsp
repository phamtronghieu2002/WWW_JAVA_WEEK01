<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<style>
    *
    {
        box-sizing: border-box;
    }
    body
    {

        margin: 0;
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .wrapper
    {
        width: 500px;

        width: 500px;
        padding: 20px;
        border: 1px solid rgb(128, 128, 128);

    }

</style>
  <div class="wrapper">
      <form action="ControllerServlet" method="post">
          <div class="mb-3">
              <label  class="form-label">User name</label>
              <input name="username" class="form-control" aria-describedby="emailHelp">
              <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
          </div>
          <div class="mb-3">
              <label  class="form-label">Password</label>
              <input name="password"  type="password" class="form-control">
          </div>

          <button   name="action" value="login" type="submit" class="btn btn-primary">Submit</button>
      </form>
  </div>
</body>
</html>