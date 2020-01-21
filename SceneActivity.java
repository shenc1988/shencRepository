package com.example.myfirstapplication;

        import android.os.Bundle;
        import android.app.Activity;

public class SceneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SceneSurfaceView(this));
    }

}
