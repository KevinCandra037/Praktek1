package com.example.praktek1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.praktek1.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // tangkap nilai dari Intent
        Intent intent = getIntent();
        binding.etNama.setText(intent.getStringExtra("nilai_nama"));
        binding.etUsia.setText(intent.getStringExtra("nilai_usia"));

        // back button
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

}