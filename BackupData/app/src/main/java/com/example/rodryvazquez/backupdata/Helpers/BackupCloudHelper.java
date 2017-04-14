package com.example.rodryvazquez.backupdata.Helpers;

import android.app.backup.BackupAgentHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.util.Log;

/**
 * Clase Helper para las operaciones de respaldo Key-Value backup
 */

public class BackupCloudHelper extends BackupAgentHelper {

    private static final String TAG = "BackupHelper";
    public static final String PREFS_TEST= "testprefs";
    public static final String MY_PREFS_BACKUP_KEY = "myprefs";

    @Override
    public void onCreate() {
        SharedPreferencesBackupHelper preferencesBackupHelper =
                new SharedPreferencesBackupHelper(this,PREFS_TEST);

        addHelper(MY_PREFS_BACKUP_KEY,preferencesBackupHelper);
        Log.d(TAG,"Adding BackupAgent...");
    }
}
