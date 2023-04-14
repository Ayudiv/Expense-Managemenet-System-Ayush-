package com.example.Expense.Management.System.com.expenseManagement.system.service;

import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;
import com.example.Expense.Management.System.com.expenseManagement.system.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService implements ExpenseServiceImpl {

   @Autowired
   private ExpenseRepository expenseRepository;

   @Override
   public Expense submitExpense(Expense expense) {
      Expense savedExpenseDto=expenseRepository.save(expense);
      return savedExpenseDto;
   }

   @Override
   public List<Expense> fetchAllExpense() {
      return expenseRepository.findAll();
   }

   @Override
   public Expense getExpensesbyId(Long id) {
      return expenseRepository.findById(id).get();
   }

   @Override
   public void deleteExpenseById(Long id) {
      expenseRepository.deleteById(id);
   }


}
