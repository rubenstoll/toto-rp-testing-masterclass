package de.rieckpil.courses.book.review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(RandomReviewParameterResolverExtension.class)
class ReviewVerifierTest {

  private ReviewVerifier reviewVerifier;

//    @RandomReview
//    String review;

  @BeforeEach
  void setUp() {
    reviewVerifier = new ReviewVerifier();

  }

  @RepeatedTest(5)
  void givenBadReview_whenReview_thenFail(@RandomReview String review) {
//        boolean result = reviewVerifier.doesMeetQualityStandards(review, @NonNull String userId );
    boolean result = reviewVerifier.doesMeetQualityStandards(review);
    assertThat(result).withFailMessage("ReviewVerifier did not detect random bad review").isFalse();
  }
}
