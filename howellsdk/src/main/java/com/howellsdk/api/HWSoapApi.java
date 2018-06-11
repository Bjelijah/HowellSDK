package com.howellsdk.api;

import com.howellsdk.net.soap.bean.*;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/8/14.
 */

public interface HWSoapApi {

    Observable<AuthenticatedRes> queryAuthenticated(AuthenticatedReq req);

    Observable<Result> updateDeviceAuthenticated(UpdateAuthenticatedReq req);

    Observable<LoginResponse> userLogin(LoginRequest loginRequest);

    Observable<Result> userLogout(LogoutRequest logoutRequest);

    Observable<Result> updateChannelName(UpdateChannelNameReq req);

    Observable<Result> addDevice(AddDeviceReq req);

    Observable<Result> nullifyDevice(NullifyDeviceReq req);

    Observable<Result> ptzControl(PtzControlReq req);

    Observable<Result> lensControl(LensControlReq req);

    Observable<Result> presetControl(PresetControlReq req);

    Observable<CodingParamRes> getCodingParam(CodingParamReq req);

    Observable<Result> setCodingParam(SetCodingParamReq req);

    Observable<Result> reboot(RebootReq req);

    Observable<DevVerRes> queryDevVer(DevVerReq req);

    Observable<Result> upgradeDevVer(UpgradeDevVerReq req);

    Observable<VideoParamRes> getVideoParam(Request req);

    Observable<Result> setVideoParam(VideoParamReq req);

    Observable<OSDParamRes> getOSDParam(Request req);

    Observable<Result> setOSDParam(OSDParamReq req);

    Observable<TimeRes> getTime(GetTimeReq req);

    Observable<Result> setTime(SetTimeReq req);

    Observable<VMDParamRes> getVMDParam(Request req);

    Observable<Result> setVMDParam(VMDParamReq req);

    Observable<PrivacyMaskParamRes> getPrivacyMaskParam(Request req);

    Observable<Result> setPrivacymaskParam(PrivacyMaskParamReq req);

    Observable<VodSearchRes> vodSearch(VodSearchReq req);

    Observable<Result> createAccount(CreateAccountReq req);

    Observable<Result> updateAccount(UpdateAccountReq req);

    Observable<Result> updatePassword(UpdatePasswordReq req);

    Observable<DeviceRes> queryDevice(Request req);

    Observable<AccountRes> getAccount(Request req);

    Observable<PasswordRes> getBackPassword(PasswordReq req);

    Observable<AuxiliaryRes> getAuxiliary(GetAuxiliaryReq req);

    Observable<Result> setAuxiliary(SetAuxiliaryReq req);

    Observable<InviteRes> invite(InviteReq req);

    Observable<Result> bye(ByeReq req);

    Observable<NATServerRes> getNATServer(NATServerReq req);

    Observable<Result> subscribeEmail(SubscribeBaseReq req);

    Observable<Result> subscribeSMS(SubscribeBaseReq req);

    Observable<Result> notifyNATResult(NotifyNATResultReq req);

    Observable<Result> inviteKeepAlive(InviteKeepAliveReq req);

    Observable<PUOnOffLogRes> queryPUOnOffLog(PUOnOffLogReq req);

    Observable<PUEventLogRes> queryPUEventLog(PUEventLogReq req);

    Observable<Result> updateAndroidToken(UpdateAndroidTokenReq req);

    Observable<DeviceStatusRes>queryDeviceStatus(DeviceStatusReq req);

    Observable<Result> addDeviceSharer(DeviceSharerReq req);

    Observable<Result> nullifyDeviceSharer(NullifyDeviceSharerReq req);

    Observable<DeviceSharerRes> queryDeviceSharer(Request req);

    Observable<DeviceSharingSourceRes> queryDeviceSharingSource(Request req);

    Observable<AndroidTokenRes> queryAndroidToken(AndroidTokenReq req);

    Observable<ClientVersionRes> queryClientVersion(ClientVersionReq req);

    Observable<DeviceBondedRes> queryDeviceBonded(Request req);

    Observable<Result> subscribeAndroidPush(SubscribeAndroidPushReq req);

    Observable<PushWorkSheetRes> getPushWorkSheet(Request req);

    Observable<Result> setPushWorkSheet(PushWorkSheetReq req);

    Observable<RecordParamRes> getRecordParam(Request req);

    Observable<Result> setRecordParam(RecordParamReq req);

    Observable<RelayRes> getRelay(Request req);

    Observable<Result> setRelay(RelayReq req);

    Observable<WirelessNetworkRes> getGetWirelessNetworkRes(WirelessNetworkReq req);

    Observable<Result> getDynamicPassword(Request req);

    Observable<DeviceMatchingCodeRes> getDeviceMatchingCode(Request req);

    Observable<GetDeviceMatchingResultRes> getDeviceMatchingResult(GetDeviceMatchingResultReq req);


    Observable<TrustedAuthorityLoginRes> trustedAuthorityLogin(TrustedAuthorityLoginReq req);

    Observable<NoticesRes> queryNoticesRes(NoticesReq req);

    Observable<Result> flaggedNoticeStatusRes(FlaggedNoticeStatusReq req);

    Observable<PictureRes> getGetPictureRes(PictureReq req);

    Observable<GetScheduledTaskRes>  getScheduledTask(Request req);

    Observable<CreateScheduledTaskRes> createScheduledTask(CreateScheduledTaskReq req);

    Observable<Result> setScheduledTask(SetScheduledTaskReq req);

    Observable<Result> deleteScheduledTask(DeleteScheduledTaskReq req);

    Observable<ExtendedParamRes> getExtendedParam(Request req);

    Observable<Result> setExtendedParam(ExtendedParamReq req);

    Observable<Result> uploadMCUDevice(UploadMCUDeviceReq req);

    Observable<MCUDeviceAuthenticatedRes> queryMCUDeviceAuthenticated(MCUDeviceAuthenticatedReq req);

    Observable<Result> addDeviceForcible(AddDeviceForceibleReq req);

    Observable<Result> nullifyDeviceForcible(nullifyDeviceForcibleReq req);

    Observable<VideoBasicRes> getVideoBasic(Request req);

    Observable<Result> setVideoBasic(VideoBasicReq req);

}
