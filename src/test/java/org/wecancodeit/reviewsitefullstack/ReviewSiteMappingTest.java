package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewSiteMappingTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private CategoryRepository catRepo;

	@Resource
	private ReviewRepository reviewRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category categoryUnderTest = new Category("Cat Type");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		long categoryId = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryId);
		assertThat(categoryUnderTest.getType(), is("Cat Type"));
	}

	@Test
	public void shouldSaveAndLoadReview() {
		Category categoryUnderTest = new Category("CategoryType");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review Name", "description", categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		long reviewIdUnderTest = reviewUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		reviewUnderTest = reviewRepo.findOne(reviewIdUnderTest);
		assertThat(reviewUnderTest.getName(), is("Review Name"));
	}

	@Test
	public void ShouldCallCategoryWithinReviewClass() {
		Category categoryUnderTest = new Category("Cat Type");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review", "description", categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		long reviewIdUnderTest = reviewUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		reviewUnderTest = reviewRepo.findOne(reviewIdUnderTest);
		assertThat(reviewUnderTest.getCategory().getType(), is("Cat Type"));
	}

	@Test
	public void CategoryShouldHaveMultipleReviews() {
		Category categoryUnderTest = new Category("CategoryType");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", categoryUnderTest);
		reviewUnderTest3 = reviewRepo.save(reviewUnderTest3);
		long categoryIdUnderTest = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryIdUnderTest);
		assertThat(categoryUnderTest.getReviews(),
				containsInAnyOrder(reviewUnderTest, reviewUnderTest2, reviewUnderTest3));
	}

	@Test
	public void ShouldFindReviewsByCategory() {
		Category categoryUnderTest = new Category("CategoryType");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", categoryUnderTest);
		reviewUnderTest3 = reviewRepo.save(reviewUnderTest3);
		long categoryIdUnderTest = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryIdUnderTest);
		Collection<Review> reviewsForCategory = reviewRepo.findByCategory(categoryUnderTest);
		assertThat(reviewsForCategory, containsInAnyOrder(reviewUnderTest, reviewUnderTest2, reviewUnderTest3));
	}

	@Test
	public void ShouldFindReviewsByCategoryId() {
		Category categoryUnderTest = new Category("CategoryType");
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", categoryUnderTest);
		reviewUnderTest3 = reviewRepo.save(reviewUnderTest3);
		long categoryIdUnderTest = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryIdUnderTest);
		Collection<Review> reviewsForCategoryId = reviewRepo.findByCategoryId(categoryIdUnderTest);
		assertThat(reviewsForCategoryId, containsInAnyOrder(reviewUnderTest, reviewUnderTest2, reviewUnderTest3));
	}

}
