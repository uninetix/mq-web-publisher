<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Test wysyłania do kolejki MQ</title>
    <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.css"
          type="text/css" rel="stylesheet">
    <link href="webjars/bootstrap-datetimepicker/2.3.5/ss/bootstrap-datetimepicker.min.css" media="all"/>
    <link href="css/js-grid/jsgrid.min.css" type="text/css" rel="stylesheet">
    <link href="css/js-grid/jsgrid-theme.min.css" type="text/css" rel="stylesheet">


    <script type="text/javascript" src="webjars/jquery/3.2.0/jquery.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.js"></script>
    <script type="text/javascript"
            src="webjars/bootstrap-datetimepicker/2.3.5/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-validation/1.15.0/jquery.validate.js"></script>
    <script type="text/javascript" src="js/js-grid/jsgrid.min.js"></script>

    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }

        .dropdown-submenu {
            position: relative;
        }

        .dropdown-submenu > .dropdown-menu {
            top: 0;
            left: 100%;
            margin-top: -6px;
            margin-left: -1px;
            -webkit-border-radius: 0 6px 6px 6px;
            -moz-border-radius: 0 6px 6px 6px;
            border-radius: 0 6px 6px 6px;
        }

        .dropdown-submenu > a:after {
            display: block;
            content: " ";
            float: right;
            width: 0;
            height: 0;
            border-color: transparent;
            border-style: solid;
            border-width: 5px 0 5px 5px;
            border-left-color: #cccccc;
            margin-top: 5px;
            margin-right: -10px;
        }

        .dropdown-submenu:hover > a:after {
            border-left-color: #ffffff;
        }

        .dropdown-submenu.pull-left {
            float: none;
        }

        .dropdown-submenu.pull-left > .dropdown-menu {
            left: -100%;
            margin-left: 10px;
            -webkit-border-radius: 6px 0 6px 6px;
            -moz-border-radius: 6px 0 6px 6px;
            border-radius: 6px 0 6px 6px;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><img alt="Brand" height="30" src="/img/Orange.gif"></a>
        </div>
        <div class="navbar-collapse collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li class="nav-link"><a href="/">Strona startowa</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Kolejki MQ<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/send">Wysyłanie komunikatów</a></li>
                        <li><a href="/recive">Odbiór komunikatów</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>