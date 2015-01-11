package com.dreamtweat.fragment;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.dreamtweats.R;
import com.extra.RoundedImageView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class DreamerProfileFragment extends Fragment {

	ImageButton changeProfilePic;
	private static final int SELECT_PICTURE = 1;
	private String selectedImagePath;
	RoundedImageView roundedImageView;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.profile_fragment_layout, container, false);
		BottomFragment.isProfileActive = true;
		BottomFragment.profileButton.setImageResource(R.drawable.profile_icon_normal);
		return rootView;
		
	}
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		roundedImageView = new RoundedImageView(getActivity());
		changeProfilePic = (ImageButton) getActivity().findViewById(R.id.profilePic);
		changeProfilePic.setOnClickListener(new OnClickListener() {
			
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
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		BottomFragment.isProfileActive = false;
		BottomFragment.profileButton.setImageResource(R.drawable.profile_icon_pressed);
	}
	@SuppressWarnings("static-access")
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == Activity.RESULT_OK) {
	        if (requestCode == SELECT_PICTURE) {
	            Uri selectedImageUri = data.getData();
	            if (Build.VERSION.SDK_INT < 19) {
	                selectedImagePath = getPath(selectedImageUri);
	                Bitmap bitmap = BitmapFactory.decodeFile(selectedImagePath);
	                Bitmap resized = Bitmap.createScaledBitmap(bitmap, 150, 150, true);
	                resized = roundedImageView.getCroppedBitmap(resized, 150);
	                changeProfilePic.setImageBitmap(resized);
	                Toast.makeText(getActivity(), "Added", Toast.LENGTH_SHORT).show();
	            }
	            else {
	                ParcelFileDescriptor parcelFileDescriptor;
	                try {
	                    parcelFileDescriptor = getActivity().getContentResolver().openFileDescriptor(selectedImageUri, "r");
	                    FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
	                    Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
	                    parcelFileDescriptor.close();
	                    Bitmap resized = Bitmap.createScaledBitmap(image,150 , 150, true);
	                    resized = roundedImageView.getCroppedBitmap(resized, 150);
	                    changeProfilePic.setImageBitmap(resized);
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
}
