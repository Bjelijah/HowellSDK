package com.howellsdk.api;

import com.howellsdk.net.websocket.bean.WSRes;

import org.json.JSONException;

/**
 * Created by Administrator on 2017/8/21.
 */

public interface HWWebSocketApi {
    int ERROR_SEND = 0x01;
    int ERROR_RECEIVE = 0x02;
    int ERROR_SOCKET = 0x00;

    void connect();
    void alarmLink(int cseq, String session, String username) throws JSONException;
    void alarmAlive(int cseq, long systemUpTime, Double longitude, Double latitude) throws JSONException;
    void ADCEventRes(int cseq) throws JSONException;
    void ADCNoticeRes(int cseq) throws JSONException;
    void MCUSendNotice(WSRes.AlarmNotice n) throws JSONException;
    void disconnect();
    interface IWebSocketCB{
        void onWebSocketOpen();
        void onWebSocketClose();
        void onGetMessage(WSRes res);
        void onError(int error);
    }
}
