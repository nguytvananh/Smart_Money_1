package com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner;

import java.util.Calendar;
import java.util.Date;

public class SharedPlan
{
    int planID;
    private String title;
    private String description;
    private double MoneyNeeded;
    private Date deadline;

    public SharedPlan(int planID , String title, String description, double moneyNeeded, Date deadline) {
        this.planID = planID;
        this.title = title;
        this.description = description;
        MoneyNeeded = moneyNeeded;
        this.deadline = deadline;
    }

    public SharedPlan(int planID , String title, String description, double moneyNeeded) {
        this.planID = planID;
        this.title = title;
        this.description = description;
        MoneyNeeded = moneyNeeded;

        this.deadline = Calendar.getInstance().getTime();
    }

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoneyNeeded() {
        return MoneyNeeded;
    }

    public void setMoneyNeeded(double moneyNeeded) {
        MoneyNeeded = moneyNeeded;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", MoneyNeeded=" + MoneyNeeded +
                ", deadline=" + deadline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SharedPlan)) return false;

        SharedPlan sharedPlan = (SharedPlan) o;

        if (Double.compare(sharedPlan.getMoneyNeeded(), getMoneyNeeded()) != 0) return false;
        if (getTitle() != null ? !getTitle().equals(sharedPlan.getTitle()) : sharedPlan.getTitle() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(sharedPlan.getDescription()) : sharedPlan.getDescription() != null)
            return false;
        return getDeadline() != null ? getDeadline().equals(sharedPlan.getDeadline()) : sharedPlan.getDeadline() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        temp = Double.doubleToLongBits(getMoneyNeeded());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getDeadline() != null ? getDeadline().hashCode() : 0);
        return result;
    }
}
