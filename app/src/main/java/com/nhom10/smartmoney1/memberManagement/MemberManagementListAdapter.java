package com.nhom10.smartmoney1.memberManagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nhom10.smartmoney1.R;
import com.nhom10.smartmoney1.budget_categories.BudgetCategory;
import com.nhom10.smartmoney1.transactions.activities.ListingCategoryTransactionsActivity;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class MemberManagementListAdapter extends BaseAdapter
{
    ArrayList<MemberList> memberLists;
    Context context;

    public MemberManagementListAdapter(Context context, ArrayList<MemberList> memberLists) {
        this.memberLists = memberLists;

        this.context = context;
    }

    @Override
    public int getCount() {
        return memberLists.size();
    }

    @Override
    public Object getItem(int i) {
        return memberLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        view = inflater.inflate(R.layout.list_member, null);

        final MemberList memberList = memberLists.get(i);


        TextView memberName = view.findViewById(R.id.member_name);
        TextView memberRole = view.findViewById(R.id.member_role);


        memberName.setText(memberList.getName());
        memberRole.setText("$"+String.valueOf(memberList.getRole()));










        return view;
    }
}
