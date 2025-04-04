package fintrek.expense.core;

import fintrek.misc.MessageDisplayer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private final String description;
    private final double amount;
    private final String category;
    private LocalDate date;

    /**
     * This function constructs an expense object based on the parameters below
     * @param description is the description of the expense
     * @param amount is the amount spent in this expense
     * @param category is the category of the expense
     * @param date is when the expense is made
     */
    public Expense(String description, double amount, String category, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException(MessageDisplayer.INVALID_AMOUNT);
        }
        assert amount > 0 : MessageDisplayer.INVALID_AMOUNT;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void updateDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category.toUpperCase();
    }

    public double getAmount() {
        assert amount > 0 : MessageDisplayer.INVALID_AMOUNT;
        return amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return description + " | $" + String.format("%.2f", amount) + " | "
                + category.toUpperCase() + " | " + date.format(formatter);
    }
}
