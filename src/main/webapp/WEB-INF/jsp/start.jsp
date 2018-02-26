<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Test wysyłania do kolejki MQ</title>
    <script type="text/javascript" src="js/start.js"></script>
</head>
<body>
<div class="well well-sm">
    <div class="page-header">
        <h2>Wypełnij formularz
            <small></small>
        </h2>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <form id="registrationForm">
                <div class="row top-buffer">
                    <div class="col-lg-3 center-block text-center">
                        <label class="control-label small" for="firstName">Imię</label>
                        <input id="firstName" name ="firstName" type="text" class="form-control input-sm" aria-label="..."/>
                    </div>
                    <div class="col-lg-3 center-block text-center">
                        <label class="control-label small" for="lastName">Nazwisko</label>
                        <input id="lastName" name ="lastName" type="text" class="form-control input-sm" aria-label="..."/>
                    </div>
                    <div class="col-lg-3 center-block text-center">
                        <label class="control-label small" for="city">Miasto</label>
                        <input id="city" name="city" type="text" class="form-control input-sm" aria-label="..."/>
                    </div>
                    <div id="dateCloseFromBlock" class="col-lg-3 center-block text-center">
                        <label class="control-label small" for="birthDate">Data urodzenia</label>
                        <div id="birthDate" class="input-group date">
                            <input id="birthDateVal" name="birthDateVal" type="text"
                                   class="form-control input-sm text-left"/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                        </div>
                        <script type="text/javascript">
                            $(function () {
                                $('#birthDate').datetimepicker({
                                    language: 'pl',
                                    autoclose: true,
                                    pickerPosition: 'bottom-left',
                                    todayBtn: true,
                                    startView: 2,
                                    minView: 2,
                                    format: "yyyy-mm-dd"
                                });
                            });
                        </script>
                    </div>
                </div>
                <br>
                <div class="row top-buffer">
                    <div class="col-lg-12 center-block text-left">
                        <label class="control-label small" for="btnSend"></label>
                        <button id="btnSend" type="button" class="form-control btn btn-primary">Wyślij</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>