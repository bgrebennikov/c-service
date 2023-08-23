$(window).on("load", function () {

    let forms_selector = $("form");

    let forms = forms_selector.context.forms;

    for (var i = 0; i < forms.length; i++) {
        $(forms[i]).on("submit", function (e) {

            $(`#${e.target.id} :input`).each(function () {
                console.log(this.name)
                console.log($(this).val())

                if (this.name === "Phone") {
                    sendForm({
                        "phone": $(this).val()
                    })
                }

            })

            e.preventDefault()
        })
    }

    function sendForm(form_data) {

        $.ajax(
            {
                url: `${window.location.origin}/sendForm`,
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(form_data),
                type: "POST",
                success: function (response) {
                    console.log(response.data)
                },
                error: function (err) {
                    console.log(err);
                }
            }
        )
    }


})