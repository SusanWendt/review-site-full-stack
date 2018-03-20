package org.wecancodeit.reviewsitefullstack;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long>{

	public Tag findByTagWordIgnoreCase(String tagWord);
	//TODO fix refactor in Rest Controller
}
