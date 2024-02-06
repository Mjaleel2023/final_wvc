package com.Worldvision.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sling Model representing an iterator for a multi-section navigation component.
 * This class is responsible for iterating over child resources and adapting them
 * to NavMultiSection instances.
 */
@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavMultiSectionIterator {

    private static final Logger log = LoggerFactory.getLogger(NavMultiSectionIterator.class);

    // List to store the adapted NavMultiSection instances
    private List<NavMultiSection> options;

    // Child resource representing the "navmultifield" resource
    @ChildResource(name = "navmultifield")
    private Resource navmultifield;

    /**
     * Getter for the "navmultifield" resource.
     *
     * @return The "navmultifield" resource.
     */
    public Resource getNavmultifield() {
        return navmultifield;
    }

    /**
     * Getter for the list of adapted NavMultiSection instances.
     *
     * @return List of NavMultiSection instances.
     */
    public final List<NavMultiSection> getMultifields() {
        return this.options;
    }

    /**
     * PostConstruct method to initialize the Sling Model.
     * This method populates the options list by adapting child resources to NavMultiSection instances.
     */
    @PostConstruct
    protected final void init() {
        options = new ArrayList<>();

        // Check if the "navmultifield" resource is not null
        if (navmultifield != null) {
            // Iterate over child resources of "navmultifield"
            Iterator<Resource> iterator = navmultifield.listChildren();

            while (iterator.hasNext()) {
                Resource child = iterator.next();
                // Adapt each child resource to NavMultiSection and add it to the options list
                NavMultiSection navmultisection = child.adaptTo(NavMultiSection.class);
                options.add(navmultisection);
            }
        }

        log.debug("Initialized NavMultiSectionIterator");
    }
}
