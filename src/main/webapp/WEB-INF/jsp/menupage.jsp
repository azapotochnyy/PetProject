<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Створення меню</title>
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
        <a class="navbar-brand js-scroll-trigger">СТВОРЕННЯ МЕНЮ</a>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">


                <li class="nav-item">
                    <a class="nav-link js-scroll-trigger" href="/showinfo">СПИСОК КЛІЄНТІВ</a>
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

        <div class="row">
            <div class="col-lg-8 mx-auto">

                <form class="form-horizontal" action="/savemenu" method="get">
                    <div class="form-group">

                        <div class="col-sm-10">
                            ${requestScope.error}

                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="menuname" placeholder="Назва меню" name="name">
                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="breakfast" placeholder="Сніданок"
                                   name="breakfast">
                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lunchone" placeholder="Перекус перший"
                                   name="lunchone">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="dinner" placeholder="Обід" name="dinner">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lunchtwo" placeholder="Перекус другий"
                                   name="lunchtwo">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="supper" placeholder="Вечеря" name="supper">
                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="lunchthree" placeholder="Перекус третій"
                                   name="lunchthree">
                        </div>
                    </div>


                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="date" placeholder="Дата" name="date">
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" name="saveMenu" value="Save">SAVE</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</section>
</body>
</html>