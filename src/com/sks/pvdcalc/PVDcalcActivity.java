package com.sks.pvdcalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PVDcalcActivity extends Activity implements OnClickListener {

	int unit;
	Button unitButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		unitButton = (Button) findViewById(R.id.unit);
		unit = 0;
		Button computeButton = (Button) findViewById(R.id.compute);
		EditText flText = (EditText) findViewById(R.id.fl);
		EditText iswText = (EditText) findViewById(R.id.isw);
		EditText iwText = (EditText) findViewById(R.id.iw);
		unitButton.setOnClickListener(this);
		computeButton.setOnClickListener(this);
		// Log.e("Error", "POOTIS");
	}

	public void onClick(View v) {
		// Log.e("Error", );
		switch (view.getId()) {
		case R.id.unit:
			if (unit < 2) {
				unit++;
			} else {
				unit = 0;
			}
		}
	}

	public void updateUnit() {
		switch (unit) {
		case 0:
			unitButton.setText("Cm");
			break;
		case 1:
			unitButton.setText("In");
			break;
		case 2:
			unitButton.setText("Ft");
			break;
		}
	}
}