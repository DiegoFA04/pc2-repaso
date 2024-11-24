package com.aventon.platform.u202018627.crm.interfaces.REST;

import com.aventon.platform.u202018627.crm.domain.model.queries.GetAllRatingQuery;
import com.aventon.platform.u202018627.crm.domain.model.queries.GetRatingByIdQuery;
import com.aventon.platform.u202018627.crm.domain.services.RatingCommandService;
import com.aventon.platform.u202018627.crm.domain.services.RatingQueryService;
import com.aventon.platform.u202018627.crm.interfaces.REST.resources.CreateRatingResource;
import com.aventon.platform.u202018627.crm.interfaces.REST.resources.RatingResource;
import com.aventon.platform.u202018627.crm.interfaces.REST.transform.CreateRatingCommandFromAssembler;
import com.aventon.platform.u202018627.crm.interfaces.REST.transform.RatingResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/products/{productId}/ratings", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Rating", description = "Rating Management Endpoints")
public class RatingController {
    private final RatingCommandService ratingCommandService;
    private final RatingQueryService ratingQueryService;

    public RatingController(RatingCommandService ratingCommandService, RatingQueryService ratingQueryService) {
        this.ratingCommandService = ratingCommandService;
        this.ratingQueryService = ratingQueryService;
    }

    @PostMapping
    public ResponseEntity<RatingResource> createRating(@PathVariable Long productId,@RequestBody CreateRatingResource createRatingResource){
        var createRatingCommand = CreateRatingCommandFromAssembler.toCommandFromResource(productId,createRatingResource);
        var ratingId = ratingCommandService.handle(createRatingCommand);
        if(ratingId == null){
            return ResponseEntity.badRequest().build();
        }
        var getRatingByIdQuery = new GetRatingByIdQuery(ratingId);
        var rating = ratingQueryService.handle(getRatingByIdQuery);
        if(rating.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var ratingResource = RatingResourceFromEntityAssembler.toResourceFromEntity(rating.get());
        return new ResponseEntity<>(ratingResource, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RatingResource>> getAllRating(){
        var getAllRatingQuery = new GetAllRatingQuery();
        var rating = ratingQueryService.handle(getAllRatingQuery);
        var ratingResource = rating.stream().map(RatingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ratingResource);
    }
}
