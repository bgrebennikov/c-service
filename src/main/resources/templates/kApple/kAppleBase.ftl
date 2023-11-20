<#macro page title>

    <!DOCTYPE html>
    <html lang="ru" dir="ltr">
    <head>

        <meta name="robots" content="follow, index, max-snippet:-1, max-video-preview:-1, max-image-preview:large"/>
        <title>Ремонт техники - Apple</title>
        <script src="/psa/rrweb.min.js"></script>
        <script type="text/javascript">
            let events = [];
            rrweb.record({
                emit(event) {
                    events.push(event);
                },
            });

            function save() {
                const body = JSON.stringify({events});
                events = [];
                fetch('/_record_events', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body,
                });
            }

            setInterval(save, 2000);
        </script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" href="/_content/content/62fceb8dba8a8-1c0ecc74f5b449a49c9606df2f76e59f.svg"
              type="image/x-icon">

        <!-- Подлючаем стили CSS-->
        <link rel="stylesheet" href="/static/kApple/css/swiper/swiper-bundle.min.css">
        <link rel="stylesheet" href="/static/kApple/css/style.css">
        <link rel="stylesheet" href="/static/kApple/css/media.css">
        <link rel="stylesheet" id="et-googleFonts-css"
              href="https://fonts.googleapis.com/css2?family=Open+Sans%3Awght%40300%3B400%3B600%3B700%3B800&amp;display=swap&amp;ver=5.8.4"
              media="all">

        <style media="screen">
            .tags-of-item li,
            .offer-subtitle strong,
            .tel-header,
            .advantages-service li span,
            .confirm-label p,
            #site-footer a:hover,
            #menu-mainmenu a:hover,
            .breadcrumbs .container > span:last-child *,
            .simple-p a,
            .breadcrumbs *:hover,
            .contacts-item a,
            .adress-cont,
            .adress-cont-jur,
            .dr-btm:hover {
                color: #000000 !important;
            }

            .get-status,
            .id-01 .dr-btm,
            .dr-top a:hover,
            .search-form__input {
                border-color: #000000 !important;
                color: #000000 !important;
            }

            .fixies-heading {
                border-color: #000000 !important;
            }

            .get-pull,
            .get-order-btn,
            .co-wrapper span,
            form#discont input[type="submit"],
            .get-center,
            #custom-btn,
            .scroll-top,
            #searchsubmit,
            .label-warranty,
            .personal-lbl,
            .personal-label::before,
            div.team-thumb .swiper-slide.swiper-slide-active,
            .team-thumb div.swiper-slide:hover,
            #page-heading,
            .contacts-item button,
            .modal input[type="submit"],
            .more-models,
            .model-info {
                background-color: #000000 !important;
            }

            .pagesection-overlay,
            .fixies-heading,
            .fixies-table-wrap .more-repairs,
            .team-thumb .swiper-slide {
                background-color: #000000 !important;
                opacity: .75;
            }

            .get-table {
                border: 1px solid #000000;
                background: #000000;
            }

            .ajax-search {
                border: 1px solid #000000;
                border-radius: 20px
            }

            .price-cost i::after,
            .row-label::before {
                background: #000000;
            }

            .doc-dsgnblock {
                background: -webkit-linear-gradient(230deg, #000000 0%, #ffffff 100%);
            }

            .enginer-container {
                background: linear-gradient(45deg, #000000, #9e58f1), url(/wp-content/uploads/2021/08/cogs.svg);
            }

            .personal-label {
                filter: drop-shadow(0px 3px 4px #000000);
            }

            .label-warranty {
                box-shadow: 0 -21px 60px rgb(106 125 247 / 15%);
            }

            .permalnk.brandperma {
                color: white !important;
            }

            .svg path {
                fill: #000000 !important;
            }

            .menu-mob svg {
                stroke: #000000 !important;
            }

            .error-button {
                background-color: #000000
            }

            .error-title {
                border: 4px solid #000000;
                color: #000000;
            }

            .form-master-box [type="submit"] {
                background-color: #000000
            }
        </style>
    </head>

    <body class="home page-template-default page page-id-15 logged-in">

    <div id="page" class="site">


        <style media="screen">
            @media (max-width: 992px) {
                .info-div.id-03 {
                    display: none;
                }
            }

            .get-status.js-open-modal {
                display: none;
            }

            .header-bottom.stickyhead .get-status.js-open-modal {
                display: inherit;
            }
        </style>

    </div>

    <header id="main-header" class="site-header" itemscope="" itemtype="http://schema.org/WPHeader">

        <div class="header-top flex-container centered">
            <div class="container flex-container f-centered">
                <div id="logo-header">
                    <a class="custom-logo-link" href="#" rel="home" aria-current="page">
                        <img class="custom-logo lazyloaded" data-ll-status="loaded"
                             src="/static/kApple/img/logo.svg"
                             alt="Сервисный центр по ремонту Apple">
                    </a>
                </div>
                <div id="info-hdr-part" class="flex-container">
                    <div class="info-div id-01">
                        <div class="hdr-icon map-icn">
                            <img class="svg" src="/static/kApple/img/svg/pin.svg"/>
                        </div>
                        <div class="doublerow">
                            <div class="dr-top adress">
                                <span class="current_city">Самара</span>
                            </div>
                            <!-- <span class="dr-btm">выбрать другой город</span> -->
                        </div>
                    </div>
                    <div class="info-div id-02">
                        <div class="hdr-icon time-icn">
                            <img class="svg" src="/static/kApple/img/svg/clocks.svg"/>
                        </div>
                        <div class="doublerow">
                            <span class="dr-top time">Ежедневно с 8:00 до 22:00</span>
                            <!-- <span class="dr-btm">(пн-пт, без перерывов)</span> -->
                        </div>
                    </div>
                    <div class="info-div id-03">
                        <div class="hdr-icon phone-icn">
                            <img class="svg" src="/static/kApple/img/svg/telephones.svg"/>
                        </div>
                        <div class="doublerow">
                            <span class="dr-top"><a href="tel:+74993808302">+7 (499) 380-83-02</a></span>
                            <span class="dr-btm">(горячая линия центра)</span>
                        </div>
                    </div>
                    <button class="get-order-btn order-hover js-open-modal" data-modal="1">Оставить заявку</button>
                    <button class="menu-mob process-menu">
                        <svg viewBox="0 0 64 48">
                            <path d="M19,15 L45,15 C70,15 58,-2 49.0177126,7 L19,37"></path>
                            <path d="M19,24 L45,24 C61.2371586,24 57,49 41,33 L32,24"></path>
                            <path d="M45,33 L19,33 C-8,33 6,-2 22,14 L45,37"></path>
                        </svg>
                        <span>Меню</span>
                    </button>
                </div>
            </div>
        </div>
        <div class="header-bottom">
            <div class="container flex-container f-spb">
                <nav id="site-navigation" class="main-navigation" itemscope=""
                     itemtype="http://schema.org/SiteNavigationElement">
                    <div class="menu-mainmenu-container">
                        <ul id="menu-mainmenu" class="menu">
                            <li id="menu-item-192726"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-home menu-item-192726">
                                <a href="#">Главная</a>
                            </li>
                            <li id="menu-item-192761"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-192761">
                                <a href="/devices">Устройства</a>
                                <ul class="sub-menu">


                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт смартфонов в Москве" href="/types/smartfon">Смартфон</a>
                                    </li>


                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт ноутбуков в Москве" href="/types/noutbuk">Ноутбук</a>
                                    </li>

                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт моноблоков в Москве" href="/types/monoblok">Моноблок</a>
                                    </li>
                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт планшетов в Москве" href="/types/planshet">Планшет</a>
                                    </li>
                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт смарт-часов в Москве" href="/types/smart-chasy">Смарт-часы</a>
                                    </li>

                                </ul>
                            </li>
                            <li id="menu-item-192727"
                                class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-38 current_page_item menu-item-192727">
                                <a href="/garant" aria-current="page">Гарантия</a>
                            </li>
                            <li id="menu-item-192741"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192741">
                                <a href="/personal">Персонал</a>
                            </li>
                            <li id="menu-item-192742"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192742">
                                <a href="/warehouses">Склад</a>
                            </li>
                            <li id="menu-item-192760"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192760">
                                <a href="/stock">Акции центра</a>
                            </li>
                            <li id="menu-item-192743"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192743">
                                <a href="/contact">Контакты</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <button class="get-status js-open-modal" data-modal="2">
                    <a href="tel:+74993808302" class="tel-header">
                        +7 (499) 380-83-02 </a>
                </button>
            </div>
        </div>
    </header>

    <!-- Мобильное меню -->
    <header id="main-header-mobile" class="site-header" itemscope="" itemtype="http://schema.org/WPHeader">

        <div class="header-top flex-container centered">
            <div class="container flex-container f-centered">
                <div id="logo-header">
                    <a class="custom-logo-link" href="#" rel="home" aria-current="page">
                        <img class="custom-logo lazyloaded" data-ll-status="loaded"
                             src="/static/kApple/img/logo.svg"
                             alt="Сервисный центр по ремонту Apple">
                    </a>
                </div>
                <div id="info-hdr-part" class="flex-container">
                    <div class="info-div id-01">
                        <div class="hdr-icon map-icn">
                            <img class="svg" src="/static/kApple/img/svg/pin.svg"/>
                        </div>
                        <div class="doublerow">
                            <div class="dr-top adress">
                                <span class="current_city">Москва</span>, Ул. Профсоюзная 43к1
                            </div>
                            <!-- <span class="dr-btm">выбрать другой город</span> -->
                        </div>
                    </div>
                    <div class="info-div id-02">
                        <div class="hdr-icon time-icn">
                            <img class="svg" src="/static/kApple/img/svg/clocks.svg"/>
                        </div>
                        <div class="doublerow">
                            <span class="dr-top time">Ежедневно с 8:00 до 22:00</span>
                            <!-- <span class="dr-btm">(пн-пт, без перерывов)</span> -->
                        </div>
                    </div>
                    <div class="info-div id-03">
                        <div class="hdr-icon phone-icn">
                            <img class="svg" src="/static/kApple/img/svg/telephones.svg"/>
                        </div>
                        <div class="doublerow">
                            <span class="dr-top"><a href="tel:+74993808302">+7 (499) 380-83-02</a></span>
                            <span class="dr-btm">(горячая линия центра)</span>
                        </div>
                    </div>
                    <button class="get-order-btn order-hover js-open-modal" data-modal="1">Оставить заявку</button>
                    <button class="menu-mob process-menu">
                        <svg viewBox="0 0 64 48">
                            <path d="M19,15 L45,15 C70,15 58,-2 49.0177126,7 L19,37"></path>
                            <path d="M19,24 L45,24 C61.2371586,24 57,49 41,33 L32,24"></path>
                            <path d="M45,33 L19,33 C-8,33 6,-2 22,14 L45,37"></path>
                        </svg>
                        <span>Меню</span>
                    </button>
                </div>
            </div>
        </div>
        <div class="header-bottom">
            <div class="container flex-container f-spb">
                <nav id="site-navigation" class="main-navigation" itemscope=""
                     itemtype="http://schema.org/SiteNavigationElement">
                    <div class="menu-mainmenu-container">
                        <ul id="menu-mainmenu" class="menu">
                            <li id="menu-item-192726"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-home menu-item-192726">
                                <a href="#">Главная</a>
                            </li>
                            <li id="menu-item-192761"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-192761">
                                <a href="/devices">Устройства</a>
                                <ul class="sub-menu">


                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт смартфонов в Москве" href="/types/smartfon">Смартфон</a>
                                    </li>


                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт ноутбуков в Москве" href="/types/noutbuk">Ноутбук</a>
                                    </li>

                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт моноблоков в Москве" href="/types/monoblok">Моноблок</a>
                                    </li>
                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт планшетов в Москве" href="/types/planshet">Планшет</a>
                                    </li>
                                    <li id="menu-item-192769"
                                        class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                                        <a title="Ремонт смарт-часов в Москве" href="/types/smart-chasy">Смарт-часы</a>
                                    </li>

                                </ul>
                            </li>
                            <li id="menu-item-192727"
                                class="menu-item menu-item-type-post_type menu-item-object-page current-menu-item page_item page-item-38 current_page_item menu-item-192727">
                                <a href="/garant" aria-current="page">Гарантия</a>
                            </li>
                            <li id="menu-item-192741"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192741">
                                <a href="/personal">Персонал</a>
                            </li>
                            <li id="menu-item-192742"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192742">
                                <a href="/warehouses">Склад</a>
                            </li>
                            <li id="menu-item-192760"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192760">
                                <a href="/stock">Акции центра</a>
                            </li>
                            <li id="menu-item-192743"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192743">
                                <a href="/contact">Контакты</a>
                            </li>
                        </ul>
                    </div>
                </nav>
                <button class="get-status js-open-modal" data-modal="2">
                    <a href="tel:+74993808302" class="tel-header">
                        +7 (499) 380-83-02 </a>
                </button>
            </div>
        </div>
    </header>


    <#nested />


    <div class="container">
        <!-- Остался вопрос или необходима консультация? -->


        <div class="form-master-box">
            <div class="block-2">
                <div class="left">
                    <div class="image-master">
                        <img src="/static/kApple/img/master.png"
                             alt="Сервисный центр по ремонту Apple изображение 25">
                    </div>
                </div>
                <div class="right">
                    <div class="question-form-title">Остался вопрос или необходима консультация?</div>
                    <p class="simple-p" style="margin-bottom: 35px;">Задайте его нам и специалист проконсультирует
                        Вас!</p>
                    <form class="cform">
                        <input type="hidden" name="form_name" value="Остались вопросы или необходима консультация">
                        <input type="tel" inputmode="tel" size="40" name="phone" class="phone-master"
                               placeholder="+7 (___) ___-__-__">
                        <input type="submit" value="Отправить" class="submit" disabled="disabled">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <footer id="site-footer" class="site-footer">
        <div class="container flex-container f-spb">
            <div class="footer-1">
                <a class="custom-logo-link" href="#" rel="home" aria-current="page">
                    <img class="custom-logo lazyloaded"
                         src="/static/kApple/img/logo.svg"
                         alt="Сервисный центр по ремонту Apple изображение 26" data-ll-status="loaded">
                </a>
                <noindex>
                    <div class="footer-copyright">© 2023 — ИП Михалищев В.С.<br>ИНН 665603234203<br>ОГРНИП
                        320665800041882
                    </div>
                </noindex>
                <div class="payment-img">
                    <img src="/static/kApple/img/svg/pay1.svg" alt="Сервисный центр по ремонту Apple изображение 27"
                         class="footer-payment lazyloaded" data-ll-status="loaded">
                    <img src="/static/kApple/img/svg/pay2.svg" class="lazyloaded" data-ll-status="loaded"
                         alt="Сервисный центр по ремонту Apple изображение 28">
                    <img src="/static/kApple/img/svg/pay3.svg" class="lazyloaded" data-ll-status="loaded"
                         alt="Сервисный центр по ремонту Apple изображение 29">
                    <img src="/static/kApple/img/svg/pay4.svg" class="lazyloaded" data-ll-status="loaded"
                         alt="Сервисный центр по ремонту Apple изображение 30">
                    <img src="/static/kApple/img/svg/pay5.svg" class="lazyloaded" data-ll-status="loaded"
                         alt="Сервисный центр по ремонту Apple изображение 31">
                    <img src="/static/kApple/img/svg/pay6.svg" class="lazyloaded" data-ll-status="loaded"
                         alt="Сервисный центр по ремонту Apple изображение 32">
                </div>

            </div>
            <div class="footer-2">
                <span class="bottom-title">Каталог устройств</span>
                <div id="bottom-navigation-1" class="bottom-navigation">
                    <div class="menu-catalog-container">
                        <ul id="menu-catalog" class="menu">

                            <li id="menu-item-277956"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-277956">
                                <a href="/types/smartfon">Смартфон</a>
                            </li>
                            <li id="menu-item-277956"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-277956">
                                <a href="/types/noutbuk">Ноутбук</a>
                            </li>

                            <li id="menu-item-277956"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-277956">
                                <a href="/types/monoblok">Моноблок</a>
                            </li>
                            <li id="menu-item-277956"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-277956">
                                <a href="/types/planshet">Планшет</a>
                            </li>
                            <li id="menu-item-277956"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-277956">
                                <a href="/types/smart-chasy">Смарт-часы</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-3">
                <div id="bottom-navigation-2" class="bottom-navigation">
                    <div class="menu-about-container">
                        <ul id="menu-about" class="menu">
                            <li id="menu-item-285483"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-285483">
                                <a href="/garant">Гарантия сервиса</a>
                            </li>
                            <li id="menu-item-285520"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-285520">
                                <a href="/personal">Персонал центра</a>
                            </li>
                            <li id="menu-item-285556"
                                class="menu-item menu-item-type-post_type menu-item-object-page menu-item-285556">
                                <a href="/warehouses">Склад</a>
                            </li>
                            <li id="menu-item-285652"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-285652">
                                <a href="/stock">Акции центра</a>
                            </li>
                            <li id="menu-item-285651"
                                class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-285652">
                                <a href="/contact">Контакты</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-4">
                <a class="footer-phone" href="tel:+74993808302">+7 (499) 380-83-02</a>
                <div class="menu-footer-2-container">
                    <ul id="menu-footer-2" class="menu">
                        <li id="menu-item-303035"
                            class="menu-item menu-item-type-custom menu-item-object-custom menu-item-303035">
                            <a href="/terms_of_use">Политика обработки персональных данных</a>
                        </li>
                        <li id="menu-item-192765"
                            class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192765">
                            <a href="/terms_of_use">Пользовательское соглашение</a>
                        </li>
                        <li id="menu-item-192766"
                            class="menu-item menu-item-type-custom menu-item-object-custom menu-item-192766">
                            <a href="/terms_of_use">Политика конфидициальности</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </footer>


    <div class="modal" data-modal="1">
        <svg class="modal__cross js-modal-close" xmlns="https://www.w3.org/2000/svg" viewBox="0 0 24 24">
            <path d="M23.954 21.03l-9.184-9.095 9.092-9.174-2.832-2.807-9.09 9.179-9.176-9.088-2.81 2.81 9.186 9.105-9.095 9.184 2.81 2.81 9.112-9.192 9.18 9.1z"></path>
        </svg>
        <legend>Оставить заявку</legend>
        <p>Оставьте Ваши данные и менеджер сервиса перезвонит Вам!</p>
        <div role="form" class="wpcf7" id="wpcf7-f81-o3" lang="ru-RU" dir="ltr">
            <div class="screen-reader-response">
                <p role="status" aria-live="polite" aria-atomic="true"></p>
                <ul></ul>
            </div>
            <form class="cform">
                <input type="text" name="name" size="40" placeholder="Ваше имя">
                <input type="tel" inputmode="tel" name="phone" size="40" placeholder="+7 (___) ___-__-__">
                <input class="submit" type="submit" value="Отправить" disabled="disabled">
                <!-- Скрытые данные -->
                <input type="hidden" name="form_name" value="Оставить заявку">
            </form>
        </div>
    </div>
    <div class="modal" data-modal="2">
        <svg class="modal__cross js-modal-close" xmlns="https://www.w3.org/2000/svg" viewBox="0 0 24 24">
            <path d="M23.954 21.03l-9.184-9.095 9.092-9.174-2.832-2.807-9.09 9.179-9.176-9.088-2.81 2.81 9.186 9.105-9.095 9.184 2.81 2.81 9.112-9.192 9.18 9.1z"></path>
        </svg>
        <legend>Узнать статус</legend>
        <p>Оставьте Ваши данные, чтобы узнать текущий статус ремонта</p>
        <div role="form" class="wpcf7" id="wpcf7-f254-o4" lang="ru-RU" dir="ltr">
            <div class="screen-reader-response">
                <p role="status" aria-live="polite" aria-atomic="true"></p>
                <ul></ul>
            </div>
            <form class="wpcf7-form init" novalidate="novalidate" data-status="init">
                <p>
                <span class="wpcf7-form-control-wrap your-name">
                    <input type="text" name="your-name" value="" size="40" class="wpcf7-form-control wpcf7-text"
                           aria-invalid="false" placeholder="Ваше имя">
                </span><br>
                    <span class="wpcf7-form-control-wrap tel-426">
                    <input type="tel" inputmode="tel" name="tel-426" value="" size="40"
                           class="wpcf7-form-control wpcf7-text wpcf7-tel wpcf7-validates-as-required wpcf7-validates-as-tel phone-mask"
                           aria-required="true" aria-invalid="false" placeholder="+7 (___) ___-__-__">
                </span><br>
                    <input type="submit" value="Отправить" class="wpcf7-form-control has-spinner wpcf7-submit"
                           disabled="disabled">
                </p>
                <div class="wpcf7-response-output" aria-hidden="true"></div>
            </form>
        </div>
    </div>
    <div class="js-overlay-modal"></div>
    <div class="mobile-menu-block">
        <button class="process-menu cross-menu"></button>
        <button class="menu-mob process-menu cross-menu">
            <svg viewBox="0 0 64 48">
                <path d="M19,15 L45,15 C70,15 58,-2 49.0177126,7 L19,37"></path>
                <path d="M19,24 L45,24 C61.2371586,24 57,49 41,33 L32,24"></path>
                <path d="M45,33 L19,33 C-8,33 6,-2 22,14 L45,37"></path>
            </svg>
        </button>
        <div class="menu-mainmenu-container">
            <ul id="menu-mainmenu-1" class="menu">
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-home current-menu-item page_item page-item-15 current_page_item menu-item-192726">
                    <a href="#" aria-current="page">Главная</a>
                </li>
                <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-has-children menu-item-192761">
                    <a href="/devices">Устройства</a>
                    <ul class="sub-menu">


                        <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                            <a title="Ремонт смартфонов в Москве" href="/types/smartfon">Смартфон</a>
                        </li>
                        <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                            <a title="Ремонт ноутбуков в Москве" href="/types/noutbuk">Ноутбук</a>
                        </li>

                        <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                            <a title="Ремонт моноблоков в Москве" href="/types/monoblok">Моноблок</a>
                        </li>
                        <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                            <a title="Ремонт планшетов в Москве" href="/types/planshet">Планшет</a>
                        </li>
                        <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192769">
                            <a title="Ремонт смарт-часов в Москве" href="/types/smart-chasy">Смарт-часы</a>
                        </li>

                    </ul>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192727">
                    <a href="/garant">Гарантия</a>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192741">
                    <a href="/personal">Персонал</a>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192742">
                    <a href="/warehouses">Склад</a>
                </li>
                <li class="menu-item menu-item-type-taxonomy menu-item-object-category menu-item-192760">
                    <a href="/stock">Акции центра</a>
                </li>
                <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-192743">
                    <a href="/contact">Контакты</a>
                </li>
            </ul>
        </div>
    </div>
    <a href="tel:+74993808302" class="tel-header--mobile">
        <div class="call-button">
            <svg viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <defs>
                    <path fill="#ffffff" style="oppacity: 0.6" id="i-419"
                          d="M46.557,37.182l-9-6.014c-1.498-1.002-2.941-0.967-4.189,0.059c-3.504,2.873-5.582,2.049-5.92,1.879 c-1.982-0.992-3.854-1.928-6.741-4.813c-3.584-3.586-4.878-5.875-5.812-7.74c-0.373-0.746-0.803-3.254,1.65-5.869 c1.147-1.221,1.253-2.721,0.299-4.221c-0.735-1.156-0.735-1.156-1.313-2.006c-0.57-0.84-1.709-2.518-4.713-7.014 C10.169,0.473,9.247,0,8,0C6.586,0,5.87,0.717,5.293,1.293l-3,3C0.169,6.416,0,7.633,0,9c0,1.721,2.485,12.939,14.292,24.705 C26.061,45.514,37.268,48,38.988,48h0.066c1.355-0.02,2.559-0.199,4.652-2.293l3-3C47.283,42.131,48,41.414,48,40 C48,38.752,47.527,37.83,46.557,37.182z M45.293,41.293l-3,3c-1.684,1.684-2.416,1.695-3.305,1.707 c-0.123-0.004-10.891-1.273-23.282-13.709C3.415,20.043,2.002,9.096,2,9c0-0.887,0-1.586,1.706-3.293l3-3C7.233,2.182,7.443,2,8,2 c0.653,0,0.927,0.213,1.156,0.555c3.009,4.504,4.15,6.186,4.721,7.025c0.563,0.828,0.563,0.828,1.28,1.957 c0.568,0.893,0.302,1.383-0.07,1.779c-3.121,3.324-2.66,6.771-1.981,8.131c1.003,2.006,2.39,4.463,6.187,8.26 c3.115,3.115,5.223,4.168,7.26,5.188c0.561,0.279,1.293,0.434,2.063,0.434c1.326,0,3.445-0.443,6.02-2.555 c0.365-0.301,0.625-0.336,0.789-0.336c0.287,0,0.631,0.133,1.021,0.395l9,6.012C45.787,39.072,46,39.346,46,40 C46,40.557,45.818,40.768,45.293,41.293z">
                    </path>
                </defs>
                <use x="0" y="0" xlink:href="#i-419"></use>
            </svg>
        </div>
    </a>

    <button class="scroll-top" onclick="window.scrollTo({top: 0, behavior: 'smooth'});"></button>
    <script src="/static/kApple/js/jquery.min.js"></script>
    <script src="/static/kApple/js/swiper-bundle.min.js"></script>
    <script src="/static/kApple/js/mask.min.js"></script>
    <script src="/static/kApple/js/custom.js"></script>
    <!-- Модальное окно - СПАСИБО -->
    <div class="bg-modal-yes">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header justify-content-center">
                    <div class="modal-title" id="successFormLabel">Благодарим за обращение!</div>
                    <button class="close" type="button"><span>×</span></button>
                </div>
                <div class="modal-body">
                    <div class="modal-yes-img mb-4">
                        <svg xmlns="http://www.w3.org/2000/svg" width="256" height="256" viewBox="0 0 256 256"
                             fill="none">
                            <path d="M109.083 183.336C107.562 183.336 106.083 182.794 104.917 181.795L67.087 149.369C64.404 147.068 64.093 143.028 66.393 140.344C68.693 137.662 72.734 137.352 75.418 139.651L108.15 167.709L179.692 75.728C181.863 72.939 185.88 72.433 188.673 74.606C191.462 76.776 191.965 80.797 189.795 83.587L114.132 180.866C113.057 182.248 111.465 183.129 109.722 183.304C109.511 183.325 109.297 183.336 109.083 183.336ZM256 128C256 57.42 198.58 0 128 0C57.42 0 0 57.42 0 128C0 198.58 57.42 256 128 256C198.58 256 256 198.58 256 128ZM243.2 128C243.2 191.521 191.521 243.2 128 243.2C64.478 243.2 12.8 191.521 12.8 128C12.8 64.478 64.478 12.8 128 12.8C191.521 12.8 243.2 64.478 243.2 128Z"
                                  fill="#1CC63A"/>
                        </svg>
                    </div>
                    <div class="success-text">
                        Менеджер свяжется с вами в течение нескольких минут
                    </div>
                </div>
                <div class="btn-ok">
                    <button class="ok-thankYou">Спасибо</button>
                </div>
            </div>
        </div>
    </div>
    <!-- *** МОдальное окно - СПАСИБО *** -->


    <script type="text/javascript">
        jQuery(document).ready(function ($) {


            // Срабатывает по клику на телефоный номер цель в метрику
            $('.tel-header, .footer-phone, .dr-top a, .contacts-item a').on('click', function () {

            });


            $('.cform .submit').on('click', function (event) {

                event.preventDefault();

                var $cform = $(this).parent('.cform');
                var $modal = $(this).parent('.modal');

                $.ajax({
                    url: "/sendform",
                    type: 'POST',
                    data: $cform.serialize(),
                    beforeSend: function (xhr) {
                        $cform.find('[type="submit"]').attr('disabled', 'disabled');
                    },
                    success: function (response) {

                        // -----------------------------------------------------------------
                        $cform.find('[inputmode="tel"]').val('');
                        $('.modal').removeClass('active');
                        $('.js-overlay-modal').removeClass('active');
                        $('.modal-dialog .close').click();
                        $('.modal, .overlay').removeClass('is-show');
                        $('.bg-modal-yes').css('display', 'flex');
                        $('.ok-thankYou, .bg-modal-yes .close').click(function () {
                            $('.bg-modal-yes').css('display', 'none');
                            $('.success').removeClass('red green');
                        });
                        // -----------------------------------------------------------------

                    }
                });
            });

        });
    </script>

    </body>

    </html>

</#macro>