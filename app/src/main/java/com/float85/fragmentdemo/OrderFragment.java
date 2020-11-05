package com.float85.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.float85.fragmentdemo.databinding.OderfragmentLayoutBinding;

public class OrderFragment extends Fragment {
//    TextView tvName;
//    Button btnSettext;

    OderfragmentLayoutBinding binding;

    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View view = inflater.inflate(R.layout.oderfragment_layout, container, false);
        binding = DataBindingUtil.inflate(inflater, R.layout.oderfragment_layout, container, false);

//        tvName = view.findViewById(R.id.tvName);
//        btnSettext = view.findViewById(R.id.btnSettext);

//        btnSettext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvName.setText("An AN Button");
//            }
//        });
            binding.btnSettext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    binding.tvName.setText("An AN tivi");
                }
            });


        return binding.getRoot();
    }
}
