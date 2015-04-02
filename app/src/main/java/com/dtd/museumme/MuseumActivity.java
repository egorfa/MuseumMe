package com.dtd.museumme;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.Arrays;
import java.util.List;


public class MuseumActivity extends SherlockFragmentActivity {

    private Handler mHandler;
    private BluetoothAdapter mBluetoothAdapter;
    private boolean mScanning;

    static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    private static final int REQUEST_ENABLE_BT = 1;
    // Stops scanning after 10 seconds.
    private static final long SCAN_PERIOD = 20000;

    public SlidingMenu menu;
    public List<String> MenuItemTitles;
    ListView MenuList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museum);

        mHandler = new Handler();
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();

        MenuItemTitles = Arrays.asList(getResources().getStringArray(R.array.MenuList));

        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(0.9f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sidemenu);
        menu.setBehindWidthRes(R.dimen.slidingmenu_behind_width);

        MenuList = (ListView) findViewById(R.id.MenuList);
        MenuListAdapter adapter = new MenuListAdapter(this, R.layout.menu_list_item, MenuItemTitles);
        MenuList.setAdapter(adapter);

        MenuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                menuToggle();
                changeFragment(position);
            }
        });

        changeFragment(0);


    }

    @Override
    protected void onResume() {
        super.onResume();



        Intent intent = getIntent();
        int d = intent.getIntExtra("1", 0);
        Uri data = intent.getData();
        if(d!=0 && data!=null){
            Log.d("intent", "HERE");
            scanLeDevice(false);
        }else {

            if (!mBluetoothAdapter.isEnabled()) {
                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(
                            BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                }
            }

        }

        // Initializes list view adapter.


    }

    @Override
    protected void onPause() {
        super.onPause();
        scanLeDevice(false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // User chose not to enable Bluetooth.
        if (requestCode == REQUEST_ENABLE_BT
                && resultCode == Activity.RESULT_CANCELED) {
            finish();

            scanLeDevice(false);
            return;
        }else{
            scanLeDevice(true);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void scanLeDevice(final boolean enable) {
        if (enable) {
            // Stops scanning after a pre-defined scan period.
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLeScanCallback);
                    invalidateOptionsMenu();
                }
            }, SCAN_PERIOD);

            mScanning = true;
            mBluetoothAdapter.startLeScan(mLeScanCallback);
        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLeScanCallback);
        }
        invalidateOptionsMenu();
    }


    private void changeFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);
        switch (position) {
            case 0:
                //Список экспонатов первого этажа
                if (!(currentFragment instanceof ListExhibit)) {
                    showFragment(new ListExhibit());
                }
                break;
            case 1:
                if (!(currentFragment instanceof ListExhibit)) {
                    showFragment(new ListExhibit());
                }
                break;
            case 2:
                if (!(currentFragment instanceof ListExhibit)) {
                    showFragment(new ListExhibit());
                }
                break;
            case 3:
                //Настройки
                if (!(currentFragment instanceof FragmentSettings)) {
                    showFragment(new FragmentSettings());
                }
                break;
        }
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {

        @Override
        public void onLeScan(final BluetoothDevice device, final int rssi,
                             byte[] scanRecord) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();


                    Log.d("EGORRR", "rssi=" + rssi);
                    ParcelUuid[] a = device.getUuids();
                    Log.d("EGORRR", "add=" + device.getAddress());

                }
            });


            int startByte = 2;
            boolean patternFound = false;
            while (startByte <= 5) {
                int a = scanRecord[startByte + 2];
                int b = a & 0xff;
                int c = scanRecord[startByte + 3];
                int d = c & 0xff;
                if (b == 0x02 && //Identifies an iBeacon//Преамбула
                        d == 0x15) { //Identifies correct data length
                    patternFound = true;
                    Log.d("EGORRR", "Преамбула найдена");
                    break;
                }
                startByte++;
            }

            if (patternFound) {

                //Convert to hex String
                byte[] uuidBytes = new byte[16];
                System.arraycopy(scanRecord, startByte + 4, uuidBytes, 0, 16);
                String hexString = bytesToHex(uuidBytes);


                //Here is your UUID
                String uuid = hexString.substring(0, 8) + "-" +
                        hexString.substring(8, 12) + "-" +
                        hexString.substring(12, 16) + "-" +
                        hexString.substring(16, 20) + "-" +
                        hexString.substring(20, 32);
                Log.d("EGORRR", "UUID=" + uuid);
                //Here is your Major value
                int major = (scanRecord[startByte + 20] & 0xff) * 0x100 + (scanRecord[startByte + 21] & 0xff);
                Log.d("EGORRR", "major=" + major);
                //Here is your Minor value
                int minor = (scanRecord[startByte + 22] & 0xff) * 0x100 + (scanRecord[startByte + 23] & 0xff);
                Log.d("EGORRR", "minor=" + minor);

                Exhibit exhibit = null;
                switch(major) {
                    case 5:

                        exhibit = new Exhibit("Название", 1, "Музей", null, "Описание");
                        break;
                }
                    Intent intent = new Intent(MuseumActivity.this, ExhibitActivity.class);
                    intent.putExtra("Object", exhibit);
                    startActivity(intent);
                    finish();

            }
        }
    };


        private String bytesToHex(byte[] bytes) {
            char[] hexChars = new char[bytes.length * 2];
            for ( int j = 0; j < bytes.length; j++ ) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }


    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void menuToggle(){
        if(menu.isMenuShowing()) {
            menu.showContent();
        }
        else {
            menu.showMenu();
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(MuseumActivity.this, MuseumDescriptionActivity.class);
        Museum museum = new Museum("Музей", "89295848583","Остоженка, 7" , 0, 0, "10:00 - 18:00", "Описание", null);
        intent.putExtra("Museum", museum);
        startActivity(intent);
        finish();

    }

}
