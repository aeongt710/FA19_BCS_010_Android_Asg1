package com.example.asg1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragMan;
    private FragmentTransaction fragTrans;
    private ActionFragment actionFragment;
    private MessageFragment messageFragment;
    private SharedViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        viewModel.initialize();

//        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            fragMan = getSupportFragmentManager();
            fragTrans = fragMan.beginTransaction();
            actionFragment = ActionFragment.newInstance();
            messageFragment = MessageFragment.newInstance();
            fragTrans.replace(R.id.FrameLayout_Left, actionFragment);
            fragTrans.replace(R.id.FrameLayout_Right, messageFragment);
            fragTrans.commitNow();

//        }
    }
}