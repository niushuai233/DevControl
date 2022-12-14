package cc.niushuai.project.devcontrol.ui.nav.setup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import cc.niushuai.project.devcontrol.R;
import cc.niushuai.project.devcontrol.base.ui.BaseFragment;
import cc.niushuai.project.devcontrol.base.util.Keys;
import cc.niushuai.project.devcontrol.base.util.ToastUtil;
import cc.niushuai.project.devcontrol.base.util.XLog;
import cc.niushuai.project.devcontrol.databinding.MainNavFragmentSetUpBinding;
import cc.niushuai.project.devcontrol.db.entity.SysConfig;
import cc.niushuai.project.devcontrol.db.util.DBHelper;

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

        SysConfig switchConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_SWITCH);
        if (null == switchConfig) {
            DBHelper.configDeal(Keys.SETUP_LOG_SWITCH, XLog.SWITCH.toString());
        } else {
            binding.setupLogSwitchSwitch.setChecked(Boolean.parseBoolean(switchConfig.getValue()));
        }

        SysConfig levelConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_LEVEL);
        if (null == levelConfig) {
            DBHelper.configDeal(Keys.SETUP_LOG_LEVEL, XLog.ROOT_LEVEL_NAME);
        } else {
            String[] logLevel = getResources().getStringArray(R.array.logLevel);
            for (int i = 0; i < logLevel.length; i++) {
                String level = logLevel[i];
                if (level.equals(levelConfig.getValue())) {
                    binding.setupLogLevelSpinner.setSelection(i);
                    break;
                }
            }
        }

        SysConfig keepDayConfig = DBHelper.configOneByKey(Keys.SETUP_LOG_KEEP_DAY);
        if (null == keepDayConfig) {
            DBHelper.configDeal(Keys.SETUP_LOG_KEEP_DAY, XLog.KEEP_DAY.toString());
        } else {
            binding.setupLogKeepDayDisplay.setText(keepDayConfig.getValue());
        }

    }

    private void addListener() {

        // ??????????????????
        binding.setupLlGeneralBackup.setOnClickListener(this::setupBackupClickListener);
        // ??????????????????
        binding.setupLlGeneralRestore.setOnClickListener(this::setupRestoreClickListener);
        // ???????????????????????????
        binding.setupLogSwitchSwitch.setOnClickListener(this::setupLogSwitchClickListener);
        // ????????????????????????
        binding.setupLogLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String levelName = ((Spinner) parent.findViewById(R.id.setup_log_level_spinner)).getSelectedItem().toString();
                DBHelper.configDeal(Keys.SETUP_LOG_LEVEL, levelName);

                XLog.ROOT_LEVEL = XLog.Level.transform(levelName);
                XLog.ROOT_LEVEL_NAME = levelName;
                XLog.i(Keys.Tag.APP_SETUP, "?????????????????????: {}", XLog.ROOT_LEVEL_NAME);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // ??????????????????????????????
        binding.setupLlLogKeepDay.setOnClickListener(this::setupKeepDayClickListener);
    }


    private void setupBackupClickListener(View view) {
        ToastUtil.show(getActivity(), "????????????????????????");
    }

    private void setupRestoreClickListener(View view) {
        ToastUtil.show(getActivity(), "????????????????????????");
    }

    /**
     * ???????????????????????????
     *
     * @param view
     * @author niushuai
     * @date: 2022/10/27 17:00
     */
    private void setupLogSwitchClickListener(View view) {
        Boolean checked = binding.setupLogSwitchSwitch.isChecked();
        DBHelper.configDeal(Keys.SETUP_LOG_SWITCH, checked.toString());
        XLog.SWITCH = checked;
    }

    private void setupKeepDayClickListener(View view) {
        KeepDayDialogFragment keepDayDialogFragment = new KeepDayDialogFragment();
        keepDayDialogFragment.show(getActivity().getSupportFragmentManager(), KeepDayDialogFragment.class.getSimpleName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}