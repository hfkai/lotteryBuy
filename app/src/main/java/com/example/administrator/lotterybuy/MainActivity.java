package com.example.administrator.lotterybuy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 主界面activity
 */
public class MainActivity extends Activity implements View.OnClickListener {


    private Button algorithmA;
    private Button algorithmB;
    private Button algorithmC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        algorithmA = (Button) findViewById(R.id.algorithmA);
        algorithmB = (Button) findViewById(R.id.algorithmB);
        algorithmC = (Button) findViewById(R.id.algorithmC);

        algorithmA.setOnClickListener(this);
        algorithmB.setOnClickListener(this);
        algorithmC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.algorithmA:
                goSecond(Constants.CONCRETE_A);
                break;
            case R.id.algorithmB:
                goSecond(Constants.CONCRETE_B);
                break;
            case R.id.algorithmC:
                goSecond(Constants.CONCRETE_C);
                break;
        }
    }
    private void goSecond(int i) {
        SendCondActivity.startThisActivity(MainActivity.this,i);
    }
}
