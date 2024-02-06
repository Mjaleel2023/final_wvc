package com.Worldvision.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LiveDonationModel {

	@ValueMapValue
	private String image;

	@ValueMapValue
	private int goal;

	public int getGoal() {
		return goal;
	}

	public String getImage() {
		return image;
	}
}
