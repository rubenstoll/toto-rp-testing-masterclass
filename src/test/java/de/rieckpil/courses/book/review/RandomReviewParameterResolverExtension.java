package de.rieckpil.courses.book.review;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomReviewParameterResolverExtension implements ParameterResolver {

    private static final List<String> badReviews = List.of("one", "two ", "three", "Lorem ipsum", "I I I I I", "x x x x x x x x x x x x shit");

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(RandomReview.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return badReviews.get(ThreadLocalRandom.current().nextInt(0, badReviews.size()));
    }
}
