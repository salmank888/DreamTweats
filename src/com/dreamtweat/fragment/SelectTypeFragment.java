package com.dreamtweat.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dreamtweats.DashboardActivity;
import com.example.dreamtweats.R;

public class SelectTypeFragment extends Fragment implements OnClickListener {
	
	boolean isDay = false, isNight = false;
	String mainType = "";
	LinearLayout linearLayout;
	EditText hasEditText;
	String hashTag = "";
	TextView tv1, tv2, tv3;
	int hashtagCount = 0;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.select_type_fragment_layout, container, false);
		
		DashboardActivity.innerBgShade.setBackgroundResource(Color.TRANSPARENT);
		return rootView;
		
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		linearLayout = (LinearLayout) getActivity().findViewById(R.id.hashTagsLayout);
		hasEditText = (EditText) getActivity().findViewById(R.id.hashtagEditText);
		hasEditText.setHintTextColor(Color.WHITE);
		hasEditText.setTextColor(Color.WHITE);
		hasEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				 if (s.length()>0 && s.subSequence(s.length()-1, s.length()).toString().equalsIgnoreCase("\n")) {
					 hashtagCount++;
	                	if(hashtagCount<5)
	                	{
	                    addhashTagFromTextBox();
	                	}
	                	else
	                	{
	                		Toast.makeText(getActivity(), "Only 4 Hashtag Allowed", Toast.LENGTH_SHORT).show();
	                	}
				    }
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void addhashTagFromTextBox() {
		// TODO Auto-generated method stub
		LinearLayout.LayoutParams prams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		prams.setMargins(10,5 , 0, 0);
		tv1 = new TextView(getActivity());
		tv1.setBackgroundResource(R.drawable.hashtag_bg);
		if(hasEditText.getText().length() > 0)
		{
		tv1.setText(hasEditText.getText());
		tv1.setTextColor(Color.WHITE);
		tv1.setLayoutParams(prams);
		tv1.setGravity(Gravity.CENTER);
		linearLayout.addView(tv1);
		hasEditText.setText("");
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		DashboardActivity.innerBgShade.setBackgroundResource(R.drawable.inner_bg_shade);
		
	}
}
