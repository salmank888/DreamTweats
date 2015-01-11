package com.list.adapters;

import java.util.ArrayList;

import com.list.models.DreamDetailModal;
import com.list.models.TweetModal;

import com.dreamtweat.fragment.DreamDetails;
import com.dreamtweat.fragment.DreamListFragment;
import com.example.dreamtweats.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TweatListAdapter extends BaseAdapter implements OnClickListener {

	  private FragmentActivity activity;
      private ArrayList<TweetModal> data;
      private static LayoutInflater inflater=null;
      public Resources res;
      TweetModal tempValues=null;
      int i=0;
      public TweatListAdapter(FragmentActivity a, ArrayList<TweetModal> d, Resources r) {
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
        // public ImageView dreamImage;
         
  
     }
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 View vi = convertView;
         ViewHolder holder;
          
         if(convertView==null){
  
             vi = inflater.inflate(R.layout.tweat_item, null);
             holder = new ViewHolder();
             holder.userName = (TextView) vi.findViewById(R.id.username);
            /// holder.dreamImage=(ImageView)vi.findViewById(R.id.tweatImage);
             holder.dreamText = (TextView) vi.findViewById(R.id.tweatText);
             holder.dreamTime=(TextView)vi.findViewById(R.id.time_of_tweet);
             holder.userImage=(ImageView)vi.findViewById(R.id.userPhoto);
             holder.commentCount = (TextView) vi.findViewById(R.id.commentCount);
             holder.likesCount = (TextView) vi.findViewById(R.id.likeCount);
             
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
             tempValues = ( TweetModal ) data.get( position );
          
              holder.dreamText.setText( tempValues.getTweatString() );
              holder.dreamTime.setText( tempValues.getTweatTime() );
              holder.userName.setText( tempValues.getUserName() );
              holder.commentCount.setText(tempValues.getTweatComments());
              holder.likesCount.setText(tempValues.getTweatLikes());
//               holder.dreamImage.setImageResource(
//                           res.getIdentifier(
//                           "com.example.dreamtweats:drawable/"+tempValues.getTweatPhoto()
//                           ,null,null));
               holder.userImage.setImageResource(
                       res.getIdentifier(
                       "com.example.dreamtweats:drawable/"+tempValues.getUserPhoto()
                       ,null,null));
               vi.setOnClickListener(new OnItemClickListener(position));
         }
         return vi;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	private class OnItemClickListener  implements OnClickListener{           
        private int mPosition;
        
        OnItemClickListener(int position){
             mPosition = position;
        }
        
        @Override
        public void onClick(View arg0) {

        	performAction(mPosition);
        }

		private void performAction(int mPosition2) {
			// TODO Auto-generated method stub
			DreamDetailModal DDM = new DreamDetailModal(); 
			TweetModal tm = DreamListFragment.tweatArray.get(mPosition2);
			DDM.setTweetTime(tm.getTweatTime());
			DDM.setUserName(tm.getUserName());
			DDM.setUserPhoto(tm.getUserPhoto());
			DreamDetails dreamDetails = new DreamDetails();
			FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.dash_container, dreamDetails);
			transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			transaction.addToBackStack(null);
			transaction.commit();
			
		}               
    }   

}
