function updateProgressBar(e) {
    const goalValue = $('#goalValue').text();
    const progressBar = $(".liveDonation-range");
    const percentage = (e / goalValue) * 100;
    if (percentage <= 100) {
                progressBar.css({ width: percentage + '%' });
            } else {
                progressBar.css({ width: '100%' });
            }
}
function fetchDataFromApi() {
    const apiUrl = "https://wvc-ccc-campaign.azurewebsites.net/api/1.0.0/CampignTotalAmount?";
    const requestBody = {
        "campaignId": 1
    };

    $.ajax({
        url: apiUrl,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(requestBody),
        success: function (response) {
            if (response.success) {
                const fundsRaised = response.responseObject.fundsRaised;
                const fundraiserValue = response.responseObject.campaignTotalAmount;
                const NoOfDonors = response.responseObject.donorsdonated;
                const formattedValue = typeof fundraiserValue !== 'undefined' ? formatValueInK(fundraiserValue) : "000";
                $("#fundraiserKValue").text("$" + " " + formattedValue),
                    $("#NoOfDonors").text(NoOfDonors)
                updateProgressBar(fundraiserValue);
                (fundsRaised);
            } else {
                console.error("API call failed: " + response.message);
            }
        },
        error: function (error) {
            console.error("AJAX error: " + error.statusText);
        }
    });
    function formatValueInK(value) {
        if (value < 1000) {
            return value.toString();
        } else {
            return (value / 1000).toFixed(1) + 'K';
        }
    }
}

fetchDataFromApi();
