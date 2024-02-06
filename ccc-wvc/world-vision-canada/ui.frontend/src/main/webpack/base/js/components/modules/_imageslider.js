// Load jQuery from CDN
var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.6.4.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

// Wait for jQuery to be ready
script.onload = function() {
    // Wrap your entire script in a jQuery ready function
    $(function() {

        var slideExtraHeight = 80;
        var wrapperPaddingLeft = 50;
        var wrapperPaddingRight = 50;
        var slideItem = 1;
        var spead = 800;
        var slideMargin = 8;
        var sliderWraper = $('#wrap-sh-slider').width();

        var slideCount = $('.sh-slider ul li').length;
        var slideWidth = (sliderWraper - wrapperPaddingLeft - wrapperPaddingRight);
        var slideUlWidth = (slideWidth / slideItem) * slideCount * slideMargin - slideMargin;
        $('#slideNumber').text("1/"+slideCount);
        $('.sh-slider ul').css({
            width: slideUlWidth,
            marginLeft: -slideWidth / slideItem
        });

        var slideHeight = $('.sh-slider ul li').height();
        $('.sh-slider ul li').css({
            width: slideWidth / slideItem,
            // height: slideHeight,
            marginRight: slideMargin
        });

        $('.sh-slider ul li:last-child').prependTo('.sh-slider ul');

        $('.sh-slider').css({
            // height: slideHeight,
            paddingTop: slideExtraHeight / 2,
            paddingBottom: slideExtraHeight / 2
        });

        var currentSlideIndex = 1; // Add this variable to track the current slide index
          var autoSlideInterval;
  function startAutoSlide() {
    clearInterval(autoSlideInterval);
    autoSlideInterval = setInterval(function () {
      moveRight();
    }, 3000);
  }
  function stopAutoSlide() {
    clearInterval(autoSlideInterval);
  }
  startAutoSlide();

        $('.sh-slider ul li:first-child').next().next().animate({}, spead);

        removeShadow($('.sh-slider ul li:first-child'));
        removeShadow($('.sh-slider ul li:first-child').next().next().next().next());

        /**
         * Move left
         */
        function moveLeft() {
            setShadow($('.sh-slider ul li'));
            $('.sh-slider ul li:first-child').next().animate({}, spead);

            $('.sh-slider ul li:first-child').next().next().animate({
                // height: slideHeight,
                marginTop: 0,
                marginLeft: 0,
                marginRight: slideMargin,
                zIndex: 1
            }, spead);

            $('.sh-slider ul').animate({
                left: +slideWidth / slideItem
            }, spead, function () {
                $('.sh-slider ul li:last-child').prependTo('.sh-slider ul');
                $('.sh-slider ul').css('left', '');
                updateSlideNumber(-1); // Update the slide number when moving left
            });

            removeShadow($('.sh-slider ul li:last-child'));
            removeShadow($('.sh-slider ul li:first-child').next().next().next());
        }

        /**
         * Move right
         */
        function moveRight() {
            setShadow($('.sh-slider ul li'));
            $('.sh-slider ul li:last-child').prev().prev().animate({}, spead);
            $('.sh-slider ul li:last-child').prev().prev().prev().animate({
                // height: slideHeight,
                marginTop: 0,
                marginLeft: 0,
                marginRight: slideMargin,
                zIndex: 1
            }, spead);

            $('.sh-slider ul').animate({
                left: -slideWidth / slideItem
            }, spead, function () {
                $('.sh-slider ul li:first-child').appendTo('.sh-slider ul');
                $('.sh-slider ul').css('left', '');
                updateSlideNumber(1); // Update the slide number when moving right
            });

            removeShadow($('.sh-slider ul li:last-child'));
            removeShadow($('.sh-slider ul li:last-child').prev().prev().prev().prev());
        }

        function setShadow(elem) {
            var shadowValue = '0px 10px 20px #148F77';
            $(elem).css({});
        }

        function removeShadow(elem) {
            $(elem).css({});
        }

        function updateSlideNumber(direction) {
            currentSlideIndex += direction;
            // slideCount
            if (currentSlideIndex < 1) {
                currentSlideIndex = slideCount;
            } else if (currentSlideIndex > slideCount) {
                currentSlideIndex = 1;
            }
            // Display or update the slide number wherever you want
            $('#slideNumber').text(currentSlideIndex + '/' + slideCount);
        }

        $('.control_prev').click(function () {
            moveLeft();
        });

        $('.control_next').click(function () {
            moveRight();
        });

        var touchStartX = 0;
        var touchEndX = 0;

        $('.sh-slider').on('touchstart', function (e) {
            touchStartX = e.originalEvent.touches[0].pageX;
        });

        $('.sh-slider').on('touchmove', function (e) {
            touchEndX = e.originalEvent.touches[0].pageX;
        });

        $('.sh-slider').on('touchend', function () {
            var touchDiff = touchStartX - touchEndX;

            if (touchDiff > 0) {
                moveRight(); // Swipe left, move to the next slide
            } else if (touchDiff < 0) {
                moveLeft(); // Swipe right, move to the previous slide
            }
        });

    });
};
