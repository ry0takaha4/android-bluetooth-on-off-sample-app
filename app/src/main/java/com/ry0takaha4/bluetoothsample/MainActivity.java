package com.ry0takaha4.bluetoothsample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {


  private BluetoothAdapter mBluetoothAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Bluetooth 有効チェック
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (mBluetoothAdapter != null) {
      // 今回はBluetoothProfile.HEADSETだが、検知するだけであればなんでも良い
      mBluetoothAdapter.getProfileProxy(this, mProfileListener, BluetoothProfile.HEADSET);
    } else {
      System.out.println("この端末ではBluetoothはサポートされていないか、無効になっています。");
    }

  }


  /**
   * Bluetooth接続検知リスナー
   * 本体のBluetooth機能をオン・オフするたびに呼ばれる
   */
  private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() {
    public void onServiceConnected(int profile, BluetoothProfile proxy) {
      System.out.println("BluetoothがONになりました。");
      hoge();
      if (profile == BluetoothProfile.HEADSET) {
        // ...
      }
    }

    public void onServiceDisconnected(int profile) {
      System.out.println("BluetoothがOFFになりました。");
      foo();
      if (profile == BluetoothProfile.HEADSET) {
        // ...
      }
    }
  };

  private void hoge(){
    System.out.println("hoge called");
  }

  private void foo(){
    System.out.println("foo called");
  }
}
