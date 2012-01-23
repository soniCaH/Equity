package be.khleuven.vanransbeeck.kevin;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class PartnerItemAdapter extends ArrayAdapter<String> {
	private Drawable[] images;
	private String[] values;
	private Context context;
	
	public PartnerItemAdapter(Context context, String[] values, Drawable[] images) {
		super(context, R.layout.partner_item, values);
		this.context = context;
		this.values = values;
		this.images = images;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View partner_item_view = inflater.inflate(R.layout.partner_item, parent, false);
		
		ImageView imageView = (ImageView) partner_item_view.findViewById(R.id.partner_logo);
		
		imageView.setImageDrawable(images[position]);
		
		return partner_item_view;
	}
}
