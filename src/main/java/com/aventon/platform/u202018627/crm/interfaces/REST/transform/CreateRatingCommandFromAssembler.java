package com.aventon.platform.u202018627.crm.interfaces.REST.transform;

import com.aventon.platform.u202018627.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202018627.crm.interfaces.REST.resources.CreateRatingResource;

public class CreateRatingCommandFromAssembler {
    public static CreateRatingCommand toCommandFromResource(Long productId,CreateRatingResource resource) {
        return new CreateRatingCommand(productId, resource.userEmailAddress(), resource.rating(), resource.ratingAspect(), resource.comment());
    }
}
