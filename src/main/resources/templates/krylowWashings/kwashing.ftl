<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="theme-color" content="#121213" />
    <title>My Website</title>
    <link rel="stylesheet" href="/static/kwashing/css/style.css">
    <link rel="icon" href="./favicon.ico" type="image/x-icon">
</head>
<body>

<header class="header" id="header">
    <nav class="navbar container">
        <img src="/static/kwashing/img/logo.svg" alt="Ремонт стиральных машин в Самаре" class="brand">

        <div class="burger" id="burger">
            <span class="burger-line"></span>
            <span class="burger-line"></span>
            <span class="burger-line"></span>
        </div>
        <div class="menu" id="menu">
            <ul class="menu-inner">
                <li class="menu-item"><a href="#" class="menu-link">Home</a></li>
                <li class="menu-item"><a href="#" class="menu-link">Feature</a></li>
                <li class="menu-item"><a href="#" class="menu-link">Product</a></li>
                <li class="menu-item"><a href="#" class="menu-link">Support</a></li>
            </ul>
        </div>
        <a href="tel:+79874363073" class="menu-block">+7 (987) 436-30-73</a>
    </nav>
</header>
<div class="header__margins"></div>

<main>
    <h1 class="main__title">Ремонт<br>стиральных машин <br><span style="color: #00d7ff;">в Самаре</span></h1>

    <div class="min__price__wrapper">
        <div class="min__price">
            <h3>От 500 Рублей</h3>
            <div class="min__price__outline"></div>
        </div>
    </div>

    <div class="special__offer">
        <img src="/static/kwashing/img/washing.png" alt="Выезд мастера и диагностика бесплатно" class="offer__img">


        <div class="offer__content">
            <p class="offer__title">
                Выезд мастера и диагностика
                <span style="color: #FAFF07;">Бесплатно</span>
            </p>

            <div class="circle__left"></div>
            <div class="circle__right"></div>
        </div>

    </div>

    <h3 class="main__subtitle">
        Получите бесплатную консультацию и расчет стоимости ремонта со скидкой до 20%
    </h3>

    <form class="calculate__price__form" action="/sendForm">
        <label for="phone_number_input">Оставьте свой номер телефона, мастер перезвонит и проконсультирует Вас по стоимости ремонта</label><input type="number" name="phone_number" id="phone_number_input" placeholder="Номер телефона">

        <button class="send_form_btn" type="button">Расчитать стоимость ремонта</button>
    </form>

</main>

<section class="prices__section">

    <h2 class="section__title">
        Цены на услуги ремонта стиральных машин
    </h2>

    <div class="prices__list__wrapper">

        <ul class="prices__list">

            <li class="prices__list__item">
                <div class="price__item__image price__image_easy"></div>
                <p class="price__item__title">
                    Малый ремонт стиральной машины
                </p>
                <p class="item__service__cost">
                    От 890 Рублей
                </p>
                <ul class="prices__list__description">
                    <li class="prices__list__description__item">
                        замена кнопки
                    </li>
                    <li class="prices__list__description__item">
                        замена ручки люка
                    </li>
                    <li class="prices__list__description__item">
                        замена петли дверцы

                    </li>
                    <li class="prices__list__description__item">
                        замена стекла люка

                    </li>
                    <li class="prices__list__description__item">
                        замена сетевого фильтра

                    </li>
                    <li class="prices__list__description__item">
                        замена сливного шланга

                    </li>
                    <li class="prices__list__description__item">
                        чистка сливного фильтра
                    </li>
                    <li class="prices__list__description__item">
                        замена приводного ремня
                    </li>

                </ul>
                <div class="garant__content">
                    <div class="garant__icon">
                        <img src="/static/kwashing/img/icons/shield.svg" alt="Гарантия 3 года на все работы">
                    </div>
                    <div class="garant__divider"></div>
                    <div class="garant__body">
                        <h1>3 Года</h1>
                        <p>Гарантия на все работы</p>
                    </div>
                </div>
                <button class="call__master__btn">Вызвать мастера</button>
            </li>

            <li class="prices__list__item">
                <div class="price__item__image price__image_medium"></div>
                <p class="price__item__title">
                    Средний ремонт стиральной машины
                </p>
                <p class="item__service__cost">
                    От 1600 Рублей
                </p>
                <ul class="prices__list__description">
                    <li class="prices__list__description__item">
                        замена ТЭНа
                    </li>
                    <li class="prices__list__description__item">
                        замена сливного насоса
                    </li>
                    <li class="prices__list__description__item">
                        замена блокировки люка
                    </li>
                    <li class="prices__list__description__item">
                        замена щёток двигателя
                    </li>
                    <li class="prices__list__description__item">
                        ремонт или замена мотора
                    </li>
                    <li class="prices__list__description__item">
                        замена прессостата
                    </li>
                    <li class="prices__list__description__item">
                        замена заливного клапана
                    </li>
                    <li class="prices__list__description__item">
                        ремонт платы управления
                    </li>

                </ul>
                <div class="garant__content">
                    <div class="garant__icon">
                        <img src="/static/kwashing/img/icons/shield.svg" alt="Гарантия 3 года на все работы">
                    </div>
                    <div class="garant__divider"></div>
                    <div class="garant__body">
                        <h1>3 Года</h1>
                        <p>Гарантия на все работы</p>
                    </div>
                </div>
                <button class="call__master__btn">Вызвать мастера</button>
            </li>

            <li class="prices__list__item">
                <div class="price__item__image price__image_hard"></div>
                <p class="price__item__title">
                    Сложный ремонт стиральной машины
                </p>
                <p class="item__service__cost">
                    От 2980 Рублей
                </p>
                <ul class="prices__list__description">
                    <li class="prices__list__description__item">
                        замена подшипника
                    </li>
                    <li class="prices__list__description__item">
                        замена крестовины
                    </li>
                    <li class="prices__list__description__item">
                        замена бака
                    </li>
                    <li class="prices__list__description__item">
                        замена барабана
                    </li>
                    <li class="prices__list__description__item">
                        замена опоры бака
                    </li>
                    <li class="prices__list__description__item">
                        замена шторок барабана
                    </li>
                    <li class="prices__list__description__item">
                        замена нижнего противовеса
                    </li>

                </ul>
                <div class="garant__content">
                    <div class="garant__icon">
                        <img src="/static/kwashing/img/icons/shield.svg" alt="Гарантия 3 года на все работы">
                    </div>
                    <div class="garant__divider"></div>
                    <div class="garant__body">
                        <h1>3 Года</h1>
                        <p>Гарантия на все работы</p>
                    </div>
                </div>
                <button class="call__master__btn">Вызвать мастера</button>
            </li>

        </ul>

    </div>

</section>


</body>
</html>