package com.example.administrator.lotterybuy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.lotterybuy.model.Operation;

/**
 * 计算界面
 */
public class SendCondActivity extends Activity {


    private EditText etNumber;
    private TextView result_tv;
    int tag;
    private static InputMethodManager mInputMethodManager;

    /**
     *
     * @param context
     * @param tag  标识{@link Constants}
     */
    public static void  startThisActivity(Context context, int tag) {
        Intent intent = new Intent(context, SendCondActivity.class);
        intent.putExtra("tag", tag);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        getDataIntent();
        initView();
    }

    private void initView() {
        etNumber = (EditText) findViewById(R.id.etNumber);
        result_tv = (TextView) findViewById(R.id.result_tv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mInputMethodManager = null;
    }


    private void getDataIntent() {
        if(getIntent()!= null){
            tag = getIntent().getIntExtra("tag", 0);
        }
    }
    public void doLogin(View view){
        hide();
        submit();
    }
    /**
     *  提交
     */
    private void submit() {
        // validate
        String etNumberString = etNumber.getText().toString().trim();
        if (TextUtils.isEmpty(etNumberString)) {
            Toast.makeText(this, "请输入注数", Toast.LENGTH_SHORT).show();
            return;
        }
        result_tv.setText(getString(R.string.result, "计算结果",
                new Operation(OperationFactory.createOperate(tag))
                        .play(Integer.parseInt(etNumberString))));
    }
    /**
     * 隐藏软键盘
     *
     * @param event
     * @return onTouchEvent
     */
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            hide();
        }
        return super.onTouchEvent(event);
    }

    /**
     * 隐藏
     */
    private void hide() {
        if (SendCondActivity.this.getCurrentFocus() != null
                && SendCondActivity.this.getCurrentFocus().getWindowToken() != null) {
            mInputMethodManager.hideSoftInputFromWindow(
                    SendCondActivity.this.getCurrentFocus()
                            .getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
