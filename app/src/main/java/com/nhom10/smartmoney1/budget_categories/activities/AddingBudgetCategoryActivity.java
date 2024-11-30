package com.nhom10.smartmoney1.budget_categories.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.ui.IconsListAdapter;

import java.util.ArrayList;

public class AddingBudgetCategoryActivity extends AppCompatActivity
{

    ArrayList<Integer> icons;
    IconsListAdapter iconsListAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_budget_category);
        icons = new ArrayList<>();

        icons.add(R.drawable.ic_dollar);
        icons.add(R.drawable.ic_menu_camera);
        icons.add(R.drawable.plan);
        icons.add(R.drawable.trending);
        icons.add(R.drawable.ic_dollar);
        icons.add(R.drawable.money_bag);
        icons.add(R.drawable.logo);
        icons.add(R.drawable.ic_paper_money);
        icons.add(R.drawable.ic_shopaholic);
        icons.add(R.drawable.icon_shopaholic);
        icons.add(R.drawable.bag_fill);
        icons.add(R.drawable.chart_square);
        icons.add(R.drawable.receipt_item);
        icons.add(R.drawable.setting_2);
        icons.add(R.drawable.u_dollar_alt);

        listView = findViewById(R.id.list_view_id);
        iconsListAdapter = new IconsListAdapter(icons , this);
        listView.setAdapter(iconsListAdapter);
        iconsListAdapter.notifyDataSetChanged();
    }
}