package com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner;

import android.content.ContentValues;
import android.database.Cursor;

import com.nhom10.smartmoney1.budgetplanner.PlansManager;
import com.nhom10.smartmoney1.dbmanagment.DatabaseController;
import com.nhom10.smartmoney1.dbmanagment.DatabaseManager;
import com.nhom10.smartmoney1.dbmanagment.PlansTable;
import com.nhom10.smartmoney1.globalOperations.DateStringFormatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
public class SharedPlansManager
{
    static ArrayList<SharedPlan> plansList = new ArrayList<>();


    public static ArrayList<SharedPlan> getPlansList() {
        plansList.clear();
        plansList.add(new SharedPlan(1,"Buy home" , "desc" , 5000.0 ,  Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(2,"Buy car" , "desc" , 15000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(3,"Get married" , "desc" , 20000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(4,"University" , "desc" , 700.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(5,"Clothes" , "desc" , 1000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(6,"Travel" , "desc" , 2000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(7,"Summer vacation" , "desc" , 1200.0 , Calendar.getInstance().getTime()));

        return plansList;
    }

    public static void loadPlans() throws ParseException //TODO from database
    {
        plansList = new ArrayList<>();


/*
        if(cursor.moveToFirst()) {
            do {
                int Id = cursor.getInt(cursor.getColumnIndex(PlansTable.colID));
                String title = cursor.getString(cursor.getColumnIndex(PlansTable.colTitle));
                String description = cursor.getString(cursor.getColumnIndex(PlansTable.colDescription));
                double moneyNeeded = cursor.getDouble(cursor.getColumnIndex(PlansTable.colNeededMoney));
                Date deadline      = DateStringFormatter.StringToDate(cursor.getString(cursor.getColumnIndex(PlansTable.colDeadline)));

                plansList.add(new SharedPlan(Id,title,description,moneyNeeded,deadline));
            } while (cursor.moveToNext());
        }

*/

        plansList.add(new SharedPlan(1,"Buy home" , "desc" , 5000.0 ,  Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(2,"Buy car" , "desc" , 15000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(3,"Get married" , "desc" , 20000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(4,"University" , "desc" , 700.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(5,"Clothes" , "desc" , 1000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(6,"Travel" , "desc" , 2000.0 , Calendar.getInstance().getTime()));
        plansList.add(new SharedPlan(7,"Summer vacation" , "desc" , 1200.0 , Calendar.getInstance().getTime()));


    }

    public static void addPlan(String title, String desc, double budget, Date deadline)
    {

    }

    public static void editPlan(int ID, String title, String desc, double budget, Date deadline)
    {

    }

    public static void deletePlan(SharedPlan sharedPlan)
    {

    }

}
