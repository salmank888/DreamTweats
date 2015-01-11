package com.example.dreamtweats;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.dreamtweat.fragment.ChatInboxFragment;
import com.dreamtweat.fragment.CommentListFragment;
import com.dreamtweat.fragment.DreamListFragment;

public class DashboardActivity extends FragmentActivity{

	public static ActionBar actionbar;
	DreamListFragment dreamListFragment;
	public static ImageButton showChat;
	public static boolean isChatEnable = false;
	public static ImageView innerBgShade;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
		setContentView(R.layout.activity_dashboard);
		actionbar = getActionBar();
		actionbar.setDisplayShowHomeEnabled(false);
	    actionbar.setDisplayShowTitleEnabled(false);
	    actionbar.setDisplayShowCustomEnabled(true);
		actionbar.setTitle("");
		actionbar.setCustomView(R.layout.action_bar);
		actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.top_bar_bg));
		dreamListFragment = new DreamListFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.dash_container, dreamListFragment);
		transaction.commit();
		innerBgShade = (ImageView) findViewById(R.id.innerBgShade);
		showChat = (ImageButton) getActionBar().getCustomView().findViewById(R.id.showChat);
		showChat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!isChatEnable) {
					
					ChatInboxFragment chatInboxFragment = new ChatInboxFragment();
					FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
					transaction.replace(R.id.dash_container, chatInboxFragment);
					transaction.addToBackStack(null);
					getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
					transaction.commit();
					
				}
			}
		});
		
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
	}
	
}
