// Load jQuery from CDN
var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.6.4.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

// Wait for jQuery to be ready
script.onload = function() {
    // Wrap your jQuery-dependent code in a function
    function initialize() {
        var menuButton = $('#menuButton');
        var menuModal = $('#menuModal');

        menuButton.click(function () {
            menuModal.toggle();
            var newRightPosition = menuModal.is(':visible') ? 0 : -300;
            menuModal.animate({
                right: newRightPosition
            }, 300);
        });

        var menuCloseButton = $('#menuCloseButton');
        menuCloseButton.click(function () {
            var newRightPosition = menuModal.is(':visible') ? -300 : 0;
            menuModal.animate({
                right: newRightPosition
            }, 300, function () {
                menuModal.toggle();
            });
        });
    }

    // Use jQuery's ready function to ensure the DOM is ready before executing the code
    $(document).ready(initialize);
};
