

const params = new Proxy(new URLSearchParams(window.location.search), {
    get: (searchParams, prop) => searchParams.get(prop),
});

const campaign = params.utm_campaign;

$(window).on("load", function () {


    let forms_selector = $("form");

    let forms = forms_selector.context.forms;

    for (var i = 0; i < forms.length; i++) {
        $(forms[i]).on("t-submit", function (e) {

            $(`#${e.target.id} :input`).each(function () {
                console.log(this.name)
                console.log($(this).val())

                let samara_datetime_utc = new Date().toGMTString("ru-RU", { timeZone: "Europe/Samara" });

                if (this.name === "Phone") {
                    sendForm({
                        Phone: $(this).val(),
                        clientId: clientId,
                        utm_campaign: campaign,
                        timeUnix: Math.floor(new Date(samara_datetime_utc) / 1000)
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