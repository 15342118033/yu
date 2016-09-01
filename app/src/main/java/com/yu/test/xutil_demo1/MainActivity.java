package com.yu.test.xutil_demo1;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(value = R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(value = R.id.dra_lv_menu)
    private ListView lvLeftMenu;
    @ViewInject(value = R.id.tl_custom)
    private Toolbar toolbar;
    @ViewInject(value = R.id.dl_left)
    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;
    private String[] lvs = {"ee","dd","cc","bb","aa"};
    private ArrayAdapter arrayAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        /*设置toolbar的标题*/
        toolbar.setTitle("Toolbar");
        /*设置标题颜色*/
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        /*设置返回键可用*/
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       /* List<String> list=new ArrayList<String>();
        list.add("AA");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lvLeftMenu.setAdapter(adapter);


        drawerLayout.setDrawerListener(mDrawerToggle);*/


        /*创建返回键，并实现打开/关闭监听*/
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.closed) {


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                System.out.println("关闭");
//                invalidateOptionsMenu();
                /*mAnimationDrawable.stop();*/
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                System.out.println("打开");
                /*mAnimationDrawable.start();*/

            }
        };
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);
        /*设置菜单列表*/
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }
}
