package com.example.Expense.Management.System.com.expenseManagement.system.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "claim_type")
    private String claimType;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @Column(name = "claim_month")
    private String claimMonth;

    @NotNull
    @Column(name = "claim_year")
    private Integer claimYear;

    @NotNull
    @Column(name = "date_of_expense")
    private LocalDate dateOfExpense;

}
