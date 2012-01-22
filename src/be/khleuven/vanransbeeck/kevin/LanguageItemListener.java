package be.khleuven.vanransbeeck.kevin;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class LanguageItemListener implements AdapterView.OnItemClickListener {
	ListView listView;
	String countryText;
	String flag;
	
	public LanguageItemListener(ListView list) {
		listView = list;
	}
	public void onItemClick(AdapterView<?> parent, 
							View itemClicked, int position, long id) {
		 countryText = listView.getItemAtPosition(position).toString();
		 TextView flagLabel = (TextView) itemClicked.findViewById(R.id.language_label);
		 int flagID = flagLabel.getId();
		 
		 switch(flagID) {
		 // EUROPE
		 case R.string.language_en_gb:
			 flag = "en-gb"; break;
		 case R.string.language_de_de:
			 flag = "de-de"; break;
		 case R.string.language_fr_fr:
			 flag = "fr-fr"; break;
		 case R.string.language_al:
			 flag = "al"; break;
		 case R.string.language_ca:
			 flag = "ca"; break;
		 case R.string.language_de_at:
			 flag = "de_at"; break;
		 case R.string.language_az:
			 flag = "az"; break;
		 case R.string.language_be:
			 flag = "be"; break;
		 case R.string.language_nl_be:
			 flag = "nl-be"; break;
		 case R.string.language_fr_be:
			 flag = "fr-be"; break;
		 case R.string.language_bg:
			 flag = "bg"; break;
		 case R.string.language_es_ca:
			 flag = "es-ca"; break;
		 case R.string.language_cs:
			 flag = "cs"; break;
		 case R.string.language_da_dk:
			 flag = "da-dk"; break;
		 case R.string.language_et:
			 flag = "et"; break;
		 case R.string.language_fi_fi:
			 flag = "fi-fi"; break;
		 case R.string.language_el:
			 flag = "el"; break;
		 case R.string.language_hu:
			 flag = "hu"; break;
		 case R.string.language_it_it:
			 flag = "it-it"; break;
		 case R.string.language_lv:
			 flag = "lv"; break;
		 case R.string.language_de_li:
			 flag = "de-li"; break;
		 case R.string.language_lt:
			 flag = "lt"; break;
		 case R.string.language_de_lu:
			 flag = "de-lu"; break;
		 case R.string.language_fr_lu:
			 flag = "fr-lu"; break;
		 case R.string.language_nl_nl:
			 flag = "nl-nl"; break;
		 case R.string.language_nb_no:
			 flag = "nb-no"; break;
		 case R.string.language_pl_pl:
			 flag = "pl-pl"; break;
		 case R.string.language_pt_pt:
			 flag = "pt-pt"; break;
		 case R.string.language_ro:
			 flag = "ro"; break;
		 case R.string.language_ru_ru:
			 flag = "ru-ru"; break;
		 case R.string.language_sk:
			 flag = "sk"; break;
		 case R.string.language_sl:
			 flag = "sl"; break;
		 case R.string.language_es_es:
			 flag = "es-es"; break;
		 case R.string.language_sv:
			 flag = "sv"; break;
		 case R.string.language_de_ch:
			 flag = "de-ch"; break;
		 case R.string.language_it_ch:
			 flag = "it-ch"; break;
		 case R.string.language_tr_tr:
			 flag = "tr-tr"; break;
		 case R.string.language_uk:
			 flag = "uk"; break;
			 
		 //NORTH AMERICA
			 
			 default: flag = "";
		 }
	}

}
