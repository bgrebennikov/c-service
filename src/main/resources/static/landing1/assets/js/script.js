$(function () {



	//
	// 
	// 
	// 
	// Переменные
	let headerTop = $('.header__top-wrapper')
	let headerTopFixed = 'header__top-wrapper_fixed';

	let menu = $('.header__menu-wrapper');
	let menuActive = 'header__menu-wrapper_active';
	let burgerMedia = 991;

	let bodyOpenModalClass = 'popup_show';

	// Функции для добавления и удаления классов для Body и фиксированной шапки при открытии модалки и мобильного меню 
	function bodyRemoveClass() {
		$('body').removeClass('window-padding')
		$(headerTop).removeClass('window-padding')

		removeScrollbarPadding($('body'))
		removeScrollbarPadding(headerTop)
	}

	function bodyToggleClass() {
		$('body').toggleClass('window-padding')
		$(headerTop).toggleClass('window-padding')

		if ($('body').hasClass('window-padding') && $(headerTop).hasClass('window-padding')) {

			addScrollbarPadding($('body'))
			addScrollbarPadding(headerTop)
		} else {
			removeScrollbarPadding($('body'))
			removeScrollbarPadding(headerTop)
		}
	}

	// Получение ширины скроллбара
	function getScrollBarWidth() {
		let div = document.createElement('div');

		div.style.overflowY = 'scroll';
		div.style.width = '50px';
		div.style.height = '50px';

		document.body.append(div);
		let scrollWidth = div.offsetWidth - div.clientWidth;

		div.remove();
		return scrollWidth
	}

	// Добавление отступа при скрытии скроллбара
	function addScrollbarPadding(elem) {
		$(elem).css({
			paddingRight: getScrollBarWidth() + 'px'
		})
	}

	// Удаление отступа при скрытии скроллбара
	function removeScrollbarPadding(elem) {
		$(elem).css({
			paddingRight: 0
		})
	}

	function hideScrollbar() {
		$('body').addClass('no-scroll');
		if (!isMobile()) {
			$('body').addClass('window-padding')
			$(headerTop).addClass('window-padding')
			$('.popup').addClass(bodyOpenModalClass)
			addScrollbarPadding($('body'))

			if ($(window).width() <= burgerMedia) {
				addScrollbarPadding(headerTop)
			}

			// if ($(headerTop).hasClass(headerTopFixed)) {
			addScrollbarPadding(headerTop)
			// }
		}
	}

	// Проверка на мобильное устройство
	function isMobile() {
		return /Android|webOS|iPhone|iPad|iPod|BlackBerry|BB|PlayBook|IEMobile|Windows Phone|Kindle|Silk|Opera Mini/i.test(navigator.userAgent);
	}


	// Проверка количества слайдов в слайдере. Если меньше или равно 1, то не включать 
	function checkSlideritems(slider) {
		if ($(slider).find('.swiper-slide').not('.swiper-slide-next').not('.swiper-slide-prev').not('.swiper-slide-duplicate').length <= 1) {

			slider.destroy()
		}
	}

	//
	// 
	// 
	// 
	// Фиксированное меню
	function fixedMenu() {
		if ($(window).width() > burgerMedia) {
			let s = $(window).scrollTop();
			if (s > 50) {
				$(headerTop).addClass(headerTopFixed);
			} else {
				$(headerTop).removeClass(headerTopFixed);
			}
		} else {
			$(headerTop).removeClass(headerTopFixed);
		}
	}

	fixedMenu();

	$(window).on('scroll', function () {
		fixedMenu();
	});

	$(window).resize(function () {
		fixedMenu();
	})


	//
	// 
	// 
	// 
	// Отрытие модалки
	$('[data-modal]').on('click', function () {
		if ($(this).attr('data-modal-text')) {
			let parent = $(this).attr('data-modal-text').split(';')[0]; // Родитель
			let children = $(this).attr('data-modal-text').split(';')[1]; // Дочерний (из которого берется контент)
			let where = $(this).attr('data-modal-text').split(';')[2]; // Куда вставлять

			let issetParent = $(this).closest(parent).length != 0; // Если есть родитель
			let isNotInput = $(where).prop('tagName') != 'INPUT'; // Если тег, куда будет вставляться контент != input
			let isClassMatch = $(this).hasClass(children.substr(1)); // Если класс во втором параметре совпадает с классом элемента, на который кликнули
			let searchInChildren = $(this).closest(parent).find(this).find(children).text() // Если элемент, из которого берется контент находится внутри элемента, на который кликнули 
			let searchInThis = $(this).closest(parent).find(this).text() // Если элемент, из которого берется контент равен элементу, на который кликнули 

			if ((issetParent && isNotInput && isClassMatch) || (!issetParent && isNotInput && isClassMatch)) {
				$(where).text(searchInThis)
			}
			if ((issetParent && isNotInput && !isClassMatch) || (!issetParent && isNotInput && !isClassMatch)) {
				$(where).text(searchInChildren)
			}
			if ((issetParent && !isNotInput && isClassMatch) || (!issetParent && !isNotInput && isClassMatch)) {
				$(where).val(searchInThis)
			}
			if ((issetParent && !isNotInput && !isClassMatch) || (!issetParent && !isNotInput && !isClassMatch)) {
				$(where).val(searchInChildren)
			}
		}

		let dataModal = $(this).attr('data-modal')
		$(`.popup[id="${dataModal}"]`).fadeIn();

		hideScrollbar()
	});

	// Функция закрытия модалок
	function closeModal() {
		$('.popup').fadeOut();
		setTimeout(() => {
			if (!$(menu).hasClass(menuActive)) {
				bodyRemoveClass()
				$('body').removeClass('no-scroll');
			}
		}, 400);
	}

	// Закрытие модалки при клике на крестик
	$('.popup__close, .popup-thank__button').on('click', function () {
		closeModal()
	});

	// Закрытие модалки при клике вне области контента
	var popup = document.querySelectorAll('.popup__dialog');
	window.addEventListener('click', function (e) {
		popup.forEach(function (popup) {
			if (e.target == popup) {
				closeModal()
			}
		});
	});

	// Закрытие модалки при клике ESC
	window.onkeydown = function (event) {
		if (event.keyCode == 27) {
			popup.forEach(function (popup) {
				closeModal()
			});
		}
	};

	// Очистка input и textarea при закрытии модалки и отправки формы
	function clearInputs() {
		$('input, textarea').removeClass('wpcf7-not-valid');
		$('.form__check').removeClass('error');
	}


	//
	// 
	//  
	// 
	// плавная прокрутка
	$('.menu li a, .scroll').click(function () {
		var scroll_el = $(this).attr('href');

		if ($(scroll_el).length != 0) {
			$('html, body').animate({
				scrollTop: $(scroll_el).offset().top - +$(headerTop).innerHeight() + 1
			}, 800);
			$(menu).removeClass(menuActive);
			$('.menu-link').removeClass('menu-link_active');
			bodyRemoveClass();
		} else {
			$('html, body').animate({
				scrollTop: 0
			}, 800);
			$(menu).removeClass(menuActive);
			$('.menu-link').removeClass('menu-link_active');
			bodyRemoveClass();
		}
		$('body').removeClass('no-scroll');
		return false;
	});

	//
	//
	//
	//
	// Общие скрипты

	let breakageArray = [];
	let modalInfoText;
	let breakageItem = $('.breakage__item');

	for (let i = 0; i < breakageItem.length; i++) {
		$(breakageItem[i]).attr('data-id', i);
		breakageArray.push('')
	}

	$(breakageItem).on('click', function () {
		$(this).toggleClass('active')

		if ($(this).hasClass('active')) {
			breakageArray[$(this).attr('data-id')] = $(this).find('.breakage__item-title').text().replace(/\s{2,}/g, ' ')
		} else {
			breakageArray[$(this).attr('data-id')] = ''
		}

		modalInfoText = (breakageArray.toString().replace(/,/g, "\n"));

		$('.breakage__form .modal-info').val(modalInfoText)
	})


	$("input[name=phone]").keydown(function (e) {
		// Allow: backspace, delete, tab, escape, enter and .
		if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190, 189]) !== -1 ||
			// Allow: Ctrl+A
			(e.keyCode == 65 && e.ctrlKey === true) ||
			// Allow: Ctrl+C
			(e.keyCode == 57 && e.shiftKey === true) ||
			// Allow: Ctrl+C
			(e.keyCode == 48 && e.shiftKey === true) ||
			// Allow: Ctrl+C
			(e.keyCode == 67 && e.ctrlKey === true) ||
			// Allow: Ctrl+X
			(e.keyCode == 88 && e.ctrlKey === true) ||
			// Allow: home, end, left, right
			(e.keyCode >= 35 && e.keyCode <= 39)) {
			// let it happen, don't do anything
			return;
		}
		// Ensure that it is a number and stop the keypress
		if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
			e.preventDefault();
		}
	});



});

