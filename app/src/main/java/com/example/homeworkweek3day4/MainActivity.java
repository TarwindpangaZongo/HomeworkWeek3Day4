package com.example.homeworkweek3day4;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        InputFragment.OnInputFragmentInteractionListener{

    OutputFragment outputFragment;
    FragmentManager fragmentManager;

    private static final String INPUT_FRAG_ONE_TAG = "input_frag_one";
    private static final String OUTPUT_FRAG_ONE_TAG = "output_frag_one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputFragment = OutputFragment.newInstance();
        //Fragment Manager
        fragmentManager = getSupportFragmentManager();
        //use fragment manager to begin fragment transaction, replace the frag in layout with the
        //    fragment we want there, add it to back stack with a tag, and commit the transaction
        fragmentManager
                .beginTransaction()
                .replace(R.id.frmInput, InputFragment.newInstance())
                .addToBackStack(INPUT_FRAG_ONE_TAG)
                .commit();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frmOutput, outputFragment)
                .addToBackStack(OUTPUT_FRAG_ONE_TAG)
                .commit();
    }

    @Override
    public void onInputSendToMain(User infoPassed) {
        outputFragment.setInputOutput(infoPassed);//send to output fragment
    }


}
