package com.example.design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class BankAct extends AppCompatActivity {
    TextView title,Subtitle_page,completeName,userName,Expired;
    Button btnEdit;

    String SHARED_PREFS = "sharedPrefs";
    String SHARED_PREFS2 = "sharedPrefs2";
    String userCompleteName = "";
    String getUserCompleteName ;
    String userUserName = "";
    String getUserUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        title = findViewById (R.id.title);
        Subtitle_page = findViewById (R.id.subtitle_page);
        completeName=findViewById (R.id.completeName );
        userName=findViewById (R.id.userName );
        Expired = findViewById ( R.id.expired );

        btnEdit = findViewById ( R.id.btnEdit );

        //import font
 Typeface MLight = Typeface.createFromAsset ( getAssets (),"fonts/MLight.ttf" );
        Typeface MMedium = Typeface.createFromAsset ( getAssets (),"fonts/MMedium.ttf" );
        Typeface MRegular = Typeface.createFromAsset ( getAssets (),"fonts/MRegular.ttf" );

//customize font
        title.setTypeface ( MRegular );
        Subtitle_page.setTypeface ( MLight );
        completeName.setTypeface ( MRegular );
        userName.setTypeface ( MRegular );
        

        btnEdit.setTypeface ( MMedium );
//        btnEdit.setOnClickListener ((new .OnClickListener ()){
//            Intent Intent = new Intent (BankAct.this,MainActivity.class);
//            startActivity ( Intent );
//        } );
        btnEdit.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BankAct.this, MainActivity.class);
                startActivity ( intent );
            }
        } );
        loadData();
        UpdateData();

    }
    public void loadData() {
        SharedPreferences sharedPreferences=getSharedPreferences ( SHARED_PREFS,MODE_PRIVATE );
        SharedPreferences sharedPreferencesII=getSharedPreferences ( SHARED_PREFS2,MODE_PRIVATE );
        getUserCompleteName = sharedPreferences.getString ( userCompleteName,"");
        getUserUserName = sharedPreferencesII.getString ( userUserName,"" );
    }
    public void UpdateData() {
        completeName.setText ( getUserCompleteName );
        userName.setText ( getUserUserName );
    }
}
