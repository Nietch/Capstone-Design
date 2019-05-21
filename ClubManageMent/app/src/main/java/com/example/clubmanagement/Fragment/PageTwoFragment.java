package com.example.clubmanagement.Fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.Database.ClubData;
import com.example.clubmanagement.Database.Club_Member_Data;
import com.example.clubmanagement.R;

import java.util.ArrayList;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;

public class PageTwoFragment extends Fragment {
    private ListView listview;
    private ListViewAdapter adapter;
    int Code;
    HashMap<String, String> Club_Item = new HashMap<String, String>();
    ArrayList<HashMap<String, String>> Club_Item_list;
    ClubData CdTwo = new ClubData();
    TextView txtResult;
    Button applyUp;


    public static PageTwoFragment newInstance() {
        Bundle args = new Bundle();
        PageTwoFragment fragment = new PageTwoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page_two, container, false);

        Spinner checkSpinner = (Spinner) v.findViewById(R.id.spinner_Check);
        ArrayAdapter Adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.major, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        checkSpinner.setAdapter(Adapter);
        checkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Code = position;
                //  ((ArrayAdapter) checkSpinner.getAdapter()).notifyDataSetChanged();
                // Adapter.notifyDataSetChanged();
                //((FragmentStart)getActivity()).refresh();

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        //어뎁터 할당
        //adapter를 통한 값 전달

        listview.setAdapter(adapter);
       CdTwo.ClearListData();

        String temp = CdTwo.Temp;
        CdTwo.GetListData(temp);
        Club_Item_list = CdTwo.Club_Item_list;

        for (int i = 0; i < Club_Item_list.size(); i++) {
            Club_Item = Club_Item_list.get(i);
            if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 0) {
                adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 1){
                if(Club_Item.get("CLUB_AT_CD").equals("2001")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 2){
                if(Club_Item.get("CLUB_AT_CD").equals("2002")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 3){
                if(Club_Item.get("CLUB_AT_CD").equals("2003")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 4){
                if(Club_Item.get("CLUB_AT_CD").equals("2004")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 5){
                if(Club_Item.get("CLUB_AT_CD").equals("2005")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }else if(Club_Item.get("CLUB_GB_CD").equals("1001") && Code == 6){
                if(Club_Item.get("CLUB_AT_CD").equals("2006")){
                    adapter.addVO(ContextCompat.getDrawable(this.getActivity(), R.drawable.one), Club_Item.get("CLUB_NM"), Club_Item.get("INTRO_CONT"));
                }
            }
        }
        ApplyStart(v);
        return v;
    }

    private void ApplyStart(View v) {
        applyUp = (Button) v.findViewById(R.id.button);
        applyUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ApplyActivity.class);
                intent.putExtra("data", "Test Popup");
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
                txtResult.setText(result);
            }
        }
    }
}