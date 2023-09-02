package com.amadeus.ikramdagci.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = FlightArrivalNotBeforeDepartureValidator.class)
@Target({ TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FlightArrivalNotBeforeDeparture {
    String message() default "The flight's arrival date must not be before the departure date.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
