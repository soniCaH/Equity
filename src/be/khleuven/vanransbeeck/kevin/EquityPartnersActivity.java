package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class EquityPartnersActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partners);
		
		final ListView menuList = (ListView) findViewById(R.id.ListView_Partners);
		
		String[] values = {
				"KHLeuven", "University College Sj�lland", "University of Iceland",
				"ESTeSL", "Soro Kummunity", "Leonardo da Vinci Program",
		};
		
		Drawable[] icons = {
				getResources().getDrawable(R.drawable.khleuven_port),
				getResources().getDrawable(R.drawable.ucsjaelland_port),
				getResources().getDrawable(R.drawable.univiceland_port),
				getResources().getDrawable(R.drawable.estesl_port),
				getResources().getDrawable(R.drawable.soro_port),
				getResources().getDrawable(R.drawable.leonardo_port),
		};
		
		PartnerItemAdapter adapt = new PartnerItemAdapter(this, values, icons);
		menuList.setAdapter(adapt);
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
