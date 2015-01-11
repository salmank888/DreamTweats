package com.dreamtweat.fragment;

import com.example.dreamtweats.R;
import com.list.models.DreamDetailModal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DreamDetails extends Fragment {

	ImageView userPhoto;
	TextView userName;
	TextView dreamTime;
	TextView viewallComment;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.dream_detail_layout, container, false);
		return rootView;
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		DreamDetailModal ddm = new DreamDetailModal();
		userPhoto = (ImageView) getActivity().findViewById(R.id.userPhotoDetail);
		userName = (TextView) getActivity().findViewById(R.id.usernameDetail);
		dreamTime = (TextView) getActivity().findViewById(R.id.time_of_tweet_Detail);
		viewallComment = (TextView) getActivity().findViewById(R.id.viewAllComments);
		//userName.setText(ddm.getUserName());
		//dreamTime.setText(ddm.getTweetTime());
		viewallComment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CommentListFragment commentListFragment = new CommentListFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, commentListFragment,"DreamListFragment");
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
	}
}
