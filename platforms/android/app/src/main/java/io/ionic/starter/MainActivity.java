/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package io.ionic.starter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import org.apache.cordova.*;

public class MainActivity extends CordovaActivity {

    private Intent websocketIntent = null;
    public static String CHANNEL_ID = "familycarechannel";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel();
        }
        startWebSocketService();


    }

    private void startWebSocketService() {
        // mySharedPreferences.putBoolean(Utilities.IS_SERVICE_DESTROYED, false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            websocketIntent = new Intent(this, WebSocketService.class);
            //websocketIntent.putExtra(Utilities.PATIENT_ID, mySharedPreferences.getInt(Utilities.PATIENT_ID));
            ContextCompat.startForegroundService(this, websocketIntent);


        } else {
            websocketIntent = new Intent(this, WebSocketService.class);
            //websocketIntent.putExtra(Utilities.PATIENT_ID, mySharedPreferences.getInt(Utilities.PATIENT_ID));
            startService(websocketIntent);
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Service Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }
}
