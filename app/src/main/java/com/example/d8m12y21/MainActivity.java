package com.example.d8m12y21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author		Harel Leibovich <address @ example.com>
 * @version	1.0 (current version number of program)
 * @since		10/12/2021 (the date of the package the class was added)
 * main activity of the program
 */
public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout background;
    EditText et;

    String[] colorsName ={"RED","GREEN","BLUE"};
    int[] color = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = (LinearLayout) findViewById(R.id.back);


    }
    /**
     * open a dialog with list of background colors and change the background color by the choose of the user
     * (one option)
     * colors  included:
     * Red
     * Green
     * Blue
     * <p>
     *
     * @param	view Button (on click).
     */


    public void but1(View view) {
        color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);

        adb.setCancelable(false);
        adb.setTitle("choose one color");
        adb.setItems(colorsName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                background.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }
    /**
     * open a dialog with list of background colors and change the background color by the choose of the user
     * (multiple choose)
     * colors  included:
     * Red
     * Green
     * Blue
     * <p>
     *
     * @param	view Button (on click).
     */

    public void but2(View view) {
        color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);

        adb.setCancelable(false);
        adb.setTitle("choose one or more colors");
        adb.setMultiChoiceItems(colorsName, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    color[which] = 255;
                }else if (color[which] == 255){
                    color[which] = 0;
                }

            }
        });
        adb.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (color[0] != 0 || color[1] != 0 ||color[2] != 0){
                    background.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
                }
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();

    }
    /**
     * reset the background color to white
     * <p>
     *
     * @param	view Button (on click).
     */
    public void but3(View view) {
        background.setBackgroundColor(Color.WHITE);
    }
    /**
     * open a dialog with option to enter text and make a toast with the text.
     * <p>
     *
     * @param	view Button (on click).
     */
    public void but4(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setCancelable(false);
        adb.setTitle("enter any text");
        et = new EditText(this);
        et.setHint("enter text here");
        adb.setView(et);
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                if (str.length() >0){
                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                    dialog.dismiss();

                }else{
                    Toast.makeText(MainActivity.this,"text field was empty!",Toast.LENGTH_LONG).show();
                }
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }


    /**
     * create the menu.
     * <p>
     *
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    /**
     * move to the credits activity.
     * <p>
     *
     */
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.cridits1){
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }



}