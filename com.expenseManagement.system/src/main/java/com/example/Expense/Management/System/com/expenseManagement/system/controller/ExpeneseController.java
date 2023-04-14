package com.example.Expense.Management.System.com.expenseManagement.system.controller;


import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;
import com.example.Expense.Management.System.com.expenseManagement.system.service.ExpenseService;
import com.example.Expense.Management.System.com.expenseManagement.system.service.ExpenseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpeneseController {

  @Autowired
   private ExpenseServiceImpl expenseServiceImpl;

   @PostMapping("/submit")
   public ResponseEntity<Expense> submitExpense(@RequestBody Expense expense){
      Expense savedExpenseDto=expenseServiceImpl.submitExpense(expense);
      return new ResponseEntity<>(savedExpenseDto, HttpStatus.ACCEPTED);
   }

   @GetMapping("/all")
    public ResponseEntity<List<Expense>> fetchAllExpense(){
       List<Expense> listOfallExpense=expenseServiceImpl.fetchAllExpense();
       return new ResponseEntity<>(listOfallExpense, HttpStatus.OK);
   }

   @GetMapping("/exp/{expid}")
    public ResponseEntity<Expense> getExpensesbyId(@PathVariable("expid") Long id){
       Expense fetchExpensebyId=expenseServiceImpl.getExpensesbyId(id);
       return new ResponseEntity<>(fetchExpensebyId, HttpStatus.OK);
   }

   @DeleteMapping("/exp/{expid}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("expid") Long id){
       expenseServiceImpl.deleteExpenseById(id);
       return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        Expense savedExpenseDto=expenseServiceImpl.submitExpense(expense);
        return new ResponseEntity<>(savedExpenseDto, HttpStatus.CREATED);
    }

}
