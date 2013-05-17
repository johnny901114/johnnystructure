package com.johnnystruct;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.johnnystruct.sample.TestEngine2;

public class MainActivity extends BaseActivity {

	TestEngine2 enTestengine = new TestEngine2(this);
	TextView tvContent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvContent = (TextView) findViewById(R.id.tv_content);
		enTestengine.sendRequest();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void handleRightJsonCode(int index, Object data) {
		tvContent.setText("get data from server \n"+data.toString());
	}

}
