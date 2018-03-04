package org.wecancodeit.reviewsitefullstack;

import static org.hamcrest.Matchers.contains;
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

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldSaveAndLoadCategory() {
		Category categoryUnderTest = new Category("Cat Type", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		long categoryId = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryId);
		assertThat(categoryUnderTest.getType(), is("Cat Type"));
	}

	@Test
	public void shouldSaveAndLoadReview() {
		Category categoryUnderTest = new Category("CategoryType", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review Name", "description", null, null, null, categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		long reviewIdUnderTest = reviewUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		reviewUnderTest = reviewRepo.findOne(reviewIdUnderTest);
		assertThat(reviewUnderTest.getName(), is("Review Name"));
	}

	@Test
	public void ShouldCallCategoryWithinReviewClass() {
		Category categoryUnderTest = new Category("Cat Type", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review", "description", null, null, null, categoryUnderTest, null);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		long reviewIdUnderTest = reviewUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		reviewUnderTest = reviewRepo.findOne(reviewIdUnderTest);
		assertThat(reviewUnderTest.getCategory().getType(), is("Cat Type"));
	}

	@Test
	public void CategoryShouldHaveMultipleReviews() {
		Category categoryUnderTest = new Category("CategoryType", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", null, null, null, categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", null, null, null, categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", null, null, null, categoryUnderTest);
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
		Category categoryUnderTest = new Category("CategoryType", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", null, null, null, categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", null, null, null,  categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", null, null, null, categoryUnderTest);
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
		Category categoryUnderTest = new Category("CategoryType", null, null);
		categoryUnderTest = catRepo.save(categoryUnderTest);
		Review reviewUnderTest = new Review("Review One", "description", null, null, null, categoryUnderTest);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		Review reviewUnderTest2 = new Review("Review Two", "description", null, null, null, categoryUnderTest);
		reviewUnderTest2 = reviewRepo.save(reviewUnderTest2);
		Review reviewUnderTest3 = new Review("Review Three", "description", null, null, null, categoryUnderTest);
		reviewUnderTest3 = reviewRepo.save(reviewUnderTest3);
		long categoryIdUnderTest = categoryUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		categoryUnderTest = catRepo.findOne(categoryIdUnderTest);
		Collection<Review> reviewsForCategoryId = reviewRepo.findByCategoryId(categoryIdUnderTest);
		assertThat(reviewsForCategoryId, containsInAnyOrder(reviewUnderTest, reviewUnderTest2, reviewUnderTest3));
	}
	
	@Test
	public void saveAndLoadTags() {
		Tag tagUnderTest = new Tag("TagWord");
		tagUnderTest = tagRepo.save(tagUnderTest);
		long tagId = tagUnderTest.getId();

		entityManager.flush();
		entityManager.clear();

		tagUnderTest = tagRepo.findOne(tagId);
		assertThat(tagUnderTest.getTagWord(), is("TagWord"));
	}
	
	@Test
	public void shouldSaveAndLoadTagsWithinReviews() {
		Tag tagUnderTest = new Tag("TagWord");
		tagUnderTest = tagRepo.save(tagUnderTest);
		Tag tagUnderTest2 = new Tag("TagWord");
		tagUnderTest2 = tagRepo.save(tagUnderTest2);
		Category category = new Category("CategoryType", null, null);
		category = catRepo.save(category);
		Review reviewUnderTest = new Review("Review One", "description", null, null, null, category, tagUnderTest, tagUnderTest2);
		reviewUnderTest = reviewRepo.save(reviewUnderTest);
		long reviewId = reviewUnderTest.getId(); 
		
		entityManager.flush();
		entityManager.clear();
		
		reviewUnderTest = reviewRepo.findOne(reviewId);
		assertThat(reviewUnderTest.getTags(), containsInAnyOrder(tagUnderTest, tagUnderTest2));
	}
	
	@Test
	public void ShouldCallTagWithinReview() {
		Category category = new Category("Cat Name", null, null);
		category = catRepo.save(category);
		Tag tag = new Tag("tag");
		tag = tagRepo.save(tag);
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		Review review = new Review("review", "description", null, null, null, category, tag, tag2);
		review = reviewRepo.save(review);
		long reviewId = review.getId();

		entityManager.flush();
		entityManager.clear();

		review = reviewRepo.findOne(reviewId);
		assertThat(review.getTags(), contains(tag, tag2));
	}

}
