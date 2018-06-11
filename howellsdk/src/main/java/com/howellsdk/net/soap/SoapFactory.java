package com.howellsdk.net.soap;

import android.util.Log;

import com.howellsdk.api.HWSoapApi;
import com.howellsdk.net.soap.bean.*;
import com.howellsdk.utils.SDKDebugLog;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Administrator on 2017/8/16.
 */

public class SoapFactory {
    private String mUrl;

    SoapFactory(String url){
        mUrl = url;
    }
    public static final class Builder{
        String url;
        public Builder(){

        }
        public Builder baseUrl(String url) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
            this.url = url;
            return this;
        }

        public SoapFactory build(){
            return new SoapFactory(url);
        }
    }
    public SoapProduct create(){
        return new SoapProduct();
    }

    /***********************
     * soap api 具体实现
     ***********************/
    public class SoapProduct implements HWSoapApi{
        private final String TAG = SoapProduct.class.getName();
        SoapProduct(){}
        private final String mNameSpace = "http://www.haoweis.com/HomeServices/MCU/";
        HttpTransportSE mTransport;

        private SoapObject initEnvelopAndTransport(SoapObject rpc, String sSoapAction) throws IOException, XmlPullParserException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER10);
            envelope.bodyOut = rpc;
            envelope.dotNet = true;
            envelope.encodingStyle = "UTF-8";
            envelope.setOutputSoapObject(rpc);
            Log.i("123","initEnvelopAndTransport url="+mUrl);
            if (mTransport==null){
                mTransport = new HttpTransportSE(mUrl);
                mTransport.debug = true;
            }
            SDKDebugLog.logI("soap",sSoapAction);
            mTransport.call(sSoapAction, envelope);
            SoapObject soapObject = (SoapObject) envelope.bodyIn;
            SDKDebugLog.logI(TAG+":initEnvelopAndTransport","res="+soapObject.toString());
            return soapObject;
        }


        @Override
        public Observable<AuthenticatedRes> queryAuthenticated(AuthenticatedReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "queryMCUDeviceAuthenticatedReq")
                    .addProperty("UUID", req.getUUID());
            return Observable.create(new ObservableOnSubscribe<AuthenticatedRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<AuthenticatedRes> e) throws Exception {
                    AuthenticatedRes res = new AuthenticatedRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryMCUDeviceAuthenticated");
                        res.setResult(obj.getProperty("result").toString());
                        res.setAuthenticated(Boolean.valueOf(obj.getProperty("Authenticated").toString()));
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> updateDeviceAuthenticated(UpdateAuthenticatedReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "uploadMCUDeviceReq")
                    .addProperty("UUID",req.getUUID())
                    .addProperty("Model",req.getModel())
                    .addProperty("Type",req.getType())
                    .addProperty("OSType",req.getOSType())
                    .addProperty("OSVersion", req.getOSVersion())
                    .addProperty("Manufactory",req.getManufactory())
                    .addProperty("IEMI",req.getIMEI());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/uploadMCUDevice");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<LoginResponse> userLogin(LoginRequest loginRequest) {
            final SoapObject rpc = new SoapObject(mNameSpace, "userLoginReq");
            rpc.addProperty("Account", loginRequest.getAccount());
            rpc.addProperty("PwdType", loginRequest.getPwdType());
            rpc.addProperty("Password", loginRequest.getPassword());
            rpc.addProperty("Version", loginRequest.getVersion());
            SoapObject rpcChild = new SoapObject(mNameSpace, "MCUDev");
            rpcChild.addProperty("UUID",loginRequest.getIEMI());
            rpcChild.addProperty("Model",loginRequest.getPhoneModel());
            rpcChild.addProperty("NetworkOperator",loginRequest.getNetworkOperator());
            rpcChild.addProperty("NetType","Wifi");
            rpcChild.addProperty("Type", "CellPhone");
            rpcChild.addProperty("OSType", "Android");
            rpcChild.addProperty("OSVersion",loginRequest.getOsVersion());
            rpcChild.addProperty("Manufactory",loginRequest.getManuFactory());
            rpcChild.addProperty("IEMI",loginRequest.getIEMI());
            rpc.addProperty("MCUDev",rpcChild);
            Log.i("123","rpc="+rpc.toString());
            return Observable.create(new ObservableOnSubscribe<LoginResponse>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<LoginResponse> e) throws Exception {
                    LoginResponse res = new LoginResponse();
                    try{
                        SoapObject so = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/userLogin");
                        res.setResult(so.getProperty("result").toString());
                        if (so.getProperty("result").toString().equalsIgnoreCase("OK")){
                            res.setLoginSession(so.getProperty("LoginSession").toString());
                            res.setUsername(so.getProperty("Username").toString());
                            SoapObject nodeList= (SoapObject) so.getProperty("NodeList");
                            int len = nodeList.getPropertyCount();
                            ArrayList<Device> devices = new ArrayList<Device>();
                            for (int i=0;i<len;i++){
                                SoapObject dev = (SoapObject) nodeList.getProperty(i);
                                Device device = new Device(
                                        dev.getProperty("DevID").toString(),
                                        Integer.valueOf(dev.getProperty("ChannelNo").toString()),
                                        dev.getProperty("Name").toString(),
                                        Boolean.valueOf(dev.getProperty("OnLine").toString()),
                                        Boolean.valueOf(dev.getProperty("PtzFlag").toString()),
                                        Integer.valueOf(dev.getProperty("SharingFlag").toString()),
                                        Integer.valueOf(dev.getProperty("WirelessFlag").toString())
                                );
                                devices.add(device);
                            }
                            res.setNodeList(devices);
                        }
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> userLogout(LogoutRequest logoutRequest) {
            final SoapObject rpc = new SoapObject(mNameSpace, "userLogoutReq")
                    .addProperty("Account", logoutRequest.getAccount())
                    .addProperty("LoginSession",logoutRequest.getSession());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/userLogout");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> updateChannelName(UpdateChannelNameReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "updateChannelNameReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("DevID", req.getDevID())
                    .addProperty("ChannelNo", 0)
                    .addProperty("ChannelName", req.getChannelName());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/updateChannelName");
                        Log.i("123","updatachannelname="+obj.toString());
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> addDevice(AddDeviceReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"addDeviceReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("DevKey",req.getDevKey())
                    .addProperty("DevName",req.getDevName())
                    .addProperty("Forcible",req.isForcible());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/addDevice");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> nullifyDevice(NullifyDeviceReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "nullifyDeviceReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("DevID", req.getDevID())
                    .addProperty("DevKey", req.getDevKey());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/nullifyDevice");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> ptzControl(PtzControlReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "ptzControlReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("DevID", req.getDevID())
                    .addProperty("ChannelNo", req.getChannelNo())
                    .addProperty("PtzDirection", req.getPtzDirection());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/ptzControl");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> lensControl(LensControlReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"lensControlReq");
            rpc.addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("PtzLens",req.getPtzLens());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    Result res = new Result();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/lensControl");
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> presetControl(PresetControlReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"presetControlReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("PtzPreset",req.getPtzPreset())
                    .addProperty("PresetNo",req.getPresetNo());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/lensControl");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<CodingParamRes> getCodingParam(CodingParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getCodingParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("StreamType",req.getStreamType());
            return Observable.create(new ObservableOnSubscribe<CodingParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<CodingParamRes> em) throws Exception {
                    CodingParamRes res = new CodingParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getCodingParam");
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")){
                            try{res.setFrameSize( obj.getProperty("FrameSize").toString());}catch (Exception e){}
                            try{res.setFrameRate(Integer.valueOf(obj.getProperty("FrameRate").toString()));}catch (Exception e){}
                            try{res.setRateType(obj.getProperty("RateType").toString());}catch (Exception e){}
                            try{res.setBitRate(Integer.valueOf(obj.getProperty("BitRate").toString()));}catch (Exception e){}
                            try{res.setImageQuality(Integer.valueOf(obj.getProperty("ImageQuality").toString()));}catch (Exception e){}
                            try{res.setAudioInput(Boolean.valueOf(obj.getProperty("AudioInput").toString()));}catch (Exception e){}
                        }
                        res.setResult(result);
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setCodingParam(SetCodingParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setCodingParamReq");
            rpc.addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("StreamType",req.getStreamType());
            if (req.getFrameSize()!=null)rpc.addProperty("FrameSize",req.getFrameSize());
            if (req.getFrameRate()!=null)rpc.addProperty("FrameRate",req.getFrameRate());
            if (req.getRateType()!=null)rpc.addProperty("RateType",req.getRateType());
            if (req.getBitRate()!=null)rpc.addProperty("BitRate",req.getBitRate());
            if (req.getImageQuality()!=null)rpc.addProperty("ImageQuality",req.getImageQuality());
            if (req.getAudioInput()!=null)rpc.addProperty("AudioInput",req.getAudioInput());
            Log.i("123","rpc="+rpc.toString());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setCodingParam");
                        Log.i("123","obj="+obj.toString());
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> reboot(RebootReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"rebootReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/reboot");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<DevVerRes> queryDevVer(DevVerReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "getDevVerReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("DevID", req.getDevID());
            return Observable.create(new ObservableOnSubscribe<DevVerRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DevVerRes> e) throws Exception {
                    DevVerRes res = new DevVerRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getDevVer");
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")){
                            res.setCurDevVer(obj.getProperty("CurDevVer").toString());
                            res.setNewDevVer(obj.getProperty("NewDevVer").toString());
                        }
                        res.setResult(result);
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> upgradeDevVer(UpgradeDevVerReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"upgradeDevVerReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            if (req.getNewDevVer()!=null)rpc.addProperty("NewDevVer",req.getNewDevVer());
            if (req.getFtpAddress()!=null)rpc.addProperty("FTPAddress",req.getFtpAddress());
            if (req.getFtpPort()!=null)rpc.addProperty("FTPPort",req.getFtpPort());
            if (req.getAccount()!=null)rpc.addProperty("FTPAccount",req.getAccount());
            if (req.getFtpPassword()!=null)rpc.addProperty("FTPPassword",req.getFtpPassword());
            if (req.getFtpFileName()!=null)rpc.addProperty("FTPFileName",req.getFtpFileName());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/upgradeDevVer");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<VideoParamRes> getVideoParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getVideoParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<VideoParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<VideoParamRes> em) throws Exception {
                    VideoParamRes res = new VideoParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getVideoParam");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            try{res.setVideoStandard(obj.getProperty("VideoStandard").toString());}catch (Exception e){}
                            try{res.setRotationDegree(Integer.valueOf(obj.getProperty("RotationDegree").toString()));}catch (Exception e){}
                            try{res.setBrightness(Integer.valueOf(obj.getProperty("Brightness").toString()));}catch (Exception e){}
                            try{res.setContrast(Integer.valueOf(obj.getProperty("Contrast").toString()));}catch (Exception e){}
                            try{res.setSaturation(Integer.valueOf(obj.getProperty("Saturation").toString()));}catch (Exception e){}
                            try{res.setHue(Integer.valueOf(obj.getProperty("Hue").toString()));}catch (Exception e){}
                            try{res.setInfrared(Boolean.valueOf(obj.getProperty("Infrared").toString()) );}catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setVideoParam(VideoParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setVideoParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelNo());
            if (req.getVideoStandard()!=null)rpc.addProperty("VideoStandard",req.getVideoStandard());
            if (req.getRotationDegree()!=null)rpc.addProperty("RotationDegree",req.getRotationDegree());
            if (req.getBrightness()!=null)rpc.addProperty("Brightness",req.getBrightness());
            if (req.getContrast()!=null)rpc.addProperty("Contrast",req.getContrast());
            if (req.getSaturation()!=null)rpc.addProperty("Saturation",req.getSaturation());
            if (req.getHue()!=null)rpc.addProperty("Hue",req.getHue());
            if (req.getInfrared()!=null)rpc.addProperty("Infrared",req.getInfrared());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setVideoParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<OSDParamRes> getOSDParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getOSDParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<OSDParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<OSDParamRes> em) throws Exception {
                    OSDParamRes res = new OSDParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getOSDParam");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("OK")){
                            try{res.setEnable(Boolean.valueOf(obj.getProperty("Enable").toString()));}catch (Exception e){}
                            try{res.setTimestampEnabled(Boolean.valueOf(obj.getProperty("TimestampEnabled").toString()));}catch (Exception e){}
                            try{res.setDateTimeFormat(obj.getProperty("DateTimeFormat").toString());}catch (Exception e){}
                            try{res.setDisplayText(obj.getProperty("DisplayText").toString());}catch (Exception e){}
                            try{res.setFontSize(Integer.valueOf(obj.getProperty("FontSize").toString()));}catch (Exception e){}
                            try{res.setFontColor(Integer.valueOf(obj.getProperty("FontColor").toString()));}catch (Exception e){}
                            try{res.setTextPositionX(Integer.valueOf(obj.getProperty("TextPositionX").toString()));}catch (Exception e){}
                            try{res.setTextPositionY(Integer.valueOf(obj.getProperty("TextPositionY").toString()));}catch (Exception e){}
                            try{res.setTimestampPositionX(Integer.valueOf(obj.getProperty("TimestampPositionX").toString()));}catch (Exception e){}
                            try{res.setTimestampPositionY(Integer.valueOf(obj.getProperty("TimestampPositionY").toString()));}catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setOSDParam(OSDParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setOSDParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelNo());
            if (req.getEnable()!=null)rpc.addProperty("Enabled",req.getEnable());
            if (req.getTimestanpEnable()!=null)rpc.addProperty("TimestampEnabled",req.getTimestanpEnable());
            if (req.getDateTimeFormat()!=null)rpc.addProperty("DateTimeFormat",req.getDateTimeFormat());
            if (req.getDisplayText()!=null)rpc.addProperty("DisplayText",req.getDisplayText());
            if (req.getFontSize()!=null)rpc.addProperty("FontSize",req.getFontSize());
            if (req.getFontColor()!=null)rpc.addProperty("FontColor",req.getFontColor());
            if (req.getTextPositionX()!=null)rpc.addProperty("TextPositionX",req.getTextPositionX());
            if (req.getTextPositionY()!=null)rpc.addProperty("TextPositionY",req.getTextPositionY());
            if (req.getTimestampPositionX()!=null)rpc.addProperty("TimestampPositionX",req.getTimestampPositionX());
            if (req.getTimestampPositionY()!=null)rpc.addProperty("TimestampPositionY",req.getTimestampPositionY());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setOSDParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<TimeRes> getTime(GetTimeReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getTimeReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId());
            return Observable.create(new ObservableOnSubscribe<TimeRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<TimeRes> em) throws Exception {
                    TimeRes res = new TimeRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getTime");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            try{res.setTime(obj.getProperty("Time").toString());}catch (Exception e){}
                            try{res.setTimeZone(obj.getProperty("TimeZone").toString());}catch (Exception e){}
                            try{res.setPOSIXTimeZone(obj.getProperty("POSIXTimeZone").toString());}catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setTime(SetTimeReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setTimeReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId());
            if (req.getTime()!=null)rpc.addProperty("Time",req.getTime());
            if (req.getTimeZone()!=null)rpc.addProperty("TimeZone",req.getTimeZone());
            if (req.getPOSIXTimeZone()!=null)rpc.addProperty("POSIXTimeZone",req.getPOSIXTimeZone());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setTime");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<VMDParamRes> getVMDParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getVMDParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<VMDParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<VMDParamRes> em) throws Exception {
                    VMDParamRes res = new VMDParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getVMDParam");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("OK")){
                            try{res.setEnable(Boolean.valueOf(obj.getProperty("Enabled").toString()));}catch (Exception e){}
                            try{res.setSensitivity(Integer.valueOf(obj.getProperty("Sensitivity").toString()));}catch (Exception e){}
                            try{res.setStartTriggerTime(Integer.valueOf(obj.getProperty("StartTriggerTime").toString()));}catch (Exception e){}
                            try{res.setEndTriggerTime(Integer.valueOf(obj.getProperty("EndTriggerTime").toString()));}catch (Exception e){}
                            try{res.setRowGranularity(Integer.valueOf(obj.getProperty("RowGranularity").toString()));}catch (Exception e){}
                            try{res.setColumnGranularity(Integer.valueOf(obj.getProperty("ColumnGranularity").toString()));}catch (Exception e){}
                            try{
                                SoapObject childGrid = (SoapObject) obj.getProperty("VMDGrid");
                                String row = childGrid.getProperty("Row").toString();
                                res.setVmdGrid(new VMDParamRes.VMDGrid(row));
                            }catch (Exception e){}
                            try{
                                SoapObject childWorkSheet = (SoapObject) obj.getProperty("WorkSheet");
                                Boolean enable = Boolean.valueOf(childWorkSheet.getProperty("Enabled").toString());
                                String bitString = childWorkSheet.getProperty("BitString").toString();
                                res.setWorkSheet(new VMDParamRes.WorkSheet(enable,bitString));
                            }catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setVMDParam(VMDParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setVMDParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevId())
                    .addProperty("ChannelNo",req.getChannelId());
            if (req.getEnable()!=null)rpc.addProperty("Enabled",req.getEnable());
            if (req.getSensitivity()!=null)rpc.addProperty("Sensitivity",req.getSensitivity());
            if (req.getStartTriggerTime()!=null)rpc.addProperty("StartTriggerTime",req.getStartTriggerTime());
            if (req.getEndTriggerTime()!=null)rpc.addProperty("EndTriggerTime",req.getEndTriggerTime());
            if (req.getVmdGrid()!=null){
                SoapObject vmdGrid = new SoapObject(mNameSpace,"VMDGrid");
                for (String s:req.getVmdGrid().getRow()){
                    vmdGrid.addProperty("Row",s);
                }
                rpc.addProperty("Grid",vmdGrid);
            }
            if (req.getWorkSheet()!=null){
                SoapObject workSheet = new SoapObject(mNameSpace,"WorkSheet");
                workSheet.addProperty("Enabled",req.getWorkSheet().getEnable())
                        .addProperty("BitString",req.getWorkSheet().getBitString());
                rpc.addProperty("WorkSheet",workSheet);
            }
            Log.i("123","save vmd="+rpc.toString());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setVMDParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PrivacyMaskParamRes> getPrivacyMaskParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getPrivacyMaskParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<PrivacyMaskParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PrivacyMaskParamRes> em) throws Exception {
                    PrivacyMaskParamRes res = new PrivacyMaskParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getPrivacyMaskParam");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            try{res.setEnable(Boolean.valueOf(obj.getProperty("Enabled").toString()));}catch (Exception e){}
                            try{res.setHorizontalResolution(Integer.valueOf(obj.getProperty("HorizontalResolution").toString()));}catch (Exception e){}
                            try{res.setVerticalResolution(Integer.valueOf(obj.getProperty("VerticalResolution").toString()));}catch (Exception e){}
                            try{
                                int left = Integer.valueOf(obj.getProperty("Left").toString());
                                int top =  Integer.valueOf(obj.getProperty("Top").toString());
                                int right = Integer.valueOf(obj.getProperty("Right").toString());
                                int bottom = Integer.valueOf(obj.getProperty("Bottom").toString());
                                res.setPrivacyMaskRegion(new PrivacyMaskParamRes.PrivacyMaskRegion(left,top,right,bottom));
                            }catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }


                }
            });
        }

        @Override
        public Observable<Result> setPrivacymaskParam(PrivacyMaskParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setPrivacyMaskParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            if (req.getEnable()!=null)rpc.addProperty("Enabled",req.getEnable());
            if (req.getPrivacyMaskRegion()!=null){
                SoapObject child = new SoapObject(mNameSpace,"PrivacyMaskRegion");
                child.addProperty("Left",req.getPrivacyMaskRegion().getLeft())
                        .addProperty("Top",req.getPrivacyMaskRegion().getTop())
                        .addProperty("Right",req.getPrivacyMaskRegion().getRight())
                        .addProperty("Bottom",req.getPrivacyMaskRegion().getBottom());
                rpc.addProperty("PrivacyMaskRegion",child);
            }
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setPrivacyMaskParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<VodSearchRes> vodSearch(VodSearchReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"vodSearchReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("StreamType",req.getStreamType())
                    .addProperty("StartTime",req.getStartTime())
                    .addProperty("EndTime",req.getEndTime())
                    .addProperty("PageNo",req.getPageNo())
                    .addProperty("PageSize",req.getPageSize());
            if (req.getSearchID()!=null)rpc.addProperty("SearchID",req.getSearchID());
            return Observable.create(new ObservableOnSubscribe<VodSearchRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<VodSearchRes> e) throws Exception {
                    VodSearchRes res = new VodSearchRes();
                    try{
                        Log.i("123","rpc="+rpc.toString());
                        SDKDebugLog.LogEnable(true);
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/vodSearch");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setPageNo(Integer.valueOf(obj.getProperty("PageNo").toString()));
                            res.setPageCount(Integer.valueOf(obj.getProperty("PageCount").toString()));
                            res.setRecordCount(Integer.valueOf(obj.getProperty("RecordCount").toString()));

//                            SoapObject record = (SoapObject) obj.getProperty("Record");

                            int conunt = obj.getPropertyCount();
                            Log.i("123","count="+conunt);
                            ArrayList<VodSearchRes.Record> records = new ArrayList<>();
                            for (int i=4;i<conunt;i++){
                                SoapObject o = (SoapObject) obj.getProperty(i);
                                records.add(new VodSearchRes.Record(
                                        o.getProperty("StartTime").toString(),
                                        o.getProperty("EndTime").toString(),
                                        Long.valueOf( o.getProperty("FileSize").toString()),
                                        "",//o.getProperty("ContentType").toString(),
                                        o.getProperty("Desc").toString()
                                ));
                            }
                            res.setRecord(records);
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> createAccount(CreateAccountReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"createAccountReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("Username", req.getUsername())
                    .addProperty("Password", req.getPassword())
                    .addProperty("Email", req.getEmail());
            if (req.getMobileTel()!=null)rpc.addProperty("MobileTel",req.getMobileTel());
            rpc.addProperty("SecurityQuestion",req.getSecurityQuestion());
            rpc.addProperty("SecurityAnswer",req.getSecurityAnswer());
            if (req.getCountry()!=null)rpc.addProperty("Country",req.getCountry());
            if (req.getCountryTelCode()!=null)rpc.addProperty("CountryTelCode",req.getCountryTelCode());
            if (req.getiDCard()!=null)rpc.addProperty("IDCard",req.getiDCard());
            if (req.getApplicationID()!=null)rpc.addProperty("ApplicationID",req.getApplicationID());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/createAccount");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> updateAccount(UpdateAccountReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "updateAccountReq");
            rpc.addProperty("Account", req.getAccount());
            rpc.addProperty("LoginSession", req.getLoginSession());
            if (req.getUsername()!=null)rpc.addProperty("Username", req.getUsername());
            if (req.getMobileTel()!=null)rpc.addProperty("MobileTel", req.getMobileTel());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/updateAccount");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> updatePassword(UpdatePasswordReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "updatePasswordReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("Password", req.getPassword())
                    .addProperty("NewPassword", req.getNewPassword());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/updatePassword");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }

            });
        }

        @Override
        public Observable<DeviceRes> queryDevice(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryDeviceReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            if (req.getDevID()!=null)rpc.addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<DeviceRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceRes> em) throws Exception {
                    DeviceRes res = new DeviceRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryDevice");
                        Log.i("123","query device="+obj.toString());
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")) {
                            SoapObject nodeList = (SoapObject) obj.getProperty("NodeList");
                            int count = nodeList.getPropertyCount();
                            ArrayList<DeviceRes.NodeList> nodeLists = new ArrayList<>();
                            for (int i = 0; i < count; i++) {
                                SoapObject node = (SoapObject) nodeList.getProperty(i);
                                nodeLists.add(new DeviceRes.NodeList(
                                        node.getProperty("DevID").toString(),
                                        Integer.valueOf(node.getProperty("ChannelNo").toString()),
                                        node.getProperty("Name").toString(),
                                        Boolean.valueOf(node.getProperty("OnLine").toString()),
                                        Boolean.valueOf(node.getProperty("PtzFlag").toString()),
                                        Integer.valueOf(node.getProperty("SecurityArea").toString()),
                                        Integer.valueOf(node.getProperty("EStoreFlag").toString()),
                                        node.getProperty("UpnpIP").toString(),
                                        Integer.valueOf(node.getProperty("UpnpPort").toString()),
                                        node.getProperty("DevVer").toString(),
                                        Integer.valueOf(node.getProperty("CurVideoNum").toString()),
                                        node.getProperty("LastUpdated").toString(),
                                        Integer.valueOf(node.getProperty("SMSSubscribedFlag").toString()),
                                        Integer.valueOf(node.getProperty("EMailSubscribedFlag").toString()),
                                        Integer.valueOf(node.getProperty("SharingFlag").toString()),
                                        Integer.valueOf(node.getProperty("ApplePushSubscribedFlag").toString()),
                                        Integer.valueOf(node.getProperty("AndroidPushSubscribedFlag").toString()),
                                        Integer.valueOf(node.getProperty("InfraredFlag").toString()),
                                        Integer.valueOf(node.getProperty("WirelessFlag").toString())
                                ));
                            }
                            res.setNodeLists(nodeLists);
                            try{
                                SoapObject network = (SoapObject) obj.getProperty("WirelessNetwork");
                                res.setWirelessNetwork(new DeviceRes.WirelessNetwork(
                                        network.getProperty("WirelessType").toString(),
                                        network.getProperty("SSID").toString(),
                                        Integer.valueOf(network.getProperty("Intensity").toString())
                                ));
                            }catch (Exception e){}
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        em.onNext(res);
                    }catch (Exception ex){
                        em.onError(ex);
                    }finally {
                        em.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<AccountRes> getAccount(Request req) {
            final  SoapObject rpc = new SoapObject(mNameSpace,"getAccountReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            return Observable.create(new ObservableOnSubscribe<AccountRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<AccountRes> e) throws Exception {
                    AccountRes res = new AccountRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getAccount");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("Ok")){
                            res.setUserName(obj.getProperty("Username").toString());
                            res.setEmail(obj.getProperty("Email").toString());
                            try{res.setMobileTel(obj.getProperty("MobileTel").toString());}catch (Exception ex){}
                            try{res.setCountry(obj.getProperty("MobileTel").toString());}catch (Exception ex){}
                            res.setCountryTelCode(obj.getProperty("CountryTelCode").toString());
                            try{res.setIDCard(obj.getProperty("IDCard").toString());}catch (Exception ex){}
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PasswordRes> getBackPassword(PasswordReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getBackPasswordReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("GetBackType",req.getGetBackType());
            return Observable.create(new ObservableOnSubscribe<PasswordRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PasswordRes> e) throws Exception {
                    PasswordRes res = new PasswordRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getBackPassword");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            res.setAddress(obj.getProperty("Address").toString());
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<AuxiliaryRes> getAuxiliary(GetAuxiliaryReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getAuxiliaryReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("Auxiliary",req.getAuxiliary());
            return Observable.create(new ObservableOnSubscribe<AuxiliaryRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<AuxiliaryRes> e) throws Exception {
                    AuxiliaryRes res = new AuxiliaryRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getAuxiliary");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setAuxiliaryState(obj.getProperty("AuxiliaryState").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setAuxiliary(SetAuxiliaryReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setAuxiliaryReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("Auxiliary",req.getAuxiliary())
                    .addProperty("AuxiliaryState",req.getAuxiliaryState());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setAuxiliary");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<InviteRes> invite(InviteReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"inviteReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("StreamType",req.getStreamType())
                    .addProperty("DialogID",req.getDialogId())
                    .addProperty("SDPMessage",req.getSdpMessage());
            return Observable.create(new ObservableOnSubscribe<InviteRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<InviteRes> e) throws Exception {
                    InviteRes res = new InviteRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/invite");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setDialogId(obj.getProperty("DialogID").toString());
                            res.setSdpMessage(obj.getProperty("SDPMessage").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> bye(ByeReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"byeReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("StreamType",req.getStreamType())
                    .addProperty("DialogID",req.getDialogID());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/bye");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<NATServerRes> getNATServer(NATServerReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "getNATServerReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession());
            return Observable.create(new ObservableOnSubscribe<NATServerRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<NATServerRes> e) throws Exception {
                    NATServerRes res = new NATServerRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getNATServer");
                        Log.i("123","obj="+obj.toString());
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")) {
                            SoapObject stunList = (SoapObject) obj.getProperty("STUNServerList");
                            int count = stunList.getPropertyCount();
                            ArrayList<NATServerRes.STUNServer> sList = new ArrayList<NATServerRes.STUNServer>();
                            for (int i = 0; i < count; i++) {
                                SoapObject stun = (SoapObject) stunList.getProperty(i);
                                NATServerRes.STUNServer sServer = new NATServerRes.STUNServer();
                                sServer.setIPv4Address(stun.getProperty("IPv4Address").toString());
                                try {sServer.setIPv6Address(stun.getProperty("IPv6Address").toString());} catch (Exception ex) {}
                                sServer.setPort(Integer.valueOf(stun.getProperty("Port").toString()));
                                sList.add(sServer);
                            }
                            res.setStunServers(sList);
                            SoapObject turnList = (SoapObject) obj.getProperty("TURNServerList");
                            count = turnList.getPropertyCount();
                            ArrayList<NATServerRes.TURNServer> tList = new ArrayList<NATServerRes.TURNServer>();
                            for (int i = 0; i < count; i++) {
                                SoapObject turn = (SoapObject) turnList.getProperty(i);
                                NATServerRes.TURNServer tServer = new NATServerRes.TURNServer();
                                tServer.setIPv4Address(turn.getProperty("IPv4Address").toString());
                                try {tServer.setIPv6Address(turn.getProperty("IPv6Address").toString());} catch (Exception ex) {}
                                tServer.setPort(Integer.valueOf(turn.getProperty("Port").toString()));
                                try {tServer.setUsername(turn.getProperty("Username").toString());} catch (Exception ex) {}
                                try {tServer.setPassword(turn.getProperty("Password").toString());} catch (Exception ex) {}
                                tList.add(tServer);
                            }
                            res.setTurnServers(tList);
                        }
                        res.setResult(result);
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> subscribeEmail(SubscribeBaseReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"subscribeEMailReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("SubscribedFlag",req.getSubscribedFlag())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/subscribeEMail");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> subscribeSMS(SubscribeBaseReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"subscribeSMSReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("SubscribedFlag",req.getSubscribedFlag())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/subscribeSMS");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> notifyNATResult(NotifyNATResultReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"notifyNATResultReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DialogID",req.getDialogID())
                    .addProperty("NATType",req.getNATType());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/notifyNATResult");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> inviteKeepAlive(InviteKeepAliveReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"inviteKeepAliveReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DialogID",req.getDialogID());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/inviteKeepAlive");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PUOnOffLogRes> queryPUOnOffLog(PUOnOffLogReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryPUOnOffLogReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            if (req.getDevID()!=null) rpc.addProperty("DevID",req.getDevID());
            rpc.addProperty("StartTime",req.getStartTime());
            rpc.addProperty("EndTime",req.getEndTime());
            if (req.getPageNo()!=null)rpc.addProperty("PageNo",req.getPageNo());
            if (req.getSearchID()!=null)rpc.addProperty("SearchID",req.getSearchID());
            if (req.getPageSize()!=null)rpc.addProperty("PageSize",req.getPageSize());
            return Observable.create(new ObservableOnSubscribe<PUOnOffLogRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PUOnOffLogRes> e) throws Exception {
                    PUOnOffLogRes res = new PUOnOffLogRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryPUOnOffLog");
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")){
                            res.setPageNo(Integer.valueOf(obj.getProperty("PageNo").toString()));
                            res.setPageCount(Integer.valueOf(obj.getProperty("PageCount").toString()));
                            res.setRecordCount(Integer.valueOf(obj.getProperty("RecordCount").toString()));
                            SoapObject o = (SoapObject) obj.getProperty("Log");
                            int count = o.getPropertyCount();
                            ArrayList<PUOnOffLogRes.Log> logs = new ArrayList<PUOnOffLogRes.Log>();
                            for (int i=0;i<count;i++){
                                SoapObject puOnOffLog = (SoapObject) o.getProperty(i);
                                PUOnOffLogRes.Log log = new PUOnOffLogRes.Log();
                                log.setDevID(puOnOffLog.getProperty("DevID").toString());
                                log.setTime(puOnOffLog.getProperty("Time").toString());
                                log.setOffTime(puOnOffLog.getProperty("OffTime").toString());
                                try{log.setOffReason(puOnOffLog.getProperty("OffReason").toString());}catch (Exception ex){}
                                logs.add(log);
                            }
                            res.setLogs(logs);
                        }
                        res.setResult(result);
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PUEventLogRes> queryPUEventLog(final PUEventLogReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryPUEventLogReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            if (req.getDevID()!=null)rpc.addProperty("DevID",req.getDevID());
            if (req.getEventType()!=null)rpc.addProperty("EventType",req.getEventType());
            if (req.getEventState()!=null)rpc.addProperty("EventState",req.getEventState());
            rpc.addProperty("StartTime",req.getStartTime());
            rpc.addProperty("EndTime",req.getEndTime());
            if (req.getPageNo()!=null)rpc.addProperty("PageNo",req.getPageNo());
            if (req.getSearchID()!=null)rpc.addProperty("SearchID",req.getSearchID());
            if (req.getPageSize()!=null)rpc.addProperty("PageSize",req.getPageSize());
            return Observable.create(new ObservableOnSubscribe<PUEventLogRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PUEventLogRes> e) throws Exception {
                    PUEventLogRes res = new PUEventLogRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryPUEventLog");
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")){
                            res.setPageNo(Integer.valueOf(obj.getProperty("PageNo").toString()));
                            res.setPageCount(Integer.valueOf(obj.getProperty("PageCount").toString()));
                            res.setRecordCount(Integer.valueOf(obj.getProperty("RecordCount").toString()));
                            SoapObject o = (SoapObject) obj.getProperty("Log");
                            int count = o.getPropertyCount();
                            ArrayList<PUEventLogRes.Log> logs = new ArrayList<PUEventLogRes.Log>();
                            for (int i=0;i<count;i++){
                                SoapObject eventLog = (SoapObject) o.getProperty(i);
                                PUEventLogRes.Log log = new PUEventLogRes.Log();
                                log.setDevID(eventLog.getProperty("DevID").toString());
                                log.setChannelNo(Integer.valueOf(eventLog.getProperty("ChannelNo").toString()));
                                log.setEventType(eventLog.getProperty("EventType").toString());
                                log.setEventState(eventLog.getProperty("EventState").toString());
                                try{log.setEventDesc(eventLog.getProperty("EventDesc").toString());}catch (Exception ex){}
                                log.setTime(eventLog.getProperty("Time").toString());
                                logs.add(log);
                            }
                            res.setLogs(logs);
                        }
                        res.setResult(result);
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> updateAndroidToken(UpdateAndroidTokenReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"updateAndroidTokenReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("UDID",req.getUDID())
                    .addProperty("APNs",req.getAPNs())
                    .addProperty("DeviceToken",req.getDeviceToken())
                    .addProperty("AndroidOS",req.getAndroidOS());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/updateAndroidToken");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                    SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/updateAndroidToken");


                }
            });
        }

        @Override
        public Observable<DeviceStatusRes> queryDeviceStatus(DeviceStatusReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryDeviceStatusReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            if (req.getPageNo()!=null)rpc.addProperty("PageNo",req.getPageNo());
            if (req.getSearchID()!=null)rpc.addProperty("SearchID",req.getSearchID());
            if (req.getPageSize()!=null)rpc.addProperty("PageSize",req.getPageSize());

            return Observable.create(new ObservableOnSubscribe<DeviceStatusRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceStatusRes> e) throws Exception {
                    DeviceStatusRes res = new DeviceStatusRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryDeviceStatus");

                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setPageNo(Integer.valueOf(obj.getProperty("PageNo").toString()));
                            res.setPageCount(Integer.valueOf(obj.getProperty("PageCount").toString()));
                            res.setRecordCount(Integer.valueOf(obj.getProperty("RecordCount").toString()));
                            SoapObject nodeList = (SoapObject) obj.getProperty("NodeList");
                            int count = nodeList.getPropertyCount();
                            ArrayList<DeviceStatusRes.Node> nodes = new ArrayList<>();
                            for (int i=0;i<count;i++){
                                SoapObject o = (SoapObject) nodeList.getProperty(i);
                                Log.i("123","o="+o.toString());
                                DeviceStatusRes.Node node = new DeviceStatusRes.Node();
                                node.setDevID(o.getProperty("DevID").toString());
                                node.setChannelNo(Integer.valueOf(o.getProperty("ChannelNo").toString()));
                                node.setName(o.getProperty("Name").toString());
                                node.setOnLine(Boolean.valueOf(o.getProperty("OnLine").toString()));
                                node.setPtzFlag(Boolean.valueOf(o.getProperty("PtzFlag").toString()));
                                node.setSecurityArea(Integer.valueOf(o.getProperty("SecurityArea").toString()));
                                node.seteStoreFlag(Boolean.valueOf(o.getProperty("EStoreFlag").toString()));//// FIXME: 2017/8/18 协议书上写int类型 实测为bool类型
                                node.setUpnpIP(o.getProperty("UpnpIP").toString());
                                node.setUpnpPort(Integer.valueOf(o.getProperty("UpnpPort").toString()));
                                node.setDevVer(o.getProperty("DevVer").toString());
                                node.setCurVideoNum(Integer.valueOf(o.getProperty("CurVideoNum").toString()));
                                node.setLastUpdated(o.getProperty("LastUpdated").toString());
                                node.setSmsSubscribedFlag(Integer.valueOf(o.getProperty("SMSSubscribedFlag").toString()));
                                node.setEmailSubscribedFlag(Integer.valueOf(o.getProperty("EMailSubscribedFlag").toString()));
                                node.setSharingFlag(Integer.valueOf(o.getProperty("SharingFlag").toString()));
                                node.setApplePushSubscribedFlag(Integer.valueOf(o.getProperty("ApplePushSubscribedFlag").toString()));
                                node.setAndroidPushSubscribedFlag(Integer.valueOf(o.getProperty("AndroidPushSubscribedFlag").toString()));
                                node.setInfraredFlag(Integer.valueOf(o.getProperty("InfraredFlag").toString()));
                                node.setWirelessFlag(Integer.valueOf(o.getProperty("WirelessFlag").toString()));
                                DeviceStatusRes.WirelessNetwork network = new DeviceStatusRes.WirelessNetwork();
                                try{
                                    SoapObject so = (SoapObject) o.getProperty("WirelessNetwork");
                                    network.setWirelessType(so.getProperty("WirelessType").toString());
                                    network.setSsid(so.getProperty("SSID").toString());
                                    network.setIntensity(Integer.valueOf(so.getProperty("Intensity").toString()));
                                }catch (Exception ex){}
                                node.setNetwork(network);
                                nodes.add(node);
                            }
                            res.setNodes(nodes);
                            try{
                                DeviceStatusRes.WirelessNetwork network = new DeviceStatusRes.WirelessNetwork();
                                SoapObject o = (SoapObject) obj.getProperty("WirelessNetwork");
                                network.setWirelessType(o.getProperty("WirelessType").toString());
                                network.setSsid(o.getProperty("SSID").toString());
                                network.setIntensity(Integer.valueOf(o.getProperty("Intensity").toString()));
                                res.setWirelessNetwork(network);
                            }catch (Exception ex){}
                            try{res.setDevType(Integer.valueOf(obj.getProperty("DevType").toString()));}catch (Exception ex){}
                            try{res.setModel(obj.getProperty("Model").toString());}catch (Exception ex){}
                            try{res.setSerialID(obj.getProperty("SerialID").toString());}catch (Exception ex){}
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){e.onError(ex);}finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> addDeviceSharer(DeviceSharerReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"addDeviceSharerReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("SharerAccount",req.getSharerAccount())
                    .addProperty("SharingPriority",req.getSharingPriority())
                    .addProperty("SharingName",req.getSharingName());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/addDeviceSharer");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> nullifyDeviceSharer(NullifyDeviceSharerReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"nullifyDeviceSharerReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("SharerAccount",req.getSharerASccount());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/nullifyDeviceSharer");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<DeviceSharerRes> queryDeviceSharer(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryDeviceSharerReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<DeviceSharerRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceSharerRes> e) throws Exception {
                    DeviceSharerRes res = new DeviceSharerRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryDeviceSharer");
                        String result = obj.getProperty("result").toString();
                        if (result.equalsIgnoreCase("OK")) {
                            ArrayList<DeviceSharerRes.Sharer> sharers = new ArrayList<>();
                            SoapObject sharer = (SoapObject) obj.getProperty("Sharer");
                            int count = sharer.getPropertyCount();
                            for (int i = 0; i < count; i++) {
                                SoapObject o = (SoapObject) sharer.getProperty(i);
                                sharers.add(new DeviceSharerRes.Sharer(
                                        o.getProperty("SharerAccount").toString(),
                                        Integer.valueOf(o.getProperty("SharingPriority").toString())
                                ));
                            }
                        }
                        res.setResult(result);
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }


                }
            });
        }

        @Override
        public Observable<DeviceSharingSourceRes> queryDeviceSharingSource(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryDeviceSharingSourceReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<DeviceSharingSourceRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceSharingSourceRes> e) throws Exception {
                    DeviceSharingSourceRes res = new DeviceSharingSourceRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryDeviceSharingSource");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setSharingSourceAccount(obj.getProperty("SharingSourceAccount").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<AndroidTokenRes> queryAndroidToken(AndroidTokenReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryAndroidTokenReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("UDID",req.getUDID());
            return Observable.create(new ObservableOnSubscribe<AndroidTokenRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<AndroidTokenRes> e) throws Exception {
                    AndroidTokenRes res = new AndroidTokenRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryAndroidToken");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setUDID(obj.getProperty("UDID").toString());
                            res.setAPNs(Boolean.valueOf(obj.getProperty("APNs").toString()));
                            res.setDeviceToken(obj.getProperty("DeviceToken").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });

        }

        @Override
        public Observable<ClientVersionRes> queryClientVersion(ClientVersionReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryClientVersionReq");
            rpc.addProperty("ClientType",req.getClientType());
            if (req.getApplicationID()!=null)rpc.addProperty("ApplicationID",req.getApplicationID());
            return Observable.create(new ObservableOnSubscribe<ClientVersionRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<ClientVersionRes> e) throws Exception {
                    ClientVersionRes res = new ClientVersionRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryClientVersion");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setVersion(obj.getProperty("Version").toString());
                            res.setDownloadAddress(obj.getProperty("DownloadAddress").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }

                }
            });
        }

        @Override
        public Observable<DeviceBondedRes> queryDeviceBonded(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryDeviceBondedReq");
            rpc.addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<DeviceBondedRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceBondedRes> e) throws Exception {
                    DeviceBondedRes res = new DeviceBondedRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryDeviceBonded");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            res.setHasBonded(Boolean.valueOf(obj.getProperty("HasBonded").toString()));
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> subscribeAndroidPush(SubscribeAndroidPushReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"subscribeAndroidPushReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("SubscribedFlag",req.getSubscribedFlag());
            if (req.getDevID()!=null)rpc.addProperty("DevID",req.getDevID());
            if (req.getChannelNo()!=null)rpc.addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/subscribeAndroidPush");
                        Log.i("123","~~~~~ obj = =="+obj.toString());
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PushWorkSheetRes> getPushWorkSheet(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getPushWorkSheetReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<PushWorkSheetRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PushWorkSheetRes> e) throws Exception {
                    PushWorkSheetRes res = new PushWorkSheetRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getPushWorkSheet");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            res.setWorkSheet(new PushWorkSheetRes.WorkSheet(((SoapObject)obj.getProperty("WorkSheet")).getProperty("BitString").toString()));
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setPushWorkSheet(PushWorkSheetReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setPushWorkSheetReq");
            SoapObject workSheet = new SoapObject(mNameSpace,"WorkSheet").addProperty("BitString",req.getWorkSheet().getBitString());
            rpc.addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("WorkSheet",workSheet);
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setPushWorkSheet");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<RecordParamRes> getRecordParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getRecordParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<RecordParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<RecordParamRes> e) throws Exception {
                    RecordParamRes res = new RecordParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getRecordParam");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            res.setEnabled(Boolean.valueOf(obj.getProperty("Enabled").toString()));
                            SoapObject workSheet = (SoapObject) obj.getProperty("WorkSheet");
                            res.setWorkSheet(new RecordParamRes.WorkSheet(
                                    Boolean.valueOf(workSheet.getProperty("Enabled").toString()),
                                    workSheet.getProperty("BitString").toString()
                            ));
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }

                }
            });
        }

        @Override
        public Observable<Result> setRecordParam(RecordParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setRecordParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo())
                    .addProperty("Enabled",req.getEnabled());
            if (req.getWorkSheet()!=null){
                SoapObject worksheet = new SoapObject(mNameSpace,"WorkSheet");
                worksheet.addProperty("Enabled",req.getWorkSheet().getEnabled())
                        .addProperty("BitString",req.getWorkSheet().getBitString());
                rpc.addProperty("WorkSheet",worksheet);
            }
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/setRecordParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<RelayRes> getRelay(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getRelayReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<RelayRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<RelayRes> e) throws Exception {
                    RelayRes res = new RelayRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getRelay");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            ArrayList<RelayRes.Relay> relays = new ArrayList<>();
                            SoapObject relay = (SoapObject) obj.getProperty("Relay");
                            int count = relay.getPropertyCount();
                            for (int i=0;i<count;i++){
                                SoapObject o = (SoapObject) relay.getProperty(i);
                                relays.add(new RelayRes.Relay(
                                        Integer.valueOf(o.getProperty("No").toString()),
                                        o.getProperty("Name").toString(),
                                        o.getProperty("State").toString()
                                ));
                            }
                            res.setRelays(relays);
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setRelay(RelayReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setRelayReq");
            rpc.addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            if (req.getRelays()!=null){
                for (RelayReq.Relay r:req.getRelays()){
                    SoapObject relay = new SoapObject(mNameSpace,"Relay");
                    relay.addProperty("No",r.getNo());
                    if (r.getName()!=null)relay.addProperty("Name",r.getNo());
                    if (r.getState()!=null)relay.addProperty("State",r.getState());
                    rpc.addProperty("Relay",relay);
                }
            }
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setRelay");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<WirelessNetworkRes> getGetWirelessNetworkRes(WirelessNetworkReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "getWirelessNetworkReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("DevID", req.getDevID());
            return Observable.create(new ObservableOnSubscribe<WirelessNetworkRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<WirelessNetworkRes> e) throws Exception {
                    WirelessNetworkRes res = new WirelessNetworkRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getWirelessNetwork");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setWirelessType(obj.getProperty("WirelessType").toString());
                            res.setsSID(obj.getProperty("SSID").toString());
                            res.setIntensity(Integer.valueOf(obj.getProperty("Intensity").toString()));
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> getDynamicPassword(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getDynamicPasswordReq")
                    .addProperty("Account",req.getAccount());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getDynamicPassword");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<DeviceMatchingCodeRes> getDeviceMatchingCode(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getDeviceMatchingCodeReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            return Observable.create(new ObservableOnSubscribe<DeviceMatchingCodeRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<DeviceMatchingCodeRes> e) throws Exception {
                    DeviceMatchingCodeRes res = new DeviceMatchingCodeRes();
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/getDeviceMatchingCode");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")) {
                            res.setMatchCode(obj.getProperty("MatchingCode").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<GetDeviceMatchingResultRes> getDeviceMatchingResult(GetDeviceMatchingResultReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "getDeviceMatchingResultReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("MatchingCode",req.getMatchingCode());
            return Observable.create(new ObservableOnSubscribe<GetDeviceMatchingResultRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<GetDeviceMatchingResultRes> e) throws Exception {
                    GetDeviceMatchingResultRes res = new GetDeviceMatchingResultRes();
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/getDeviceMatchingResult");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")) {
                            res.setDevID(obj.getProperty("DevID").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<TrustedAuthorityLoginRes> trustedAuthorityLogin(TrustedAuthorityLoginReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"trustedAuthorityLoginReq");
            rpc.addProperty("TrustedAuthority",req.getTrustedAuthority())
                    .addProperty("TrustedCode",req.getTrustedCode())
                    .addProperty("AuthorizationCode",req.getAuthorizationCode())
                    .addProperty("Version",req.getVersion())
                    .addProperty("NetworkOperator",req.getNetworkOperator())
                    .addProperty("NetType",req.getNetType());
            SoapObject mcuDev = new SoapObject(mNameSpace,"MCUDev");
            mcuDev.addProperty("UUID",req.getMcuDev().getUUID())
                    .addProperty("Model",req.getMcuDev().getModel())
                    .addProperty("Type",req.getMcuDev().getType())
                    .addProperty("OSType",req.getMcuDev().getOsType());
            if (req.getMcuDev().getOsVersion()!=null)mcuDev.addProperty("OSVersion",req.getMcuDev().getOsVersion());
            if (req.getMcuDev().getManufactory()!=null)mcuDev.addProperty("Manufactory",req.getMcuDev().getManufactory());
            if (req.getMcuDev().getIEMI()!=null)mcuDev.addProperty("IEMI",req.getMcuDev().getIEMI());
            rpc.addProperty("MCUDev",mcuDev);
            rpc.addProperty("ApplicationID",req.getApplicationID());
            return Observable.create(new ObservableOnSubscribe<TrustedAuthorityLoginRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<TrustedAuthorityLoginRes> e) throws Exception {
                    TrustedAuthorityLoginRes res = new TrustedAuthorityLoginRes();
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/trustedAuthorityLogin");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")) {
                            res.setSession(obj.getProperty("LoginSession").toString());
                            res.setUserName(obj.getProperty("Username").toString());
                            res.setAccount(obj.getProperty("Account").toString());
                            //TODO info

                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }


                }
            });
        }

        @Override
        public Observable<NoticesRes> queryNoticesRes(NoticesReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "queryNoticesReq");
            rpc.addProperty("Account", req.getAccount());
            rpc.addProperty("LoginSession", req.getLoginSession());
            if(req.getPageNo() != null) rpc.addProperty("PageNo", req.getPageNo());
            if (req.getPageSize()!=null) rpc.addProperty("PageSize", req.getPageSize());
            if(req.getSearchID()!=null)rpc.addProperty("SearchID",req.getSearchID());
            if (req.getStatus()!=null)rpc.addProperty("Status",req.getStatus());
            if (req.getTime()!=null)rpc.addProperty("Time",req.getTime());
            if (req.getSender()!=null)rpc.addProperty("Sender",req.getSender());
            Log.e("123","rpc="+rpc.toString());
            return Observable.create(new ObservableOnSubscribe<NoticesRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<NoticesRes> e) throws Exception {
                    NoticesRes res = new NoticesRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/queryNotices");
                        Log.e("123","obj="+obj.toString());
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setPageNo(Integer.valueOf(obj.getProperty("PageNo").toString()));
                            res.setPageCount(Integer.valueOf(obj.getProperty("PageCount").toString()));
                            res.setRecordCount(Integer.valueOf(obj.getProperty("RecordCount").toString()));

                            SoapObject noticeList = (SoapObject) obj.getProperty("Notice");
                            ArrayList<NoticeList> list = new ArrayList<NoticeList>();
                            int count = noticeList.getPropertyCount();
                            for (int i=0;i<count;i++){
                                NoticeList n = new NoticeList();
                                SoapObject s = (SoapObject) noticeList.getProperty(i);
                                n.setiD(s.getProperty("ID").toString());
                                n.setMessage(s.getProperty("Message").toString());
                                n.setClassification(s.getProperty("Classification").toString());
                                n.setTime(s.getProperty("Time").toString());
                                n.setStatus(s.getProperty("Status").toString());
                                n.setDevID(s.getProperty("DevID").toString());
                                n.setChannelNo(Integer.valueOf(s.getProperty("ChannelNo").toString()));
                                try{n.setName(s.getProperty("Name").toString());}catch (Exception ex){}
                                try{
                                    SoapObject pictureIDList = (SoapObject)s.getProperty("PictureID");
                                    ArrayList<String> pictureIdList = new ArrayList<String>();
                                    for(int j = 0 ; j < pictureIDList.getPropertyCount() ; j++){
                                        Object pictureID = pictureIDList.getProperty(j);
                                        pictureIdList.add(pictureID.toString());
                                    }
                                    n.setPictureID(pictureIdList);
                                }catch(Exception ex){
                                    n.setPictureID(new ArrayList<String>());
                                }
                                list.add(n);
                            }
                            res.setNoticeList(list);
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> flaggedNoticeStatusRes(FlaggedNoticeStatusReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "flaggedNoticeStatusReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("Status", req.getStatus());

            PropertyInfo p = new PropertyInfo();
            for (int i=0;i<req.getNoticeID().length;i++){
                p.setName("NoticeID");
                p.setValue(req.getNoticeID()[i]);
            }
            rpc.addProperty(p);
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/flaggedNoticeStatus");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<PictureRes> getGetPictureRes(final PictureReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace, "getPictureReq")
                    .addProperty("Account", req.getAccount())
                    .addProperty("LoginSession", req.getLoginSession())
                    .addProperty("PictureID", req.getPictureID());
            return Observable.create(new ObservableOnSubscribe<PictureRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<PictureRes> e) throws Exception {
                    PictureRes res = new PictureRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getPicture");
                        Log.i("123","get pictureRes="+obj.toString());
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setPictureID(obj.getProperty("PictureID").toString());
                            res.setPicture(obj.getProperty("Picture").toString());
                        }else if(obj.getProperty("result").toString().equalsIgnoreCase("NoRecord")){
                            Log.e("123","noRecord   picId="+req.getPictureID()+"  get picId="+obj.getProperty("PictureID").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<GetScheduledTaskRes> getScheduledTask(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getScheduledTaskReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<GetScheduledTaskRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<GetScheduledTaskRes> e) throws Exception {
                    GetScheduledTaskRes res = new GetScheduledTaskRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getScheduledTask");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            SoapObject task = (SoapObject) obj.getProperty("Task");
                            int count = task.getPropertyCount();
                            ArrayList<GetScheduledTaskRes.Task> tasks = new ArrayList<>();
                            for (int i=0;i<count;i++){
                                SoapObject o = (SoapObject) task.getProperty(i);
                                tasks.add(new GetScheduledTaskRes.Task(
                                        o.getProperty("TaskID").toString(),
                                        o.getProperty("Name").toString(),
                                        Boolean.valueOf(o.getProperty("Enabled").toString()),
                                        o.getProperty("TimeType").toString(),
                                        o.getProperty("Time").toString(),
                                        o.getProperty("ActionType").toString()
                                ));
                            }
                            res.setTasks(tasks);
                            SoapObject auxiliary = (SoapObject) obj.getProperty("Auxiliary");
                            res.setAuxiliary(new GetScheduledTaskRes.Auxiliary(
                                    auxiliary.getProperty("AuxiliaryType").toString(),
                                    auxiliary.getProperty("AuxiliaryState").toString()
                            ));
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<CreateScheduledTaskRes> createScheduledTask(CreateScheduledTaskReq req) {
            SoapObject task = new SoapObject(mNameSpace,"Task")
                    .addProperty("TaskID",req.getTask().getTaskID())
                    .addProperty("Name",req.getTask().getName())
                    .addProperty("Enabled",req.getTask().getEnabled())
                    .addProperty("TimeType",req.getTask().getTimeType())
                    .addProperty("TIme",req.getTask().getTime())
                    .addProperty("ActionType",req.getTask().getActionType());
            SoapObject auxiliary = new SoapObject(mNameSpace,"Auxiliary")
                    .addProperty("AuxiliaryType",req.getAuxiliary().getAuxiliaryType())
                    .addProperty("AuxiliaryState",req.getAuxiliary().getAuxiliaryState());
            final SoapObject rpc = new SoapObject(mNameSpace,"createScheduledTaskReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("Task",task)
                    .addProperty("Auxiliary",auxiliary);
            return Observable.create(new ObservableOnSubscribe<CreateScheduledTaskRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<CreateScheduledTaskRes> e) throws Exception {
                    CreateScheduledTaskRes res = new CreateScheduledTaskRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/createScheduledTask");
                        if (obj.getProperty("result").toString().equalsIgnoreCase("ok")){
                            res.setTaskID(obj.getProperty("TaskID").toString());
                        }
                        res.setResult(obj.getProperty("result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setScheduledTask(SetScheduledTaskReq req) {
            SoapObject task = new SoapObject(mNameSpace,"Task")
                    .addProperty("TaskID",req.getTask().getTaskID())
                    .addProperty("Name",req.getTask().getName())
                    .addProperty("Enabled",req.getTask().getEnabled())
                    .addProperty("TimeType",req.getTask().getTimeType())
                    .addProperty("Time",req.getTask().getTime())
                    .addProperty("ActionType",req.getTask().getActionType());
            SoapObject auxiliary =  new SoapObject(mNameSpace,"Auxiliary")
                    .addProperty("AuxiliaryType",req.getAuxiliary().getAuxiliType())
                    .addProperty("AuxiliaryState",req.getAuxiliary().getAuxiliState());
            final SoapObject rpc = new SoapObject(mNameSpace,"setScheduledTaskReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("Task",task)
                    .addProperty("Auxiliary",auxiliary);
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setScheduledTask");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> deleteScheduledTask(DeleteScheduledTaskReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"deleteScheduledTaskReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("TaskID",req.getTaskID());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/deleteScheduledTask");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<ExtendedParamRes> getExtendedParam(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getExtendedParamReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            return Observable.create(new ObservableOnSubscribe<ExtendedParamRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<ExtendedParamRes> e) throws Exception {
                    ExtendedParamRes res = new ExtendedParamRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getExtendedParam");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            res.setLightingDuration(Integer.valueOf(obj.getProperty("LightingDuration").toString()));
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setExtendedParam(ExtendedParamReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setExtendedParamReq");
            rpc.addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("LightingDuration",req.getLightingDuration());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setExtendedParam");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> uploadMCUDevice(UploadMCUDeviceReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"uploadMCUDeviceReq")
                    .addProperty("UUID",req.getUUID())
                    .addProperty("Model",req.getModel())
                    .addProperty("Type",req.getType())
                    .addProperty("OSType",req.getOsType());
            if (req.getOsVersion()!=null)rpc.addProperty("OSVersion",req.getOsVersion());
            if (req.getManufactory()!=null)rpc.addProperty("Manufactory",req.getManufactory());
            if (req.getIEMI()!=null)rpc.addProperty("IEMI",req.getIEMI());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/uploadMCUDevice");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<MCUDeviceAuthenticatedRes> queryMCUDeviceAuthenticated(MCUDeviceAuthenticatedReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"queryMCUDeviceAuthenticatedReq")
                    .addProperty("UUID",req.getUUID());
            return Observable.create(new ObservableOnSubscribe<MCUDeviceAuthenticatedRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<MCUDeviceAuthenticatedRes> e) throws Exception {
                    MCUDeviceAuthenticatedRes res = new MCUDeviceAuthenticatedRes();
                    try {
                        SoapObject obj = initEnvelopAndTransport(rpc, "http://www.haoweis.com/HomeServices/MCU/queryMCUDeviceAuthenticated");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")) {
                            res.setAuthenticated(Boolean.valueOf(obj.getProperty("Authenticated").toString()));
                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> addDeviceForcible(AddDeviceForceibleReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"addDeviceForcibleReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession());
            for (AddDeviceForceibleReq.Device d:req.getDevices()){
                SoapObject dev = new SoapObject(mNameSpace,"Device");
                dev.addProperty("DevID",d.getDevID());
                dev.addProperty("DevKey",d.getDevKey());
                if (d.getChannelNo()!=null)dev.addProperty("ChannelNo",d.getChannelNo());
                dev.addProperty("DevName",d.getDevName());
                rpc.addProperty("Device",dev);
            }
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/addDeviceForcible");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> nullifyDeviceForcible(nullifyDeviceForcibleReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"nullifyDeviceForcibleReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID());
            if (req.getDevKey()!=null)rpc.addProperty("DevKey",req.getDevKey());
            if (req.getChannelNo()!=null)rpc.addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/nullifyDeviceForcible");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<VideoBasicRes> getVideoBasic(Request req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"getVideoBasicReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            return Observable.create(new ObservableOnSubscribe<VideoBasicRes>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<VideoBasicRes> e) throws Exception {
                    VideoBasicRes res = new VideoBasicRes();
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/getVideoBasic");
                        if (obj.getProperty("Result").toString().equalsIgnoreCase("ok")){
                            try{res.setDNMode(obj.getProperty("DNMode").toString());}catch (Exception ex){}
                            try{
                                SoapObject o = (SoapObject) obj.getProperty("DNSensitivity");
                                res.setDnSensitivity(new VideoBasicRes.DNSensitivity(
                                        Integer.valueOf(o.getProperty("Minimum").toString()),
                                        Integer.valueOf(o.getProperty("Maximum").toString()),
                                        Integer.valueOf(o.getProperty("Value").toString())
                                ));
                            }catch (Exception ex){}
                            try{res.setAGCMode(obj.getProperty("AGCMode").toString());}catch (Exception ex){}
                            try{
                                SoapObject o = (SoapObject) obj.getProperty("AGC");
                                res.setAgc(new VideoBasicRes.AGC(
                                        Integer.valueOf(o.getProperty("Minimum").toString()),
                                        Integer.valueOf(o.getProperty("Maximum").toString()),
                                        Integer.valueOf(o.getProperty("Value").toString())
                                ));
                            }catch (Exception ex){}
                            try{res.seteShutterMode(obj.getProperty("eShutterMode").toString());}catch (Exception ex){}
                            try{
                                SoapObject o = (SoapObject) obj.getProperty("eShutter");
                                res.seteShutter(new VideoBasicRes.EShutter(
                                        o.getProperty("Value").toString(),
                                        o.getProperty("Options").toString()
                                ));
                            }catch (Exception ex){}
                            try{res.setInfraredMode(obj.getProperty("InfraredMode").toString());}catch (Exception ex){}

                        }
                        res.setResult(obj.getProperty("Result").toString());
                        e.onNext(res);
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }

        @Override
        public Observable<Result> setVideoBasic(VideoBasicReq req) {
            final SoapObject rpc = new SoapObject(mNameSpace,"setVideoBasicReq")
                    .addProperty("Account",req.getAccount())
                    .addProperty("LoginSession",req.getSession())
                    .addProperty("DevID",req.getDevID())
                    .addProperty("ChannelNo",req.getChannelNo());
            if (req.getDNMode()!=null)rpc.addProperty("DNMode",req.getDNMode());
            if (req.getDNSensitivity()!=null)rpc.addProperty("DNSensitivity",req.getDNSensitivity());
            if (req.getAGCMode()!=null)rpc.addProperty("AGCMode",req.getAGCMode());
            if (req.getAGC()!=null)rpc.addProperty("AGC",req.getAGC());
            if (req.geteShutterMode()!=null)rpc.addProperty("eShutterMode",req.geteShutterMode());
            if (req.geteShutter()!=null)rpc.addProperty("eShutter",req.geteShutter());
            if (req.getInfraredMode()!=null)rpc.addProperty("InfraredMode",req.getInfraredMode());
            return Observable.create(new ObservableOnSubscribe<Result>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Result> e) throws Exception {
                    try{
                        SoapObject obj = initEnvelopAndTransport(rpc,"http://www.haoweis.com/HomeServices/MCU/setVideoBasicReq");
                        e.onNext(new Result(obj.getProperty("result").toString()));
                    }catch (Exception ex){
                        e.onError(ex);
                    }finally {
                        e.onComplete();
                    }
                }
            });
        }


    }

}
