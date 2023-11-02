window.isset = function (v) {
    if (typeof (v) == 'object' && v == 'undefined') {
        return false;
    } else if (arguments.length === 0) {
        return false;
    } else {
        var buff = arguments[0];
        for (var i = 0; i < arguments.length; i++) {
            if (typeof (buff) === 'undefined' || buff === null) return false;
            buff = buff[arguments[i + 1]];
        }
    }
    return true;
}

/*Отправка форм.*/

function feedback(vars) {
    var bt = $(vars.form).find('.feedback');
    var p = new URLSearchParams(vars.data)

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'POST',
        url: '/coolers-sendForm',
        cache: false,
        dataType: 'json',
        // data: 'act=' + vars.act + '&' + vars.data,
        data : JSON.stringify(
            {
                phone: p.get('phone').replace(/\D/g, ''),
                name: p.get('name'),
                text: p.get('text'),
                tag: p.get('tag'),
                city: p.get('city'),
                form_name: p.get('what')
            }
        ),
        beforeSend: function() {
            $(bt).prop("disabled", true);
            $(bt).addClass('loading');
        },
        success: function(answer) {

            $(bt).prop("disabled", false);
            $(bt).removeClass('loading');

            if(isset(answer.ok) && answer.ok === 1) {
                $(vars.form)[0].reset();
                $.each(answer.infos, function(k,val) {
                    $.fancybox.open([{ href : '#responseMessage', padding : 0 }] );
                    $.arcticmodal('close');
                    $('#responseMessage .modal-content').removeClass('error').html(val);
                });

                ym(94751823,'reachGoal','rem_tv')

            }else{
                $.each(answer.errors, function(k,val) {
                    $.jGrowl(val, {theme: 'error', header: 'Ошибка!', life: 3000 });
                    $('#responseMessage .modal-content').addClass('error').html(val);
                });
            }
            $('#responseMessage .fancyClose').click(function(){
                $.fancybox.close('#responseMessage');
                return false;
            });
        }
    });

}




/**
 * Обработчик кнопки форм.
 * Кнопка должна быть внутри тегов <form> c классом .feedback
 * будет отправлено любое кол-во полей, кроме файлов
 *
 */

$(document).on('click', '.feedback', function(){
    var form = $(this).closest('form'), name = form.attr('name'), obj = {};
    obj.form = form;
    obj.act = name;
    obj.data = $(form).serialize();

    feedback(obj);

    return false;
});