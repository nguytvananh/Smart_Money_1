package com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.SharedPlan;
import com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.SharedPlansManager;
import com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.activities.SharedPlanInfoActivity;

import java.util.ArrayList;

public class SharedBudgetPlannerFragment extends Fragment
{
    ListView plansListView;

    static SharedPlansListAdapter sharedPlansListAdapter;
    ArrayList<SharedPlan> plansList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_budget_planner, container, false);
        final Context context = getActivity().getApplicationContext();


        plansListView = root.findViewById(R.id.plans_lv);

        plansList = new ArrayList<>();
        plansList = SharedPlansManager.getPlansList();

        sharedPlansListAdapter = new SharedPlansListAdapter(context, plansList);

        plansListView.setAdapter(sharedPlansListAdapter);
        sharedPlansListAdapter.notifyDataSetChanged();

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPlanActivity();
            }
        });

        plansListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final SharedPlan selectedSharedPlan = plansList.get(i);
                try {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getActivity());

                    alertBuilder.setMessage("Bạn có muốn \"Sửa\" hoặc \"Xóa\" kế hoạch này không?")
                            .setTitle(plansList.get(i).getTitle() + " Plan")
                            .setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // open

                                    editSelectedPlan(context, selectedSharedPlan);
                                }
                            })
                            .setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    SharedPlansManager.deletePlan(selectedSharedPlan);
                                    refresh();
                                }
                            }).show();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }

    void editSelectedPlan(Context context , SharedPlan selectedSharedPlan)
    {
        try {
            Intent intent = new Intent(context, SharedPlanInfoActivity.class);

            intent.putExtra("editPlan", true);

            intent.putExtra("planID" , selectedSharedPlan.getPlanID());
            intent.putExtra("planTitle", selectedSharedPlan.getTitle());
            intent.putExtra("planDesc", selectedSharedPlan.getDescription());
            intent.putExtra("planBudget", String.valueOf(selectedSharedPlan.getMoneyNeeded()));

            String year = (selectedSharedPlan.getDeadline().toString()).substring(
                    selectedSharedPlan.getDeadline().toString().length() - 4);

            String dateStr = (selectedSharedPlan.getDeadline().toString()).substring(0, 10) + " " + year;

            Log.i("planDate", "editSelectedPlan: "

                    + (selectedSharedPlan.getDeadline().toString()).substring(0, 10)

                    + "," + year);

            intent.putExtra("planDate", dateStr);
            startActivity(intent);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void startPlanActivity() {
        Intent intent = new Intent(getContext(), SharedPlanInfoActivity.class);
        intent.putExtra("editPlan" , false);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPlansListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        if(sharedPlansListAdapter !=null)
        {
            sharedPlansListAdapter.notifyDataSetChanged();
        }
    }

    public static void refresh() // TODO : call it when you add a new plan
    {
        if(sharedPlansListAdapter !=null)
        {
            sharedPlansListAdapter.notifyDataSetChanged();
        }
    }
}