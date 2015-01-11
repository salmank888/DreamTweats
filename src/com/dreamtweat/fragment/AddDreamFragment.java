package com.dreamtweat.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dreamtweats.DashboardActivity;
import com.example.dreamtweats.R;

public class AddDreamFragment extends Fragment {

	Typeface tf;
	Button selectType;
	TextView dreamTextView;
	public static String myDream="";
	ImageView feather;
	RelativeLayout featherlayout;
	LinearLayout addDreamLayout;
	TranslateAnimation translateAnimation;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.add_dream_fragment_layout, container, false);
		BottomFragment.isShareActive = true;
		BottomFragment.share_dream_btn.setImageResource(R.drawable.share_dream_icon_active);
		DashboardActivity.innerBgShade.setBackgroundResource(Color.TRANSPARENT);
		return rootView;
	}
	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		tf = Typeface.createFromAsset(getActivity().getAssets(),"HelveticaNeueLTStd-Th.otf" );
		selectType = (Button) getActivity().findViewById(R.id.selectType);
		selectType.setTypeface(tf);
		dreamTextView = (TextView) getActivity().findViewById(R.id.myDream);
		dreamTextView.setTypeface(tf);
		dreamTextView.setHintTextColor(Color.WHITE);
		
		feather = (ImageView) getActivity().findViewById(R.id.feather);
		translateAnimation = new TranslateAnimation(0, 0, feather.getY(),-30);
		
		featherlayout = (RelativeLayout) getActivity().findViewById(R.id.featherConainer);
		addDreamLayout = (LinearLayout) getActivity().findViewById(R.id.addDreamContainer);
		selectType.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(dreamTextView.getText().length()<=0)
				{
					Toast.makeText(getActivity(), "Add your dream first", Toast.LENGTH_SHORT).show();
				}
				else
				{
					myDream = dreamTextView.getText().toString();
				UploadPhotoFragment selecPhoto = new UploadPhotoFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, selecPhoto);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack(null);
				transaction.commit();
				}
			}
		});
		
		addDreamLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dreamTextView.requestFocus();
				
			}
		});
		
		dreamTextView.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(hasFocus)
				{
					((ViewManager)feather.getParent()).removeView(feather);
					LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,0);
					p.weight = 1;
					featherlayout.setLayoutParams(p);
					LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,0);
					p1.weight = 6;
					dreamTextView.setLayoutParams(p1);
					
				}
			}
		});
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		BottomFragment.isShareActive = false;
		BottomFragment.share_dream_btn.setImageResource(R.drawable.share_dream_icon);
		DashboardActivity.innerBgShade.setBackgroundResource(R.drawable.inner_bg_shade);
		
	}
}
