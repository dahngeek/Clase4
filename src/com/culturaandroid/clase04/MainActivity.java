package com.culturaandroid.clase04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private Button btnLogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SharedPreferences sp = getSharedPreferences("SETT",Context.MODE_WORLD_READABLE);
        if (sp.getString("usuario", "").equals(""))
        {
               btnLogin = (Button) findViewById(R.id.btnLogin);
               btnLogin.setOnClickListener(new Button.OnClickListener() {
	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					EditText txtUsuario = (EditText) findViewById(R.id.txtUsuario);				
					Intent intent = new Intent(getBaseContext(),MenuActivity.class);
					intent.putExtra("nombre", txtUsuario.getText().toString());
					startActivity(intent);
				}
	        	
	        });
        }else {
        	Intent intent = new Intent(getBaseContext(),MenuActivity.class);
        	startActivity(intent);
        }
    }
}