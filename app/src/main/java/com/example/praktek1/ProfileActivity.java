package com.example.praktek1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.praktek1.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // back button
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }
}