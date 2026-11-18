package de.rieckpil.courses.book.review;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * <a href="https://www.geeksforgeeks.org/springboot/spring-boot-mockmvc-example/">Spring Boot MockMVC Example</a>
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReviewControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ReviewService reviewService;

  @BeforeEach
  void setUp() {
  }

  @Test
  void givenAuthenticatedUserWithValidPayload_whenCreateNewBookReview_thenHappy() {
    String requestBody = """
      {
      "reviewTitle" : "Great Java Book!",
      "reviewContent" : "I really like this book!",
      "rating" : 4
      }
      """;

    when(reviewService.createBookReview("42", any(BookReviewRequest.class), "duek", "spring.io")).thenReturn(42L);

//    this.mockMvc.perform(post("/api/books/{isbn}/reviews", 42)
//      .contentType(MediaType.APPLICATION_JSON).content(requestBody)
//      with(jwt());
//
  }
}
