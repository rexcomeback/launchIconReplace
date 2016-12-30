package test.replace.icon.iconreplacetest;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ComponentName mDouble1;
    private ComponentName mDefault;


    private PackageManager mPm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDefault = new ComponentName(getBaseContext(), "test.replace.icon.iconreplacetest.MainActivity");
        mDouble1 = new ComponentName(getBaseContext(), "test.replace.icon.iconreplacetest.Test11");
        mPm = getApplicationContext().getPackageManager();
    }
    public void changeIcon11(View view) {
        disableComponent(mDefault);
        enableComponent(mDouble1);
    }

    public void changeIconDefault(View view) {
        disableComponent(mDouble1);
        enableComponent(mDefault);
    }

    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}
