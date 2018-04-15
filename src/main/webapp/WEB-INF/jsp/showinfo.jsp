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
        <a class="navbar-brand js-scroll-trigger">СПИСОК КЛІЄНТІВ</a>

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
                ${requestScope.userdelete}

            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 mx-auto">

                <table class="table">
                    <thead class="thead-green">
                    <tr>
                        <th scope="col">ІМ'Я</th>
                        <th scope="col">ФАМІЛІЯ</th>
                        <th scope="col">ТЕЛЕФОН</th>
                        <th scope="col">EMAIL</th>
                        <th scope="col">ЛОГІН</th>
                        <th scope="col">МЕНЮ</th>
                        <th scope="col">НАЗНАЧИТИ МЕНЮ</th>
                        <th scope="col">ВИДАЛИТИ КЛІЄНТА</th>
                    </tr>
                    </thead>

                    <c:forEach var="user" items="${requestScope.userdto}">

                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.telephone}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.login}"/></td>
                            <td><c:out value="${user.menu}"/></td>

                            <td>
                                <form class="form-horizontal" action="/insertmenu" method="get">
                                    <div class="form-group">
                                        <div class="col-sm-10">
                                            <p><select size="3" multiple name="menuname" class="form-control">

                                                <option disabled>Выберите меню</option>

                                                <c:forEach var="menu" items="${requestScope.menudto}">

                                                    <option value="<c:out value="${menu.name}"/>"><c:out value="${menu.name}"/></option>

                                                </c:forEach>

                                            </select></p>
                                            <button type="submit" class="btn btn-default" name="login"
                                                    value="<c:out value="${user.login}"/>">Insert/Change
                                            </button>
                                        </div>
                                    </div>
                                </form>


                            </td>


                            <td>

                                <form class="form-horizontal" action="/forwardtodeleteuserpage" method="get">
                                    <div class="form-group">

                                        <button type="submit" class="btn btn-default" name="deleteuserlogin"
                                                value="<c:out value="${user.login}"/>">DELETE
                                        </button>

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