package de.rieckpil.courses.book.review;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@DataJpaTest(properties = {
  "spring.flyway.enabled=false",
  "spring.jpa.hibernate.ddl-auto=create-drop",
//  "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
//  "spring.datasource.driverClassName=org.h2.Driver",
  "spring.datasource.driverClassName=com.p6spy.engine.spy.P6SpyDriver", // P6Spy
  "spring.datasource.url=jdbc:p6spy:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"
//  "spring.datasource.username=sa",
//  "spring.datasource.password="
})
// do not create embedded DB, let p6spy create it
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReviewRepositoryTest {
  @Autowired
  private EntityManager entityManager;
  @Autowired
  private ReviewRepository reviewRepository;
  @Autowired
  private DataSource dataSource;
  @Autowired
  private TestEntityManager testEntityManager;

  @BeforeEach
  void setUp() {
    // Set up test data in the database
    assertThat(reviewRepository.count()).isEqualTo(0L);

  }

  @Test
  void testSaveReview() {
    assertThat(entityManager).isNotNull();
    assertThat(reviewRepository).isNotNull();
    assertThat(testEntityManager).isNotNull();
    assertThat(dataSource).isNotNull();
  }

  @Test
  void givenNewReview_whenSave_thenP6SpyLog() {
    Review review = new Review();
    review.setContent("Duke");
    review.setRating(5);
    review.setTitle("Review 101");
    review.setCreatedAt(LocalDateTime.now());
    review.setBook(null);
    review.setUser(null);

    var result = reviewRepository.save(review);
    System.out.println(result);
    assertThat(result.getId()).isNotNull();
  }
}
