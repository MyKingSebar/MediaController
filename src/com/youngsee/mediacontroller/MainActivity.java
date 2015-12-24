package com.youngsee.mediacontroller;

import com.youngsee.mediacontroller.common.Actions;
import com.youngsee.mediacontroller.common.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

	private Button mBtnPlay = null;
	private Button mBtnPause = null;
	private Button mBtnVisible = null;
	private Button mBtnGone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnPlay = (Button)findViewById(R.id.btn_play);
        mBtnPlay.setOnClickListener(this);

        mBtnPause = (Button)findViewById(R.id.btn_pause);
        mBtnPause.setOnClickListener(this);

        mBtnVisible = (Button)findViewById(R.id.btn_visible);
        mBtnVisible.setOnClickListener(this);

        mBtnGone = (Button)findViewById(R.id.btn_gone);
        mBtnGone.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void sendControlAction(int code) {
    	Intent intent = new Intent(Actions.MEDIAPLAYER_CONTROL_ACTION);
        intent.putExtra(Actions.MEDIAPLAYER_CONTROL_ACTION_EXTRA_CODE, code);
        sendBroadcast(intent);
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_play:
			sendControlAction(Constants.CONTROLCODE_PLAY);

			break;
		case R.id.btn_pause:
			sendControlAction(Constants.CONTROLCODE_PAUSE);

			break;
		case R.id.btn_visible:
			sendControlAction(Constants.CONTROLCODE_VISIBLE);

			break;
		case R.id.btn_gone:
			sendControlAction(Constants.CONTROLCODE_GONE);

			break;
		}
	}

}
