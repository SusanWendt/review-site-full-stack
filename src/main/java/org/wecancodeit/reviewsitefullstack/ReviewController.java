package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class ReviewController {
	
	@Resource
	private CategoryRepository catRepo;

	@Resource
	private ReviewRepository reviewRepo;
	
	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", catRepo.findAll());
		return "categoriesView";
	}
	
	@RequestMapping("/category")
	public String getSingleCategory(@RequestParam Long id, Model model) {
		Category category = catRepo.findOne(id);
		model.addAttribute("category", category); 
		model.addAttribute("reviews", reviewRepo.findByCategory(category));
		return "singleCategoryView";
	}
	
	@RequestMapping("/review")
	public String getSingleReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "reviewView";
	}
	
}
