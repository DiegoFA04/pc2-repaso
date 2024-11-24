package com.aventon.platform.u202018627.crm.interfaces.REST.transform;

import com.aventon.platform.u202018627.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202018627.crm.interfaces.REST.resources.RatingResource;

public class RatingResourceFromEntityAssembler {
    public static RatingResource toResourceFromEntity(Rating rating) {
        return new RatingResource(rating.getId(), rating.getProductId().productId(), rating.getUserEmailAddress().email(), rating.getRating(), rating.getRatingAspect(), rating.getComment(), rating.getRatedAt());
    }
}
