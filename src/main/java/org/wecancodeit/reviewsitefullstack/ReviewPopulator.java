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

		//categories
		Category categoryYoga = new Category("Yoga", "description of Yoga category... ", "./images/dogYoga.jpg");
		categoryYoga = catRepo.save(categoryYoga);

		Category categoryBarre = new Category("Barre", "description of Barre category... ", "./images/dogYoga.jpg");
		categoryBarre = catRepo.save(categoryBarre);

		Category categoryPilates = new Category("Pilates", "description of Pilates category... ", "./images/dogYoga.jpg");
		categoryPilates = catRepo.save(categoryPilates);

		Category categoryMix = new Category("Mixed Workout", "description of Mix category... ", "./images/dogYoga.jpg");
		categoryMix = catRepo.save(categoryMix);

		//tags
		Tag tag1 = new Tag("tag1");
		tag1 = tagRepo.save(tag1);

		Tag tag2 = new Tag("tag2");
		tag2 = tagRepo.save(tag2);

		Tag tag3 = new Tag("tag3");
		tag3 = tagRepo.save(tag3);

		Tag tag4 = new Tag("tag4");
		tag4 = tagRepo.save(tag4);

		
		//reviews
		Review reviewYoga1 = new Review("Yoga1", "imageURL", "websiteink", "instalink", "description", categoryYoga,
				tag1, tag2);
		reviewYoga1 = reviewRepo.save(reviewYoga1);

		Review reviewYoga2 = new Review("Yoga2", "imageURL", "websiteink", "instalink", "description", categoryYoga,
				tag1);
		reviewYoga2 = reviewRepo.save(reviewYoga2);

		Review reviewBarre1 = new Review("Barre1", "imageURL", "websiteink", "instalink", "description", categoryBarre,
				tag3, tag4);
		reviewBarre1 = reviewRepo.save(reviewBarre1);

		Review reviewPilates1 = new Review("Pilates1", "imageURL", "websiteink", "instalink", "description",
				categoryPilates, tag3);
		reviewPilates1 = reviewRepo.save(reviewPilates1);

		Review reviewMix1 = new Review("mix1", "imageURL", "websiteink", "instalink", "description", categoryMix, tag4,
				tag2);
		reviewMix1 = reviewRepo.save(reviewMix1);

		Review yohi = new Review("Yoga on High", "./images/yohi.jpg", "http://yogaonhigh.com/",
				"https://www.instagram.com/yogaonhigh/",
				"This yoga studio is where I did my teacher training. "
						+ "It has three different locations and is the most comprehensive studio in Columbus, "
						+ "offering Vinyasa, Hatha, Ashtanga, Mysore, Restorative, Maternity, Kids yoga, free community yoga, and many more.",
				categoryYoga, tag1);
		yohi = reviewRepo.save(yohi);

		Review corePower = new Review("CorePower Yoga", "./images/corePower.jpg", "https://www.corepoweryoga.com/",
				"https://www.instagram.com/corepoweryoga/?hl=en", "Description", categoryYoga, tag4);
		corePower = reviewRepo.save(corePower);
		
		Review barreThree = new Review("Barre3", "./barre3.png", "https://barre3.com/", "https://www.instagram.com/",
				"Barre3 incorporates cardio and weights throughout the workout to give you a total body workout. "
				+ " Not only that, but it targets muscles you never knew you had.  "
				+ "Unlike a lot of workouts, barre3 has modifications for every move, so if you have a bad knee or back there will be a "
				+ "modification to alleviate the pain and make each posture work for you. "
				+ "I've never been in better shape, and a lot of that has to do with barre3.", categoryBarre, tag2);
		barreThree = reviewRepo.save(barreThree);
		
		Review butcherShop = new Review("The ButcherShop Fitness", "./lagree.jpg", "https://www.butchershopfitness.com/", "https://www.instagram.com/",
				"Similar to barre, this workout targets muscles you've never worked before. "
				+ "And a big reason for that is due to the machine's design. "
				+ "Each workout is 50 minutes (or 40 if you are doing the ab class), and consists of slow, controlled movements. "
				+ "For instance, you'll be in a pike to plank, and instead of trying to do as many as you can, the goal is to go as slow as you can. "
				+ "This is A LOT harder. This workout is so hard that you will need to take a break, "
				+ "and I don't mean the classic break during a workout where it's mostly in your head. "
				+ "I mean these moves are so challenging and target muscles you rarely use that you will need to take breaks. "
				+ "However, as I've continued to go, I've noticed I'm getting stronger, and am taking fewer breaks.", categoryPilates, tag3);
		butcherShop = reviewRepo.save(butcherShop);
		
//		Review sos = new Review("System of Strength", "Various workout classes that range from HIIT to yoga",
//				"sos.jpg", "https://systemofstrength.com/", "Fitness",
//				"What I like about system is the variety of classes you can take. They have classes that span from hot yoga, to weight training, to bootcamp/obstacle courses. There is something for everyone. The workouts I've done incorporated weight training and cardio, which you don't realize you don't need to run or bike a mile to get great cardio. After each workout, I felt stronger, sweatier, and ready to tackle my daily to-do list.");

	}
}
