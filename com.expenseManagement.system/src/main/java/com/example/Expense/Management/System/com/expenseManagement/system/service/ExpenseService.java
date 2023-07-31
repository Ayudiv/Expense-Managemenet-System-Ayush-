package com.example.Expense.Management.System.com.expenseManagement.system.service;

import com.example.Expense.Management.System.com.expenseManagement.system.customException.BusinessException;
import com.example.Expense.Management.System.com.expenseManagement.system.customException.EmptyInputException;
import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;
import com.example.Expense.Management.System.com.expenseManagement.system.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
      if (expense.getAmount() == 0 || expense.getClaimMonth().length() == 0) {
         throw new EmptyInputException("Amount is not available","Amount is either empty or 0");
      } else {
         try {
            Expense savedExpenseDto = expenseRepository.save(expense);
            return savedExpenseDto;
         } catch (IllegalArgumentException i) {
            throw new EmptyInputException("902", "while submitting the expense some details are not correct" + i.getMessage());
         } catch (Exception e) {
            throw new EmptyInputException("903", "Something went wrong in Service Layer" + e.getMessage());
         }
      }
   }

   @Override
   public List<Expense> fetchAllExpense() {
      List<Expense> expenses=expenseRepository.findAll();
      if(expenses.isEmpty()){
         throw new EmptyInputException("904","Expenses is empty in database");
      }
      try {
         return expenses;
      }catch (Exception e){
         throw new EmptyInputException("905","Spmething went wrong while fetching the records in Service Layer");
      }
   }

   @Override
   public Expense getExpensesbyId(Long id) {
      try {
         return expenseRepository.findById(id).get();
      }catch (IllegalArgumentException i){
         throw new IllegalArgumentException(i.getClass() + i.getMessage());
      }catch (NoSuchElementException e){
         throw new NoSuchElementException(e.getCause()+e.getMessage());
      }
   }

   @Override
   public void deleteExpenseById(Long id) {
      try {
         expenseRepository.deleteById(id);
      }catch (IllegalArgumentException i){
      throw new EmptyInputException("906","Expense Id is null please send some id"+ i.getMessage());
      }catch (NoSuchElementException e){
      throw new EmptyInputException("907","Given Expense Id does not exist in the database"+e.getMessage());
   }
   }

   @Override
   public void updateAllExpenses(List<Expense> expenses) {
      expenseRepository.saveAll(expenses);
   }


}
