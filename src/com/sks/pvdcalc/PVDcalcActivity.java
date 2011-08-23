package com.sks.pvdcalc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PVDcalcActivity extends Activity implements OnClickListener {

	int unit;
	double unitValue;
	double fl;
	double isw;
	double iw;
	double vd;
	double hfov;
	double hfovd;
	EditText flText;
	EditText iswText;
	EditText iwText;
	EditText hfovText;
	EditText vdFtText;
	EditText vdMText;
	Button unitButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		unitButton = (Button) findViewById(R.id.unit);
		unit = 0;
		unitValue = 0.0;
		fl = 0.0;
		isw = 0.0;
		iw = 0.0;
		hfovd = 0.0;
		hfov = 0.0;
		Button computeButton = (Button) findViewById(R.id.compute);
		flText = (EditText) findViewById(R.id.fl);
		iswText = (EditText) findViewById(R.id.isw);
		iwText = (EditText) findViewById(R.id.iw);
		hfovText = (EditText) findViewById(R.id.hfov);
		vdFtText = (EditText) findViewById(R.id.vdf);
		vdMText = (EditText) findViewById(R.id.vdm);
		unitButton.setOnClickListener(this);
		computeButton.setOnClickListener(this);
		// Log.e("Error", "POOTIS");
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.unit:
			if (unit < 2) {
				unit++;
			} else {
				unit = 0;
			}
			updateUnit();
			break;
		case R.id.compute:
			findViewingDistance();
			break;
		}
	}

	public void updateUnit() {
		switch (unit) {
		case 0:
			unitButton.setText("Cm");
			unitValue = 10.0;
			break;
		case 1:
			unitButton.setText("In");
			unitValue = 25.4;
			break;
		case 2:
			unitButton.setText("Ft");
			unitValue = 304.8;
			break;
		}
		Log.e("value", unitValue + " and "+ unit);
	}

	public void findViewingDistance() {
		String flTextValue = flText.getText().toString();
		String iswTextValue = iswText.getText().toString();
		String iwTextValue = iwText.getText().toString();

		try {
			fl = Double.valueOf(flTextValue).doubleValue();
			isw = Double.valueOf(iswTextValue).doubleValue();
			iw = Double.valueOf(iwTextValue).doubleValue() * unitValue;
		} catch (Exception e) {
			Toast toast = Toast.makeText(getApplicationContext(),
					"Invalid input values, please try again.",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			return;
		}

		hfovd = (2 * (Math.atan(.5 * (isw / fl)))) * 57.2957795;
		hfov = (2 * (Math.atan(.5 * (isw / fl))));

		vd = ((iw / 2) / (Math.tan(hfov / 2)));

		hfovText.setText(Double.toString(hfovd));
		vdFtText.setText(Double.toString(vd/304.8));
		vdMText.setText(Double.toString(vd/100));
	}
}