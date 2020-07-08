package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView title,Subtitle_page,completeName,userName;
    Button BtnSave,BtnCancel;

    String SHARED_PREFS = "sharedPrefs";
    String SHARED_PREFS2 = "sharedPrefs2";
    String userCompleteName = "";
    String getUserCompleteName ;
    String userUserName = "";
    String getUserUserName;


    //why Object, should be class name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        title = findViewById (R.id.title);
        Subtitle_page = findViewById (R.id.subtitle_page);
        completeName=findViewById (R.id.completeName );
        userName=findViewById (R.id.userName );
        BtnCancel=findViewById (R.id.BtnCancel);
        BtnSave=findViewById (R.id.BtnSave );

        BtnSave.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString ( userCompleteName,completeName.getText ().toString ());
                editor.apply ();

                SharedPreferences sharedPreferencesII=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
                SharedPreferences.Editor editorII= sharedPreferencesII.edit();
                editorII.putString (userCompleteName,userName.getText ().toString ());
                editorII.apply ();

                Intent a = new Intent (MainActivity.this,BankAct.class );
                startActivity ( a);
            }
        });

        //import font
//        //import font
//        Typeface MLight = Typeface.createFromAsset ( getAssets (),"fonts/MLight.ttf" );
//       Typeface MMedium = Typeface.createFromAsset ( getAssets (),"fonts/MMedium.ttf" );
//        Typeface MRegular = Typeface.createFromAsset ( getAssets (),"fonts/MRegular.ttf" );


//        //customize font
//        title.setTypeface ( MRegular );
//       Subtitle_page.setTypeface ( MLight );
//       completeName.setTypeface ( MRegular );
//        userName.setTypeface ( MRegular );
//        BtnSave.setTypeface ( MMedium );
//        BtnCancel.setTypeface ( MLight );

        loadData ();
        updateData ();
    }
    public void loadData() {
        SharedPreferences sharedPreferences=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
        SharedPreferences sharedPreferencesII=getSharedPreferences ( SHARED_PREFS2,MODE_PRIVATE );
        getUserCompleteName = sharedPreferences.getString ( userCompleteName,"");
        getUserUserName = sharedPreferencesII.getString ( userUserName,"" );
    }
    public void updateData() {
        completeName.setText ( getUserCompleteName );
        userName.setText ( getUserUserName );
    }
}

