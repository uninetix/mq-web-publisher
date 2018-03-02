$(document).ready(function () {

    var messages = [{"firstName": "Jan", "lastName": "Kowalski", "city": "Wrocław", "birthDate": "2017-01-01"}];

    $("#btnReceive").click(function () {
        $("#jsGridReceivePanel").css("display", "none");

        var d = $.Deferred();
        $.ajax({
            url: "api/receiveData",
            //dataType: "json",
            type: "POST",
            data: {}
        }).done(function (response) {
            d.resolve(response);
        });

        messages.unshift(d.promise());
        showJsGridReceive();
    });

    function showJsGridReceive() {

        $("#jsGridReceive").jsGrid({
            height: "100%",
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
            data:  messages,
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