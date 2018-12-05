package com.phonepe.parentapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class KeyRetrivalService extends Service {
    public KeyRetrivalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IKeyRetrival.Stub binder = new IKeyRetrival.Stub() {
        @Override
        public String getKey() throws RemoteException {
            return DataStorage.getText();
        }
    };
}
