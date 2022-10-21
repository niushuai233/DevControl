package cc.niushuai.project.devcontrol.ui.powerswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseActivity;
import cc.niushuai.project.devcontrol.base.util.ActivityUtil;
import cc.niushuai.project.devcontrol.base.util.GlobalVariables;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.databinding.ActivityPowerSwitchSetBinding;

public class PowerSwitchSetActivity extends BaseActivity {

    private ActivityPowerSwitchSetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPowerSwitchSetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.init();
        this.addListener();
    }

    @Override
    protected void init() {
        this.device = GlobalVariables.getDeviceInfo(getIntentDeviceId());
        super.setTitle(getString(R.string.set), null);
    }

    @Override
    protected void addListener() {

        super.activityButtonBackClickListener(this);
        super.activityButtonMoreSetClickListener(false, null, null, null);

        binding.powerSwitchSetActivityItemIconChangeOutside.setOnClickListener(this::outsideIconChangeClickListener);
        binding.powerSwitchSetActivityItemParamSetOutside.setOnClickListener(this::outsideParamSetClickListener);
        binding.powerSwitchSetActivityItemLogViewOutside.setOnClickListener(this::outsideLogViewClickListener);
    }

    private void outsideIconChangeClickListener(View view) {
        Toast.makeText(this, "更换图标暂未实现哦", Toast.LENGTH_SHORT).show();
    }

    private void outsideParamSetClickListener(View view) {

        HashMap<String, String> withData = new HashMap<>(1);
        withData.put(Keys.ID, device.getId());
        ActivityUtil.startActivity(this, PowerSwitchSetParamActivity.class, withData);
    }

    private void outsideLogViewClickListener(View view) {
        Toast.makeText(this, "日志暂未实现哦", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}