package com.example.asg1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchRecordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SharedViewModel viewModel;
    private Button btn_search;
    private EditText et_name;
    private TextView tv_result;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchRecordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchRecordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchRecordFragment newInstance(String param1, String param2) {
        SearchRecordFragment fragment = new SearchRecordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static SearchRecordFragment newInstance() {
        SearchRecordFragment fragment = new SearchRecordFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        return inflater.inflate(R.layout.fragment_search_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_search=view.findViewById(R.id.Fragment_Search_BTN_Search);
        et_name=view.findViewById(R.id.Fragment_Search_ET_Name);
        tv_result=view.findViewById(R.id.Fragment_Search_TV_Result);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p=viewModel.searchPerson(et_name.getText().toString());
                if(p!=null) {
//                    Toast.makeText(getActivity(), p.toString(), Toast.LENGTH_SHORT).show();
                    tv_result.setText(p.toString());
                }
                else{
                    Toast.makeText(getActivity(), "Not Found!", Toast.LENGTH_SHORT).show();
                    tv_result.setText("Not Found!");
                }

            }
        });

    }
}