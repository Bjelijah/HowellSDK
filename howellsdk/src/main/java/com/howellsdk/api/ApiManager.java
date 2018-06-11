package com.howellsdk.api;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.howell.jni.JniUtil;
import com.howellsdk.download.ApDownloadFactory;
import com.howellsdk.net.http.utils.CustomInterceptor;
import com.howellsdk.net.http.utils.MD5;
import com.howellsdk.net.soap.SoapFactory;
import com.howellsdk.net.websocket.WebSocketFactory;
import com.howellsdk.player.ap.ApFactory;
import com.howellsdk.player.ecam.EcamFactory;
import com.howellsdk.player.local.LocalFactory;
import com.howellsdk.player.turn.TurnFactory;
import com.howellsdk.utils.SSLConection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2017/8/9.
 */

public class ApiManager {
    private static volatile ApiManager mInstance;
    public static ApiManager getInstance(){
        if (mInstance==null){
            synchronized (ApiManager.class){
                if (mInstance==null){
                    mInstance = new ApiManager();
                }
            }
        }
        return mInstance;
    }
    private ApiManager(){}

    private OkHttpClient mClient;
    private HWHttpApi mHWHttpApi;
    private HWSoapApi mHWSoapApi;
    private HWWebSocketApi mHWWebSocketApi;
    private HWPlayApi mHWTurnApi,mHWEcamApi,mHWApcamApi,mLocalApi;
    private HWDownloadApi mDownloadApi;

    public  ApiManager setJNILogEnable(boolean enable) {
        JniUtil.logEnable(enable);
        return this;
    }

    public ApiManager initHttpClient(Context context, boolean isSSL){
        if (mClient==null){
            try {
                mClient = (isSSL?SSLConection.getOKSSLBuild(context):new OkHttpClient.Builder())
                        .addInterceptor(new CustomInterceptor())
                        .connectTimeout(8, TimeUnit.SECONDS)
                        .readTimeout(8, TimeUnit.SECONDS)
                        .build();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CertificateException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnrecoverableKeyException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ApiManager initSoapClient(Context context, boolean isSSL){
        if (isSSL) try {
            SSLConection.allowSSL(context);
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }


    public HWHttpApi getHWHttpService(String url){
        if (mHWHttpApi==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(mClient)
                    .baseUrl(url)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(FastJsonConverterFactory.create())//FIXME error
                    .build();
            mHWHttpApi = retrofit.create(HWHttpApi.class);
        }
        return mHWHttpApi;
    }

    public HWHttpApi getHWHttpService(){
        if (mHWHttpApi==null)throw new NullPointerException("api=null");
        return mHWHttpApi;
    }



    public HWSoapApi getSoapService(String url){
        SoapFactory factory = null;
        try {
            factory = new SoapFactory.Builder()
                    .baseUrl(url)
                    .build();
            mHWSoapApi = factory.create();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mHWSoapApi;
    }

    public HWSoapApi getSoapService(){
        if (mHWSoapApi==null)throw new NullPointerException("api=null");
        return mHWSoapApi;
    }

    public ApiManager resetSoapService(){
        mHWSoapApi = null;
        return this;
    }

    public HWWebSocketApi getWebSocketService(String url,HWWebSocketApi.IWebSocketCB cb){
        if (mHWWebSocketApi==null){
            mHWWebSocketApi = new WebSocketFactory.Builder()
                    .baseUrl(url)
                    .callback(cb)
                    .build().create();
        }
        return mHWWebSocketApi;
    }

    public HWWebSocketApi getWebSocketService(){
        if (mHWWebSocketApi==null) throw new NullPointerException("api=null");
        return mHWWebSocketApi;
    }

    public ApiManager resetWebSocketService(){
        mHWWebSocketApi = null;
        return this;
    }


    public HWPlayApi getTurnService(){
        if (mHWTurnApi==null){Log.e("123","mHWTurnApi==null throw exception");throw new NullPointerException("api=null");}
        return mHWTurnApi;
    }

    public HWPlayApi getTurnService(Context c, String ip, int port
            ,String deviceId,int channel,boolean isSub
            , String name, String pwd, boolean ssl, String imei, HWPlayApi.ITurnCB cb){
//        if (mHWTurnApi==null){
        mHWTurnApi = new TurnFactory.Builder()
                .setContext(c)
                .setIP(ip)
                .setPort(port)
                .setName(name)
                .setPwd(pwd)
                .setSSL(ssl)
                .setIMEI(imei)
                .setTurnCallback(cb)
                .setDeviceId(deviceId)
                .setChannel(channel)
                .build()
                .create();
//        }
        return mHWTurnApi;
    }

    public ApiManager resetTurnService(){
        mHWTurnApi = null;
        return this;
    }


    public HWPlayApi getEcamService(String name, String ip, int port, int method,HWPlayApi.IEcamCB cb){
//        if (mHWEcamApi==null){
        mHWEcamApi = new EcamFactory.Builder()
                .setAccount(name)
                .setUpnp(ip,port)
                .setMethodType(method)
                .setEcamCB(cb)
                .build().create();
//        }
        return mHWEcamApi;
    }

    public HWPlayApi getEcamService(){
        if (mHWEcamApi==null) throw new NullPointerException("api=null");
        return mHWEcamApi;
    }

    public ApiManager resetEcamService(){
        mHWEcamApi = null;
        return this;
    }


    public HWPlayApi getAPcamService(){
        if (mHWApcamApi==null)throw new NullPointerException("api=null");
        return mHWApcamApi;
    }

    public HWPlayApi getAPcamService(String ip,int slot,int crypto,HWPlayApi.IAPCamCB cb){
//        if (mHWApcamApi==null){
        mHWApcamApi = new ApFactory.Builder()
                .setIP(ip)
                .setSlot(slot)
                .setCrypto(crypto)
                .setCallback(cb)
                .build().create();
//        }
        return mHWApcamApi;
    }

    public HWPlayApi setApcamService(HWPlayApi api){
        if (api!=null) {
            mHWApcamApi = api;
        }
        return mHWApcamApi;
    }

    public HWPlayApi setTurnService(HWPlayApi api){
        if(api!=null){ mHWTurnApi = api;}
        return mHWTurnApi;
    }

    public ApiManager resetApService(){
        mHWApcamApi = null;
        return this;
    }

    public HWDownloadApi getApDownLoadServer(int type){
       if (mDownloadApi==null){
           mDownloadApi = new ApDownloadFactory
                   .Builder()
                   .setType(type)
                   .build().create();
       }
       return mDownloadApi;
    }



    public HWDownloadApi getApDownLoadServer() {
        return mDownloadApi;
    }

    public HWPlayApi getLocalService(int crypto,String path){
        if(mLocalApi==null){
            mLocalApi = new LocalFactory.Builder()
                    .setCrypto(crypto)
                    .setPath(path)
                    .build().create();
        }
        return mLocalApi;
    }
    public HWPlayApi getLocalService(){
        return mLocalApi;
    }



    public enum EventType{
        NONE("None"),
        IO("IO"),
        VMD("VMD"),
        VIDEO_LOSS("Videoloss"),
        IRCUT("IRCut"),
        DAY_NIGHT("DayNight"),
        RECORD_STATE("RecordState"),
        STORAGE_MEDIUM_FAILURE("StorageMediumFailure"),
        RAID_FAILURE("RAIDFailure"),
        RECORDING_FAILURE("RecordingFailure"),
        BAD_VIDEO("BadVideo"),
        POS("POS"),
        FAN_FAILURE("FanFailure"),
        CPU_USAGE("CpuUsage"),
        MEMORY_USAGE("MemoryUsage"),
        TEMPERATURE("Temperature"),
        PRESSURE("Pressure"),
        VOLTAGE("Voltage"),
        MAX_CONNECT("MaximumConnections"),
        NETWORK_BITRATE("NetworkBitrate"),
        VIDEO_BITRATE("VideoBitrate"),
        SQUINT("Squint"),
        VIDEO_TURNED("VideoTurned"),
        JITTER("Jitter"),
        FREEZE("Freeze"),
        BLOCKED("Blocked"),
        HUMIDITY("Humidity"),
        DC12V_1("DC12V_1"),
        DC12V_2("DC12V_2"),
        DC24V("DC24V"),
        AC24V("AC24V"),
        AC220V("AC220V"),
        LOST_FOCUS("LostFocus"),
        NOISE("Noise"),
        COLOR_CAST("ColorCast"),
        ABNORMAL_BRIGHTNESS("AbnormalBrightness"),
        ABNORMAL_CONTRAST("AbnormalContrast"),
        SCENE_CHANGED("SceneChanged"),
        MOVED("Moved"),
        ONLINE("Online"),
        OFFLINE("Offline"),
        POWER_OFF("PowerOff"),
        TRANSMITTER_RECOVERY("TransmitterRecovery"),
        INDUSTRIAL_RECOVERY("IndustrialRecovery"),
        INTRUSION("Intrusion"),
        TRIPWIRE("Tripwire"),
        LOITERING("Loitering"),
        UNATTENDED("Unattended"),
        REMOVAL("Removal"),
        RETROGRADE("Retrograde"),
        COUNTING("Counting"),
        CROWED("Crowed"),
        DAMAGE("Damage"),
        STATIONARY("Stationary"),
        VOILENCE("Voilence"),
        POSE("POSE"),
        VEHICLE_PLATE("VehiclePlate"),
        ATM_SLOT("ATMSlot"),
        ATM_KEY_BOARD("ATMKeyBoard"),
        ATM_DAMAGE("ATMDamage"),
        BACK_ROOM_NUMBER_LIMIT("BackRoomNumberLimit"),
        BACK_ROOM_CROUCHED("BackRoomCrouched"),
        BACK_ROOM_COUNTING("BackRoomCounting"),
        ATM_TAIL_GATING("ATMTailGating"),
        ATM_THRUST("ATMThrust"),
        ATM_SEIZING("ATMSeizing"),
        ATM_FIGHTING("ATMFighting"),
        ATM_FUZZY_FACE("ATMFuzzyFace"),
        ATM_LOITERING("ATMLoitering"),
        ATM_RETENTIONG("ATMRetention"),
        DOOR_OPENED("DoorOpened");
        private String s;
        EventType(String s){this.s=s;}
        public String getVal(){return this.s;}
    }
    public static class HttpHelp{
        static String sCookieHalf;
        static String sVerify;
        private static String sSession;
        public enum Type{
            BUSINESS_DEVICE,
            BUSINESS_VIDEO_INPUT,
            BUSINESS_VIDEO_INPUT_GROUP,
            BUSINESS_VIDEO_INPUT_GROUP_CHILDGROUPS,
            BUSINESS_VIDEO_INPUT_GROUP_CHANNELS,
            BUSINESS_VIDEO_OUTPUT,
            BUSINESS_IO_INPUT,
            BUSINESS_IO_OUPUT,
            BUSINESS_MAP,
            BUSINESS_MAP_GROUP,
            BUSINESS_MAP_GROUP_CHILDGROUPS,
            BUSINESS_MAP_GROUP_MAPS,
            BUSINESS_LINKAGES,
            BUSINESS_USER,
            BUSINESS_DEPARTMENTS,
            BUSINESS_IO_INPUT_CHANNELS_STATUS,
            BUSINESS_IO_INPUT_CHANNELS_STATUS_UPDATE,
            BUSINESS_IO_INPUT_CHANNELS_STATUS_ELIMINATE,
            BUSINESS_IO_INPUT_CHANNELS_STATUS_PROCESS,
            BUSINESS_IO_OUTPUT_CHANNELS_STATUS,
            BUSINESS_IO_OUTPUT_CHANNELS_STATUS_UPDATE,
            BUSINESS_MAP_DATA,
            BUSINESS_MAP_ITEM,
            BUSINESS_EVENT_LINKAGES,
            BUSINESS_EVENT_RECORDS,
            BUSINESS_STREAM_CODEC,
            BUSINESS_GIS_MAP,
            BUSINESS_GIS_MAP_LAYERS,
            BUSINESS_GIS_MAP_ITEMS,
            GPS_DEVICES,
            GPS_RMC,
            GPS_DEVICES_ACCESS,
            GPS_DEVICES_ACCESS_RMC,
            VEHICLE_DEVICE,
            VEHICLE_DEVICE_RECORDS,
            VEHICLE_DEVICE_ACCESS,
            VEHICLE_DEVICE_ACCESS_RECORDS,
            VEHICLE_DEVICE_RECORDS_ALL,
            VEHICLE_PICTURES_UPDATE,
            VEHICLE_PICTURES,
            VEHICLE_PICTURES_DATA,
            VEHICLE_PICTURES_DETECT,
            VEHICLE_VEHICLE,
            PDC_VERSION,
            PDC_MAINPAGE_LAYOUT,
            PDC_DEVICE_SEARCH,
            PDC_DEVICE_SEARCH_START,
            PDC_DEVICE_SEARCH_STOP,
            PDC_DEVICE,
            PDC_DEVICE_STATUS,
            PDC_DEVICE_SAMPLES,
            PDC_DEVICE_THRESHOLD,
            PDC_DEVICE_SCHEDULE,
            PDC_GROUP,
            PDC_GROUP_STATUS,
            PDC_GROUP_DEVICES,
            PDC_GROUP_SAMPLES,
            PDC_GROUP_THRESHOLD,
            PDC_FLAVOURS,
            PDC_EVENTS_RECORDS,
            PDC_USERS
        }
        public enum DeviceClassification{
            NONE("None"),
            IP_CAMERA("IPCamera"),
            DVS("DVS"),
            NVR("NVR"),
            DVR("DVR"),
            DIGITAL_MATRIX("DigitalMatrix"),
            HD_Decoder("HDDecoder"),
            ANALOG_MATRIX("AnalogMatrix"),
            VAS("VAS"),
            AAM("AAM"),
            NAM("NAM"),
            VPS("VPS"),
            INTEGRATED_MATRIX("IntegratedMatrix"),
            MATRIX_CONTROL_UNIT("MatrixControlUnit"),
            STREAMING_MEDIA_SERVER("StreamingMediaServer"),
            DECODING_UNIT("DecodingUnit "),
            ENCODING_UNIT("EncodingUnit "),
            NVS("NVS"),
            DATA_SERVER("DataServer"),
            ACQUISITION_SERVER("AcquisitionServer"),
            SYSTEM_GATEWAY("SystemGateway"),
            CAMERA("Camera"),
            ULTRASONIC_PROBE("UltrasonicProbe"),
            RFID_ANTENNA("RFIDAntenna"),
            ATM_ANALYSER("ATMAnalyser");

            private String s;
            DeviceClassification(String s){
                this.s=s;
            }
            public String getVal(){
                return this.s;
            }
        }


        public static void setCookie(String userName,String domain,String loginSession,String verifySession){
            sCookieHalf = "username="+userName+";sid="+loginSession+";domain="+domain+";";
            sVerify = verifySession;
            sSession = loginSession;
        }
        public static String getCookie(Type type,@Nullable String... params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
            //Log.i("123","params="+params+"  params len="+params.length);
            String action = null;
            switch (type){
                case BUSINESS_DEVICE:action="GET:/howell/ver10/data_service/Business/Informations/Devices"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_VIDEO_INPUT:action="GET:/howell/ver10/data_service/Business/Informations/Video/Inputs/Channels"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_VIDEO_INPUT_GROUP:action="GET:/howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_VIDEO_INPUT_GROUP_CHILDGROUPS:action="GET:/howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/"+params[0]+"/ChildGroups:";break;
                case BUSINESS_VIDEO_INPUT_GROUP_CHANNELS:action="GET:/howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/"+params[0]+"/Channels"+(params.length>1?"/"+params[1]:"")+":";break;
                case BUSINESS_VIDEO_OUTPUT:action="GET:/howell/ver10/data_service/Business/Informations/Video/OutPuts/Channels"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_IO_INPUT:action="GET:/howell/ver10/data_service/Business/Informations/IO/Inputs/Channels"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_IO_OUPUT:action="GET:/howell/ver10/data_service/Business/Informations/IO/Outputs/Channels"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_MAP:action="GET:/howell/ver10/data_service/Business/Informations/Maps"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_MAP_GROUP:action="GET:/howell/ver10/data_service/Business/Informations/Maps/Groups"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_MAP_GROUP_CHILDGROUPS:action="GET:/howell/ver10/data_service/Business/Informations/Maps/Groups/"+params[0]+"/ChildGroups:";break;
                case BUSINESS_MAP_GROUP_MAPS:action="GET:/howell/ver10/data_service/Business/Informations/Maps/Groups/"+params[0]+"/Maps"+(params.length>1?"/"+params[1]:"")+":";break;
                case BUSINESS_LINKAGES:action="GET:/howell/ver10/data_service/Business/Informations/Linkages"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_USER:action="GET:/howell/ver10/data_service/Business/Informations/User:";break;
                case BUSINESS_DEPARTMENTS:action="GET:/howell/ver10/data_service/Business/Informations/Departments"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_IO_INPUT_CHANNELS_STATUS:action="GET:/howell/ver10/data_service/Business/Informations/IO/Inputs/Channels"+(params.length>0?"/"+params[0]:"")+"/Status:";break;
                case BUSINESS_IO_INPUT_CHANNELS_STATUS_UPDATE:action="PUT:/howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/"+params[0]+"/Status:";break;
                case BUSINESS_IO_INPUT_CHANNELS_STATUS_ELIMINATE:action="POST:/howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/"+params[0]+"/Status/Eliminate:";break;
                case BUSINESS_IO_INPUT_CHANNELS_STATUS_PROCESS:action="POST:/howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/"+params[0]+"/Status/Process:";break;
                case BUSINESS_IO_OUTPUT_CHANNELS_STATUS:action="GET:/howell/ver10/data_service/Business/Informations/IO/Outputs/Channels"+(params.length>0?"/"+params[0]:"")+"/Status:";break;
                case BUSINESS_IO_OUTPUT_CHANNELS_STATUS_UPDATE:action="PUT:/howell/ver10/data_service/Business/Informations/IO/Outputs/Channels/"+params[0]+"/Status:";break;
                case BUSINESS_MAP_DATA:action="GET:/howell/ver10/data_service/Business/Informations/Maps/"+params[0]+"/Data:";break;
                case BUSINESS_MAP_ITEM:action="GET:/howell/ver10/data_service/Business/Informations/Maps/"+params[0]+"/Items"+(params.length>1?"/"+params[1]:"")+":";break;
                case BUSINESS_EVENT_LINKAGES:action="GET:/howell/ver10/data_service/Business/Informations/Event/Linkages"+(params.length>0?"/"+params[0]:"")+":";break;
                case BUSINESS_EVENT_RECORDS:action="GET:/howell/ver10/data_service/Business/Informations/Event/Records:";break;
                case BUSINESS_STREAM_CODEC:action="howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/"+params[0]+"/Streaming/"+params[1]+"/Codec:";break;
                case BUSINESS_GIS_MAP:action="GET:/howell/ver10/data_service/Business/Informations/GIS/Maps:";break;
                case BUSINESS_GIS_MAP_LAYERS:action="GET:/howell/ver10/data_service/Business/Informations/GIS/Maps/"+params[0]+"/Layers:";break;
                case BUSINESS_GIS_MAP_ITEMS:action="GET:/howell/ver10/data_service/Business/Informations/GIS/Maps/"+params[0]+"/Items"+(params.length>1?"/"+params[1]:"")+":";break;
                case GPS_DEVICES:action="GET:/howell/ver10/gps_service/System/Devices"+(params.length>0?"/"+params[0]:"")+":";break;
                case GPS_RMC:action="GET:/howell/ver10/gps_service/System/Devices/"+params[0]+"/RMC:";break;
                case GPS_DEVICES_ACCESS:action="GET:/howell/ver10/gps_service/System/Devices/Access"+(params.length>0?"/"+params[0]:"")+":";break;
                case GPS_DEVICES_ACCESS_RMC:action="GET:/howell/ver10/gps_service/System/Devices/Access/"+params[0]+"/RMC:";break;
                case VEHICLE_DEVICE:action="GET:/howell/ver10/vehicle_service/System/Devices"+(params.length>0?"/"+params[0]:"")+":";break;
                case VEHICLE_DEVICE_RECORDS:action="GET:/howell/ver10/vehicle_service/System/Devices/"+params[0]+"/Records:";break;
                case VEHICLE_DEVICE_ACCESS:action="GET:/howell/ver10/vehicle_service/System/Devices/Access"+(params.length>0?"/"+params[0]:"")+":";break;
                case VEHICLE_DEVICE_ACCESS_RECORDS:action="GET:/howell/ver10/vehicle_service/System/Devices/Access/"+params[0]+"/Records:";break;
                case VEHICLE_DEVICE_RECORDS_ALL:action="GET:/howell/ver10/vehicle_service/System/Devices/Records:";break;
                case VEHICLE_PICTURES_UPDATE:action="POST:/howell/ver10/vehicle_service/System/Pictures:";break;
                case VEHICLE_PICTURES:action="GET:/howell/ver10/vehicle_service/System/Pictures/"+params[0]+":";break;
                case VEHICLE_PICTURES_DATA:action="GET:/howell/ver10/vehicle_service/System/Pictures/"+params[0]+"/Data:";break;
                case VEHICLE_PICTURES_DETECT:action="GET:/howell/ver10/vehicle_service/System/Pictures/"+params[0]+"/Detection:";break;
                case VEHICLE_VEHICLE:action="GET:/howell/ver10/vehicle_service/System/Vehicles"+(params.length>0?"/"+params[0]:"")+":";break;
                case PDC_VERSION:action="GET:/howell/ver10/pdc_service/System/Version:";break;
                case PDC_MAINPAGE_LAYOUT:action="GET:/howell/ver10/pdc_service/System/MainPage/Layout:";break;
                case PDC_DEVICE_SEARCH:action="GET:/howell/ver10/pdc_service/System/Devices/Searching/"+params[0]+":";break;
                case PDC_DEVICE_SEARCH_START:action="POST:/howell/ver10/pdc_service/System/Devices/Searching/"+params[0]+":";break;
                case PDC_DEVICE_SEARCH_STOP:action="DELETE:/howell/ver10/pdc_service/System/Devices/Searching/"+params[0]+":";break;
                case PDC_DEVICE:action="GET:/howell/ver10/pdc_service/System/Devices"+(params.length>0?"/"+params[0]:"")+":";break;
                case PDC_DEVICE_STATUS:action="GET:/howell/ver10/pdc_service/System/Devices/"+params[0]+"/Status:";break;
                case PDC_DEVICE_SAMPLES:action="GET:/howell/ver10/pdc_service/System/Devices/"+params[0]+"/Samples:";break;
                case PDC_DEVICE_THRESHOLD:action="GET:/howell/ver10/pdc_service/System/Devices/"+params[0]+"/Threshold:";break;
                case PDC_DEVICE_SCHEDULE:action="GET:/howell/ver10/pdc_service/System/Devices/"+params[0]+"/Schedule:";break;
                case PDC_GROUP:action="GET:/howell/ver10/pdc_service/System/Groups"+(params.length>0?"/"+params[0]:"")+":";break;
                case PDC_GROUP_STATUS:action="GET:/howell/ver10/pdc_service/System/Groups/"+params[0]+"/Status:";break;
                case PDC_GROUP_DEVICES:action="GET:/howell/ver10/pdc_service/System/Groups/"+params[0]+"/Devices"+(params.length>1?"/"+params[1]:"")+":";break;
                case PDC_GROUP_SAMPLES:action="GET:/howell/ver10/pdc_service/System/Groups/"+params[0]+"/Samples:";break;
                case PDC_GROUP_THRESHOLD:action="GET:/howell/ver10/pdc_service/System/Groups/"+params[0]+"/Threshold:";break;
                case PDC_FLAVOURS:action="GET:/howell/ver10/pdc_service/System/Flavours"+(params.length>0?"/"+params[0]:"")+":";break;
                case PDC_EVENTS_RECORDS:action="GET:/howell/ver10/pdc_service/System/Events/Records:";break;
                case PDC_USERS:action="GET:/howell/ver10/pdc_service/System/Users"+(params.length>0?"/"+params[0]:"")+":";break;
                default:
                    break;
            }
            return  sCookieHalf+"verifysession="+ MD5.getMD5(action+sVerify);
        }
        public static String getSession(){
            return sSession;
        }
    }

    public static class SoapHelp{
        private static String sSession;

        public static String getsSession() {
            return sSession;
        }

        public static void setsSession(String sSession) {
            SoapHelp.sSession = sSession;
        }
    }

    public static class PlayHelp{
        static HWPlayApi api;
        public static void keepApi(HWPlayApi api){
            PlayHelp.api = api;
        }
        public static HWPlayApi getAPi(){
            return api;
        }
        public static void clearAPi(){api=null;}
    }


}
