package com.helha.myplanserver.infrastructure.transaction;

import org.springframework.data.repository.CrudRepository;

public interface ITransactionRepository extends CrudRepository<DbTransaction,Long> {

}
