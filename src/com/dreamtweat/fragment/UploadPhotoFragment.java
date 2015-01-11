package com.dreamtweat.fragment;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.example.dreamtweats.DashboardActivity;
import com.example.dreamtweats.R;
import com.extra.RoundedImageView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UploadPhotoFragment extends Fragment implements OnTouchListener
{
	TextView showDream;
	ImageButton addPhoto, changeFont;
	private static final int SELECT_PICTURE = 1;
	private String selectedImagePath;
	ImageView addDream;
	ImageButton goAhead;
	private ViewGroup mRrootLayout;
	private int _xDelta;
	private int _yDelta;
	Typeface tf1, tf2,tf3,tf,tf5,tf6;
	RoundedImageView roundedImageView;
	ArrayList<Typeface> typefaces = new ArrayList<>();
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.upload_photo_frgment, container, false);
		DashboardActivity.innerBgShade.setBackgroundResource(Color.TRANSPARENT);
		showDream = (TextView) rootView.findViewById(R.id.showDreamOnPic);
		showDream.setText(AddDreamFragment.myDream);
		showDream.setOnTouchListener(this);
		return rootView;
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		roundedImageView = new RoundedImageView(getActivity());
		addPhoto = (ImageButton) getActivity().findViewById(R.id.uploadPhotoBtn);
		addDream = (ImageView) getActivity().findViewById(R.id.dreamImageShow);
		changeFont = (ImageButton) getActivity().findViewById(R.id.changeFontButton);
		goAhead = (ImageButton) getActivity().findViewById(R.id.goAheadBtn);
		mRrootLayout = (ViewGroup) getActivity().findViewById(R.id.rootView);
		tf = Typeface.createFromAsset(getActivity().getAssets(),"HelveticaNeue.ttf" );
		tf1  = Typeface.createFromAsset(getActivity().getAssets(),"HelveticaNeueBoldItalic.ttf" );
		tf2 = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueCondensedBlack.ttf");
		tf3 = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueItalic.ttf");
		tf5 = Typeface.createFromAsset(getActivity().getAssets(), "HelveticaNeueLTStd-Th.otf");
		typefaces.add(tf);
		typefaces.add(tf1);
		typefaces.add(tf2);
		typefaces.add(tf3);
		typefaces.add(tf5);
		typefaces.add(tf6);
		goAhead.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectTypeFragment selectTypeFragment = new SelectTypeFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.dash_container, selectTypeFragment);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		addPhoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent = new Intent();
                 intent.setType("image/*");
                 intent.setAction(Intent.ACTION_GET_CONTENT);
                 startActivityForResult(Intent.createChooser(intent,
                         "Select Picture"), SELECT_PICTURE);
			}
		});
		changeFont.setOnClickListener(new OnClickListener() {
			int i = 0;
			@Override
			public void onClick(View v) {
				if(i<typefaces.size())
				{
					showDream.setTypeface(typefaces.get(i));
					i++;
				}
				else
				{
					i = 0;
				}
				
				
			}
		});
	}
	
	
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		DashboardActivity.innerBgShade.setBackgroundResource(R.drawable.inner_bg_shade);
	}
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == Activity.RESULT_OK) {
	        if (requestCode == SELECT_PICTURE) {
	            Uri selectedImageUri = data.getData();
	            if (Build.VERSION.SDK_INT < 19) {
	                selectedImagePath = getPath(selectedImageUri);
	                Bitmap bitmap = BitmapFactory.decodeFile(selectedImagePath);
	                Bitmap resized = Bitmap.createScaledBitmap(bitmap, 500, 300, true);
	                addDream.setImageBitmap(resized);
	                Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
	            }
	            else {
	                ParcelFileDescriptor parcelFileDescriptor;
	                try {
	                    parcelFileDescriptor = getActivity().getContentResolver().openFileDescriptor(selectedImageUri, "r");
	                    FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
	                    Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
	                    parcelFileDescriptor.close();
	                    Bitmap resized = Bitmap.createScaledBitmap(image, 500, 300, true);
	                    addDream.setImageBitmap(resized);
	                    Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
	                } catch (FileNotFoundException e) {
	                    e.printStackTrace();
	                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
	                }
	            }
	        }
	    }
	}
	public String getPath(Uri uri) {
        if( uri == null ) {
            return null;
        }
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if( cursor != null ){
            int column_index = cursor
            .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        return uri.getPath();
}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		DashboardActivity.innerBgShade.setBackgroundResource(Color.TRANSPARENT);
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		final int X = (int) event.getRawX();
		final int Y = (int) event.getRawY();
		switch (event.getAction() & MotionEvent.ACTION_MASK) {
		case MotionEvent.ACTION_DOWN:
			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
			_xDelta = X - lParams.leftMargin;
			_yDelta = Y - lParams.topMargin;
			break;
		case MotionEvent.ACTION_UP:
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			break;
		case MotionEvent.ACTION_POINTER_UP:
			break;
		case MotionEvent.ACTION_MOVE:
			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();
			layoutParams.leftMargin = X - _xDelta;
			layoutParams.topMargin = Y - _yDelta;
			layoutParams.rightMargin = -250;
			layoutParams.bottomMargin = -250;
			v.setLayoutParams(layoutParams);
			break;
		}
		mRrootLayout.invalidate();
		return true;
	}
}
