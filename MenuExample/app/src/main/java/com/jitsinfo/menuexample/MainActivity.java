package com.jitsinfo.menuexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {
    final int OPEN_CAMERA_MENU = 1;
    final int DELETE_MENU = 2;
    final int GALLERY_MENU = 3;
    final int SAVE_MENU = 4;
    final int SEARCH_MENU = 5;
    final int SUB_MENU = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v("Message", "Inside onCreateOptionsMenu()");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.v("Message", "Inside onPrepareOptionsMenu()");

        menu.removeItem(OPEN_CAMERA_MENU);
        menu.removeItem(DELETE_MENU);
        menu.removeItem(GALLERY_MENU);
        menu.removeItem(SEARCH_MENU);
        menu.removeItem(SAVE_MENU);
        menu.removeItem(SUB_MENU);

        menu.add(0, OPEN_CAMERA_MENU, 0, "Camera").setIcon(android.R.drawable.ic_menu_camera);
        menu.add(0, GALLERY_MENU, 0, "Gallery").setIcon(android.R.drawable.ic_menu_gallery);
        menu.add(0, SAVE_MENU, 0, "Save").setIcon(android.R.drawable.ic_menu_save);
        menu.add(0, SEARCH_MENU, 0, "Search").setIcon(android.R.drawable.ic_menu_search);
        menu.add(0, DELETE_MENU, 0, "Delete").setIcon(android.R.drawable.ic_menu_delete);

        SubMenu subMenu = menu.addSubMenu(0, SUB_MENU, 0, "Sub Menu");
        subMenu.add("Sub Menu 1");
        subMenu.add("Sub Menu 2");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_menu) {
        } else if (item.getItemId() == OPEN_CAMERA_MENU) {
            //Launch camera intent only if device has camera
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, 0);
        } else if (item.getItemId() == GALLERY_MENU) {
            //Launch an intent to open gallery
        } else if (item.getItemId() == R.id.close_menu) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
