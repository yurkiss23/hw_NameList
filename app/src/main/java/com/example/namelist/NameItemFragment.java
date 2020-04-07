package com.example.namelist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NameItemFragment extends Fragment {

    private String name, desc;

    public NameItemFragment(String name){ this.name = name; }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_name_item, container, false);

        TextView nameItem = view.findViewById(R.id.tvText_name);
        TextView descItem = view.findViewById(R.id.tvText_dest);
        desc = ((NavigationHost)getActivity()).description(name);

        nameItem.setText(name);
        descItem.setText("description: " + desc);

        return view;
    }
}
