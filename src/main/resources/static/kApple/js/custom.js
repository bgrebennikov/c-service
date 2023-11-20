/*
* Replace all SVG images with inline SVG
*/
$(document).ready(function() {
  $('img.svg').each(function() {
    var $img = jQuery(this);
    var imgURL = $img.attr('src');
    var attributes = $img.prop("attributes");

    $.get(imgURL, function(data) {
      // Get the SVG tag, ignore the rest
      var $svg = jQuery(data).find('svg');

      // Remove any invalid XML tags
      $svg = $svg.removeAttr('xmlns:a');

      // Loop through IMG attributes and apply on SVG
      $.each(attributes, function() {
        $svg.attr(this.name, this.value);
      });

      // Replace IMG with SVG
      $img.replaceWith($svg);
    }, 'xml');
  });
});



jQuery(document).ready(function($) {
  // Мониторим событие  wpcf7-submit у выбранного блока
  // document.addEventListener("wpcf7submit", function(event) {
  //   var data = event.detail.inputs;
  //   $.ajax({
  //     url: "https://panel.garantsc.ru/collector.php",
  //     type: "post",
  //     data: data,
  //     success: function(result) {
  //       // действия при получения ответа (result) от сервера
  //     },
  //   });
  // });

  $(function() {
    $("a[href^='#']").click(function() {
      var _href = $(this).attr("href");
      $("html, body").animate({ scrollTop: $(_href).offset().top + "px" });
      $(_href).addClass("founded");
      setTimeout(function() {
        $(_href).removeClass("founded");
      }, 1000);

      return false;
    });
  });

  const search_input = $(".search-form__input");
  const search_results = $(".ajax-search");
  const $cat_rel = $(".cat_rel");
  const $urlSerach = $('.urlserch').val();

  search_input.keyup(function() {
    let search_value = $(this).val();
    let cat_rel = $cat_rel.val();
    var area = $(this).attr('data-search');
    var search = $(this).val();
    var dataset = $('.dataset[data-search="'+area+'"]').val();

    if (search_value.length > 2) {
      // кол-во символов
      $.ajax({
        url: $urlSerach,
        type: "POST",
        data: {
          // action: "ajax_search", // functions.php
          // term: search_value,
          // cat_rel: cat_rel,
          search: search,
          dataset: dataset,
        },
        success: function(results) {
          console.log(results);
          search_results.fadeIn(200).css("display", "flex").html(results);
        },
      });
    } else {
      search_results.fadeOut(200);
    }
  });

  // Закрытие поиска при клике вне его
  $(document).mouseup(function(e) {
    if (
      search_input.has(e.target).length === 0 &&
      search_results.has(e.target).length === 0
    ) {
      search_results.fadeOut(200);
    }
  });

  $(".fixies-table-wrap .more-repairs").click(function() {
    $(".fixies-table-wrap .more-repairs").toggle();
    $(".fixies-table-wrap .fixies-table").toggleClass("active");
  });
});

// Sticky Header
jQuery(function() {
  createSticky(jQuery("#main-header .header-bottom"));

  //menu parent hover
  $(document).ready(function() {
    var $nav = $("#menu-mainmenu > li");
    $nav.hover(
      function() {
        $(".sub-menu", this).stop(true, true).slideDown("fast");
      },
      function() {
        $(".sub-menu", this).slideUp("fast");
      }
    );
  });

  $(function() {
    $(".wpcf7-response-output").delay(5000).slideUp(300);
  });
  $(".accordion > li:eq(0) a").addClass("active").next().slideDown();

  $(".accordion a").click(function(j) {
    var dropDown = $(this).closest("li").find("p");

    $(this).closest(".accordion").find("p").not(dropDown).slideUp();

    if ($(this).hasClass("active")) {
      $(this).removeClass("active");
    } else {
      $(this).closest(".accordion").find("a.active").removeClass("active");
      $(this).addClass("active");
    }

    dropDown.stop(false, true).slideToggle();

    j.preventDefault();
  });
  $(".menu-mob").on("click", function(e) {
    $(".menu-mob").toggleClass("active"); //you can list several class names
    e.preventDefault();
  });
  $(".id-01 .dr-btm").on("click", function(e) {
    $(".city-changer").toggleClass("active"); //you can list several class names
    e.preventDefault();
  });
  $(".process-menu").on("click", function(e) {
    $(".mobile-menu-block").toggleClass("active"); //you can list several class names
    e.preventDefault();
  });
});

function createSticky(sticky) {
  if (typeof sticky != "undefined") {
    var pos = sticky.offset().top + 100,
    win = jQuery(window);

    // scroll should really be debounced
    win.on("scroll", function() {
      if (win.scrollTop() > pos) {
        sticky.addClass("stickyhead");
      } else {
        sticky.removeClass("stickyhead");
      }
    });
  }
}

// Модальное окно
document.addEventListener("DOMContentLoaded", function() {
  var modalButtons = document.querySelectorAll(".js-open-modal"),
  overlay = document.querySelector(".js-overlay-modal"),
  closeButtons = document.querySelectorAll(".js-modal-close");
  modalButtons.forEach(function(item) {
    item.addEventListener("click", function(e) {
      e.preventDefault();
      var modalId = this.getAttribute("data-modal"),
      modalElem = document.querySelector(
        '.modal[data-modal="' + modalId + '"]'
      );
      modalElem.classList.add("active");
      overlay.classList.add("active");
    });
  });
  closeButtons.forEach(function(item) {
    item.addEventListener("click", function(e) {
      var parentModal = this.closest(".modal");
      parentModal.classList.remove("active");
      overlay.classList.remove("active");
    });
  });
  document.body.addEventListener(
    "keyup",
    function(e) {
      var key = e.keyCode;
      if (key == 27) {
        document.querySelector(".modal.active").classList.remove("active");
        document.querySelector(".overlay").classList.remove("active");
      }
    },
    false
  );
});

window.onload = function() {
  const items = Array.from(
    document.querySelectorAll(".childcat-title"),
    (item) => item.textContent
  );

  if (document.querySelector(".search-form__input")) {
    var rand = Math.floor(Math.random() * items.length);
    document.querySelector(".search-form__input").placeholder =
    "Введите вашу модель, например, " + items[rand] + "..";
  }

  if (document.querySelector(".team-slider")) {
    var galleryTop = new Swiper(".team-slider", {
      spaceBetween: 40,
      loop: true,
      loopedSlides: 4,
      slidesPerView: "auto",
      centeredSlides: true,
      autoplay: {
        delay: 2500,
      },
    });
  }
  if (document.querySelector(".team-thumb")) {
    var galleryThumbs = new Swiper(".team-thumb", {
      spaceBetween: 15,
      centeredSlides: true,
      slidesPerView: "auto",
      touchRatio: 0.2,
      slideToClickedSlide: true,
      loop: true,
      loopedSlides: 4,
    });
    galleryTop.controller.control = galleryThumbs;
    galleryThumbs.controller.control = galleryTop;
  }
  //
};



jQuery(document).ready(function($) {

  $('.modal-yes .close').click(function(){
    $('.modal').removeClass('active');
    $('.modal-yes').removeClass('active');
    $('.js-overlay-modal').removeClass('active');
  });

	$('[inputmode="tel"]').mask("+7 (000) 000-00-00", {
		placeholder: '+7 (___) ___-__-__'
	});

	// $("[inputmode='tel']").click(function() {
	// 	if($(this).val().length < 4) {
	// 		$(this).val('+7 (');
	// 	}
	// });

	// $("[inputmode='tel']").on('keyup change', function() {
	// 	var phoneLenth = $(this).val().length;
	// 	if(phoneLenth < 5) {
	// 		$(this).val('+7 (');
	// 	}
	// });

  // недаем возможность отправлять письма, если нету нужного кол-ва цифр
  $(function() {

    $("input[type='submit']").addClass('no-submit');

    $("input[inputmode='tel']").change( function count() {
      number = $(this).val().length;
      if (number == 18) {
        $(this).parent('form.cform').find('[type="submit"]').removeClass('no-submit');
      } else {
        $(this).parent('form.cform').find('[type="submit"]').addClass('no-submit');
      }
    });

  });


  // Попап "Спасибо!" ----------------------------------------------------------
  $('[type="submit"]').attr('disabled', 'disabled');
  $('form.cform').on('ready keyup', function(){
    let form = $(this).find('[inputmode="tel"]').val().length;
    if (form == 18) {
      $(this).find('[type="submit"]').attr('disabled', null);
    } else {
      $(this).find('[type="submit"]').attr('disabled', 'disabled');
    }
  });
  // Попап "Спасибо!" **********************************************************


  // Добавлять в меню класс при скролле в мобильной версии -----------------
  function headerAddClassInMobileVersion() {
    let windowWidth  = $(window).width(); // Ширина окна сайта в браузере
    let windowScroll = $(window).scrollTop().toFixed(); // Расположение окна (пользователя) сайта относительно документа
    // ---
    if (windowWidth < 768) {
      if (windowScroll > 400) {
        $('#main-header-mobile').addClass('fixedMenu');
      } else {
        $('#main-header-mobile').removeClass('fixedMenu');
      }
    }
    // console.log("Условия совпадают");
  }
  // ---
  $(window).on('load ready resize scroll', headerAddClassInMobileVersion);
  // Добавлять в меню класс при скролле в мобильной версии *****************
});
