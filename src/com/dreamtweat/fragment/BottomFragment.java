package com.dreamtweat.fragment;
import com.example.dreamtweats.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class BottomFragment extends Fragment implements OnClickListener
{
	public static ImageButton topics_btn;
	public static ImageButton share_dream_btn;
	public static ImageButton profileButton;
	public static ImageButton alertButton;
	public static ImageButton homeButton;
	public static boolean isShareActive = false;
	public static boolean isTypesActive = false;
	public static boolean isProfileActive = false;
	public static boolean isAlertActive = false;
	public static boolean isHomeActive = false;
	LinearLayout topicLayout,homeLayout,shareLayout,profileLayout,alertLayout;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView=  inflater.inflate(R.layout.bottom_fragment_layout, null);
		return rootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		topics_btn = (ImageButton) getActivity().findViewById(R.id.topicsBtn);
		share_dream_btn = (ImageButton) getActivity().findViewById(R.id.shareBtn);
		profileButton = (ImageButton) getActivity().findViewById(R.id.profileBtn);
		alertButton = (ImageButton) getActivity().findViewById(R.id.alertsBtn);
		homeButton = (ImageButton) getActivity().findViewById(R.id.homeBtn);
		homeLayout = (LinearLayout) getActivity().findViewById(R.id.homeEvent);
		alertLayout = (LinearLayout) getActivity().findViewById(R.id.alertEvent);
		profileLayout = (LinearLayout) getActivity().findViewById(R.id.profileEvent);
		shareLayout = (LinearLayout) getActivity().findViewById(R.id.shareEvent);
		topicLayout = (LinearLayout) getActivity().findViewById(R.id.topicEvent);
		topicLayout.setOnClickListener(this);
		shareLayout.setOnClickListener(this);
		profileLayout.setOnClickListener(this);
		alertLayout.setOnClickListener(this);
		homeLayout.setOnClickListener(this);
		homeButton.setOnClickListener(this);
		alertButton.setOnClickListener(this);
		topics_btn.setOnClickListener(this);
		profileButton.setOnClickListener(this);
		share_dream_btn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if ((v.getId() == R.id.shareBtn) || (v.getId() == R.id.shareEvent))
		{
			if(!isShareActive)
			{
				AddDreamFragment addDream = new AddDreamFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, addDream);
				transaction.addToBackStack("share");
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				transaction.commit();
				
			}
		}
		else if((v.getId() == R.id.topicEvent) || (v.getId() == R.id.topicsBtn))
		{
			if(!isTypesActive)
			{
				TopicsFragment topics = new TopicsFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, topics);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack("profile");
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				transaction.commit();
				
				
			}
			
		}
		else if((v.getId() == R.id.profileBtn) || (v.getId() == R.id.profileEvent))
		{
			if(!isProfileActive)
			{
				DreamerProfileFragment profileFragment = new DreamerProfileFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, profileFragment);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack("profile");
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				transaction.commit();
				
			}
		}
		else if((v.getId() == R.id.alertsBtn) || (v.getId() == R.id.alertEvent))
		{
			if(!isAlertActive)
			{
				AlertsFragment alertsFragment = new AlertsFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, alertsFragment);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack("alert");
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				transaction.commit();
				
			}
			
		}
		else if((v.getId() == R.id.homeBtn) || (v.getId() == R.id.homeEvent))
		{
			if(!isHomeActive)
			{
				DreamListFragment dreamListFragment = new DreamListFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, dreamListFragment,"DreamList");
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack("home");
				getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
				transaction.commit();
				
			}
			
		}
		
	}
}
