package com.aventon.platform.u202018627.crm.domain.services;

import com.aventon.platform.u202018627.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202018627.crm.domain.model.queries.GetAllRatingQuery;
import com.aventon.platform.u202018627.crm.domain.model.queries.GetRatingByIdQuery;

import java.util.List;
import java.util.Optional;

public interface RatingQueryService {
    Optional<Rating> handle(GetRatingByIdQuery query);
    List<Rating> handle(GetAllRatingQuery query);
}
