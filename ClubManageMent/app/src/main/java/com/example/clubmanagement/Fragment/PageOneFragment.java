package com.example.clubmanagement.Fragment;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.clubmanagement.Adapter.ListViewAdapter;
import com.example.clubmanagement.Database.CLUB_DAO;
import com.example.clubmanagement.R;

public class PageOneFragment extends Fragment {
    private ListView listview ;
    private ListViewAdapter adapter;
    private int[] img = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.three,R.drawable.one};
    private String[] Title = {"정준일 하이","윤종신 좋니","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","gkskej"};
    private String[] Context = {"정준일 명곡","윤종신 히트곡","러블리즈 히트곡","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","러블리즈 아츄","하나더"};

    public static PageOneFragment newInstance(){
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_page_one, container, false);

        //변수 초기화
        adapter = new ListViewAdapter();
        listview = (ListView) v.findViewById(R.id.List_view);

        //어뎁터 할당
        listview.setAdapter(adapter);
        //adapter를 통한 값 전달
        CLUB_DAO sl = new CLUB_DAO();
        sl.showList();
        /*
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this.getActivity() ,img[i]),Title[i],Context[i]);
        }
        */
        return v;
    }

}