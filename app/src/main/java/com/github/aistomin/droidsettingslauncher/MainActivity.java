package com.github.aistomin.droidsettingslauncher;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnMain).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    launchComponent(
                        MainActivity.this,
                        "com.droidlogic.tv.settings/.MainSettings"
                    );
                }
            }
        );
        findViewById(R.id.btnDisplay).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    launchComponent(
                        MainActivity.this,
                        "com.droidlogic.tv.settings/.display.DisplayActivity"
                    );
                }
            }
        );
    }

    /**
     * Launch a system component.
     *
     * @param context Application context.
     * @param comp    Component's name.
     */
    private void launchComponent(
        final Context context, final String comp
    ) {

        try {
            final Intent intent = new Intent("com.intent.MAIN");
            intent.setComponent(ComponentName.unflattenFromString(comp));
            context.startActivity(intent);
        } catch (final ActivityNotFoundException exception) {
            Toast.makeText(
                context, String.format("Component %s not found.", comp),
                Toast.LENGTH_LONG
            ).show();
        }
    }
}
