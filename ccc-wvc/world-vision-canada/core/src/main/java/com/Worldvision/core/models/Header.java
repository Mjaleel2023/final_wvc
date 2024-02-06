package com.Worldvision.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sling Model class representing the Header component.
 * This class is used to map properties from the underlying resource.
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {

    private static final Logger log = LoggerFactory.getLogger(Header.class);

    // Injecting the 'logo' property from the resource
    @Inject
    private String logo;

    // Injecting the 'logoalt' property from the resource
    @Inject
    private String logoalt;

    // Injecting the 'logourl' property from the resource
    @Inject
    private String logourl;

    // Injecting the 'newwindow' property from the resource
    @Inject
    private String newwindow;

    /**
     * Get the value of the 'newwindow' property.
     * @return The value of the 'newwindow' property.
     */
    public String getNewwindow() {
        return newwindow;
    }

    /**
     * Get the value of the 'logourl' property.
     * @return The value of the 'logourl' property.
     */
    public String getLogourl() {
        return logourl;
    }

    /**
     * Get the value of the 'logoalt' property.
     * @return The value of the 'logoalt' property.
     */
    public String getLogoalt() {
        return logoalt;
    }

    /**
     * Get the value of the 'logo' property.
     * @return The value of the 'logo' property.
     */
    public String getLogo() {
        return logo;
    }

}
