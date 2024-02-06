package com.Worldvision.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
        
public class EventCardsMultifieldDropdown {

    private static final Logger log = LoggerFactory.getLogger(EventCardsMultifieldDropdown.class);

    @ValueMapValue(name = "image", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;

    @ValueMapValue(name = "atitle", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String atitle;

    @ValueMapValue(name = "adescription", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String adescription;

    @ValueMapValue(name = "day", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String day;

    public String getAtitle() {
        return atitle;
    }

    public String getAdescription() {
        return adescription;
    }

    public String getDay() {
        return day;
    }
    public String getImage() {
        return image;
    }

    @PostConstruct
    protected final void init() {
        log.debug("ImgMultiSection model initialized");
    }

}
