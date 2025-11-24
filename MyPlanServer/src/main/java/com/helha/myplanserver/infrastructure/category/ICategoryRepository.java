package com.helha.myplanserver.infrastructure.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<DbCategory,Long> {

}
