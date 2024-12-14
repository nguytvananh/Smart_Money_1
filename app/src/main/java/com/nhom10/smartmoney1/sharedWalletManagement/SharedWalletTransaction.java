    package com.nhom10.smartmoney1.sharedWalletManagement;


    import android.content.Context;
    import android.content.Intent;
    import android.os.Bundle;
    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ListView;
    import android.widget.TextView;

    import com.google.android.material.floatingactionbutton.FloatingActionButton;
    import com.nhom10.smartmoney1.R;
    import com.nhom10.smartmoney1.budget_categories.BudgetCategory;
    import com.nhom10.smartmoney1.budget_categories.BudgetCategoryManager;
    import com.nhom10.smartmoney1.budget_categories.ui.BudgetCategoryListAdapter;
    import com.nhom10.smartmoney1.transactions.activities.AddingTransactionActivity;

    import android.view.View;
    import android.widget.ListView;
    import android.widget.TextView;

    import java.util.ArrayList;

    public class SharedWalletTransaction extends Fragment {
        TextView totalExpensesTextView;
        ListView budgetCategoryListView;
        static BudgetCategoryListAdapter budgetCategoryListAdapter;
        ArrayList<BudgetCategory> budgetCategories;
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View root =  inflater.inflate(R.layout.shared_wallet_transaction, container, false);
            final Context context = getActivity().getApplicationContext();

            totalExpensesTextView = root.findViewById(R.id.total_expenses);
            budgetCategoryListView = root.findViewById(R.id.budget_category_lv);
            FloatingActionButton fab = root.findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //      .setAction("Action", null).show();

                    Intent intent = new Intent(context, AddingTransactionSharedWallet.class);
                    startActivity(intent);
                }
            });

            budgetCategories = new ArrayList<>();

            // Thêm các danh mục mẫu vào danh sách
            budgetCategories.add(new BudgetCategory(1, "Food", 5000, 1000));
            budgetCategories.add(new BudgetCategory(2, "Transport", 3000, 500));
            budgetCategories.add(new BudgetCategory(3, "Entertainment", 2000, 750));
            budgetCategories.add(new BudgetCategory(4, "Utilities", 4000, 1500));
            budgetCategories.add(new BudgetCategory(5, "Health", 2500, 1000));

            budgetCategoryListAdapter = new BudgetCategoryListAdapter(context, budgetCategories);

            budgetCategoryListView.setAdapter(budgetCategoryListAdapter);
            budgetCategoryListAdapter.notifyDataSetChanged();

            totalExpensesTextView.setText("$ "+String.valueOf(4750));


            return root;
        }

        @Override
        public void onResume() {
            super.onResume();
            budgetCategoryListAdapter.notifyDataSetChanged();
            totalExpensesTextView.setText("$ "+String.valueOf(4750));
        }

        @Override
        public void onStart() {
            super.onStart();
            if(budgetCategoryListAdapter!=null)
            {
                budgetCategoryListAdapter.notifyDataSetChanged();
                totalExpensesTextView.setText("$ "+4750);
            }
        }

        public static void refresh()
        {
            if(budgetCategoryListAdapter!=null)
            {
                budgetCategoryListAdapter.notifyDataSetChanged();
            }
        }
    }

