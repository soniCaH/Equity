package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class EquitySettingsActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.eqoptions, menu);
		menu.findItem(R.id.help_menu_item).setIntent(new Intent(this, EquityHelpActivity.class));
		menu.findItem(R.id.settings_menu_item).setIntent(new Intent(this, EquitySettingsActivity.class));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		startActivity(item.getIntent());
		return true;
	}	
}
