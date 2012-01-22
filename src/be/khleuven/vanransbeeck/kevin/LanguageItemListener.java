package be.khleuven.vanransbeeck.kevin;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LanguageItemListener implements AdapterView.OnItemClickListener {
	ListView listView;
	String countryText;
	Drawable flag;
	
	public LanguageItemListener(ListView list) {
		listView = list;
	}
	public void onItemClick(AdapterView<?> parent, 
							View itemClicked, int position, long id) {
		 countryText = listView.getItemAtPosition(position).toString();
		 System.out.println(countryText);
	}

}
