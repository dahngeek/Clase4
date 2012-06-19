package com.culturaandroid.clase04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class MenuActivity extends Activity implements OnClickListener {
	TextView lblSaludo;
	Button btnFoto, btnLlamada;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		String nombre;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		sp = getSharedPreferences("SETT",Context.MODE_WORLD_WRITEABLE);
		if (sp.getString("usuario", "").equals("")) {
			 nombre = getIntent().getExtras().getString("nombre");
			 SharedPreferences.Editor edit = sp.edit();
			 edit.putString("usuario",nombre);
			 edit.commit();
		}else{
			 nombre= sp.getString("usuario","");
		}
		lblSaludo = (TextView) findViewById(R.id.lblSaludo);
		lblSaludo.setText("Hola " + nombre);
		btnFoto = (Button) findViewById(R.id.btnFoto);
		btnLlamada = (Button) findViewById(R.id.btnLlamada);
		btnFoto.setOnClickListener(this);
		btnLlamada.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent;
		intent = new Intent();
		if (v.getId() == R.id.btnFoto) {
			intent.setAction(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent,0);
		} else if (v.getId() == R.id.btnLlamada) {
			
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:110"));
			startActivity(intent);
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub

		super.onActivityResult(requestCode, resultCode, data);
		ImageView foto = (ImageView) findViewById(R.id.imgFoto);
		foto.setImageBitmap((Bitmap)getIntent().getExtras().get("data"));
	}

}
