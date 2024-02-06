package com.Worldvision.core.models;

import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.annotation.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DynamicFundRaiserComponent {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String maximumfunds;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getMaximumfunds() {
        return maximumfunds;
    }

}
