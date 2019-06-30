package com.example.demofragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.demofragment.databinding.FragmentView01Binding;

public class Fragment01 extends Fragment {
    FragmentView01Binding binding;

    public static Fragment01 newInstance() {
        Bundle args = new Bundle();

        Fragment01 fragment = new Fragment01();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view01,
                container, false);

        binding.tvDemo.setText("Done");


        return binding.getRoot();
    }
}
