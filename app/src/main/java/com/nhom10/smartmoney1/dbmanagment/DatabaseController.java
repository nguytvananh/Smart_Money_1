package com.nhom10.smartmoney1.dbmanagment;

import android.content.ContentValues;
import android.content.Context;

import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
import com.nhom10.smartmoney1.globalOperations.DateStringFormatter;
import com.nhom10.smartmoney1.mainactivity.fragments.home.HomeFragment;


// TODO Change the current budget every month

public class DatabaseController
{
    static private DatabaseManager databaseManager;

    public DatabaseController(Context context)
    {
        if(databaseManager == null)
        {
            databaseManager = new DatabaseManager(context);
        }
    }


    public static DatabaseManager getDatabaseManager() {

        return databaseManager;
    }


}
