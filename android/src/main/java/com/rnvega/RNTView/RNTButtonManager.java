package com.rnvega.RNTView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.rnvega.R;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.Map;

public class RNTButtonManager extends SimpleViewManager<Button> {
    public static final String REACT_CLASS = "RNTAnButton";
    ReactApplicationContext mCallerContext;

    public RNTButtonManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected Button createViewInstance(ThemedReactContext reactContext) {
        Button btn = new Button(mCallerContext);
        btn.setText(R.string.default_text);
        btn.setAllCaps(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WritableMap event = Arguments.createMap();
                event.putString("message", "MyMessage");
                mCallerContext.getJSModule(RCTEventEmitter.class).receiveEvent(btn.getId(), "onClick", event);
            }
        });
        return btn;
    }

    @ReactProp(name = "text")
    public void setText(Button btn, String text) {
        btn.setText(text);
    }

    @ReactProp(name = "textSize")
    public void setTextSize(Button btn, float size) {
        btn.setTextSize(size);
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(Button btn, String backgroundColor) {
        btn.setBackgroundColor(Color.parseColor(backgroundColor));
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onClick",
                        MapBuilder.of(
                                "phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onClick")))
                .build();
    }
}