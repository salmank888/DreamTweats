package com.dreamtweat.fragment;

import java.util.ArrayList;

import com.example.dreamtweats.R;
import com.list.adapters.TweatListAdapter;
import com.list.models.TweetModal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class DreamListFragment extends Fragment {

	ListView tweatList;
	TweatListAdapter adapter;
	public static ArrayList<TweetModal> tweatArray = new ArrayList<TweetModal>();
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.dream_list_fragment_layout, container,false);
		BottomFragment.isHomeActive = true;
		BottomFragment.homeButton.setImageResource(R.drawable.home_icon_normal);
		return rootView;
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		tweatList = (ListView) getActivity().findViewById(R.id.tweatList);
		adapter = new  TweatListAdapter(getActivity(),tweatArray, getActivity().getResources());
		setListData();
		tweatList.setAdapter(adapter);
	}
	private void setListData() {
		// TODO Auto-generated method stub
		
		for (int i = 1; i<5; i++)
		{
			final TweetModal sched = new TweetModal();
			sched.setTweatString("This is My Dream "+i);
			sched.setUserName("User "+i);
			sched.setTweatTime(i +" min ago");
			sched.setUserPhoto("user"+i);
			sched.setTweatPhoto("dream"+i);
			sched.setTweatComments(""+i);
			sched.setTweatLikes("1"+i);
			tweatArray.add(sched);
		}
		Toast.makeText(getActivity(), tweatArray.size()+"", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		tweatArray.clear();
		BottomFragment.isHomeActive = false;
		BottomFragment.homeButton.setImageResource(R.drawable.home_icon_pressed);
	}
	
}
