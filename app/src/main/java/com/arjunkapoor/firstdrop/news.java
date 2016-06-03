package com.arjunkapoor.firstdrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;

public class news extends AppCompatActivity {
    TextView mText1 ;
    TextView mText11;
    TextView mText2  ;
    TextView mText22  ;
    TextView mText3  ;
    TextView mText33  ;
    TextView mText4  ;
    TextView mText44 ;
    TextView mText5  ;
    TextView mText55  ;
    TextView mText6  ;
    TextView mText66  ;

    static boolean active = false;
    LinearLayout LayoutOnNullCount;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarnews);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("News");
        if(active == false){
            Button newsButton = (Button) findViewById(R.id.new_buttonnews);
            newsButton.setTextColor(Color.parseColor("#ffffff"));
            newsButton.setBackgroundColor(Color.parseColor("#1f1a1a"));
            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);

/*if(isNetworkAvailable() == false){
    LinearLayout layoutexisting = (LinearLayout) findViewById(R.id.cardlinearlayoutnews);
    layoutexisting.setVisibility(LinearLayout.GONE);
    LayoutOnNullCount = new LinearLayout(this);
    LayoutOnNullCount.setBackgroundColor(Color.parseColor("#F2F2F2"));
    LayoutOnNullCount.setOrientation(LinearLayout.VERTICAL);
    LinearLayout.LayoutParams LayoutOnNullCountParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    LayoutOnNullCount.setLayoutParams(LayoutOnNullCountParams);
    TextView Text = new TextView(this);
    Text.setText("\n\n\n\n\n\n\n\n\nNo internet connection");
    Text.setGravity(Gravity.CENTER);
    Text.setTextSize(20);


    LayoutOnNullCount.addView(Text);
    LinearLayout layoutparent = (LinearLayout) findViewById(R.id.cardlinearlayoutparentnews);
    layoutparent.addView(LayoutOnNullCount);
Toast.makeText(this,"No connection detected",Toast.LENGTH_SHORT).show();
*/


}
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new newsfragment(), "NEWS");
        adapter.addFragment(new knowledgefragment(), "KNOWLEDGE");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    public void profilebuttonnews(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void sharebuttonnews(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey here I found this cool application on play store for baby immnuization.Do download it from Google play via  = ";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

    }
    public void settingsbuttonnews(View view) {
        Intent i = new Intent(this, settings.class);
        startActivity(i);
    }
    /*public void onStart() {
        super.onStart();
        active = true;
        mText1 = (TextView) findViewById(R.id.text1);
         mText11  =(TextView) findViewById(R.id.text11);
         mText2  =(TextView) findViewById(R.id.text2);
         mText22  =(TextView) findViewById(R.id.text22);
         mText3  =(TextView) findViewById(R.id.text3);
         mText33  =(TextView) findViewById(R.id.text33);
         mText4  =(TextView) findViewById(R.id.text4);
         mText44  =(TextView) findViewById(R.id.text44);
         mText5  =(TextView) findViewById(R.id.text5);
         mText55  =(TextView) findViewById(R.id.text55);
         mText6  =(TextView) findViewById(R.id.text6);
         mText66  =(TextView) findViewById(R.id.text66);











        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Over");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText1.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Overdetail");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText11.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Intra");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText2.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Intradet");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText22.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Fort");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText3.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Fortdet");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText33.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Rota");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText4.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Rotadet");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText44.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/The");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText5.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Thedet");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText55.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Vacc");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText6.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mRef=new Firebase("http://sizzling-torch-6549.firebaseio.com/Vaccdet");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                mText66.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }*/
    public void onStop() {
        super.onStop();
        active = false;
    }
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}