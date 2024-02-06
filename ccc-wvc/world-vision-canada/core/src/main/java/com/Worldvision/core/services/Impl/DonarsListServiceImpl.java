package com.Worldvision.core.services.Impl;

import com.Worldvision.core.models.DonarsData;
import com.Worldvision.core.services.DonarsListService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component(service = DonarsListService.class)
public class DonarsListServiceImpl implements DonarsListService {

    private static final String API_URL = "https://wvc-ccc-donar.azurewebsites.net/api/1.0.0/PaidDonors";

    @Override
    public List<DonarsData> getDonarsData() {
        List<DonarsData> donarsDataList = new ArrayList<>();

        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(API_URL);
            httpPost.setHeader("Content-Type", "application/json");

            JsonObject jsonPayload = new JsonObject();
            jsonPayload.addProperty("FundRaiserId", 1);
            jsonPayload.addProperty("CampaignId", 1);

            StringEntity requestEntity = new StringEntity(new Gson().toJson(jsonPayload));
            httpPost.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(httpPost);
            String responseBody = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);

            JsonObject responseObject = new Gson().fromJson(responseBody, JsonObject.class);
            JsonArray responseObjectArray = responseObject.getAsJsonArray("responseObject");

            for (int i = 0; i < responseObjectArray.size(); i++) {
                JsonObject donarObject = responseObjectArray.get(i).getAsJsonObject();
                DonarsData donarsData = new DonarsData();
                donarsData.setDonarName(donarObject.get("donarName").getAsString());
                donarsData.setActivityName(donarObject.get("activityName").getAsString());
                donarsData.setDonorAmount(donarObject.get("donorAmount").getAsDouble());
                String paidDateStr = donarObject.get("paidDate").getAsString();
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                SimpleDateFormat outputFormat = new SimpleDateFormat("EEEE, dd", Locale.US);
                try {
                    Date date = inputFormat.parse(paidDateStr);
                    donarsData.setPaidDate(outputFormat.format(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                donarsDataList.add(donarsData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return donarsDataList;
    }
}
