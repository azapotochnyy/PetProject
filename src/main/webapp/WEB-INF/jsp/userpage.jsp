<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Сторінка Користувача</title>

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
        <a class="navbar-brand js-scroll-trigger">СТОРІНКА КОРИСТУВАЧА</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


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

        <div class="row">
            <div class="col-lg-8 mx-auto">

                <form action="./showmenu" method="get">

                    <div class="form-group">

                        <div class="col-sm-10">

                            <p><select size="3" class="form-control" multiple name="date">

                                <option disabled>Выберіть дату</option>

                                <c:forEach var="menu" items="${requestScope.date}">

                                    <option value="<c:out value="${menu.date}"/>"><c:out value="${menu.date}"/></option>

                                </c:forEach>
                            </select></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="DateButton" value="Date">Date
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
