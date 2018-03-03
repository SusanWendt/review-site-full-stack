package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	CategoryRepository catRepo;

	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category categoryYoga = new Category("Yoga");
		categoryYoga = catRepo.save(categoryYoga);
		
		Category categoryBarre = new Category("Barre");
		categoryBarre = catRepo.save(categoryBarre);
		
		Category categoryPilates = new Category("Pilates");
		categoryPilates = catRepo.save(categoryPilates);
		
		Category categoryMix = new Category("Mix");
		categoryMix = catRepo.save(categoryMix);
		
		Tag tag1 = new Tag("tag1");
		tag1 = tagRepo.save(tag1);
		
		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);
		
		Review reviewYoga1 = new Review("Yoga1", "Great time", categoryYoga, tag1, tag2);
		reviewYoga1 = reviewRepo.save(reviewYoga1);
		
		Review reviewYoga2 = new Review("Yoga2", "excellent", categoryYoga);
		reviewYoga2 = reviewRepo.save(reviewYoga2);
		
		Review reviewBarre1 = new Review("Barre1", "excellent", categoryBarre);
		reviewBarre1 = reviewRepo.save(reviewBarre1);
		
		Review reviewPilates1 = new Review("Pilates1", "excellent", categoryPilates);
		reviewPilates1 = reviewRepo.save(reviewPilates1);
		
		Review reviewMix1 = new Review("mix1", "excellent", categoryMix);
		reviewMix1 = reviewRepo.save(reviewMix1);
	}
}
