package com.dreamtweat.fragment;

import com.example.dreamtweats.DashboardActivity;
import com.example.dreamtweats.R;
import com.list.adapters.CustomGridAdapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TopicsFragment extends Fragment implements OnClickListener {

	ImageButton dayDream;
	ImageButton nightDream;
	boolean isDayDream = false, isNightDream = false;
	LinearLayout linearLayout;
	 GridView gridView;
	 static final String[ ] GRID_DATA = new String[] {
         "Recurring" ,
         "Scary",
         "LOL" ,
         "Happy",
         "Sci-Fi" ,
         "WTF",
         "Nature",
         "Animal",       
         "War" 
      };
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.topics_fragment_layout, container, false);
		BottomFragment.isTypesActive = true;
		BottomFragment.topics_btn.setImageResource(R.drawable.topics_icon_normal);
		
		return rootView;
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		dayDream = (ImageButton) getActivity().findViewById(R.id.categoryDayDream);
		nightDream = (ImageButton) getActivity().findViewById(R.id.categoryNightDream);
		linearLayout = (LinearLayout) getActivity().findViewById(R.id.categoryLayout);
		dayDream.setOnClickListener(this);
		nightDream.setOnClickListener(this);
		 gridView = (GridView) getActivity().findViewById(R.id.gridView);
		 gridView.setAdapter(  new CustomGridAdapter( getActivity(), GRID_DATA ) );
	}
	@SuppressLint("NewApi")
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		BottomFragment.isTypesActive = false;
		BottomFragment.topics_btn.setImageResource(R.drawable.topics_icon_pressed);
		DashboardActivity.actionbar.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.top_bar_bg));
		
	}
	@SuppressLint("NewApi")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.categoryDayDream:
			
				if(!isDayDream)
				{
					linearLayout.setBackgroundResource(R.drawable.day_dream_bg);
					DashboardActivity.actionbar.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.day_dream_top_bar));
					isDayDream= true;
					isNightDream = false;
				}
			break;

		case R.id.categoryNightDream:
			if(!isNightDream)
			{
				linearLayout.setBackgroundResource(R.drawable.main_bg);
				DashboardActivity.actionbar.setBackgroundDrawable(getActivity().getResources().getDrawable(R.drawable.top_bar_bg));
				isDayDream= false;
				isNightDream = true;
			}
			break;	
		}
	}
}
