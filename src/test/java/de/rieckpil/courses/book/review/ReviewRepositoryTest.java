package de.rieckpil.courses.book.review;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(properties = {
  "springflyway.enabled=false",
  "spring.jpa.hibernate.ddl-auto=create-drop",
  "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE",
  "spring.datasource.driverClassName=org.h2.Driver",
  "spring.datasource.username=sa",
  "spring.datasource.password=password"
})
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
    assertThat(dataSource).isNotNull();
    assertThat(testEntityManager).isNotNull();
  }

}
