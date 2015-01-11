package com.dreamtweat.fragment;

import java.util.ArrayList;

import com.example.dreamtweats.R;
import com.list.adapters.AlertListAdapter;
import com.list.adapters.TweatListAdapter;
import com.list.models.AlertModal;
import com.list.models.TweetModal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AlertsFragment extends Fragment {
	ListView alertList;
	AlertListAdapter adapter;
	ArrayList<AlertModal> alertArray = new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.alerts_fragment_activity, container, false);
		BottomFragment.isAlertActive = true;
		BottomFragment.alertButton.setImageResource(R.drawable.alerts_icon_normal);
		return rootView;
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		alertList = (ListView) getActivity().findViewById(R.id.notificationList);
		adapter = new AlertListAdapter(getActivity(), alertArray, getResources());
		setListData();
		alertList.setAdapter(adapter);
	}
	private void setListData() {
		// TODO Auto-generated method stub
		for (int i = 1; i<5; i++)
		{
			final AlertModal sched = new AlertModal();
			switch (i) {
			case 1:
				sched.setTweatString("followed you");
				sched.setUserName("User "+i);
				sched.setTweatTime(i +" min ago");
				sched.setUserPhoto("user"+i);
				sched.setTweatPhoto(""+i);
				break;

			case 2:
				sched.setTweatString("liked you dream ");
				sched.setUserName("User "+i);
				sched.setTweatTime(i +" min ago");
				sched.setUserPhoto("user"+i);
				sched.setTweatPhoto("");
				break;
			case 3:
				sched.setTweatString("followed you ");
				sched.setUserName("User "+i);
				sched.setTweatTime(i +" min ago");
				sched.setUserPhoto("user"+i);
				sched.setTweatPhoto("");
				break;
			case 4:
				sched.setTweatString("added a new dream "+i);
				sched.setUserName("User "+i);
				sched.setTweatTime(i +" min ago");
				sched.setUserPhoto("user"+i);
				sched.setTweatPhoto("dream"+i);
				break;
			}
			
			alertArray.add(sched);
		}
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		BottomFragment.isAlertActive = false;
		BottomFragment.alertButton.setImageResource(R.drawable.alerts_icon_pressed);
	}
}
