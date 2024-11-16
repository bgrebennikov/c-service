var selector = 'form';
$(selector).each(function (indx) {
    if ($(this).attr('action') === undefined) {
        $(this).attr('action', '/ремонт/').attr('method', 'post');
    }
});
$(function () {

    $('input[name^="Phone"]').on('paste',function(e){
        e.preventDefault();
        var pastedData = e.originalEvent.clipboardData.getData('text');
        pastedData = pastedData.replace(/[^0-9]/g, '');
        if (pastedData.length > 9) {
            $(this).val(pastedData.slice(-10));
        }
        console.log(pastedData);
    });

    $(selector + '[action = "/ремонт"]').submit(function (e) {
        hide = 0;
        delay = 3000;
        success_msg = "Спасибо! Мы перезвоним Вам в ближайшее время!";
        error_msg = "Ошибка отправки! Попробуйте еще раз.";
        wait_msg = 'Идет отправка...';
        redirect = '/thx?redirectUrl=/ремонт';
        action = '/ремонт';
        cur_id = '#' + $(this).attr('id');
        if ($(cur_id).attr('data-hide') !== undefined) {
            hide = parseInt($(cur_id).attr('data-hide'));
        }
        if ($(cur_id).attr('data-delay') !== undefined) {
            delay = parseInt($(cur_id).attr('data-delay'));
        }
        cur_success = $(cur_id).siblings('.form-done').text().trim();
        if (cur_success !== 'Thank you! Your submission has been received!') {
            success_msg = cur_success;
        }
        cur_error = $(cur_id).siblings('.form-fail').text().trim();
        if (cur_error !== 'Oops! Something went wrong while submitting the form') {
            error_msg = cur_error;
        }
        cur_wait = $(cur_id).find('[data-wait]').attr('data-wait');
        if (cur_wait !== 'Please wait...') {
            wait_msg = cur_wait;
        }
        cur_redirect = $(cur_id).attr('data-redirect');
        if (cur_redirect !== undefined) {
            redirect = cur_redirect;
        }
        cur_action = $(cur_id).attr('action');
        if (cur_action !== '/') {
            action = cur_action;
        }
        submit_div = $(cur_id).find('[type = submit]');
        submit_txt = submit_div.attr('value');
        if (wait_msg !== '') {
            submit_div.attr('value', wait_msg);
        }
        if ($(cur_id).attr('data-send') !== undefined) {
            $('<input type="hidden" name="sendto" value="' + $(cur_id).attr('data-send') + '">').prependTo(cur_id);
        }
        $('<input type="hidden" name="Форма" value="' + $(cur_id).attr('data-name') + '">').prependTo(cur_id);
        $('<input type="hidden" name="Страница" value="' + document.title + '">').prependTo(cur_id);
        $('<input type="hidden" name="required_fields">').prependTo(cur_id);
        required_fields = '';
        $(cur_id).find('[required=required]').each(function () {
            required_fields = required_fields + ',' + $(this).attr('name');
        });
        $(cur_id).find('[name=required_fields]').val(required_fields);
        e.preventDefault();
        var formData = new FormData($(cur_id)[0]);
        formData.append('title',document.title);
        formData.append('city_code',cityID);

        var phone = $(this).find('[id^="Phone"]').val();
        var vopros = $(this).find('[id="vopros"]').val();
        var discount = $(this).find('[name="discount"]').val();
		var campaign = $(this).find('[name="campaign"]').val();

        $.ajax({
            url: action,
            type: 'POST',
            processData: false,
            contentType: false,
            data: formData
        }).done(function (result) {
            console.log(result);
            if (result == 'success') {
                if (redirect !== '' && redirect !== '/-') {
                    document.location.href = redirect;
                    return (true);
                }
                $(cur_id).siblings('.form-fail').hide();
                replay_class = '.form-done';
                replay_msg = success_msg;
            } else {
                $(cur_id).siblings('.form-done').hide();
                if (result === 'ERROR_REQUIRED') {
                    replay_msg = 'Не заполнено обязательное поле!'
                } else {
                    replay_msg = error_msg;
                    console.log(result);
                }
                replay_class = '.form-fail';
            }
            replay_div = $(cur_id).siblings(replay_class);
            replay_div.find('div,p').text(replay_msg);
            replay_div.show();
            if (hide) {
                $(cur_id).hide();
            }
            submit_div.attr('value', submit_txt);
            if (delay !== 0) {
                replay_div.delay(delay).fadeOut();
            }
            if (result == 'success') {
                $(cur_id).trigger("reset");
            }
        });
    });
});

$('label[for^=file]').each(function () {
    file_id = $(this).attr('for');
    $(this).after('<input name="file[]" type="file" id="' + file_id + '" multiple style="display:none;">');
    $('input#' + file_id).change(function () {
        $(this).siblings('div[for]').text('Файл выбран.');
    });
});