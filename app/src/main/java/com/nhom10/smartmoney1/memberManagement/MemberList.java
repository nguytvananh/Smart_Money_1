package com.nhom10.smartmoney1.memberManagement;

public class MemberList
{
    private int ID;
    private String name;
    private String role;


    /*
    public BudgetCategory(String name, double maxBudget) {
        this.name = name;
        this.maxBudget = maxBudget;
        currentBudget = 0;
    }
*/
    public MemberList(int ID, String name, String role) {
        this.ID = ID;
        this.name = name;
        this.role = role;

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String ROLE){
            this.role=ROLE;
    }
    public String getRole() {
        return this.role;
    }


    @Override
    public String toString() {
        return "BudgetCategory{" +
                "name='" + name + '\'' +
                ", Role=" + role +
                "," +
                '}';
    }





}
