package com.example.Expense.Management.System.com.expenseManagement.system.service;

import com.example.Expense.Management.System.com.expenseManagement.system.customException.BusinessException;
import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;
import com.example.Expense.Management.System.com.expenseManagement.system.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ExpenseService implements ExpenseServiceImpl {

   @Autowired
   private ExpenseRepository expenseRepository;

   @Override
   public Expense submitExpense(Expense expense) {
      if (expense.getAmount() == null || expense.getClaimMonth().length() == 0) {
         throw new BusinessException("901", "Amount is either blank or Claim month is empty");
      }
      try {
         Expense savedExpenseDto = expenseRepository.save(expense);
         return savedExpenseDto;
      } catch (IllegalArgumentException i) {
         throw new BusinessException("902","while submitting the expense some details are not correct" + i.getMessage());
      }catch (Exception e){
         throw new BusinessException("903","Something went wrong in Service Layer"+ e.getMessage());
      }
   }

   @Override
   public List<Expense> fetchAllExpense() {
      List<Expense> expenses=expenseRepository.findAll();
      if(expenses.isEmpty()){
         throw new BusinessException("904","Expenses is empty in database");
      }
      try {
         return expenses;
      }catch (Exception e){
         throw new BusinessException("905","Spmething went wrong while fetching the records in Service Layer");
      }
   }

   @Override
   public Expense getExpensesbyId(Long id) {
      try {
         return expenseRepository.findById(id).get();
      }catch (IllegalArgumentException i){
         throw new BusinessException("906","Expense Id is null please send some id"+ i.getMessage());
      }catch (NoSuchElementException e){
         throw new BusinessException("907","Given Expense Id does not exist in the database"+e.getMessage());
      }
   }

   @Override
   public void deleteExpenseById(Long id) {
      try {
         expenseRepository.deleteById(id);
      }catch (IllegalArgumentException i){
      throw new BusinessException("906","Expense Id is null please send some id"+ i.getMessage());
      }catch (NoSuchElementException e){
      throw new BusinessException("907","Given Expense Id does not exist in the database"+e.getMessage());
   }
   }

   @Override
   public void updateAllExpenses(List<Expense> expenses) {
      expenseRepository.saveAll(expenses);
   }


}
