package kr.hs.ss.s210406;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_com,tv_result;
    Button bt_man_gawi,bt_man_bawi,bt_man_bo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_com = (TextView) findViewById(R.id.TV_com);
        tv_result = (TextView) findViewById(R.id.TV_result);
        bt_man_bawi = (Button) findViewById(R.id.BT_man_Bawi);
        bt_man_gawi = (Button) findViewById(R.id.BT_man_Gawi);
        bt_man_bo = (Button) findViewById(R.id.BT_man_Bo);

    }

}