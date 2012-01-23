package be.khleuven.vanransbeeck.kevin;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

public class EquityPartnersActivity extends EquityActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.partners);
		
		final ListView menuList = (ListView) findViewById(R.id.ListView_Partners);
		
		Drawable[] icons = {
				getResources().getDrawable(R.drawable.khleuven_port),
				getResources().getDrawable(R.drawable.ucsjaelland_port),
				getResources().getDrawable(R.drawable.univiceland_port),
				getResources().getDrawable(R.drawable.estesl_port),
				getResources().getDrawable(R.drawable.soro_port),
				getResources().getDrawable(R.drawable.leonardo_port),
		};
		
		PartnerItemAdapter adapt = new PartnerItemAdapter(this, icons);
		menuList.setAdapter(adapt);
	}
}
