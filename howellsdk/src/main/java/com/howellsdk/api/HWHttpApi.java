package com.howellsdk.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.howellsdk.net.http.bean.*;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/9.
 */

public interface HWHttpApi {
    @GET("howell/ver10/user_authentication/Authentication/Nonce")
    Observable<UserNonce> getUserNonce(@Query("UserName") String userName);

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("howell/ver10/user_authentication/Authentication/Authenticate")
    Observable<Fault> doUserAuthenticate(@Body ClientCredential req);


    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("howell/ver10/user_authentication/Authentication/Teardown")
    Observable<Fault> doUserTeardown(@Body TeardownCredential req);

    @GET("howell/ver10/data_service/Business/Informations/Devices")
    Observable<DevicePermissionList> queryBusinessDevice(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize,
            @Query("Classification") @Nullable String classification);

    @GET("howell/ver10/data_service/Business/Informations/Devices/{id}")
    Observable<DevicePermission> queryBusinessDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels")
    Observable<VideoInputChannelPermissionList> queryBusinessVideoInputChannel(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/{id}")
    Observable<VideoInputChannelPermission> queryBusinessVideoInputChannel(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups")
    Observable<VideoInputChannelGroupList> queryBusinessVideoInputChannelGroup(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/{id}")
    Observable<VideoInputChannelGroup> queryBusinessVideoInputChannelGroup(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/{id}/ChildGroups")
    Observable<VideoInputChannelGroupList> queryBusinessVideoInputChildGroup(
            @Header("Cookie") String cookie,
            @Path("id") String groupId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/{id}/Channels")
    Observable<VideoInputChannelPermissionList> queryBusinessVideoInputChannelGroupChannels(
            @Header("Cookie") String cookie,
            @Path("id") String groupId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/Groups/{groupId}/Channels/{channelId}")
    Observable<VideoInputChannelPermission> queryBusinessVideoInputChannelGroupChannels(
            @Header("Cookie") String cookie,
            @Path("groupId") String groupId,
            @Path("channelId") String channelId);

    @GET("howell/ver10/data_service/Business/Informations/Video/OutPuts/Channels")
    Observable<VideoOutputChannelPermissionList> queryBusinessOutputChannel(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/OutPuts/Channels/{id}")
    Observable<VideoOutputChannelPermission> queryBusinessOutputChannel(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels")
    Observable<IOInputChannelList>  queryBusinessIOInputChannel(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/{id}")
    Observable<IOInputChannel> queryBusinessIOInputChannel(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/IO/Outputs/Channels")
    Observable<IOOutputChannelList> queryBusinessIOOutputChannel(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/IO/Outputs/Channels/{id}")
    Observable<IOOutputChannel> queryBusinessIOOutputChannel(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Maps")
    Observable<MapList> queryBusinessMaps(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Maps/{id}")
    Observable<Map> queryBusinessMaps(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Maps/Groups")
    Observable<MapGroupList> queryBusinessMapGroup(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Maps/Groups/{id}")
    Observable<MapGroup> queryBusinessMapGroup(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Maps/Groups/{id}/ChildGroups")
    Observable<MapGroupList> queryBusinessMapGroupChildGroup(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Maps/Groups/{id}/Maps")
    Observable<MapList> queryBusinessMapGroupMaps(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Maps/Groups/{groupId}/Maps/{mapId}")
    Observable<Map> queryBusinessMapGroupMaps(
            @Header("Cookie") String cookie,
            @Path("groupId") String groupId,
            @Path("mapId") String mapId);

    @GET("howell/ver10/data_service/Business/Informations/Linkages")
    Observable<LinkageList> queryBusinessLinkages(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Linkages/{id}")
    Observable<Linkage> queryBusinessLinkages(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/User")
    Observable<User> queryBusinessUser(@Header("Cookie") String cookie);

    @GET("howell/ver10/data_service/Business/Informations/Departments")
    Observable<DepartmentList> queryBusinessDepartments(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Departments/{id}")
    Observable<Department> queryBusinessDepartments(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/Status")
    Observable<IOInputChannelStatusList> queryBusinessIOInputChannelStatus(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/{id}/Status")
    Observable<IOInputChannelStatus> queryBusinessIOInputChannelStatus(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @Headers("Content-Type:application/json;charset=utf-8")
    @PUT("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/{id}/Status")
    Observable<Fault> updataBusinessIOInputChannelStatus(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Body IOInputChannelStatus status);

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/{id}/Status/Eliminate")
    Observable<Fault> doBusinessIOInputChannelStatusEliminate(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("howell/ver10/data_service/Business/Informations/IO/Inputs/Channels/{id}/Status/Process")
    Observable<Fault> doBusinessIOInputChannelStatusProcess(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Body ProcessingResult result);

    @GET("howell/ver10/data_service/Business/Informations/IO/Outputs/Channels/Status")
    Observable<IOOutputChannelStatusList> queryBusinessIOOutputChannelStatus(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/IO/Outputs/Channels/{id}/Status")
    Observable<IOOutputChannelStatus> queryBusinessIOOutputChannelStatus(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @Headers("Content-Type:application/json;charset=utf-8")
    @PUT("howell/ver10/data_service/Business/Informations/IO/Outputs/Channels/{id}/Status")
    Observable<Fault> updataBusinessIOOutputChannelStatus(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Body IOOutputChannelStatus status);

    @GET("howell/ver10/data_service/Business/Informations/Maps/{id}/Data")
    Observable<Byte []> queryBusinessMapData(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Maps/{id}/Items")
    Observable<MapItemList> queryBusinessMapItem(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Maps/{mapId}/Items/{itemId}")
    Observable<MapItem> queryBusinessMapItem(
            @Header("Cookie") String cookie,
            @Path("mapId") String mapId,
            @Path("itemId") String itemId);

    @GET("howell/ver10/data_service/Business/Informations/Event/Linkages")
    Observable<EventLinkageList> queryBusinessEventLinkages(@Header("Cookie") String cookie);

    @GET("howell/ver10/data_service/Business/Informations/Event/Linkages/{id}")
    Observable<EventLinkage> queryBusinessEventLinkages(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/data_service/Business/Informations/Event/Records")
    Observable<EventRecordedList> queryBusinessEventRecords(
            @Header("Cookie") String cookie,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("ComponentId") @Nullable String id,
            @Query("EventType") @Nullable String eventType,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/Video/Inputs/Channels/{channelId}/Streaming/{streamId}/Codec")
    Observable<Codec> queryBusinessVideoInputChannelsStreamCodec(
            @Header("Cookie") String cookie,
            @Path("channelId") String channelId,
            @Path("streamId") String streamId,
            @Query("BeginTime") @Nullable String beg,
            @Query("EndTime") @Nullable String end);

    @GET("howell/ver10/data_service/Business/Informations/GIS/Maps")
    Observable<GISMapList> queryBusinessGISMaps(
            @Header("Cookie") String cookie,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/GIS/Maps/{id}/Layers")
    Observable<GISMapLayerList> queryBusinessGISMapsLayers(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("ParentLayerId") @Nullable String parentLayerId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/data_service/Business/Informations/GIS/Maps/{id}/Items")
    Observable<GISMapItemList> queryBusinessGISMapsItems(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("ItemId") @Nullable String itemId,
            @Query("ParentLayerId") @Nullable String parentLayerId,
            @Query("GPSId") @Nullable String gpsId,
            @Query("HasGPSId") @Nullable Boolean hasGpsId,
            @Query("VehiclePlateId") @Nullable String vehiclePlateId,
            @Query("HasVehiclePlateId") @Nullable Boolean hasVehiclePlateId,
            @Query("FaceRecognitionId") @Nullable String faceRecognitionId,
            @Query("HasFaceRecognitionId") @Nullable Boolean hasFaceRecognitionId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/gps_service/System/Devices")
    Observable<GPSDeviceList> queryGPSDevice(
            @Header("Cookie") String cookie,
            @Query("DeviceId") @Nullable String deviceId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/gps_service/System/Devices/{id}")
    Observable<GPSDevice> queryGPSDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/gps_service/System/Devices/{id}/RMC")
    Observable<RMCList> queryGPSRMC(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("Status") @Nullable Integer status,
            @Query("Interval") @Nullable Integer interval,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/gps_service/System/Devices/Access")
    Observable<GPSDeviceList> queryGPSDeviceAccess(
            @Header("Cookie") String cookie,
            @Query("AccessId") @Nullable String accessId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/gps_service/System/Devices/Access/{id}")
    Observable<GPSDevice> queryGPSDeviceAccess(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/gps_service/System/Devices/Access/{id}/RMC")
    Observable<RMCList> queryGPSDeviceAccessRMC(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("Status") @Nullable Integer status,
            @Query("Interval") @Nullable Integer interval,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/vehicle_service/System/Devices")
    Observable<VehiclePlateDeviceList> queryVehiclePlateDevice(
            @Header("Cookie") String cookie,
            @Query("DeviceId") @Nullable String deviceId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/vehicle_service/System/Devices/{id}")
    Observable<VehiclePlateDevice> queryVehiclePlateDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/vehicle_service/System/Devices/{id}/Records")
    Observable<VehiclePlateRecordList> queryVehiclePlateRecords(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize
    );

    @GET("howell/ver10/vehicle_service/System/Devices/Access")
    Observable<VehiclePlateDeviceList> queryVehiclePlateDeviceAccess(
            @Header("Cookie") String cookie,
            @Query("AccessId") @Nullable String accessId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/vehicle_service/System/Devices/Access/{id}")
    Observable<VehiclePlateDevice> queryVehiclePlateDeviceAccess(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/vehicle_service/System/Devices/Access/{id}/Records")
    Observable<VehiclePlateRecordList> queryVehiclePlateDeviceAccessRecords(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/vehicle_service/System/Devices/Records")
    Observable<VehiclePlateRecordList> queryVehiclePlateDeviceRecord(
            @Header("Cookie") String cookie,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("Plate") @Nullable String plate,
            @Query("Brand") @Nullable String brand,
            @Query("Name") @Nullable String name,
            @Query("DeviceId") @Nullable String deviceId,
            @Query("AccessId") @Nullable String accessId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);


    @GET("howell/ver10/vehicle_service/System/Devices/Records")
    Observable<ResponseBody> queryVehiclePlateDeviceRecordResponse(
            @Header("Cookie") String cookie,
            @Query("BeginTime") @NonNull String beg,
            @Query("EndTime") @NonNull String end,
            @Query("Plate") @Nullable String plate,
            @Query("Brand") @Nullable String brand,
            @Query("Name") @Nullable String name,
            @Query("DeviceId") @Nullable String deviceId,
            @Query("AccessId") @Nullable String accessId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);



    @Headers("Content-Type:application/octet-stream")
    @POST("howell/ver10/vehicle_service/System/Pictures")
    Observable<VehiclePlatePicture> updataVehiclePicture(
            @Header("Cookie") String cookie,
            @Body byte[] imageData);

    @GET("howell/ver10/vehicle_service/System/Pictures/{id}")
    Observable<VehiclePlatePicture> queryVehiclePicture(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/vehicle_service/System/Pictures/{id}/Data")
    Observable<byte []> queryVehiclePictureData(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/vehicle_service/System/Pictures/{id}/Detection")
    Observable<VehicleDetectionResult> queryVehicleDetectionResult(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/vehicle_service/System/Vehicles")
    Observable<VehicleList> queryVehicleList(
            @Header("Cookie") String cookie,
            @Query("Plate") @Nullable String plate,
            @Query("Brand") @Nullable String brand,
            @Query("ExistedInBlackList") @Nullable Boolean existed,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize") @Nullable Integer pageSize);

    @GET("howell/ver10/vehicle_service/System/Vehicles/{id}")
    Observable<Vehicle> queryVehicleList(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/pdc_service/System/Version")
    Observable<PDCServiceVersion> queryPdcServiceVersion(@Header("Cookie") String cookie);

    @GET("howell/ver10/pdc_service/System/Version")
    Observable<PDCServiceVersion> queryPdcServiceVersion();


    @GET("howell/ver10/pdc_service/System/MainPage/Layout")
    Observable<MainPageLayout> queryMainPageLayout(@Header("Cookie") String cookie);

    @GET("howell/ver10/pdc_service/System/Devices/Searching/{id}")
    Observable<PDCDevice> getSearchPdcDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @Headers("Content-Type:application/json;charset=utf-8")
    @POST("howell/ver10/pdc_service/System/Devices/Searching/{id}")
    Observable<Fault> startSearchPdcDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id,
            @Body String ProtocolTypeAndTimeout);

    @DELETE("howell/ver10/pdc_service/System/Devices/Searching/{id}")
    Observable<Fault> stopSearchPdcDevice(
            @Header("Cookie") String cookie,
            @Path("id") String id);

    @GET("howell/ver10/pdc_service/System/Devices")
    Observable<PDCDeviceList> queryPdcDevices(
            @Header("Cookie") String cookie,
            @Query("DeviceId")  @Nullable String deviceId,
            @Query("PageIndex") @Nullable Integer pageIndex,
            @Query("PageSize")  @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Devices/{id}")
    Observable<PDCDevice> queryPdcDevices(
            @Header("Cookie") String cookie,
            @Path("id")       String id);

    @GET("howell/ver10/pdc_service/System/Devices/{id}/Status")
    Observable<PDCDeviceStatus> queryPdcDeviceStatus(
            @Header("Cookie") String cookie,
            @Path("id")       String id);

    @GET("howell/ver10/pdc_service/System/Devices/{id}/Samples")
    Observable<PDCSampleList> queryPdcDeviceSamples(
            @Header("Cookie")       String cookie,
            @Path("id")             String id,
            @Query("SampleUnit")   @NonNull String sampleUnit,
            @Query("BeginTime")    @NonNull String beginTime,
            @Query("EndTime")      @NonNull String endTime,
            @Query("PageIndex")    @Nullable Integer pageIndex,
            @Query("PageSize")     @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Devices/{id}/Threshold")
    Observable<PDCThreshold> queryPdcDeviceThreshold(
            @Header("Cookie")       String cookie,
            @Path("id")             String id);

    @GET("howell/ver10/pdc_service/System/Devices/{id}/Schedule")
    Observable<WeeklySchedule> queryPdcDeviceSchedule(
            @Header("Cookie")       String cookie,
            @Path("id")             String id);

    @GET("howell/ver10/pdc_service/System/Groups")
    Observable<PDCDeviceGroupList> queryPdcGroups(
            @Header("Cookie")               String cookie,
            @Query("PDCDeviceGroupId")      @Nullable String pdcDeviceGroupId,
            @Query("PageIndex")             @Nullable Integer pageIndex,
            @Query("PageSize")              @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Groups/{id}")
    Observable<PDCDeviceGroup> queryPdcGroups(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id);

    @GET("howell/ver10/pdc_service/System/Groups/{id}/Status")
    Observable<PDCDeviceGroupStatus> queryPdcGroupStatus(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id);

    @GET("howell/ver10/pdc_service/System/Groups/{id}/Devices")
    Observable<PDCDeviceList> queryPdcGroupDevices(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id,
            @Query("PageIndex")             @Nullable Integer pageIndex,
            @Query("PageSize")              @Nullable Integer pageSize,
            @Query("Inversed")              @Nullable Boolean inverse);

    @GET("howell/ver10/pdc_service/System/Groups/{groupId}/Devices/{deviceId}")
    Observable<PDCDevice> queryPdcGroupDevices(
            @Header("Cookie")               String cookie,
            @Path("groupId")                String groupId,
            @Path("deviceId")               String deviceId);

    @GET("howell/ver10/pdc_service/System/Groups/{id}/Samples")
    Observable<PDCSampleList> queryPdcGroupSamples(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id,
            @Query("SampleUnit")            @NonNull String sampleUnit,
            @Query("BeginTime")             @NonNull String beginTime,
            @Query("EndTime")               @NonNull String endTime);

    @GET("howell/ver10/pdc_service/System/Groups/{id}/Threshold")
    Observable<PDCThreshold> queryPdcGroupThreshold(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id);

    @GET("howell/ver10/pdc_service/System/Flavours")
    Observable<PDCFlavourList> queryPdcFlavours(
            @Header("Cookie")               String cookie,
            @Query("PageIndex")             @Nullable Integer pageIndex,
            @Query("PageSize")              @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Flavours/{id}")
    Observable<PDCFlavour> queryPdcFlavours(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id);

    @GET("howell/ver10/pdc_service/System/Events/Records")
    Observable<EventRecordedList> queryPdcEventRecords(
            @Header("Cookie")               String cookie,
            @Query("BeginTime")             @NonNull String beginTime,
            @Query("EndTime")               @NonNull String endTime,
            @Query("ComponentId")           @Nullable String componentId,
            @Query("EventType")             @Nullable String eventType,
            @Query("PageIndex")             @Nullable Integer pageIndex,
            @Query("PageSize")              @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Users")
    Observable<PDCUserList> queryPdcUsers(
            @Header("Cookie")               String cookie,
            @Query("PageIndex")             @Nullable Integer pageIndex,
            @Query("PageSize")              @Nullable Integer pageSize);

    @GET("howell/ver10/pdc_service/System/Users/{id}")
    Observable<PDCUser> queryPdcUsers(
            @Header("Cookie")               String cookie,
            @Path("id")                     String id);

}
