package com.example.Expense.Management.System.com.expenseManagement.system.repository;

import com.example.Expense.Management.System.com.expenseManagement.system.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
