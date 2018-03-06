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
		Tag highCost = new Tag("High Cost");
		highCost = tagRepo.save(highCost);

		Tag lowCost = new Tag("lowCost");
		lowCost = tagRepo.save(lowCost);

		Tag hiit = new Tag("High Intensity Interval Training");
		hiit = tagRepo.save(hiit);

		Tag lowImpact = new Tag("Low Impact");
		lowImpact = tagRepo.save(lowImpact);

		// reviews

		Review yohi = new Review("Yoga on High", "./images/yohi.jpg", "http://yogaonhigh.com/",
				"https://www.instagram.com/yogaonhigh/",
				"This yoga studio is where I did my teacher training. "
						+ "It has three different locations and is the most comprehensive studio in Columbus, "
						+ "offering Vinyasa, Hatha, Ashtanga, Mysore, Restorative, Maternity, Kids yoga, free community yoga, and many more.",
				categoryYoga, lowImpact, highCost);
		yohi = reviewRepo.save(yohi);

		Review corePower = new Review("CorePower Yoga", "./images/corePower.jpg", "https://www.corepoweryoga.com/",
				"https://www.instagram.com/corepoweryoga/", "Description", categoryYoga, lowImpact, hiit, highCost);
		corePower = reviewRepo.save(corePower);

		Review barreThree = new Review("Barre3", "./images/barre3.png", "https://barre3.com/",
				"https://www.instagram.com/barre3/",
				"Barre3 incorporates cardio and weights throughout the workout to give you a total body workout. ",
				categoryBarre, hiit, highCost);
		barreThree = reviewRepo.save(barreThree);

		Review butcherShop = new Review("The ButcherShop Fitness", "./images/lagree.jpg",
				"https://www.butchershopfitness.com/", "https://www.instagram.com/lagreefitness/",
				"Similar to barre, this workout targets muscles you've never worked before.", categoryPilates, highCost);
		butcherShop = reviewRepo.save(butcherShop);

		Review sos = new Review("System of Strength", "./images/sos.jpg", "https://systemofstrength.com/",
				"https://www.instagram.com/systemofstrength/", "Various workout classes that range from HIIT to Yoga.", categoryMix,
				highCost);
		sos = reviewRepo.save(sos);

	}
}
