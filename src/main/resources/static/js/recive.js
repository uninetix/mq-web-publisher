$(document).ready(function () {

    var messages = [];
    var intervalID;

    $("#btnStopReceiving").attr("disabled", true);
    showJsGridReceive();

    $("#btnReceive").click(function () {
        getMessage();
    });

    $("#btnStartReceiving").click(function () {
        $("#btnStartReceiving").attr("disabled", true);
        $("#btnStopReceiving").attr("disabled", false);
        var interval;
        if ($("#interval").val() == null) interwal = 1
        else interval = $("#interval").val();
        intervalID = setInterval(function () {
            getMessage();
        }, interval * 1000);
    });

    $("#btnStopReceiving").click(function () {
        clearInterval(intervalID);
        $("#btnStartReceiving").attr("disabled", false);
        $("#btnStopReceiving").attr("disabled", true);
    });

    function getMessage() {
        var d = $.Deferred();
        $.ajax({
            url: "api/receiveData",
            dataType: "json",
            type: "POST",
            async: false,
            data: {}
        }).done(function (response) {
            d.resolve(response);
            if (response[0] !== null)
                messages.unshift(response[0]);
            showJsGridReceive();
        }).fail(function () {
            clearInterval(intervalID);
        });
    }

    function showJsGridReceive() {

        $("#jsGridReceive").jsGrid({
            height: 600,
            width: "100%",
            sorting: true,
            paging: true,
            autoload: true,
            editing: false,
            inserting: false,
            loadMessage: "Proszę, czekać...",
            noDataContent: "Brak danych",
            pagerFormat: "Strony: {first} {prev} {pages} {next} {last}    {pageIndex} z {pageCount}",
            pagePrevText: "Poprzednia",
            pageNextText: "Następna",
            pageFirstText: "Pierwsza",
            pageLastText: "Ostatnia",
            onItemEditing: function (args) {

            },
            invalidNotify: function (args) {
            },
            data: messages,
            deleteConfirm:
                "Czy jesteś pewny że chcesz skasować dane?",
            fields:
                [
                    {name: "firstName", title: "Imię", type: "text", align: "left", validate: "required"},
                    {name: "lastName", title: "Nazwisko", type: "text", align: "left", validate: "required"},
                    {name: "city", title: "Miasto", type: "text", align: "left", validate: "required"},
                    {name: "birthDate", title: "Data urodzenia", type: "text", align: "left", validate: "required"}
                ]
        });

        $("#jsGridReceivePanel").css("display", "block");
    }

});