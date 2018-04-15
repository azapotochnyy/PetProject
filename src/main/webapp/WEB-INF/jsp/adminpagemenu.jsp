<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Список меню</title>
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
        <a class="navbar-brand js-scroll-trigger">СПИСОК МЕНЮ</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/showinfo">СПИСОК КЛІЄНТІВ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/createmenu">СТВОРИТИ МЕНЮ</a>
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
                        <form action="./adminpage" method="get">
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
        <div class="form-group">

            <div class="col-sm-10 mx-auto">
                ${requestScope.menubydatedelete}
                ${requestScope.menudelete}
                ${requestScope.error}

            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 mx-auto">


                <table class="table">
                    <thead class="thead-green">
                    <tr>
                        <th scope="col">НАЗВА</th>
                        <th scope="col">ПОКАЗАТИ</th>
                        <th scope="col">ВИДАЛИТИ</th>



                    </tr>
                    </thead>
                    <c:forEach var="menu" items="${requestScope.menulist}">

                        <tr>
                            <td><c:out value="${menu.name}"/></td>

                            <td>
                                <form action="/alldatebymenu" method="get">
                                    <div class="form-group">

                                        <div class="col-sm-10">
                                            <button type="submit" class="btn btn-default" name="showdate"
                                                    value="<c:out value="${menu.name}"/>">ShowDate
                                            </button>

                                        </div>
                                    </div>
                                </form>


                            </td>

                            <td>
                                <form action="/forwardtodeletemenupage" method="get">
                                    <div class="form-group">

                                        <div class="col-sm-10">
                                            <button type="submit" class="btn btn-default" name="deletemenuname"
                                                    value="<c:out value="${menu.name}"/>">Delete
                                            </button>

                                        </div>
                                    </div>
                                </form>

                            </td>

                        </tr>

                    </c:forEach>

                </table>




            </div>
        </div>
    </div>
</section>





</body>


</html>