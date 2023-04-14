package com.example.Expense.Management.System.com.expenseManagement.system.service;

import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;

import java.util.List;

public interface ExpenseServiceImpl {
    public Expense submitExpense(Expense expense);

    public List<Expense> fetchAllExpense();


    Expense getExpensesbyId(Long id);

    void deleteExpenseById(Long id);
}
