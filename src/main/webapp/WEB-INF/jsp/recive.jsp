<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Test odbierania z kolejki MQ</title>
    <script type="text/javascript" src="js/recive.js"></script>
    <style>
        #jsGridReceivePanel {
            display: none;
        }
    </style>
</head>
<body>
<div class="page-header">
    <h2>Odbieranie komunikatów
        <small></small>
    </h2>
</div>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-3 center-block text-left">
                <label class="control-label small" for="btnReceive"></label>
                <button id="btnReceive" type="button" class="btn btn-primary">Pobierz komunikat z kolejki
                </button>
            </div>
        </div>
    </div>
</div>
<div class="panel panel-default" id="jsGridReceivePanel">
    <div class="panel-body">
        <div class="row top-buffer">
            <div id="jsGridReceive"></div>
        </div>
    </div>
</div>
</body>
</html>