package net.nepal12.weather2day.sync;

/**
 * Created by Ritesh on 11/27/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class W2dSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static W2dSyncAdapter sW2dSyncAdapter = null;

    @Override
    public void onCreate() {
        Log.d("SunshineSyncService", "onCreate - SunshineSyncService");
        synchronized (sSyncAdapterLock) {
            if (sW2dSyncAdapter == null) {
                sW2dSyncAdapter = new W2dSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return sW2dSyncAdapter.getSyncAdapterBinder();
    }
}