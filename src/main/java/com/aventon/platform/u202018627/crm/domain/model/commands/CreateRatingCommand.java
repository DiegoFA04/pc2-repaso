package com.aventon.platform.u202018627.crm.domain.model.commands;

import com.aventon.platform.u202018627.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.RatingAspect;

import java.util.Date;
/**
 * Command to create a new rating.
 *
 * @param productId the product ID
 * @param userEmailAddress the user's email address
 * @param rating the rating value (1-5)
 * @param ratingAspect the aspect of the rating
 * @param comment the comment for the rating
 * @param ratedAt the date the rating was made
 * @throws IllegalArgumentException if the rating is not between 1 and 5
 *
 * @since 1.0.0
 */
public record CreateRatingCommand(Long productId, String userEmailAddress, Integer rating, RatingAspect ratingAspect, String comment) {
    public CreateRatingCommand {
        if (rating == null || rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be an integer between 1 and 5");
        }
    }
}
