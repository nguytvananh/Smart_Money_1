package com.nhom10.smartmoney1.sharedWalletManagement;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.BudgetCategory;
import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
import com.nhom10.smartmoney1.budget_categories.ui.BudgetCategoryInfoFragment;
import com.nhom10.smartmoney1.mainactivity.fragments.budgetmanager.BudgetManagerListAdapter;

import java.util.ArrayList;

public class SharedWalletCategory extends Fragment {

    ListView budgetCategoryListView;

    static BudgetManagerListAdapter budgetManagerListAdapter;
    ArrayList<BudgetCategory> budgetCategories;

    FragmentActivity fragmentActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_budget_manager, container, false);
        final Context context = getActivity().getApplicationContext();
        fragmentActivity = (FragmentActivity) getActivity();
        try {
            budgetCategoryListView = root.findViewById(R.id.budget_manager_lv);

            budgetCategories = new ArrayList<>();

            // Thêm các danh mục mẫu vào danh sách
            budgetCategories.add(new BudgetCategory(1, "Food", 5000, 1000));
            budgetCategories.add(new BudgetCategory(2, "Transport", 3000, 500));
            budgetCategories.add(new BudgetCategory(3, "Entertainment", 2000, 750));
            budgetCategories.add(new BudgetCategory(4, "Utilities", 4000, 1500));
            budgetCategories.add(new BudgetCategory(5, "Health", 2500, 1000));


            budgetManagerListAdapter = new BudgetManagerListAdapter(context, budgetCategories);

            budgetCategoryListView.setAdapter(budgetManagerListAdapter);
            budgetManagerListAdapter.notifyDataSetChanged();

            budgetCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    BudgetCategory selectedBudgetCategory = budgetCategories.get(i);
                    editBudgetCategory(selectedBudgetCategory);
                }
            });

            FloatingActionButton fab = root.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    addNewBudgetCategory();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return root;
    }
    void addNewBudgetCategory()
    {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

        BudgetCategoryInfoFragment budgetCategoryInfoFragment = new BudgetCategoryInfoFragment();

        budgetCategoryInfoFragment.show(fragmentManager,"New budget");
    }
    void editBudgetCategory( BudgetCategory budgetCategory)
    {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

        BudgetCategoryInfoFragment budgetCategoryInfoFragment = new BudgetCategoryInfoFragment(budgetCategory);

        budgetCategoryInfoFragment.show(fragmentManager,"New budget");
    }
}

