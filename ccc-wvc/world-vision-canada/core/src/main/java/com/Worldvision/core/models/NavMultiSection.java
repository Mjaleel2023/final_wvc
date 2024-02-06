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
 * Sling Model representing the NavMultiSection component.
 * This model is adaptable to SlingHttpServletRequest and Resource.
 * It uses OPTIONAL injection strategy by default.
 */
@Model(adaptables = { SlingHttpServletRequest.class, Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavMultiSection {

    private static final Logger log = LoggerFactory.getLogger(NavMultiSection.class);

    // ValueMapValue annotations for injecting properties from the resource's ValueMap.

    /**
     * Injected property for the title of the NavMultiSection.
     */
    @ValueMapValue(name = "title", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    /**
     * Injected property for the URL of the call-to-action button in the NavMultiSection.
     */
    @ValueMapValue(name = "ctaurl", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaurl;

    /**
     * Injected property indicating whether to open the link in a new window.
     */
    @ValueMapValue(name = "newwindow", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String newwindow;

    /**
     * Getter method for the new window property.
     *
     * @return The value of the new window property.
     */
    public String getNewwindow() {
        return newwindow;
    }

    /**
     * Getter method for the title property.
     *
     * @return The value of the title property.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter method for the CTA URL property.
     *
     * @return The value of the CTA URL property.
     */
    public String getCtaurl() {
        return ctaurl;
    }

    /**
     * PostConstruct method called after the model is constructed.
     * It logs a debug message indicating the initialization of the pricing matrix model.
     */
    @PostConstruct
    protected final void init() {
        log.debug("NavMultiSection model initialized.");
    }
}
