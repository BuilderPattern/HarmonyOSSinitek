package com.example.harmonyosfirst;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.event.notification.NotificationRequest;
import ohos.rpc.IRemoteObject;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.rpc.RemoteObject;

public class ForegroundServiceAbility extends Ability {
    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD001100, "Demo");

    @Override
    public void onStart(Intent intent) {
        HiLog.error(LABEL_LOG, "ForegroundServiceAbility::onStart");
        super.onStart(intent);

        if (intent != null) {
            NotificationRequest request = new NotificationRequest(1005);
            NotificationRequest.NotificationNormalContent content = new NotificationRequest.NotificationNormalContent();
            content.setTitle("HarmonyOS").setText("鸿蒙相关内容");
            NotificationRequest.NotificationContent notificationContent = new NotificationRequest.NotificationContent(content);
            request.setContent(notificationContent);

            // 绑定通知，1005为创建通知时传入的notificationId
            keepBackgroundRunning(1005, request);
        }
    }

    @Override
    public void onBackground() {
        super.onBackground();
        HiLog.info(LABEL_LOG, "ForegroundServiceAbility::onBackground");
    }

    @Override
    public void onStop() {
        super.onStop();
        HiLog.info(LABEL_LOG, "ForegroundServiceAbility::onStop");
    }

    @Override
    public void onCommand(Intent intent, boolean restart, int startId) {
        if (intent != null) {
            NotificationRequest request = new NotificationRequest(1005);
            NotificationRequest.NotificationNormalContent content = new NotificationRequest.NotificationNormalContent();
            content.setTitle("HarmonyOS").setText("鸿蒙相关内容");
            NotificationRequest.NotificationContent notificationContent = new NotificationRequest.NotificationContent(content);
            request.setContent(notificationContent);

            // 绑定通知，1005为创建通知时传入的notificationId
            keepBackgroundRunning(1005, request);
        }
    }

    @Override
    public IRemoteObject onConnect(Intent intent) {
        return new RemoteObject("HarmonyOSForegroundService");
    }

    @Override
    public void onDisconnect(Intent intent) {
    }
}