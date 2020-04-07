package com.example.namelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NameListFragment extends Fragment {

    String[] names = {"qwe", "rty", "uio", "asd", "fgh", "jkl", "zxc", "vbn"};
    private GridView nameView;
    ArrayAdapter<String> nameAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_name_list, container, false);

        nameView = view.findViewById(R.id.name_list);
        nameAdapter = new ArrayAdapter<String>(getActivity(), R.layout.name_item, R.id.tvText, names);
        nameView.setAdapter(nameAdapter);

        nameView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (savedInstanceState == null){
//                    Log.d("TAG", Integer.toString(position));
                    ((NavigationHost)getActivity())
                            .navigateTo(new NameItemFragment(names[position]), false);
                }
            }
        });

        return view;
    }
}
