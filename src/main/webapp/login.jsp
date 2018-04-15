<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <title>Login Page</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet"
          type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Cabin:700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="/static/css/grayscale.min.css" rel="stylesheet">

</head>
<body>

<body id="page-top">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger">СТОРІНКА ВХОДУ</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="./">НА ГОЛОВНУ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="./registration">РЕЄСТРАЦІЯ</a>
                </li>


            </ul>
        </div>
    </div>
</nav>


<section id="about" class="content-section text-center">
    <div class="container">

        <div class="row">
            <div class="col-lg-8 mx-auto">


                <form class="form-horizontal" action="./login" method="post">

                    <div class="form-group">

                        <div class="col-sm-10">
                            ${requestScope.error}

                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="userlogin" placeholder="Login" name="userlogin">
                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="userpassword" placeholder="Password"
                                   name="userpassword">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="loginButton" value="Login">Login
                            </button>
                        </div>
                    </div>
                </form>


            </div>
        </div>
    </div>
</section>


</body>
</html>
