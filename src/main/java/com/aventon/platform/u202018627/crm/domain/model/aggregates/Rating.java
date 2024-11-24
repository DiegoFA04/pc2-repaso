package com.aventon.platform.u202018627.crm.domain.model.aggregates;

import com.aventon.platform.u202018627.crm.domain.model.commands.CreateRatingCommand;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.EmailAdress;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.ProductId;
import com.aventon.platform.u202018627.crm.domain.model.valueobjects.RatingAspect;
import com.aventon.platform.u202018627.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
/**
 * Aggregate root representing a rating.
 *
 * @since 1.0.0
 */
@Getter
@Entity
public class Rating extends AuditableAbstractAggregateRoot<Rating> {
    @Embedded
    private ProductId productId;
    @Embedded
    private EmailAdress userEmailAddress;
    private Integer rating;
    private RatingAspect ratingAspect;
    // Max 3600 characters
    @Size(max = 360)
    private String comment;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date ratedAt;
    /**
     * Default constructor for Rating.
     */
    public Rating(){
        this.productId = new ProductId(0L);
        this.userEmailAddress = new EmailAdress("");
        this.rating = 0;
        this.ratingAspect = RatingAspect.EASE_OF_USE;
    }
    /**
     * Constructs a Rating with the given parameters.
     *
     * @param productId the product ID
     * @param userEmailAddress the user's email address
     * @param rating the rating value
     * @param ratingAspect the aspect of the rating
     * @param comment the comment for the rating
     * @param ratedAt the date the rating was made
     */
    public Rating(Long productId, String userEmailAddress, Integer rating, RatingAspect ratingAspect, String comment) {
        this();
        this.productId = new ProductId(productId);
        this.userEmailAddress = new EmailAdress(userEmailAddress);
        this.rating = rating;
        this.ratingAspect = ratingAspect;
        this.comment = comment;
        //this.ratedAt = ratedAt;
    }
    /**
     * Constructs a Rating from a CreateRatingCommand.
     *
     * @param command the create rating command
     */
    public Rating(CreateRatingCommand command) {
        this();
        this.productId = new ProductId(command.productId());
        this.userEmailAddress = new EmailAdress(command.userEmailAddress());
        this.rating = command.rating();
        this.ratingAspect = command.ratingAspect();
        this.comment = command.comment();
        //this.ratedAt = command.ratedAt();
    }
}
