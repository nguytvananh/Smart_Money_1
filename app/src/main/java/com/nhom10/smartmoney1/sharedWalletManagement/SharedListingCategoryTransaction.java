package com.nhom10.smartmoney1.sharedWalletManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
import com.nhom10.smartmoney1.transactions.Transaction;
import com.nhom10.smartmoney1.transactions.TransactionManager;
import com.nhom10.smartmoney1.transactions.ui.TransactionListAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class SharedListingCategoryTransaction extends AppCompatActivity
{
    TextView selectedCategoryName;
    ListView transactionListView;

    String categoryName;
    ArrayList<Transaction> transactions;
    TransactionListAdapter transactionListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_transaction);
        try {
            selectedCategoryName = findViewById(R.id.selected_category_name);
            transactionListView = findViewById(R.id.transaction_lv);

            Bundle bundle = getIntent().getExtras();
            categoryName = bundle.getString("category", "none");
            selectedCategoryName.setText(categoryName);

            ArrayList<Transaction> transactions = new ArrayList<>();
            if (categoryName.equals("Food")) {
                transactions.add(new Transaction(1, "Food Expense", 1000.0,  Calendar.getInstance().getTime()));
            } else if (categoryName.equals("Transport")) {
                transactions.add(new Transaction(2, "Transport Expense", 500.0,  Calendar.getInstance().getTime()));
            } else if (categoryName.equals("Entertainment")) {
                transactions.add(new Transaction(3, "Entertainment Expense", 750.0,  Calendar.getInstance().getTime()));
            } else if (categoryName.equals("Utilities")) {
                transactions.add(new Transaction(4, "Utilities Expense", 1500.0,  Calendar.getInstance().getTime()));
            } else if (categoryName.equals("Health")) {
                transactions.add(new Transaction(5, "Health Expense", 1000.0,  Calendar.getInstance().getTime()));
            } else {
                System.out.println("Category name không hợp lệ!");
            }
            transactionListAdapter = new TransactionListAdapter(getApplicationContext(), transactions);
            transactionListView.setAdapter(transactionListAdapter);
            transactionListAdapter.notifyDataSetChanged();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(transactionListAdapter!=null)
            transactionListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(transactionListAdapter!=null)
            transactionListAdapter.notifyDataSetChanged();
    }
}