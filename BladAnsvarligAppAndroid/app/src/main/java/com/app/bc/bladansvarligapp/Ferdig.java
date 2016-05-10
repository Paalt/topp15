package com.app.bc.bladansvarligapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ferdig extends AppCompatActivity
{
	Button mSupplering;
	Button mFerdig;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ferdig);

		// Instatiate buttons
		mSupplering = (Button) findViewById(R.id.Supplering);
		mFerdig = (Button) findViewById(R.id.Ferdig);

		// Set listeners
		mSupplering.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				sendToSupplering();
			}
		});
		mFerdig.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				sendToHighFive();
			}
		});
	}

	private void sendToSupplering()
	{
		Intent intent = new Intent(this, Supplering.class);
		startActivity(intent);
	}

	private void sendToHighFive()
	{
		Intent intent = new Intent(this, HighFive.class);
		intent.putExtra(HighFive.POINTS, HighFive.HIGH_FIVE_SUPPLERING);
		startActivity(intent);
	}
}
