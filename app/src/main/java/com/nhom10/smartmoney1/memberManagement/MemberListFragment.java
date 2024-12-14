package com.nhom10.smartmoney1.memberManagement;

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

public class MemberListFragment extends DialogFragment implements View.OnClickListener
{
    View newMemberListView;
    boolean isNew;
    MemberList memberList;

    EditText memberNameEditText;
    EditText memberRoleEditText;
    Button addBudgetCategoryButton;

    public MemberListFragment( MemberList budgetCategory) // false
    {
        this.isNew = false;
        this.memberList =budgetCategory;
    }

    public MemberListFragment() // true
    {
        this.isNew = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        newMemberListView = inflater.inflate(R.layout.fragment_member_list,container,false);

        memberNameEditText = newMemberListView.findViewById(R.id.member_name);
        memberRoleEditText = newMemberListView.findViewById(R.id.member_role);
        addBudgetCategoryButton = newMemberListView.findViewById(R.id.add_Budget_button);

        if (!isNew)
        {
            memberNameEditText.setText(memberList.getName());

            //          budgetCategoryNameEditText.setEnabled(false);

            memberNameEditText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext()  , "Không thể thêm thành viên",
                            Toast.LENGTH_LONG).show();
                }
            });

            memberRoleEditText.setText(String.valueOf(memberList.getRole()));
        }

        addBudgetCategoryButton.setOnClickListener(this);


        return newMemberListView;
    }

    @Override
    public void onClick(View view) {
        this.dismiss();

    }
}