package com.dreamtweat.fragment;

import java.util.ArrayList;

import com.example.dreamtweats.DashboardActivity;
import com.example.dreamtweats.R;
import com.list.adapters.ChatListAdapter;
import com.list.adapters.TweatListAdapter;
import com.list.models.ChatInboxModal;
import com.list.models.TweetModal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ChatInboxFragment extends Fragment {

	ListView chatList;
	ChatListAdapter adapter;
	ArrayList<ChatInboxModal> chatArray = new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.chat_inbox_fragment_layout, container,false);
		DashboardActivity.isChatEnable = true;
		DashboardActivity.showChat.setImageResource(R.drawable.top_chat_icon_pressed);
		return rootView;
		
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		chatList = (ListView) getActivity().findViewById(R.id.chatList);
		adapter = new ChatListAdapter(getActivity(), chatArray, getResources());
		setListData();
		chatList.setAdapter(adapter);
	}
	private void setListData() {
		// TODO Auto-generated method stub
		for (int i = 1; i<8; i++)
		{
			final ChatInboxModal sched = new ChatInboxModal();
			sched.setTweatString("This is My Dream "+i);
			sched.setUserName("Dreamer "+i);
			sched.setTweatTime(i+":2"+i  +" AM");
			sched.setUserPhoto("user"+i);
			sched.setTweatPhoto("dream"+i);
			sched.setTweatLikes(""+i);
			chatArray.add(sched);
		}
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		chatArray.clear();
		DashboardActivity.isChatEnable = false;
		DashboardActivity.showChat.setImageResource(R.drawable.top_chat_icon);
	}
}
