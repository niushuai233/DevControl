package cc.niushuai.project.devcontrol.ui.device;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import cc.niushuai.project.devcontrol.databinding.DeviceActivityBinding;

public class DeviceActivity extends AppCompatActivity {

    private DeviceActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DeviceActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
