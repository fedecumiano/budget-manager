package org.github.fedecumiano.budgetManager.service;

import org.github.fedecumiano.budgetManager.model.Operations;
import org.github.fedecumiano.budgetManager.model.User;
import org.github.fedecumiano.budgetManager.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;


    public List<Operations> retrieveOperationsByType (User user, String type){
        List<Operations> filteredOperations = operationRepository.findByUsernameAndType(user.getUsername(), type);
        return filteredOperations;
    }

    public List<Operations> retrieveAllOperations(User user){
        List<Operations> operationsList = operationRepository.findByUsernameOrderByDatedDesc(user.getUsername());
        return operationsList;
    }

    public void saveOperation(Operations operation){
        operationRepository.save(operation);
    }

    public void deleteOperation(Operations operation){
        operationRepository.delete(operation);
    }

    public double balance(User user){
        double balance = 0;
        List<Operations> operationsList = retrieveAllOperations(user);
        for (Operations operation: operationsList){
            if (operation.getType().equals("income")){
                balance += operation.getAmount();
            }
            else{
                balance -= operation.getAmount();
            }
        }
        return balance;
    }

    public Operations findOperation(Integer id){
        Optional<Operations> op = operationRepository.findById(id);
        if (op.isEmpty()){
            return null;
        }
        else{
            return op.get();
        }
    }


}
