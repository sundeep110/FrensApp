package com.finc.frensapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements FrensApps.OnFragmentInteractionListener,
        TopApps.OnFragmentInteractionListener, MyApps.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("main activity", "in oncreate");

        setContentView(R.layout.activity_main);
        // create the TabHost that will contain the Tabs
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        setUpTabs(tabHost);
        new DownloadImageTask((ImageView) findViewById(R.id.img1))
                .execute("http://cntcdn.cntraveller.in/sites/default/files/Hyderabad3-Alamy-D9K7KC.jpg");

    }

    private void setUpTabs(FragmentTabHost tabHost) {
        TabSpec tab1 = tabHost.newTabSpec("Top Apps");
        TabSpec tab2 = tabHost.newTabSpec("My Apps");
        TabSpec tab3 = tabHost.newTabSpec("Frens Apps");


        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator(createTabView(tabHost.getContext(), "Top Apps"));
        tab2.setIndicator(createTabView(tabHost.getContext(), "My Apps"));
        tab3.setIndicator(createTabView(tabHost.getContext(), "Frens Apps"));

        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1, TopApps.class, null);
        tabHost.addTab(tab2, MyApps.class, null);
        tabHost.addTab(tab3, FrensApps.class, null);
    }

    private View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) view.findViewById(R.id.tabsText);
        tv.setText(text);
        return view;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}




