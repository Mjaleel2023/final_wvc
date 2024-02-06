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

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImgMultiSectionIterator {

    private static final Logger log = LoggerFactory.getLogger(ImgMultiSectionIterator.class);

    // List to hold ImgMultiSection objects
    private List<ImgMultiSection> options;

    // Child resource named "multifield"
    @ChildResource(name = "multifield")
    private Resource multifield;

    // Getter for multifield
    public Resource getMultifield() {
        return multifield;
    }

    // Getter for the list of ImgMultiSection objects
    public final List<ImgMultiSection> getMultifields() {
        return this.options;
    }

    // PostConstruct method to initialize the options list
    @PostConstruct
    protected final void init() {
        // Initialize the list
        options = new ArrayList<>();

        // Check if multifield is not null
        if (multifield != null) {
            // Iterate over children of multifield
            Iterator<Resource> iterator = multifield.listChildren();
            while (iterator.hasNext()) {
                // Get the child resource
                Resource child = iterator.next();

                // Adapt child resource to ImgMultiSection class
                ImgMultiSection imgmultisection = child.adaptTo(ImgMultiSection.class);

                // Add ImgMultiSection object to the list
                options.add(imgmultisection);
            }
        }

        // Log a debug statement
        log.debug("Initialization completed for ImgMultiSectionIterator");
    }
}
