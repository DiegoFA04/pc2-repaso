package com.aventon.platform.u202018627.crm.application.commandservices;

import com.aventon.platform.u202018627.crm.domain.model.aggregates.Rating;
import com.aventon.platform.u202018627.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202018627.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202018627.crm.infrastructure.persistence.jpa.repositories.RatingRepository;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling rating commands.
 *
 * @since 1.0.0
 */
@Service
public class RatingCommandServiceImpl implements RatingCommandService {
    private final RatingRepository ratingRepository;

    /**
     * Constructs a RatingCommandServiceImpl with the given RatingRepository.
     *
     * @param ratingRepository the rating repository
     */
    public RatingCommandServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /**
     * Handles the creation of a new rating.
     *
     * @param command the create rating command
     * @return the ID of the created rating
     * @throws IllegalArgumentException if a rating with the same product ID, rating aspect, and user email address already exists or if there is an error saving the rating
     */
    @Override
    public Long handle(CreateRatingCommand command) {
        ProductId productId = new ProductId(command.productId());
        EmailAdress emailAdress = new EmailAdress(command.userEmailAddress());

        if (ratingRepository.existsByProductIdAndRatingAspectAndUserEmailAddress(
                productId, command.ratingAspect(), emailAdress)) {
            throw new IllegalArgumentException("Rating with product id, rating aspect, and user email address already exists");
        }

        var rating = new Rating(productId.productId(), emailAdress.email(), command.rating(), command.ratingAspect(), command.comment());
        try {
            ratingRepository.save(rating);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving rating: " + e.getMessage());
        }
        return rating.getId();
    }
}