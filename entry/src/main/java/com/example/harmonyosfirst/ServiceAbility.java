package com.example.harmonyosfirst;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.window.dialog.ToastDialog;
import ohos.event.notification.NotificationRequest;
import ohos.rpc.IRemoteObject;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.rpc.RemoteObject;

import java.util.logging.Logger;

public class ServiceAbility extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");


    @Override
    public void onStart(Intent intent) {
        HiLog.error(LABEL_LOG, "ServiceAbility::onStart");
        super.onStart(intent);
    }

    @Override
    public void onBackground() {
        super.onBackground();
        HiLog.info(LABEL_LOG, "ServiceAbility::onBackground");
    }

    @Override
    public void onStop() {
        super.onStop();
        HiLog.info(LABEL_LOG, "ServiceAbility::onStop");
    }

    @Override
    public void onCommand(Intent intent, boolean restart, int startId) {
        HiLog.info(LABEL_LOG, "ServiceAbility::onCommand");
    }

    @Override
    public IRemoteObject onConnect(Intent intent) {
        super.onConnect(intent);
        return new RemoteObject("HarmonyOSService");
    }

    @Override
    public void onDisconnect(Intent intent) {
        HiLog.info(LABEL_LOG, "ServiceAbility::onDisconnect");
    }
}