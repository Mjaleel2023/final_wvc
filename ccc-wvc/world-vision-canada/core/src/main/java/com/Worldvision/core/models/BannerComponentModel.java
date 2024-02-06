package com.Worldvision.core.models;
import java.util.Calendar;
import javax.annotation.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class, Resource.class },
  defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerComponentModel {

    @ValueMapValue
    private Calendar startdate;

    @ValueMapValue
    private Calendar enddate;
    
    @ValueMapValue
    private String image;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    
    public Calendar getStartdate() {
        return startdate;
    }

    public Calendar getEnddate() {
        return enddate;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}


