package cc.niushuai.project.devcontrol.ui.nav.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import cc.niushuai.project.devcontrol.base.ui.BaseFragment;
import cc.niushuai.project.devcontrol.base.util.IdWorker;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.XLog;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentSetUpBinding;
import cc.niushuai.project.devcontrol.db.DB;
import cc.niushuai.project.devcontrol.db.entity.SysConfig;
import cc.niushuai.project.devcontrol.db.util.DBHelper;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;

public class NavSetUpFragment extends BaseFragment {

    private MainNavFragmentSetUpBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = MainNavFragmentSetUpBinding.inflate(getLayoutInflater());

        View rootView = binding.getRoot();

        this.init();
        this.addListener();

        rootView.requestLayout();
        return rootView;
    }

    private void init() {

    }

    private void addListener() {

        // 备份点击事件
        binding.setupLlGeneralBackup.setOnClickListener(this::setupBackupClickListener);
        // 恢复点击事件
        binding.setupLlGeneralRestore.setOnClickListener(this::setupRestoreClickListener);
        // 日志总开关点击事件
        binding.setupLogSwitchSwitch.setOnClickListener(this::setupLogSwitchClickListener);
        // 日志级别点击事件
        binding.setupLogLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String level = ((TextView) view).getText().toString();

                dealConfig(Keys.SETUP_LOG_LEVEL, level);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // 日志保留天数点击事件
        binding.setupLlLogKeepDay.setOnClickListener(this::setupKeepDayClickListener);

    }


    private void setupBackupClickListener(View view) {
    }

    private void setupRestoreClickListener(View view) {
    }

    /**
     * 日志总开关点击触发
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/27 17:00
     */
    private void setupLogSwitchClickListener(View view) {
        Boolean checked = binding.setupLogSwitchSwitch.isChecked();
        XLog.LOG_SWITCH = checked;

        dealConfig(Keys.SETUP_LOG_SWITCH, checked.toString());
    }


    private void setupKeepDayClickListener(View view) {
    }

    private void dealConfig(String key, String level) {
        List<SysConfig> list = DBHelper.configListByKey(key);
        if (CollUtil.isNotEmpty(list)) {
            configUpdate(level, list.get(0));
            return;
        }
        configInsert(key, level);
    }

    private void configInsert(String key, String value) {
        DB.getSysConfigDao().insert(new SysConfig(IdWorker.getNextId(), key, value, DateUtil.now(), DateUtil.now()));
    }

    private void configUpdate(String level, SysConfig updateEntity) {
        updateEntity.setValue(level);
        updateEntity.setUpdateTime(DateUtil.now());

        DB.getSysConfigDao().update(updateEntity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}