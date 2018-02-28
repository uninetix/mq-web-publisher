$(document).ready(function () {


        $("#btnSend").click(function () {

            $.ajax({
                url: "api/sendForm",
                //dataType: "json",
                type: "POST",
                data: {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    city: $("#city").val(),
                    birthDate: $("#birthDateVal").val()
                }
            }).done(function () {

            })


            // $("#registrationForm").validate({
            //     rules: {
            //         firstName: {
            //             required: true,
            //         },
            //         lastName: {
            //             required: true,
            //         },
            //         city: {
            //             required: true,
            //         },
            //         birthDateVal: {
            //             required: true,
            //         }
            //     },
            //     highlight: function (element) {
            //         $(element).closest('.center-block').addClass('has-error');
            //     },
            //     unhighlight: function (element) {
            //         $(element).closest('.center-block').removeClass('has-error');
            //     },
            //     errorPlacement: function (error, element) {
            //
            //     },
            //     submitHandler: function (form) {
            //        alert("validate");
            //     }
            // });

        });

    }
);