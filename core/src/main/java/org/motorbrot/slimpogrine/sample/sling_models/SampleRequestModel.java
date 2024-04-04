package org.motorbrot.slimpogrine.sample.sling_models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class})
public class SampleRequestModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRequestModel.class);

    @SlingObject
    private ResourceResolver resourceResolver;

    public SampleRequestModel() {
        LOGGER.trace("Model Instance created");
    }

    /** @return User Name of the Current User **/
    public String getCurrentUser() {
        String answer = "No User";

        // Adapt to a session and get the current User ID.
        Session session = resourceResolver.adaptTo(Session.class);
        LOGGER.trace("Found Session from Resolver: '{}'", session);
        if(session != null) {
            answer = session.getUserID();
        }
        return answer;
    }
}
