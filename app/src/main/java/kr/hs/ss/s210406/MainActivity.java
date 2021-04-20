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

    TextView tv_com, tv_result;
    Button bt_man_gawi, bt_man_bawi, bt_man_bo;
    String game = "경기중지";
    String com = "가위", man = "주먹";
    int com_int = 0;
    Handler mHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_com = (TextView)findViewById(R.id.TV_com);
        tv_result = (TextView)findViewById(R.id.TV_result);

        bt_man_gawi = (Button)findViewById(R.id.BT_man_Gawi);
        bt_man_bawi = (Button)findViewById(R.id.BT_man_Bawi);
        bt_man_bo = (Button)findViewById(R.id.BT_man_Bo);

        tv_result.setOnClickListener(this);
        bt_man_gawi.setOnClickListener(this);
        bt_man_bawi.setOnClickListener(this);
        bt_man_bo.setOnClickListener(this);

        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                if (game != "경기중지") {
                    com_int++;
                    com_int = com_int % 3;
                    com_play(com_int);
                }

                mHandler.sendEmptyMessageDelayed(0,100);
                //1초 = 1000 / 0.1초 = 100
            }
        };
        mHandler.sendEmptyMessage(0);
    }

    private void com_play(int com_int) {
        switch (com_int) {
            case 0 :
                com = "주먹";
                break;

            case 1 :
                com = "보";
                break;

            case 2 :
                com = "가위";
                break;
        }
        tv_com.setText(com); //화면에 표시
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TV_result :
                tv_result.setText("경기중");
                game = "경기시작";
                break;
            case R.id.BT_man_Gawi :
                if (game == "경기시작") {
                    game = "경기중지";
                    man = "가위";
                    play_result(com, man);
                }
                break;
            case R.id.BT_man_Bawi :
                if (game == "경기시작") {
                    game = "경기중지";
                    man = "주먹";
                    play_result(com, man);
                }
                break;
            case R.id.BT_man_Bo :
                if (game == "경기시작") {
                    game = "경기중지";
                    man = "보";
                    play_result(com, man);
                }
                break;

        }
    }

    private void play_result(String com, String man) {
        if (man == "가위") {
            if (com == "가위") {
                tv_result.setText("비겼다!\n사람 : " + man);
            }
            if (com == "주먹") {
                tv_result.setText("졌다!\n사람 : " + man);
            }
            if (com == "보") {
                tv_result.setText("이겼다!\n사람 : " + man);
            }
        }

        if (man == "주먹") {
            if (com == "가위") {
                tv_result.setText("이겼다!\n사람 : " + man);
            }
            if (com == "주먹") {
                tv_result.setText("비겼다!\n사람 : " + man);
            }
            if (com == "보") {
                tv_result.setText("졌다!\n사람 : " + man);
            }
        }

        if (man == "보") {
            if (com == "가위") {
                tv_result.setText("졌다!\n사람 : " + man);
            }
            if (com == "주먹") {
                tv_result.setText("이겼다!\n사람 : " + man);
            }
            if (com == "보") {
                tv_result.setText("비겼다!\n사람 : " + man);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.getLooper().quit();
    }
}