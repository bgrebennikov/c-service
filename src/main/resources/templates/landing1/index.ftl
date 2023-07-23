<!DOCTYPE html>
<html lang="ru"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="apple-touch-icon" sizes="180x180" href="/static/landing1/assets/images/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/static/landing1/assets/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/static/landing1/assets/favicon-16x16.png">
    <link rel="mask-icon" href="/static/assets/images/favicon/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">
    <link rel="stylesheet" href="/static/landing1/assets/css/fonts.css" as="font" onload="this.rel=&#39;stylesheet&#39; ">
    <link rel="stylesheet" href="/static/landing1/assets/css/style.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.8/jquery.inputmask.min.js" integrity="sha512-efAcjYoYT0sXxQRtxGY37CKYmqsFVOIwMApaEbrxJr4RwqVVGw8o+Lfh/+59TU07+suZn1BWq4fDl5fdgyCNkw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <title>Ремонт компьютеров от 330 руб.</title>
</head>

<body id="home" cz-shortcut-listen="true">
<div class="wrapper">

    <header class="bg header" style="background-image: url(/static/landing1/assets/images/header-bg.webp)">
        <div class="header__top-wrapper header__top-wrapper_fixed">
            <div class="container">
                <div class="header__top">
                    <a href="#home" class="scroll logo header__logo">
                        <img src="/static/landing1/assets/images/logo.png" alt="logo">
                    </a>
                    <div class="header__right">
                        <div class="header__call">
                            <a href="tel:+79955775045" onclick="ym(93882118,&#39;reachGoal&#39;,&#39;a-tel&#39;); ahref(); return true;" class="header__call-icon">
                                <svg class="phone"><use xlink:href="/static/landing1/assets/sprite.svg#phone"></use></svg>
                            </a>
                            <div class="header__call-right">
                                <a href="tel:+79955775045" onclick="ym(93882118,&#39;reachGoal&#39;,&#39;a-tel&#39;); ahref(); return true;" class="header__tel">8 (995) 577-50-45</a>
                                <div class="header__call-text">Звоните круглосуточно</div>
                            </div>
                        </div>
                        <button class="button header__button" data-modal="popup-call">Заказать звонок</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <h1 class="header__title">Ремонт компьютеров от 330₽ с выездом мастера</h1>
            <div class="header__main">
                <div class="header__col">
                    <div class="header__subtitle">Наши цены до 2 раз ниже, чем в сервисных центрах, т.к. все услуги оказываем на выезде. Чиним с душой!</div>
                    <ul class="header__list">
                        <li>Выезжаем и проводим диагностику <strong>бесплатно</strong></li>
                        <li>Выписываем гарантию сроком <strong>до 3-х лет</strong></li>
                        <li>Выезжаем во <strong>все районы</strong> города и область</li>
                        <li>Чиним ПК и ноутбуки <strong>с 2011 года</strong></li>
                        <li>Согласовываем цену <strong>перед началом</strong> ремонта</li>
                    </ul>
                    <div class="form header__form">
                        <div class="header__subtitle">Дарим скидку 15% до конца дня</div>
                        <form class="submit-form" data-name="Забронировать скидку" id="fm-Form" name="fm-Form" action="/ремонт" method="post">
                            <input type="hidden" name="campaign" value="">
                            <input type="hidden" name="discount" value="15%">
                            <div class="input-wrapper">
                                <span><input type="tel" data-name="Phone" name="Phone" placeholder="Телефон" required="required"></span>
                                <input type="hidden" data-name="gorod" maxlength="100" name="gorod" value="">
                                <input type="submit" class="submit button" data-wait="Please wait..." value="Забронировать скидку">
                            </div>
                        </form>
                        <div class="success form-done popup popup-thank" id="popup-thank">
                            <div class="popup__dialog" role="document">Спасибо! Ваша заявка успешно отправлена. Мы свяжемся с вами в ближайшее время.</div>
                        </div>
                        <div class="form-fail">
                            <div>Ошибка отправки! Попробуйте еще раз.</div>
                        </div>
                        <div class="form__small">Заполняя форму, Вы соглашаетесь на обработку персональных данных</div>
                    </div>
                </div>
                <img src="/static/landing1/assets/images/header-img.png" alt="img" class="header__img">
            </div>
        </div>
    </header>

    <main class="main">
        <section id="breakage" class="breakage section">
            <form class="submit-form" data-name="Узнать стоимость" id="fm-Form2" name="fm-Form2" action="/ремонт" method="post">
                <div class="container">
                    <h2 class="breakage__title title">Узнайте стоимость ремонта за пару минут!</h2>
                    <div class="breakage__subtitle">
                        Для этого выберите свой вариант поломки из списка
                    </div>
                    <div class="breakage-wrapper">
                        <div class="breakage__item" data-id="0">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Не включается">
                                <div class="breakage__item-title">Не включается</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="1">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Не видит USB">
                                <div class="breakage__item-title">Не видит USB</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="2">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Включается и перезагружается">
                                <div class="breakage__item-title">Включается и перезагружается</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="3">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Включается и выключается">
                                <div class="breakage__item-title">Включается и выключается</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="4">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Разбита матрица">
                                <div class="breakage__item-title">Разбита матрица</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="5">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Тормозит">
                                <div class="breakage__item-title">Тормозит</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="6">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Перегревается">
                                <div class="breakage__item-title">Перегревается</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="7">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Не запускается ОС">
                                <div class="breakage__item-title">Не запускается ОС</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="8">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Синий или черный экран">
                                <div class="breakage__item-title">Синий или черный экран</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="9">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Удалили важные данные">
                                <div class="breakage__item-title">Удалили важные данные</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="10">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Установка ОС Windows">
                                <div class="breakage__item-title">Установка ОС Windows</div>
                            </label>
                        </div>
                        <div class="breakage__item" data-id="11">
                            <label>
                                <input class="radioknopka" name="polomka" type="radio" value="Прочие неисправности">
                                <div class="breakage__item-title">Прочие неисправности</div>
                            </label>
                        </div>
                    </div>
                    <div class="form breakage__form">
                        <div class="input-wrapper">
                            <input type="hidden" name="campaign" value="">
                            <span><input type="tel" data-name="Phone" name="Phone" placeholder="Телефон" required="required"></span>
                            <input type="hidden" data-name="gorod" maxlength="100" name="gorod" value="">
                            <input type="submit" class="submit button" data-wait="Please wait..." value="Узнать стоимость">
                        </div>
                        <div class="form__small">Оставляя свой номер телефона, Вы соглашаетесь на обработку персональных данных</div>
                    </div>
                </div>
            </form>
            <div class="success form-done popup popup-thank" id="popup-thank">
                <div class="popup__dialog" role="document">Спасибо! Ваша заявка успешно отправлена. Мы свяжемся с вами в ближайшее время.</div>
            </div>
            <div class="form-fail">
                <div>Ошибка отправки! Попробуйте еще раз.</div>
            </div>
        </section>

        <section id="features" class="features section-bg" style="background-image: url(/static/landing1/assets/images/features-bg.webp)">
            <div class="container">
                <h2 class="features__title title">Почему стоит обратиться <u>к нам</u>?</h2>
                <div class="features-wrapper">
                    <div class="features__item features__item_plus">
                        <div class="features__item-title">
                            <span>Мы</span>
                            <svg class="check">
                                <use xlink:href="/static/landing1/assets/sprite.svg#check"></use>
                            </svg>
                        </div>
                        <ul class="features__item-list">
                            <li>Оглашаем стоимость устранения поломки перед началом ремонта</li>
                            <li>Приступаем к ремонту только после выполнения диагностики, согласования перечня работ и стоимости с клиентом</li>
                            <li>Комплектующие покупаем у поставщиков напрямую, поэтому Вы получаете их по закупочной цене</li>
                            <li>Любую <strong>поломку</strong> устраняем <strong>максимально быстро</strong> без различных доплат и затягивания сроков</li>
                        </ul>
                    </div>
                    <div class="features__item features__item_minus">
                        <div class="features__item-title">
                            <span>Конкуренты</span>
                            <svg class="close">
                                <use xlink:href="/static/landing1/assets/sprite.svg#close"></use>
                            </svg>
                        </div>
                        <ul class="features__item-list">
                            <li>Привлекают клиентов низкими ценами от 100 рублей</li>
                            <li>Начинают ремонт без согласования стоимости с клиентом, оглашая её по факту выполнения</li>
                            <li>К цене всех комплектующих для проведения ремонта включают свою накрутку</li>
                            <li><strong>Затягивают ремонт на недели</strong>, исключая возможность вернуть технику назад</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>

        <section id="price" class="price section">
            <div class="container">
                <h2 class="price__title title">Цены на наши услуги</h2>
                <div class="price-wrapper">
                    <div class="price__item">
                        <div class="price__item-title">Выезд к клиенту</div>
                        <div class="line"></div>
                        <div class="price__item-right">Бесплатно</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Замена блока питания</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 190 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Диагностика поломки</div>
                        <div class="line"></div>
                        <div class="price__item-right">Бесплатно</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка жёсткого диска</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 190 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Настройка ОС</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 340 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка драйвера</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 170 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Чистка ПК</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 450 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Чистка ноутбука</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 450 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка утилит</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 150 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Замена матрицы ноутбука</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 580 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка программ</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 300 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка Windows</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 450 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Настройка интернета</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 430 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Чистка от залития</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 1780 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Установка антивируса</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 320 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Замена кулера ноутбука</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 580 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Удаление вирусов</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 270 руб.</div>
                    </div>
                    <div class="price__item">
                        <div class="price__item-title">Настройка Wi-Fi роутера</div>
                        <div class="line"></div>
                        <div class="price__item-right">от 440 руб.</div>
                    </div>
                </div>
            </div>
        </section>

        <section id="offer" class="bg offer section" style="background-image: url(/static/landing1/assets/images/offer-bg.webp)">
            <div class="container">
                <div class="offer-wrapper">
                    <h2 class="offer__title title">Хотите, чтобы Ваша техника заработала уже через пару часов после приезда мастера?</h2>

                    <div class="offer__call">Просто позвоните нам!</div>
                    <a href="tel:+79955775045" class="offer__tel">
                        <svg class="phone">
                            <use xlink:href="/static/landing1/assets/sprite.svg#phone"></use>
                        </svg>
                        <span>8 (995) 577-50-45</span>
                    </a>
                    <div class="form offer__form">
                        <div class="form__text">Или оставьте свой номер</div>
                        <form class="submit-form" data-name="Проконсультироваться 2" id="fm-Form3" name="fm-Form3" action="/ремонт" method="post">
                            <input type="hidden" name="campaign" value="">
                            <div class="input-wrapper">
                                <span><input type="tel" data-name="Phone" name="Phone" placeholder="Телефон" required="required"></span>
                                <input type="hidden" data-name="gorod" maxlength="100" name="gorod" value="">
                                <input type="submit" class="submit button" data-wait="Please wait..." value="Проконсультироваться">
                            </div>
                        </form>
                        <div class="success form-done popup popup-thank" id="popup-thank">
                            <div class="popup__dialog" role="document">Спасибо! Ваша заявка успешно отправлена. Мы свяжемся с вами в ближайшее время.</div>
                        </div>
                        <div class="form-fail">
                            <div>Ошибка отправки! Попробуйте еще раз.</div>
                        </div>
                        <div class="form__small">Заполняя форму, Вы соглашаетесь на обработку персональных данных</div>
                    </div>
                </div>
            </div>
        </section>

    </main>

    <footer class="footer">
        <div class="container">
            <div class="footer__top">
                <a href="#home" class="scroll logo footer__logo">
                    <img src="/static/landing1/assets/images/logo.png" alt="logo">
                </a>
                <a href="tel:+79955775045"  class="footer__tel">
                    <svg class="phone">
                        <use xlink:href="/static/landing1/assets/sprite.svg#phone"></use>
                    </svg>
                    <span>8 (995) 577-50-45</span>
                </a>

                <button class="button footer__button" data-modal="popup-call">Заказать звонок</button>
            </div>
            <div class="footer__bottom">Информация, размещенная на сайте, не является публичной офертой<br><span>Sebrem Agency Limited, HE 376576, k-master-komputerov@yandex.ru</span></div>
        </div>
    </footer>
</div>
<div class="popup popup-call" id="popup-call">
    <div class="popup__dialog">
        <div class="popup__content">
            <div class="popup__close close">
                <svg class="close">
                    <use xlink:href="/static/landing1/assets/sprite.svg#close"></use>
                </svg>
            </div>
            <div class="popup__title">Заказать звонок</div>
            <div class="popup__form">
                <form class="submit-form" data-name="Заказ звонка" id="fm-Form4" name="fm-Form4" action="/ремонт" method="post">
						<span style="display: none;">
							<input type="hidden" class="modal-info" name="modal-info">
						</span>
                    <input type="hidden" name="campaign" value="">
                    <div class="input-wrapper">
                        <span><input type="tel" data-name="Phone" name="Phone" placeholder="Телефон" required="required"></span>
                        <input type="hidden" data-name="gorod" maxlength="100" name="gorod" value="">
                        <input type="submit" class="submit button" data-wait="Please wait..." value="Отправить">
                    </div>
                </form>
                <div class="success form-done popup popup-thank" id="popup-thank">
                    <div class="popup__dialog" role="document">Спасибо! Ваша заявка успешно отправлена. Мы свяжемся с вами в ближайшее время.</div>
                </div>
                <div class="form-fail">
                    <div>Ошибка отправки! Попробуйте еще раз.</div>
                </div>
                <small>Заполняя форму, Вы соглашаетесь на обработку персональных данных</small>
            </div>
        </div>
    </div>
</div>
<script src="/static/landing1/assets/js/script.js"></script>
<script>
    var telInput = $('input[type="tel"]'); telInput.inputmask("+7(999)999-99-99");
</script>
<script>var cityID = 63;</script>
<script type="text/javascript" src="/static/landing1/assets/mail.js"></script>
<!-- Yandex.Metrika counter -->

<!-- /Yandex.Metrika counter -->

</body></html>