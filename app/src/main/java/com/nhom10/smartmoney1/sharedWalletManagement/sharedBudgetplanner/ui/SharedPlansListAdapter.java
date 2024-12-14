package com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.sharedWalletManagement.sharedBudgetplanner.SharedPlan;
import com.nhom10.smartmoney1.usermoney.UserWallet;

import java.util.ArrayList;
import java.util.Calendar;

public class SharedPlansListAdapter extends BaseAdapter {

    Context context;
    ArrayList<SharedPlan> sharedPlans;

    public SharedPlansListAdapter(Context context, ArrayList<SharedPlan> sharedPlans) {
        this.context = context;
        this.sharedPlans = sharedPlans;
    }

    @Override
    public int getCount() {
        return sharedPlans.size();
    }

    @Override
    public Object getItem(int i) {
        return sharedPlans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        view = inflater.inflate(R.layout.list_item_plans, null);

        final SharedPlan sharedPlan = sharedPlans.get(i);

        RelativeLayout planCardLayout = view.findViewById(R.id.plan_card_layout);
        TextView planTitle = view.findViewById(R.id.plan_title);
        TextView planDesc = view.findViewById(R.id.plan_desc);
        TextView planDate = view.findViewById(R.id.plan_date);
        TextView planBudget = view.findViewById(R.id.plan_budget);

        String year = (sharedPlan.getDeadline().toString()).substring(
                sharedPlan.getDeadline().toString().length()-4);

        String dateStr = (sharedPlan.getDeadline().toString()).substring(0 , 11) + ", " + year;
    //    String dateStr = (plan.getDeadline().toString());

        planTitle.setText(sharedPlan.getTitle());
        planDesc.setText(sharedPlan.getDescription());
        planDate.setText(dateStr);
        planBudget.setText("$ "+String.valueOf(sharedPlan.getMoneyNeeded()));

        if(sharedPlan.getMoneyNeeded() <= UserWallet.getUserMoney())
        {
            planCardLayout.setBackgroundResource(R.color.doneColor);
        }

        if (sharedPlan.getDeadline().compareTo(Calendar.getInstance().getTime()) < 0)
        {
            planCardLayout.setBackgroundResource(R.color.worryColor);
        }


        return view;
    }
}
