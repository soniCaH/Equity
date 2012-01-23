package be.khleuven.vanransbeeck.kevin;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class LanguageItemListener implements AdapterView.OnItemClickListener {
	ListView listView;
	String countryText;
	String langCode;
	
	public LanguageItemListener(ListView list) {
		listView = list;
	}
	public void onItemClick(AdapterView<?> parent, 
							View itemClicked, int position, long id) {
		 countryText = listView.getItemAtPosition(position).toString();
		 langCode = ((TextView) itemClicked.findViewById(R.id.language_code)).getText().toString();
		 
		 Intent intent = new Intent(itemClicked.getContext(), EquityTranslateActivity.class);
		 intent.putExtra("langCode", langCode);
		 //@TODO: save/preferences??
		 itemClicked.getContext().startActivity(intent);
	}

}
