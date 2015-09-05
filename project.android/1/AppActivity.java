/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.javascript;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;


import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.sina.push.PushManager;

public class AppActivity extends Cocos2dxActivity implements OnClickListener {
	private static final String NAME_PUSH_SERVICE = "com.sina.push.service.SinaPushService";

	private Button bt_startPush = null;
	private Button bt_stopPush = null;
	private Button bt_refresh = null;

	public static TextView tv_aid = null;
	private boolean isRunning = false;

	private PushManager manager;

    @Override
    public Cocos2dxGLSurfaceView onCreateView() {
        Cocos2dxGLSurfaceView glSurfaceView = new Cocos2dxGLSurfaceView(this);
        // TestCpp should create stencil buffer
        glSurfaceView.setEGLConfigChooser(5, 6, 5, 0, 16, 8);

        //
  //       super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		// bt_startPush = (Button) findViewById(R.id.btn_start);
		// bt_startPush.setOnClickListener(this);

		// bt_stopPush = (Button) findViewById(R.id.btn_stop);
		// bt_stopPush.setOnClickListener(this);

		// // bt_restartPush = (Button)findViewById(R.id.btn_restart);
		// // bt_restartPush.setOnClickListener(this);

		// bt_refresh = (Button) findViewById(R.id.btn_refreshConnection);
		// bt_refresh.setOnClickListener(this);

		// tv_aid = (TextView) findViewById(R.id.tv_aid);

		// isRunning = isPushRunning();
		// Log.d("sinapush", "push service is running::" + isRunning);

		// bt_startPush.setEnabled(true);
		// bt_stopPush.setEnabled(false);
		// bt_refresh.setEnabled(false);

		manager = PushManager.getInstance(getApplicationContext());
		if (getIntent() != null) {
		    manager.sendClickFeedBack (getIntent());
		}
		startSinaPushService();
		//

        return glSurfaceView;
    }


	/**
	 * push 是否正在后台运行
	 */
	private boolean isPushRunning() {
		// TODO Auto-generated method stub
		ActivityManager mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> serviceList = mActivityManager
				.getRunningServices(Integer.MAX_VALUE);

		for (RunningServiceInfo info : serviceList) {

			if (NAME_PUSH_SERVICE.equals(info.service.getClassName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void onResume() {
		super.onResume();

		//
		/*
		 * 点击率统计 if(pushSystemMethod != null){
		 * pushSystemMethod.sendClickFeedBack(getIntent()); }
		 */
	}

	@Override
	public void onClick(View v) {
		// switch (v.getId()) {
		// case R.id.btn_start: // 开启Push服务
		// 	startSinaPushService();
		// 	break;
		// case R.id.btn_stop: // 关闭Push服务
		// 	stopSinaPushService();
		// 	break;
		// case R.id.btn_refreshConnection: // 发送Wesync数据
		// 	refreshConnection();
		// 	break;

		// }
	}

	/**
	 * 开启SinaPush服务
	 */
	private void startSinaPushService() {

		manager.initPushChannel("23786", "23786", "100", "100");

		// bt_startPush.setEnabled(false);
		// bt_stopPush.setEnabled(true);
		// bt_refresh.setEnabled(true);
	}

	/**
	 * 关闭SinaPush服务
	 */
	private void stopSinaPushService() {

		manager.close();

		bt_startPush.setEnabled(true);
		bt_stopPush.setEnabled(false);
		bt_refresh.setEnabled(false);
	}

	/**
	 * 刷新Push服务长连接
	 */
	private void refreshConnection() {
		bt_refresh.setText(tv_aid.getText().toString());
		manager.refreshConnection();

	}
}
