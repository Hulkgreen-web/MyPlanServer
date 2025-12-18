package com.helha.myplanserver.infrastructure.transaction;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITransactionRepository extends CrudRepository<DbTransaction,Long> {

}
