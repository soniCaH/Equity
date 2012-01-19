package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EquityMenuActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		final ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
		String[] items = { 
				getResources().getString(R.string.menu_item_start),
				getResources().getString(R.string.menu_item_news),
				getResources().getString(R.string.menu_item_settings),
				getResources().getString(R.string.menu_item_help),
				getResources().getString(R.string.menu_item_partners),
//				getResources().getString(R.string.menu_item_exit),
		};
		
		Drawable[] icons = {
				getResources().getDrawable(R.drawable.start),
				getResources().getDrawable(R.drawable.news),
				getResources().getDrawable(R.drawable.settings),
				getResources().getDrawable(R.drawable.help),
				getResources().getDrawable(R.drawable.partners),
//				getResources().getDrawable(R.drawable.exit)
		};
		
		MenuItemAdapter adapt = new MenuItemAdapter(this, items, icons);
		menuList.setAdapter(adapt);
		
		menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, 
									View itemClicked, int position, long id) {
				ListView listView = menuList;
				String strText = listView.getItemAtPosition(position).toString(); 
				
				if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_start))) {
					startActivity(new Intent(EquityMenuActivity.this, EquityLanguageActivity.class));
				} else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_news))) {
					startActivity(new Intent(EquityMenuActivity.this, EquityNewsActivity.class));
				} else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_settings))) {
					startActivity(new Intent(EquityMenuActivity.this, EquitySettingsActivity.class));
				} else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_help))) {
					startActivity(new Intent(EquityMenuActivity.this, EquityHelpActivity.class));
				} else if(strText.equalsIgnoreCase(getResources().getString(R.string.menu_item_partners))) {
					startActivity(new Intent(EquityMenuActivity.this, EquityPartnersActivity.class));
				} 
			}
		});
	}
}
