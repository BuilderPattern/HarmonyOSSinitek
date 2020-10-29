package com.example.harmonyosfirst;

import ohos.aafwk.ability.Ability;
import ohos.app.Context;
import ohos.security.SystemPermission;

public class PermissionUtil {

    private Context ability;

    private PermissionUtil(Context ability) {
        this.ability = ability;
    }

    private static PermissionUtil permissionUtil;

    public static PermissionUtil getInstance(Context ability) {
        if (permissionUtil == null) {
            permissionUtil = new PermissionUtil(ability);
        }
        return permissionUtil;
    }

    public void requestPermission(String permission, int requestCode) {
        if (ability.canRequestPermission(SystemPermission.DISTRIBUTED_DATASYNC)) {
            ability.requestPermissionsFromUser(new String[]{permission}, requestCode);
        }
    }

    private void requestPermission(String[] permission, int requestCode) {
        if (permission == null) {
            return;
        }
        ability.requestPermissionsFromUser(permission, requestCode);
    }
}
