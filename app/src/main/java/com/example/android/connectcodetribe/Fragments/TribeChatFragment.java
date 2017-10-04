package com.example.android.connectcodetribe.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.connectcodetribe.ActiveUserAdapter;
import com.example.android.connectcodetribe.Fragments.Model.ActiveUser;
import com.example.android.connectcodetribe.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10/4/2017.
 */

public class TribeChatFragment extends Fragment {
    private ListView mActiveUserListView;
    private ActiveUserAdapter mActiveUserAdapter;
    DatabaseReference mUserDatabaseReference;
    private FirebaseDatabase mFirebaseDatabase;
    ChildEventListener mUserChildEventListener;

    public TribeChatFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.user_list,container,false);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mUserDatabaseReference = mFirebaseDatabase.getReference().child("verified_user_profile");
        mActiveUserListView = rootView.findViewById(R.id.list);
        List<ActiveUser> activeUsers  = new ArrayList<>();
        mActiveUserAdapter = new ActiveUserAdapter(getActivity(),R.layout.user_item,activeUsers);
        mActiveUserListView.setAdapter(mActiveUserAdapter);

        mUserChildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ActiveUser activeUser = dataSnapshot.getValue(ActiveUser.class);
                mActiveUserAdapter.add(activeUser);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mUserDatabaseReference.addChildEventListener(mUserChildEventListener);



        return rootView;
    }
}
