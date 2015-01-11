package com.list.adapters;

import java.util.ArrayList;

import com.list.models.ChatInboxModal;
import com.list.models.CommentModal;
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

public class CommentListAdapter extends BaseAdapter {

	  private Activity activity;
      private ArrayList<CommentModal> data;
      private static LayoutInflater inflater=null;
      public Resources res;
      CommentModal tempValues=null;
      Typeface tf;
      int i=0;
      public CommentListAdapter(Activity a, ArrayList<CommentModal> d, Resources r) {
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
         
         public TextView commentText1;
         public TextView commentTime;
         public TextView dreamerName;
         public ImageView dreamerImage;
         public TextView commentText2;
        // public ImageView dreamImage;
         
  
     }
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View vi = convertView;
         ViewHolder holder;
          
         if(convertView==null){
  
             vi = inflater.inflate(R.layout.comment_item, null);
             holder = new ViewHolder();
             holder.dreamerName = (TextView) vi.findViewById(R.id.userNameComment);
            /// holder.dreamImage=(ImageView)vi.findViewById(R.id.tweatImage);
             holder.commentText1 = (TextView) vi.findViewById(R.id.comment1);
             holder.commentTime=(TextView)vi.findViewById(R.id.time_of_comment);
             holder.dreamerImage=(ImageView)vi.findViewById(R.id.userImageComment);
             holder.commentText2 = (TextView) vi.findViewById(R.id.comment2);
             
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
             tempValues = ( CommentModal ) data.get( position );
             	
              holder.commentText1.setText( tempValues.getCommentString1() );
              holder.commentText2.setText( tempValues.getCommentString2() );
              holder.dreamerName.setText( tempValues.getUserName() );
              holder.commentTime.setText(tempValues.getTweatTime());
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
