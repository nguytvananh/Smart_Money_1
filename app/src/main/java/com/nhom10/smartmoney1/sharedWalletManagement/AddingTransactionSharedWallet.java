package com.nhom10.smartmoney1.sharedWalletManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.BudgetCategory;
import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
import com.nhom10.smartmoney1.transactions.Transaction;
import com.nhom10.smartmoney1.transactions.TransactionManager;
import com.nhom10.smartmoney1.usermoney.UserWallet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddingTransactionSharedWallet extends AppCompatActivity {

    Spinner productCategorySpinner;
    EditText productNameTextField;
    EditText productPriceTextField;
    DatePicker transactionDatePicker;

    ArrayList<String> productCategories;
    ArrayAdapter categoriesAdapter;
    ArrayList<BudgetCategory> budgetCategories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        try {
            productCategorySpinner = findViewById(R.id.product_category_spinner);
            productNameTextField  = findViewById(R.id.product_name_textField);
            productPriceTextField = findViewById(R.id.product_price_textField);
            transactionDatePicker = findViewById(R.id.date_picker);
            budgetCategories = new ArrayList<>();

            // Thêm các danh mục mẫu vào danh sách
            budgetCategories.add(new BudgetCategory(1, "Food", 5000, 1000));
            budgetCategories.add(new BudgetCategory(2, "Transport", 3000, 500));
            budgetCategories.add(new BudgetCategory(3, "Entertainment", 2000, 750));
            budgetCategories.add(new BudgetCategory(4, "Utilities", 4000, 1500));
            budgetCategories.add(new BudgetCategory(5, "Health", 2500, 1000));
            ArrayList<String> names = new ArrayList<>();
                for (int i = 0 ; i < budgetCategories.size() ; i++)
                {
                    names.add(budgetCategories.get(i).getName());
                }

            productCategories = names;
            System.out.println((productCategories));
            categoriesAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,productCategories);
            productCategorySpinner.setAdapter(categoriesAdapter);
            productCategorySpinner.setSelection(0);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onClickAddTransaction(View view)
    {
        finish();

    }

    private Date getDateFromDatePicker() {
        int day = transactionDatePicker.getDayOfMonth();
        int month = transactionDatePicker.getMonth();
        int year = transactionDatePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);

        return calendar.getTime();
    }

    private void makeLongToast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg , Toast.LENGTH_LONG).show();
    }
}