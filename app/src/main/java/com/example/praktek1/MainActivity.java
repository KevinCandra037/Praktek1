package com.example.praktek1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.praktek1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btProfil.setOnClickListener(view -> startActivity(new Intent(view.getContext(), ProfileActivity.class)));

        binding.btSimpan.setOnClickListener(view -> {
            // kirimkan data ke Detail Activity
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("nilai_nama", binding.etNama.getText().toString());
            intent.putExtra("nilai_usia", binding.etUsia.getText().toString());
            startActivity(intent);
        });

        binding.btUlangi.setOnClickListener(view -> {
            //kosongkan et_nama dan et_usia
            binding.etNama.setText(null);
            binding.etUsia.setText(null);
        });

        binding.btHitung.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), HitungActivity.class);
            intentLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> intentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    assert result.getData() != null;
                    binding.etHasil.setText(result.getData().getStringExtra("nilai_hasil"));
                }
            }
    );
}