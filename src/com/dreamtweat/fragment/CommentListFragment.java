package com.dreamtweat.fragment;

import java.util.ArrayList;

import com.example.dreamtweats.R;
import com.list.adapters.CommentListAdapter;
import com.list.models.CommentModal;
import com.list.models.TweetModal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CommentListFragment extends Fragment {

	ListView commentList;
	CommentListAdapter adapter;
	ArrayList<CommentModal> commentArray = new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.comment_list_layout, container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		commentList = (ListView) getActivity().findViewById(R.id.commentList);
		adapter = new CommentListAdapter(getActivity(), commentArray, getResources());
		setListData();
		commentList.setAdapter(adapter);
	}
	public void setListData()
	{
		for (int i = 1; i<5; i++)
		{
			final CommentModal sched = new CommentModal();
			sched.setCommentString1("comment line 1");
			sched.setCommentString2("comment line 2");
			sched.setUserName("User "+i);
			sched.setTweatTime(i +" min ago");
			sched.setUserPhoto("user"+i);
			commentArray.add(sched);
		}
	}
}
