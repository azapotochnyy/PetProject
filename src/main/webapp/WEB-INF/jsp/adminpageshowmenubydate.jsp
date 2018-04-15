<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Список клієнтів</title>
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
        <a class="navbar-brand js-scroll-trigger"> МЕНЮ ${requestScope.name}</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


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

                <li class="nav-item">
                    <div>
                        <form action="./adminpagemenu" method="get">
                            <button type="submit" class="btn btn-default" name="Logout" value="Back">Back</button>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>


<section id="about" class="content-section text-center">
    <div class="container">



        <table class="table">
            <thead class="thead-green">
            <tr>
                <th scope="col">МЕНЮ</th>
                <th scope="col">СНІДАНОК</th>
                <th scope="col">ПЕРЕКУС ПЕРШИЙ</th>
                <th scope="col">ОБІД</th>
                <th scope="col">ПЕРЕКУС ДРУГИЙ</th>
                <th scope="col">ВЕЧЕРЯ</th>
                <th scope="col">ПЕРЕКУС ТРЕТІЙ</th>
                <th scope="col">ДАТА</th>
            </tr>
            </thead>


            <tr>

                <th>${requestScope.name}</th>
                <th>${requestScope.breakfast}</th>
                <th> ${requestScope.lunchOne}</th>
                <th>${requestScope.dinner}</th>
                <th>${requestScope.lunchTwo}</th>
                <th>${requestScope.supper}</th>
                <th>${requestScope.lunchThree}</th>
                <th>${requestScope.date}</th>


            </tr>


        </table>

        <div class="col-lg-8 mx-auto">
            <form action="/forwardtodeletemenupagebydate" method="get">
                <div class="form-group">

                    <button type="submit" class="btn btn-default" name="namedate"
                            value="${requestScope.name},${requestScope.date}">DELETE
                    </button>

                </div>
            </form>

        </div>
    </div>

</section>


</body>




</html>