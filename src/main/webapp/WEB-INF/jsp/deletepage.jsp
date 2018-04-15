<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Сторінка видалення</title>
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


<body id="page-top">

<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger"> ВИДАЛЕННЯ</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/">НА ГОЛОВНУ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/createmenu">СТВОРИТИ МЕНЮ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/adminpagemenu">ПЕРЕГЛЯНУТИ МЕНЮ</a>
                </li>

                <li class="nav-item">
                    <div>
                        <form action="./logout" method="get">
                            <button type="submit" class="btn btn-default" name="Logout" value="Logout">Logout</button>
                        </form>
                    </div>
                </li>


            </ul>
        </div>
    </div>
</nav>


<section id="about" class="content-section text-center">

    <div class="container">
        <div class="col-lg-8 mx-auto">
            <div>${requestScope.userdelete} ${requestScope.menudelete}</div>


            <form action="${requestScope.controller}" method="get">
                <div class="form-group">

                    <div class="col-lg-8 mx-auto">
                        <form>
                            <button type="submit" class="btn btn-default" name="deleteuserlogin"
                                    value="${requestScope.deleteuserlogin}${requestScope.deletemenuname}${requestScope.deletemenubydate.date}${requestScope.deletemenubydate.name}">
                                DELETE
                            </button>
                        </form>
                    </div>
                </div>
            </form>

        </div>


    </div>
</section>
</body>
</html>

</html>