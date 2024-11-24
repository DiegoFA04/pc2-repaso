package com.aventon.platform.u202018627.crm.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Embeddable
public record EmailAdress(@Email @Column(length = 50) String email) {
    public EmailAdress() {
        this(null);
    }
}