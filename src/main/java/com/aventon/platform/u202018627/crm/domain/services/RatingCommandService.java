package com.aventon.platform.u202018627.crm.domain.services;

import com.aventon.platform.u202018627.crm.domain.model.commands.CreateRatingCommand;

public interface RatingCommandService {
    Long handle(CreateRatingCommand command);
}
