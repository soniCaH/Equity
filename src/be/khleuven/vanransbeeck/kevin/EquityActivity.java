package be.khleuven.vanransbeeck.kevin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class EquityActivity extends Activity {
	public static final String EQ_PREFERENCES = "EquityPreferences";
	public SharedPreferences settings;
	public SharedPreferences.Editor prefEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		settings = getSharedPreferences(EQ_PREFERENCES, MODE_PRIVATE);
		prefEditor = settings.edit();
	}
	
}
