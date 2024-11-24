package com.aventon.platform.u202018627.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


@Embeddable
public record ProductId(Long productId) {
    public ProductId {
        if (productId == null) {
            throw new IllegalArgumentException("Product id cannot be null");
        }
    }
    public ProductId(){this(0L);}
}