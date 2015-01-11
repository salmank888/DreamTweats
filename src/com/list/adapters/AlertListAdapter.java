package com.list.adapters;

import java.util.ArrayList;

import com.list.models.AlertModal;
import com.list.models.TweetModal;

import com.example.dreamtweats.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertListAdapter extends BaseAdapter {

	  private Activity activity;
      private ArrayList<AlertModal> data;
      private static LayoutInflater inflater=null;
      public Resources res;
      AlertModal tempValues=null;
      int i=0;
      public AlertListAdapter(Activity a, ArrayList<AlertModal> d, Resources r) {
    	  this.activity = a;
    	  this.data = d;
    	  this.res = r;
    	  inflater = ( LayoutInflater )activity.
                  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getCount() {
		 if(data.size()<=0)
             return 1;
         return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	 public static class ViewHolder{
         
         public TextView dreamText;
         public TextView dreamTime;
         public TextView userName;
         public ImageView userImage;
         public TextView commentCount;
         public TextView likesCount;
         public ImageView followerDreamImage;
        // public ImageView dreamImage;
         
  
     }
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View vi = convertView;
         ViewHolder holder;
          
         if(convertView==null){
  
             vi = inflater.inflate(R.layout.notification_item_layout, null);
             holder = new ViewHolder();
             holder.userName = (TextView) vi.findViewById(R.id.followerName);
            /// holder.dreamImage=(ImageView)vi.findViewById(R.id.tweatImage);
             holder.dreamText = (TextView) vi.findViewById(R.id.followrAction);
             holder.dreamTime=(TextView)vi.findViewById(R.id.followerTime);
             holder.userImage=(ImageView)vi.findViewById(R.id.followerImage);
             holder.followerDreamImage = (ImageView) vi.findViewById(R.id.followerDreamImage);
             
             vi.setTag( holder );
         }
         else 
             holder=(ViewHolder)vi.getTag();
          
         if(data.size()<=0)
         {
             holder.dreamText.setText("No Data");
              
         }
         else
         {
            
             tempValues=null;
             tempValues = ( AlertModal ) data.get( position );
          
              holder.dreamText.setText( tempValues.getTweatString() );
              holder.dreamTime.setText( tempValues.getTweatTime() );
              holder.userName.setText( tempValues.getUserName() );
              if(tempValues.getTweatPhoto().length()>3)
              {
            holder.followerDreamImage.setImageResource(
                           res.getIdentifier(
                           "com.example.dreamtweats:drawable/"+tempValues.getTweatPhoto()
                           ,null,null));
              }
               holder.userImage.setImageResource(
                       res.getIdentifier(
                       "com.example.dreamtweats:drawable/"+tempValues.getUserPhoto()
                       ,null,null));
  
         }
         return vi;
	}

}
