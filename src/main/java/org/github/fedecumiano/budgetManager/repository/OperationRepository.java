package org.github.fedecumiano.budgetManager.repository;

import org.github.fedecumiano.budgetManager.model.Operations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends CrudRepository<Operations, Integer> {
    List<Operations> findByUsernameAndType(String userName, String Type);
    List<Operations> findByUsernameOrderByDatedDesc(String userName);
}
