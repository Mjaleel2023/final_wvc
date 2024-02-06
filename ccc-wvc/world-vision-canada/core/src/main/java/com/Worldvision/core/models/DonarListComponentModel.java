package com.Worldvision.core.models;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.Worldvision.core.services.DonarsListService;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
        
public class DonarListComponentModel {
        @Inject
    private DonarsListService donarsService;
    private List<DonarsData> donarsDataList;
        @PostConstruct
    protected void init() {
        donarsDataList = donarsService.getDonarsData();
    }
    public List<DonarsData> getDonarsDataList() {
        return donarsDataList;
    }
    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

}
