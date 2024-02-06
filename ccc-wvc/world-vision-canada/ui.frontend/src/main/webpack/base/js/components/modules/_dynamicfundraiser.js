$(document).ready(function () {
    fetchDataFromApi();
});

function fetchDataFromApi() {
    const apiUrl = "https://wvc-ccc-campaign.azurewebsites.net/api/1.0.0/CampaignDetailsByCampaignIdwithFundraiserId";
    const requestBody = {
        "campaignId": 1,
        "fundraiserId": 1
    };

    $.ajax({
        url: apiUrl,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(requestBody),
        success: function (response) {
            if (response.success) {
                const fundsRaised = response.responseObject.fundsRaised;
                const fundraiserValue = response.responseObject.fundsRaised;
                const NoOfDonors = response.responseObject.noOfDonors;
                const formattedValue = typeof fundraiserValue !== 'undefined' ? formatValueInK(fundraiserValue) : "000";

                // Read hidden data
                const maxFunds = parseFloat($(".week-goal-card").data("maximum-funds"));
                console.log("Maximumfunds:", maxFunds);

                $("#fundraiserKValue").text("$" + "" + formattedValue);
                $("#NoOfDonors").text(NoOfDonors);

                updateProgressBar(fundsRaised, maxFunds);
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

    function updateProgressBar(fundsRaised, maxFunds) {
        const progressBar = $(".liveDonation-range");

        if (isNaN(maxFunds) || maxFunds <= 0) {
            console.error("Invalid maxFunds value:", maxFunds);
            return;
        }

        const percentage = (fundsRaised / maxFunds) * 100;
        
        if (!isNaN(percentage) && percentage >= 0 && percentage <= 100) {
            progressBar.css({ width: percentage + '%' });
            $("#percentage").text(percentage.toFixed(0) + '%');
        } else {
            console.error("Invalid percentage:", percentage);
        }
    }
}
