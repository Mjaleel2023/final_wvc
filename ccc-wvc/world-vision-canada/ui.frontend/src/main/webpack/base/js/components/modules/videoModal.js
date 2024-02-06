$(document).ready(function () {
    // video modal
    $("#openModalBtn").click(function () {
        $("#myModal").css("display", "block");
    });
    $(".videoModal-close").click(function () {
        $("#myModal").css("display", "none");
    });
});