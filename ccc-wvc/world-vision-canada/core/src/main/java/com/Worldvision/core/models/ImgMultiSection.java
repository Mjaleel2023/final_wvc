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

/**
 * Sling Model representing an Image Multi Section.
 */
@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImgMultiSection {

    private static final Logger log = LoggerFactory.getLogger(ImgMultiSection.class);

    @ValueMapValue(name = "image", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;

    /**
     * Getter method for the image property.
     *
     * @return The value of the image property.
     */
    public String getImage() {
        return image;
    }

    /**
     * Post-construction method executed after the model is instantiated.
     * It initializes the object and logs a debug message.
     */
    @PostConstruct
    protected final void init() {
        log.debug("ImgMultiSection model initialized");
    }

}
