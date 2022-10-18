package cc.niushuai.project.devcontrol;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import cc.niushuai.project.devcontrol.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // 设置底部导航栏
        setBottomNavigationView();
    }

    /**
     * 设置底部导航栏
     *
     * @author niushuai
     * @date: 2022/10/13 10:42
     */
    private void setBottomNavigationView() {

        // 导航栏控制器 获取navController的方式不同
        // 方式一
        NavController navController = Navigation.findNavController(this, R.id.main_nav_host_fragment_activity);
        // 方式二
//        NavHostFragment fragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_nav_host_fragment_activity);
//        NavController navController = fragment.getNavController();

        // 顶部页签  右上角展开设置项
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                // 设备页签
//                R.id.id_bottom_nav_menu_device,
//                // 日志页签
//                R.id.id_bottom_nav_menu_log,
//                // 设置页签
//                R.id.id_bottom_nav_menu_set
//        ).build();
        // 返回键 左上角以及右上角
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // 页签点击监听
//        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
//            @Override
//            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
//                Toast.makeText(MainActivity.this, "onDestinationChanged Called: " + navDestination.getDisplayName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        // 底部导航栏
//        BottomNavigationView bottomNavView = this.findViewById(R.id.bottom_nav_view);

        // 底部栏显示
        NavigationUI.setupWithNavController(activityMainBinding.bottomNavView, navController);
    }
}