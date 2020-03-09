package org.apache.cordova.aliyunsvideobase;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import android.app.Activity;
import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.aliyun.svideo.common.utils.FastClickUtil;

/**
 * This class echoes a string called from JavaScript.
 */
public class AliyunSVideoBase extends CordovaPlugin {
    /**
     * 录制activity
     */
    private static final String ACTIVITY_NAME_RECORD = "com.aliyun.svideo.snap.SnapRecorderSetting";
    /**
     * 裁剪activity
     */
    private static final String ACTIVITY_NAME_SNAP = "com.aliyun.svideo.snap.SnapCropSetting";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("test")) {
            String message = args.getString(0);
            this.showToast(message, callbackContext);
            return true;
        } else if (action.equals("startRecord")) {
            startRecord(cordova.getActivity());
            return true;
        } else if (action.equals("startCrop")) {
            startCrop(cordova.getActivity());
            return true;
        }
        return false;
    }

    private void showToast(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            Activity activity = this.cordova.getActivity();
            android.widget.Toast.makeText(activity, message, android.widget.Toast.LENGTH_SHORT).show();
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void startRecord(Activity activity){
        if (!FastClickUtil.isFastClickActivity(ACTIVITY_NAME_RECORD)) {
            // 视频拍摄
            Intent recorder = new Intent();
            recorder.setClassName(activity, ACTIVITY_NAME_RECORD);
            activity.startActivity(recorder);
        }
    }

    private void startCrop(Activity activity){
        if (!FastClickUtil.isFastClickActivity(ACTIVITY_NAME_SNAP)) {
            // 视频裁剪
            Intent crop = new Intent();
            crop.setClassName(activity, ACTIVITY_NAME_SNAP);
            activity.startActivity(crop);
        }
    }
}