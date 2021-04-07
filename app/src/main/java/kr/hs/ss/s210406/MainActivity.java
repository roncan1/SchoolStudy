package kr.hs.ss.s210406;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_com,tv_result;
    Button bt_man_gawi,bt_man_bawi,bt_man_bo;
    Handler mHandler = null;

    int com_int = 0;
    String com = "주먹";
    String man = "주먹";
    String game = "게임중지";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_com = (TextView) findViewById(R.id.TV_com);
        tv_result = (TextView) findViewById(R.id.TV_result);
        bt_man_bawi = (Button) findViewById(R.id.BT_man_Bawi);
        bt_man_gawi = (Button) findViewById(R.id.BT_man_Gawi);
        bt_man_bo = (Button) findViewById(R.id.BT_man_Bo);

        tv_result.setOnClickListener(this);
        bt_man_bawi.setOnClickListener(this);
        bt_man_gawi.setOnClickListener(this);
        bt_man_bo.setOnClickListener(this);

        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (game == "게임중") {
                    com_int = com_int + 1;
                    com_int = com_int % 3;

                    if (com_int == 0) com = "주먹";
                    if (com_int == 1) com = "가위";
                    if (com_int == 2) com = "보";

                    tv_com.setText(com);

                }
                mHandler.sendEmptyMessageDelayed(0,100);
            }
        };
        mHandler.sendEmptyMessage(0);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler = null;
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.TV_result) {
            if (game == "게임중지")game = "게임중";
        }
        if (v.getId() == R.id.BT_man_Bawi) {

        }
        if (v.getId() == R.id.BT_man_Gawi) {

        }
        if (v.getId() == R.id.BT_man_Bo) {

        }
    }
}