package com.rnvega;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

import android.app.AlertDialog;
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

    @ReactMethod
    public void showDialog(ReadableMap options, Callback positiveCB, Callback negativeCB) {
        DialogParams dialogParams = new DialogParams();
        AlertDialog.Builder builder = new AlertDialog.Builder(getCurrentActivity());
        if (options.hasKey(dialogParams.title)) {
            builder.setTitle(options.getString(dialogParams.title));
        }
        if (options.hasKey(dialogParams.message)) {
            builder.setMessage(options.getString(dialogParams.message));
        }
        if (options.hasKey(dialogParams.positive)) {
            builder.setPositiveButton(options.getString(dialogParams.positive), (dialog, which) -> positiveCB.invoke());
        }
        if (options.hasKey(dialogParams.negative)) {
            builder.setNegativeButton(options.getString(dialogParams.negative), ((dialog, which) -> negativeCB.invoke()));
        }
        builder.create().show();
    }
    private class DialogParams {
        String title = "title";
        String message = "message";
        String positive = "positive";
        String negative = "negative";
    }
}