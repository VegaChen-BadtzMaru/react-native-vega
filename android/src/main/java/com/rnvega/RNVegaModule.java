package com.rnvega;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.widget.Toast;

public class RNVegaModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNVegaModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNVega";
    }

    @ReactMethod
    public void sayHello() {
        Toast.makeText(getReactApplicationContext(), "hello!", Toast.LENGTH_SHORT).show();
    }

}