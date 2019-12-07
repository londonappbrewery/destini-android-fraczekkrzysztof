package com.londonappbrewery.destini;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;

    boolean mIsEnded = false;
    int mStep = 1;
    String mCurrentStory = "T1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStep ==1){
                    updateTexts("T3");
                } else if (mStep == 2 && mCurrentStory.equals("T3")){
                    updateEndText("T6");
                } else if (mStep == 2 && mCurrentStory.equals("T2")){
                    updateTexts("T3");
                } else if (mStep == 3 && mCurrentStory.equals("T3")){
                    updateEndText("T6");
                }
                incrementStep();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStep == 1){
                    updateTexts("T2");
                }  else if (mStep == 2 && mCurrentStory.equals("T3")){
                    updateEndText("T5");
                } else if (mStep == 2 && mCurrentStory.equals("T2")){
                    updateEndText("T4");
                } else if (mStep == 3 && mCurrentStory.equals("T3")){
                    updateEndText("T5");
                }
                incrementStep();
            }
        });
    }

    private void incrementStep(){
        mStep = mStep + 1;
    }

    private void updateTexts(String symbol){
        mStoryTextView.setText(getResources().getIdentifier(symbol + "_Story","string",getPackageName()));
        mButtonTop.setText(getResources().getIdentifier(symbol + "_Ans1","string",getPackageName()));
        mButtonBottom.setText(getResources().getIdentifier( symbol + "_Ans2","string",getPackageName()));
        mCurrentStory = symbol;
    }

    private void updateEndText(String symbol){
        mStoryTextView.setText(getResources().getIdentifier(symbol + "_End","string",getPackageName()));
        mButtonBottom.setVisibility(View.GONE);
        mButtonTop.setVisibility(View.GONE);
    }
}
