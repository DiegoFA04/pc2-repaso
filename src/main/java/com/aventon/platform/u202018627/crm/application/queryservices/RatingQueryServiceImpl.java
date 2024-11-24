package com.aventon.platform.u202018627.crm.application.queryservices;

import com.aventon.platform.u202018627.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202018627.crm.domain.model.queries.GetAllRatingQuery;
import com.aventon.platform.u202018627.crm.domain.model.queries.GetRatingByIdQuery;
import com.aventon.platform.u202018627.crm.domain.services.RatingQueryService;
import com.aventon.platform.u202018627.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingQueryServiceImpl implements RatingQueryService {
    private final RatingRepository ratingRepository;

    public RatingQueryServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Optional<Rating> handle(GetRatingByIdQuery query) {
        return ratingRepository.findById(query.id());
    }

    @Override
    public List<Rating> handle(GetAllRatingQuery query) {
        return ratingRepository.findAll();
    }
}
