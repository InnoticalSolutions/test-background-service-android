package io.ionic.starter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import com.amankumar.cordova.MyService.MyService;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by innotical on 26/8/17.
 */


public class EchoWebSocketListener extends WebSocketListener {

    private String TAG = "WebSocket";
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    private String textMsg;
    //private Bus mBus;
    // private static MyListener okListerner;
    private Handler mHandler;

    public EchoWebSocketListener() {

        // mBus = new Bus();

    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {

        Log.d(TAG, "onOpen: " + response.toString());


        /*if (okListerner != null) {
            okListerner.onConnect();
        }*/
        //webSocket.close(NORMAL_CLOSURE_STATUS, "Goodbye !");
    }

    @Override
    public void onMessage(WebSocket webSocket, final String text) {
        //output("Receiving : " + text);


        mHandler = new Handler(Looper.getMainLooper());

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                MyService.callJS(text);
                //  mBus.post(new EventModels(Utilities.RECEIVED_MESSAGE_EVENT,text));
                //
                /*if (okListerner != null) {
                    okListerner.onMessage(text);
                }*/
                // EventBus.getDefault().post(new EventModels(Utilities.RECEIVED_MESSAGE_EVENT, text));
            }
        });

        Log.d(TAG, "onMessage: " + text);

    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        //output("Receiving bytes : " + bytes.hex());
        Log.d(TAG, "onMessage: " + bytes.hex());

    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        //output("Closing : " + code + " / " + reason);
        Log.e(TAG, "onClosing: " + reason + "  code" + code);
        /*if (okListerner != null) {
            okListerner.onDisconnect(code, reason);
        }*/


    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        //output("Error : " + t.getMessage());
        Log.e(TAG, "onFailure: " + t.getMessage());
        /*if (okListerner != null) {
            okListerner.onError(t.getMessage());
        }*/
        //EventBus.getDefault().post(new EventModels(Utilities.EVENT_SOCKET_FAILURE, ""));
        // mBus.post(new EventModels(Utilities.EVENT_SOCKET_FAILURE, ""));
    }

    /*public interface MyListener {

        public void onMessage(String message);

        public void onConnect();

        public void onDisconnect(int code, String reason);

        public void onError(String cause);

    }*/

    /*public static void setonMyWebSocketListener(MyListener listener) {
        okListerner = listener;

    }*/


}
