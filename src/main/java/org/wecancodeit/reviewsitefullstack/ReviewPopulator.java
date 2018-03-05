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

		// categories
		Category categoryYoga = new Category("Yoga", "description of Yoga category... ", "./images/dogYoga.jpg");
		categoryYoga = catRepo.save(categoryYoga);

		Category categoryBarre = new Category("Barre", "description of Barre category... ", "./images/barre.jpg");
		categoryBarre = catRepo.save(categoryBarre);

		Category categoryPilates = new Category("Pilates", "description of Pilates category... ",
				"./images/pilates.jpg");
		categoryPilates = catRepo.save(categoryPilates);

		Category categoryMix = new Category("Mixed Workout", "description of Mix category... ", "./images/mix.jpg");
		categoryMix = catRepo.save(categoryMix);

		// tags
		Tag tag1 = new Tag("tag1");
		tag1 = tagRepo.save(tag1);

		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);

		Tag tag3 = new Tag("tag3");
		tag3 = tagRepo.save(tag3);

		Tag tag4 = new Tag("tag4");
		tag4 = tagRepo.save(tag4);

		// reviews

		Review yohi = new Review("Yoga on High", "./images/yohi.jpg", "http://yogaonhigh.com/",
				"https://www.instagram.com/yogaonhigh/",
				"This yoga studio is where I did my teacher training. "
						+ "It has three different locations and is the most comprehensive studio in Columbus, "
						+ "offering Vinyasa, Hatha, Ashtanga, Mysore, Restorative, Maternity, Kids yoga, free community yoga, and many more.",
				categoryYoga, tag1);
		yohi = reviewRepo.save(yohi);

		Review corePower = new Review("CorePower Yoga", "./images/corePower.jpg", "https://www.corepoweryoga.com/",
				"https://www.instagram.com/corepoweryoga/", "Description", categoryYoga, tag4);
		corePower = reviewRepo.save(corePower);

		Review barreThree = new Review("Barre3", "./images/barre3.png", "https://barre3.com/",
				"https://www.instagram.com/barre3/",
				"Barre3 incorporates cardio and weights throughout the workout to give you a total body workout. ",
				categoryBarre, tag2);
		barreThree = reviewRepo.save(barreThree);

		Review butcherShop = new Review("The ButcherShop Fitness", "./images/lagree.jpg",
				"https://www.butchershopfitness.com/", "https://www.instagram.com/lagreefitness/",
				"Similar to barre, this workout targets muscles you've never worked before.", categoryPilates, tag3);
		butcherShop = reviewRepo.save(butcherShop);

		Review sos = new Review("System of Strength", "./images/sos.jpg", "https://systemofstrength.com/",
				"https://www.instagram.com/systemofstrength/", "Various workout classes that range from HIIT to Yoga.", categoryMix,
				tag4);
		sos = reviewRepo.save(sos);

	}
}
