package com.list.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dreamtweats.R;

public class CustomGridAdapter extends BaseAdapter  {
	 
    private Context context;
    private final String[] gridValues;
    public boolean isRecuring = false, isScary = false, isLOL = false, isHappy = false, isSciFi = false, isWtf = false, isNature = false, isAnimal = false, isWar = false;
    Typeface tf;
    //Constructor to initialize values
    public CustomGridAdapter(Context context, String[ ] gridValues) {

        this.context        = context;
        this.gridValues     = gridValues;
        tf = Typeface.createFromAsset(context.getAssets(), "HelveticaNeueLTStd-Th.otf");
    }
     
    @Override
    public int getCount() {
         
        // Number of times getView method call depends upon gridValues.length
        return gridValues.length;
    }
 
    @Override
    public Object getItem(int position) {
         
        return null;
    }
 
    @Override
    public long getItemId(int position) {
         
        return 0;
    }
     
     
    // Number of times getView method call depends upon gridValues.length
     
    public View getView(final int position, View convertView, ViewGroup parent) {
 
        // LayoutInflator to call external grid_item.xml file
         
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        View gridView;
 
        if (convertView == null) {
 
            gridView = new View(context);
 
            // get layout from grid_item.xml ( Defined Below )

            gridView = inflater.inflate( R.layout.type_item_layout , null);
 
            // set value into textview
             
            TextView textView = (TextView) gridView
                    .findViewById(R.id.gridText);

            textView.setText(gridValues[position]);
            textView.setTypeface(tf);
            // set image based on selected text
             
            final ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.gridImage);
            imageView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					switch (position) {
					case 0:
						if(isRecuring)
						{
							imageView.setImageResource(R.drawable.recurring_type_normal);
							isRecuring = false;
						}
						else
						{
							imageView.setImageResource(R.drawable.recurring_type_pressed);
							isRecuring = true;
						}
						
						break;
					case 1:
						if(isScary)
						{
							imageView.setImageResource(R.drawable.scary_type_normal);
							isScary = false;
						}
						else
						{
							imageView.setImageResource(R.drawable.scary_type_pressed);	
							isScary = true ;
						}
						
						break;
					case 2:
						if(isLOL)
						{
							imageView.setImageResource(R.drawable.lol_type_normal);
							isLOL = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.lol_type_pressed);
							isLOL = true;
						}
						break;
					case 3:
						if(isHappy)
						{
							imageView.setImageResource(R.drawable.happy_type_normal);
							isHappy = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.happy_type_pressed);
							isHappy = true;
						}
						
						break;
					case 4:
						if(isSciFi)
						{
							imageView.setImageResource(R.drawable.scifi_type_normal);
							isSciFi = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.scifi_type_pressed);
							isSciFi = true;
						}
						
						break;
					case 5:
						if(isWtf)
						{
							imageView.setImageResource(R.drawable.wtf_type_normal);
							isWtf = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.wtf_type_pressed);
							isWtf = true;
						}
						
						break;
					case 6:
						if(isNature)
						{
							imageView.setImageResource(R.drawable.nature_type_normal);
							isNature = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.nature_type_pressed);
							isNature = true;
						}
						
						break;
					case 7:
						if(isAnimal)
						{
							imageView.setImageResource(R.drawable.animal_type_normal);
							isAnimal = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.animal_type_pressed);
							isAnimal = true;
						}
						
						break;
					case 8:
						if(isWar)
						{
							imageView.setImageResource(R.drawable.war_type_normal);
							isWar = false ;
						}
						else
						{
							imageView.setImageResource(R.drawable.war_type_pressed);
							isWar = true;
						}
						
						break;

					default:
						break;
					}
				}
			});
 
            String arrLabel = gridValues[ position ];
 
            if (arrLabel.equals("Recurring")) {
                 
                imageView.setImageResource(R.drawable.recurring_type_normal);
                 
            } else if (arrLabel.equals("Scary")) {
                 
                imageView.setImageResource(R.drawable.scary_type_normal);
                 
            } else if (arrLabel.equals("LOL")) {
                 
                imageView.setImageResource(R.drawable.lol_type_normal);
                 
            } 
            else if (arrLabel.equals("Happy")) {
                
                imageView.setImageResource(R.drawable.happy_type_normal);
                 
            } 
            else if (arrLabel.equals("Sci-Fi")) {
                
                imageView.setImageResource(R.drawable.scifi_type_normal);
                 
            } 
            else if (arrLabel.equals("WTF")) {
                
                imageView.setImageResource(R.drawable.wtf_type_normal);
                 
            } 
            else if (arrLabel.equals("Nature")) {
                
                imageView.setImageResource(R.drawable.nature_type_normal);
                 
            } 
            else if (arrLabel.equals("Animal")) {
                
                imageView.setImageResource(R.drawable.animal_type_normal);
                 
            } 
            else if (arrLabel.equals("War")) {
                
                imageView.setImageResource(R.drawable.war_type_normal);
                 
            } 
        } else {

           gridView = (View) convertView;
        }
        
        return gridView;
    }
}