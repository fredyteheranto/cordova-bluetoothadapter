package com.fredyteheranto;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import java.util.Date;

public class Bluetoothadapters extends CordovaPlugin {
  private static final String TAG = "Bluetoothadapters";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Inicializando Bluetoothadapters");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    BluetoothAdapter bluetoothAdapter;

    BluetoothAdapter.getDefaultAdapter();
    String bluetoothMacAddress = "";
    try {
      Field mServiceField = bluetoothAdapter.getClass().getDeclaredField("mService");
      mServiceField.setAccessible(true);

      Object btManagerService = mServiceField.get(bluetoothAdapter);

      if (btManagerService != null) {
        bluetoothMacAddress = (String) btManagerService.getClass().getMethod("getAddress").invoke(btManagerService);
      }
    } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException ignore) {

    }
    return bluetoothMacAddress;

  }

}
