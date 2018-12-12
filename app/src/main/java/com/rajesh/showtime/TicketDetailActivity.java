package com.rajesh.showtime;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rajesh.showtime.customView.TicketView;

public class TicketDetailActivity extends AppCompatActivity {

    private TextView txtName, txtDuration, txtDirector, txtGenre, txtRating, txtPrice, txtError;
    private ImageView imgPoster;
    private Button btnBuy;
    private ProgressBar progressBar;
    private TicketView ticketView;
    private Boolean isTicketUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        initViews();
        rendersViews();

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAndGoback();
            }
        });
    }

    private void updateAndGoback() {
        if (isTicketUpdate) {

        }
        onBackPressed();
    }

    private void rendersViews() {
        if (true) {
            txtName.setText("Name");
            txtDirector.setText("Director");
            txtDuration.setText("1:30");
            txtGenre.setText("Action");
            txtRating.setText("" + 3.5);
            txtPrice.setText("200");
            Glide.with(this).load("https://api.androidhive.info/barcodes/dunkirk.jpg").into(imgPoster);

            if (true) {
                btnBuy.setText(getString(R.string.btn_buy_now));
                btnBuy.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            } else {
                btnBuy.setText(getString(R.string.btn_coming_soon));
                btnBuy.setTextColor(ContextCompat.getColor(this, R.color.btn_disabled));
            }
            ticketView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    private void initViews() {
        txtName = findViewById(R.id.name);
        txtDirector = findViewById(R.id.director);
        txtDuration = findViewById(R.id.duration);
        txtPrice = findViewById(R.id.price);
        txtRating = findViewById(R.id.rating);
        imgPoster = findViewById(R.id.poster);
        txtGenre = findViewById(R.id.genre);
        btnBuy = findViewById(R.id.btn_buy);
        imgPoster = findViewById(R.id.poster);
        txtError = findViewById(R.id.txt_error);
        ticketView = findViewById(R.id.layout_ticket);
        progressBar = findViewById(R.id.progressBar);
    }
}
