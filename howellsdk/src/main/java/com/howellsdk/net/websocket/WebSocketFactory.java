package com.howellsdk.net.websocket;


import android.util.Log;

import com.howellsdk.api.HWWebSocketApi;
import com.howellsdk.net.websocket.bean.WSRes;
import com.howellsdk.net.websocket.utils.JsonUtil;
import com.howellsdk.utils.SDKDebugLog;

import org.json.JSONException;

import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketConnectionHandler;
import de.tavendo.autobahn.WebSocketException;

/**
 * Created by Administrator on 2017/8/21.
 */

public class WebSocketFactory {
    String url;
    HWWebSocketApi.IWebSocketCB mCallback;
    private WebSocketFactory(String url,HWWebSocketApi.IWebSocketCB cb){
        this.url=url;
        mCallback = cb;
    }

    public static final class Builder{
        String url;
        HWWebSocketApi.IWebSocketCB cb;
        public Builder baseUrl(String url){
            this.url = url;
            return this;
        }

        public Builder callback(HWWebSocketApi.IWebSocketCB cb){
            this.cb = cb;
            return this;
        }

        public WebSocketFactory build(){
            if (url==null)throw new NullPointerException("need baseUrl");
            if (cb==null)throw new NullPointerException("need setWebSocketCallback");
            return new WebSocketFactory(url,cb);
        }

    }
    public WebSocketPruduct create(){
        return new WebSocketPruduct();
    }

    public class WebSocketPruduct implements HWWebSocketApi{
        private WebSocketConnection mConnect;
        private void sendOpen(){
            if (mCallback==null)return;
            mCallback.onWebSocketOpen();
        }
        private void sendClose(){
            if (mCallback==null)return;
            mCallback.onWebSocketClose();
        }
        private void sendError(int error){
            if (mCallback==null)return;
            mCallback.onError(error);
        }
        private void sendMessage(WSRes res){
            if (mCallback==null)return;
            mCallback.onGetMessage(res);
        }

        private void handleMessageJsonString(String jsonStr) throws JSONException {
            sendMessage(JsonUtil.parseResJsonString(jsonStr));
        }

        WebSocketPruduct(){

        }



        @Override
        public void connect() {

            if (mConnect!=null && mConnect.isConnected()){
                return;
            }

            mConnect = new WebSocketConnection();
            try {
                mConnect.connect(url,new WebSocketConnectionHandler(){
                    @Override
                    public void onOpen() {
                        super.onOpen();
                        sendOpen();
                    }

                    @Override
                    public void onClose(int code, String reason) {
                        super.onClose(code, reason);
                        sendClose();
                    }

                    @Override
                    public void onTextMessage(String payload) {
                        super.onTextMessage(payload);
                        Log.i("547","payload="+payload);
                        try {
                            handleMessageJsonString(payload);
                        } catch (JSONException e) {
                            sendError(ERROR_RECEIVE);
                            e.printStackTrace();
                        }
                    }
                });
            } catch (WebSocketException e) {
                e.printStackTrace();
                sendError(ERROR_SOCKET);
            }

        }

        @Override
        public void alarmLink(int cseq, String session, String username) throws JSONException {
            if (!mConnect.isConnected()){
                sendError(ERROR_SEND);
                return;
            }
            mConnect.sendTextMessage(JsonUtil.createAlarmPushConnectJsonObject(cseq,session,username).toString());
        }

        @Override
        public void alarmAlive(int cseq, long systemUpTime, Double longitude, Double latitude) throws JSONException {
            if (!mConnect.isConnected()){
                sendError(ERROR_SEND);
                return;
            }
            mConnect.sendTextMessage(JsonUtil.createAlarmAliveJsonObject(cseq,systemUpTime,longitude,latitude).toString());
        }

        @Override
        public void ADCEventRes(int cseq) throws JSONException {
            if (!mConnect.isConnected()){
                sendError(ERROR_SEND);
                return;
            }
            mConnect.sendTextMessage(JsonUtil.createADCEventResJsonObject(cseq).toString());
        }

        @Override
        public void ADCNoticeRes(int cseq) throws JSONException {
            if (!mConnect.isConnected()){
                sendError(ERROR_SEND);
                return;
            }
            mConnect.sendTextMessage(JsonUtil.createADCNoticeResJsonObject(cseq).toString());
        }

        @Override
        public void MCUSendNotice(WSRes.AlarmNotice n) throws JSONException {
            if (!mConnect.isConnected()){
                sendError(ERROR_SEND);
                return;
            }
            mConnect.sendTextMessage(JsonUtil.createMCUSendMessage(n).toString());
        }

        @Override
        public void disconnect() {
            if (mConnect!=null && mConnect.isConnected()) {
                mConnect.disconnect();
                mConnect = null;
            }
        }
    }

}
