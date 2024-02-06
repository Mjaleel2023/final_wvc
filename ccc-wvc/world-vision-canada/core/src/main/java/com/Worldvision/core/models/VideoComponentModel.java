package com.Worldvision.core.models;

import javax.annotation.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class VideoComponentModel {

    @ValueMapValue
    private String videourl;

    @ValueMapValue
    private String image;

    public String getVideourl() {
        return videourl;
    }

    public String getImage() {
        return image;
    }

}
