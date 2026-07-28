package de.rieckpil.courses.book.review;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target(PARAMETER)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})

 public @interface RandomReview {}
