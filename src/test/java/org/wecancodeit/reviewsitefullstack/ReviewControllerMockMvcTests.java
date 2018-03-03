package org.wecancodeit.reviewsitefullstack;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTests {
	
	@Resource
	private MockMvc mvc;
	
	@Test
	public void shouldCreateControllerAndPopulator() {
		
	}
}
