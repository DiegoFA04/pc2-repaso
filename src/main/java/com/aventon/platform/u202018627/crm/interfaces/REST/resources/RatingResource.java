package com.aventon.platform.u202018627.crm.interfaces.REST.resources;

import com.aventon.platform.u202018627.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.RatingAspect;

import java.util.Date;

public record RatingResource(Long id, Long productId, String userEmailAddress, Integer rating, RatingAspect ratingAspect, String comment, Date ratedAt) {
}
