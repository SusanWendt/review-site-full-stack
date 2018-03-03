Reviews Site Full Stack Overview

Description: 
Project done at We Can Code IT referencing previous Review Site repository. This is my first full stack and pair programming project. 
Uses Java, Spring, JPA, HTML, and CSS. 
Reviewing work out studios around Columbuswith descriptions and tags all housed in a database.  

Tasks
	[X] Add the following dependencies to build.gradle (or use Spring Initializr to create a new build.gradle)
		[X] JPA (spring-boot-starter-data-jpa)
		[X] H2

	[X] Create a Category class that:
		[X] is a JPA entity.
		[X] contains an instance variable referencing the Reviews it contains.
		[X] configures an appropriate JPA relationship to its reviews.

	[X] Update the Review class such that:
		[X] it is a JPA entity.
		[X] configures a JPA relationship to its associated category.
		[X] allows for a description/content/body longer than 255 characters.

	[NEED TO ADD CSS] Update your view (templates/html/*css*) such that:
		[X] there is a page that lists review categories, each of which links to the (details) page for a specific category.
		[X] there is a page that lists the reviews for a chosen category, each of which links to the (details) page for a specific review.
		[X] each review detail page has a link to the page for its category.

Stretch Tasks
	[NEED TO MAKE LINKS] Tags
		[X] Create a Tag entity.
		[X] Update Review so that it can have tags associated with it. (One review, many tags.)
		[X] Display tags on the review details page.
		[] Create a page that displays links to all of the reviews associated with a given tag.

Stretchier
	[] Style your tags list template as a tag cloud, making tags which appear more often larger and/or bolder and those that appear less often smaller and/or lower weight.
	[] Allow creation and deletion of tags from a review using <form> and <button> elements along with the appropriate controller method(s).

Tips
	Start with the known specifics
		Start with mapping and displaying your Reviews. Add Categories to them after you’ve gotten that working.

	Mapping out URLs, Model attributes, view template names, etc
		It is good practice to map things out and think them through, using plural and singular names appropriately, or you’ll likely be well confused.
		Your names, etc will be different, but hopefully this helps with some of the confusion I’ve seen around naming and what is in the model for a specific view. 
		I’ll append model and view to names to help clarify, though we usually wouldn’t do this in the wild. Create your own table that maps these things out:


	String fields longer than 255 characters
		For instance variables that hold things like descriptions, which may be longer than 255 characters, 
		you will need to indicate that this should be stored in a CLOB (Character Large OBject). To do, this use the @Lob annotation on your instance variable, like so:
			@Lob
			private String description;
		
		See LOBs, BLOBs, CLOBs and Serialization in the Java Persistence wikibook.