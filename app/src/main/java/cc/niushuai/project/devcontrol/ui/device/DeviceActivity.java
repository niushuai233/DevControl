package cc.niushuai.project.devcontrol.ui.device;

import android.os.Bundle;

import cc.niushuai.project.devcontrol.base.activity.BaseActivity;
import cc.niushuai.project.devcontrol.databinding.DeviceActivityBinding;

public class DeviceActivity extends BaseActivity {

    private DeviceActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏自带的标题栏
        getSupportActionBar().hide();

        binding = DeviceActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
