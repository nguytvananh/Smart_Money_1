package com.nhom10.smartmoney1.memberManagement;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
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
import com.nhom10.smartmoney1.sharedWalletManagement.SharedBudgetInfoFragement;

import java.util.ArrayList;

public class MemberManagement extends Fragment {

    ListView MemberListView;

    static MemberManagementListAdapter memberManagementListAdapter;
    ArrayList<MemberList> memberLists;

    FragmentActivity fragmentActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.member_management, container, false);
        final Context context = getActivity().getApplicationContext();
        fragmentActivity = (FragmentActivity) getActivity();
        try {
            MemberListView = root.findViewById(R.id.member_category_lv);

            memberLists = new ArrayList<>();

            // Thêm các danh mục mẫu vào danh sách
            memberLists.add(new MemberList(1, "Nguyễn Thị Mẹ", "Chủ ví"));
            memberLists.add(new MemberList(2, "Nguyễn Văn Bố", "Khác"));
            memberLists.add(new MemberList(3, "Nguyễn Văn Con", "Khác"));
            memberLists.add(new MemberList(4, "Nguyễn Thị Bà", "Khác"));


            memberManagementListAdapter = new MemberManagementListAdapter(context, memberLists);

            MemberListView.setAdapter(memberManagementListAdapter);
            memberManagementListAdapter.notifyDataSetChanged();

            MemberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    MemberList selectedMemberList = memberLists.get(i);
                    editBudgetCategory(selectedMemberList);
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

        MemberListFragment memberListFragment = new MemberListFragment();

        memberListFragment.show(fragmentManager,"New member");
    }
    void editBudgetCategory(MemberList memberList)
    {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

        MemberListFragment memberListFragment = new MemberListFragment(memberList);

        memberListFragment.show(fragmentManager,"New member");
    }
}

