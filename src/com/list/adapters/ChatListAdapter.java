package com.list.adapters;

import java.util.ArrayList;

import com.list.models.ChatInboxModal;
import com.list.models.TweetModal;

import com.example.dreamtweats.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatListAdapter extends BaseAdapter {

	  private Activity activity;
      private ArrayList<ChatInboxModal> data;
      private static LayoutInflater inflater=null;
      public Resources res;
      ChatInboxModal tempValues=null;
      Typeface tf;
      int i=0;
      public ChatListAdapter(Activity a, ArrayList<ChatInboxModal> d, Resources r) {
    	  this.activity = a;
    	  this.data = d;
    	  this.res = r;
    	  inflater = ( LayoutInflater )activity.
                  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	  tf = Typeface.createFromAsset(a.getAssets(),"HelveticaNeueLTStd-Th.otf" );
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
         
         public TextView messageText;
         public TextView messageTime;
         public TextView dreamerName;
         public ImageView dreamerImage;
         public TextView unreadCount;
        // public ImageView dreamImage;
         
  
     }
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View vi = convertView;
         ViewHolder holder;
          
         if(convertView==null){
  
             vi = inflater.inflate(R.layout.chat_inbox_item, null);
             holder = new ViewHolder();
             holder.dreamerName = (TextView) vi.findViewById(R.id.dreamerName);
            /// holder.dreamImage=(ImageView)vi.findViewById(R.id.tweatImage);
             holder.messageText = (TextView) vi.findViewById(R.id.dreamerMessage);
             holder.messageTime=(TextView)vi.findViewById(R.id.messageTime);
             holder.dreamerImage=(ImageView)vi.findViewById(R.id.DreamerImage);
             holder.unreadCount = (TextView) vi.findViewById(R.id.unreadCount);
             
             vi.setTag( holder );
         }
         else 
             holder=(ViewHolder)vi.getTag();
          
         if(data.size()<=0)
         {
             holder.dreamerName.setText("No Data");
              
         }
         else
         {
            
             tempValues=null;
             tempValues = ( ChatInboxModal ) data.get( position );
             	holder.messageText.setTypeface(tf);
             	holder.messageTime.setTypeface(tf);
             	holder.dreamerName.setTypeface(tf);
             	holder.unreadCount.setTypeface(tf);
              holder.messageText.setText( tempValues.getTweatString() );
              holder.messageTime.setText( tempValues.getTweatTime() );
              holder.dreamerName.setText( tempValues.getUserName() );
              holder.unreadCount.setText(tempValues.getTweatLikes());
//               holder.dreamImage.setImageResource(
//                           res.getIdentifier(
//                           "com.example.dreamtweats:drawable/"+tempValues.getTweatPhoto()
//                           ,null,null));
               holder.dreamerImage.setImageResource(
                       res.getIdentifier(
                       "com.example.dreamtweats:drawable/"+tempValues.getUserPhoto()
                       ,null,null));
  
         }
         return vi;
	}

}
