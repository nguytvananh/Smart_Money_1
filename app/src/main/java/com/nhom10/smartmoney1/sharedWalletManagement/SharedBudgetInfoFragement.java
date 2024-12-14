package com.nhom10.smartmoney1.sharedWalletManagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.BudgetCategory;
import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
import com.nhom10.smartmoney1.mainactivity.fragments.budgetmanager.BudgetManagerFragment;
import com.nhom10.smartmoney1.mainactivity.fragments.home.HomeFragment;

public class SharedBudgetInfoFragement extends DialogFragment implements View.OnClickListener
{
    View newBudgetCategoryView;
    boolean isNew;
    BudgetCategory budgetCategory;

    EditText budgetCategoryNameEditText;
    EditText budgetCategoryPriceEditText;
    Button addBudgetCategoryButton;

    public SharedBudgetInfoFragement( BudgetCategory budgetCategory) // false
    {
        this.isNew = false;
        this.budgetCategory =budgetCategory;
    }

    public SharedBudgetInfoFragement() // true
    {
        this.isNew = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        newBudgetCategoryView = inflater.inflate(R.layout.fragment_budget_category_info,container,false);

        budgetCategoryNameEditText = newBudgetCategoryView.findViewById(R.id.category_name);
        budgetCategoryPriceEditText = newBudgetCategoryView.findViewById(R.id.Category_budget);
        addBudgetCategoryButton = newBudgetCategoryView.findViewById(R.id.add_Budget_button);

        if (!isNew)
        {
            budgetCategoryNameEditText.setText(budgetCategory.getName());

            //          budgetCategoryNameEditText.setEnabled(false);

            budgetCategoryNameEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext()  , R.string.errorMsg ,
                            Toast.LENGTH_LONG).show();
                }
            });

            budgetCategoryPriceEditText.setText(String.valueOf(budgetCategory.getMaxBudget()));
        }

        addBudgetCategoryButton.setOnClickListener(this);


        return newBudgetCategoryView;
    }

    @Override
    public void onClick(View view) {
        this.dismiss();

    }
}