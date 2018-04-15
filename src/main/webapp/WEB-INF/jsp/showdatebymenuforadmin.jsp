<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Переглянути меню на дату</title>
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
        <a class="navbar-brand js-scroll-trigger">ПЕРЕГЛЯНУТИ МЕНЮ НА ДАТУ</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/showinfo">СПИСОК КЛІЄНТІВ</a>
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


        <div class="row">
            <div class="col-lg-8 mx-auto">

                <form action="./allmenubydate" method="get">
                    <div class="col-lg-8 mx-auto">
                        Меню:  ${requestScope.name}

                    </div>
                    <p><select size="3" multiple name="date">
                        <option disabled>Выберите дату</option>

                        <c:forEach var="menu" items="${requestScope.date}">

                            <option value="<c:out value="${menu.date}"/>"><c:out value="${menu.date}"/></option>

                        </c:forEach>

                    </select></p>

                    <button type="submit" class="btn btn-default" name="menuname"
                            value="${requestScope.name}">Confirm
                    </button>

                </form>

            </div>
        </div>

    </div>
</section>


</body>
</html>
