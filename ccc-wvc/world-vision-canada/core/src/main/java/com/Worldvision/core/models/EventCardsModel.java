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
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = { SlingHttpServletRequest.class,
        Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EventCardsModel {

    private static final Logger log = LoggerFactory.getLogger(EventCardsModel.class);

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private List<EventCardsMultifieldDropdown> options;

    @ChildResource(name = "multifield")
    private Resource multifield;

    public Resource getMultifield() {
        return multifield;
    }

    public final List<EventCardsMultifieldDropdown> getMultifields() {
        return this.options;
    }

    @PostConstruct
    protected final void init() {

        options = new ArrayList<>();
        if (multifield != null) {
            Iterator<Resource> iterator = multifield.listChildren();
            while (iterator.hasNext()) {
                Resource child = iterator.next();
                EventCardsMultifieldDropdown yourCalendarMultifieldDropdown = child
                        .adaptTo(EventCardsMultifieldDropdown.class);
                options.add(yourCalendarMultifieldDropdown);
            }
        }

        log.debug("Initialization completed for ImgMultiSectionIterator");
    }
}
