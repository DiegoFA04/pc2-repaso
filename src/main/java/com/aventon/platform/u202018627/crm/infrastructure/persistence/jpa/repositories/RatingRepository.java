package com.aventon.platform.u202018627.crm.infrastructure.persistence.jpa.repositories;

import com.aventon.platform.u202018627.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.RatingAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findById(Long id);
    boolean existsByProductIdAndRatingAspectAndUserEmailAddress(ProductId productId, RatingAspect ratingAspect, EmailAdress userEmailAddress);}
