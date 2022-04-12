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
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddRecordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btn_save;
    private EditText et_name,et_age,et_address;
    private SharedViewModel viewModel;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddRecordFragment() {
        // Required empty public constructor
    }

    public static AddRecordFragment newInstance() {
        AddRecordFragment fragment = new AddRecordFragment();
        return fragment;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddRecordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddRecordFragment newInstance(String param1, String param2) {
        AddRecordFragment fragment = new AddRecordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        return inflater.inflate(R.layout.fragment_add_record, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_save=view.findViewById(R.id.Fragment_Add_BTN_Save);
        et_name=view.findViewById(R.id.Fragment_Add_ET_Name);
        et_age=view.findViewById(R.id.Fragment_Add_ET_Age);
        et_address=view.findViewById(R.id.Fragment_Add_ET_Address);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_name.getText().toString()==null||et_age.getText().toString()==null||et_address.getText().toString()==null)
                {
                    Toast.makeText(getActivity(), "Invalid Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Person p=new Person(et_name.getText().toString(),Integer.parseInt(et_age.getText().toString()),et_address.getText().toString());
                    Toast.makeText(getActivity(), p.toString(), Toast.LENGTH_SHORT).show();
                    viewModel.addPerson(p);
                }
            }
        });
    }
}