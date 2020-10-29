package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.MainAbility;
import com.example.harmonyosfirst.PermissionUtil;
import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.IAbilityConnection;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.*;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;
import ohos.bundle.ElementName;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import ohos.rpc.IRemoteObject;

import java.util.Random;

public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {

    private DirectionalLayout myLayout = new DirectionalLayout(this);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        LayoutConfig config = new LayoutConfig(LayoutConfig.MATCH_PARENT, LayoutConfig.MATCH_PARENT);
//        myLayout.setLayoutConfig(config);
//        ShapeElement element = new ShapeElement();
//        element.setRgbColor(new RgbColor(255, 255, 255));
//        myLayout.setBackground(element);
//
//        Text text = new Text(this);
//        text.setLayoutConfig(config);
//        text.setText("Hello World");
//        text.setTextColor(new Color(0xFF000000));
//        text.setTextSize(50);
//        text.setTextAlignment(TextAlignment.CENTER);
//        myLayout.addComponent(text);
//        super.setUIContent(myLayout);
        super.setUIContent(ResourceTable.Layout_ability_main);

        Text titleText = (Text) findComponentById(ResourceTable.Id_main_title_text);
        titleText.setClickedListener(this);

        Image image1 = (Image) findComponentById(ResourceTable.Id_main_gallery_sync);
        image1.setClickedListener(this);

        Image image2 = (Image) findComponentById(ResourceTable.Id_main_gallery_more);
        image2.setClickedListener(this);

        Text forGSvcTv = (Text) findComponentById(ResourceTable.Id_main_title_foreground_text);
        forGSvcTv.setClickedListener(this);

        Text visitText = (Text) findComponentById(ResourceTable.Id_main_title_data_base_db_visit_text);
        visitText.setClickedListener(this);

        Text createText = (Text) findComponentById(ResourceTable.Id_main_title_data_base_db_create_text);
        createText.setClickedListener(this);
    }

    private IAbilityConnection connection = new IAbilityConnection() {
        @Override
        public void onAbilityConnectDone(ElementName elementName, IRemoteObject iRemoteObject, int i) {
            String interfaceDescriptor = iRemoteObject.getInterfaceDescriptor();
            HiLog.error(new HiLogLabel(3, 0xD001101, "Connect"), "onAbilityConnectDone");
        }

        @Override
        public void onAbilityDisconnectDone(ElementName elementName, int i) {
            HiLog.error(new HiLogLabel(3, 0xD001101, "Connect"), "onAbilityDisconnectDone");
        }
    };

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    public void onClick(Component component) {
        Intent intent = null;
        Operation operation;
        switch (component.getId()) {
            case ResourceTable.Id_main_title_text://页面跳转
                intent = new Intent();
                operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withFlags(0)
                        .withBundleName("com.example.harmonyosfirst")
                        .withAbilityName("com.example.harmonyosfirst.PageAbility")
                        .build();
                intent.setOperation(operation);
                startAbility(intent);
                break;
            case ResourceTable.Id_main_gallery_sync://启动服务
                intent = new Intent();
                operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withFlags(2)
                        .withBundleName("com.example.harmonyosfirst")
                        .withAbilityName("com.example.harmonyosfirst.ServiceAbility")
//                            .withFlags(Intent.FLAG_ABILITYSLICE_MULTI_DEVICE) // 设置支持分布式调度系统多设备启动的标识（启动远程service）
                        .build();
                intent.setOperation(operation);
//                    startAbility(intent);
                connectAbility(intent, connection);
                break;
            case ResourceTable.Id_main_gallery_more://关闭服务
//                intent = new Intent();//顺序不可变
//                operation = new Intent.OperationBuilder()
//                        .withDeviceId("")
//                        .withFlags(2)
//                        .withBundleName("com.example.harmonyosfirst")
//                        .withAbilityName("com.example.harmonyosfirst.ServiceAbility")
////                            .withFlags(Intent.FLAG_ABILITYSLICE_MULTI_DEVICE) // 设置支持分布式调度系统多设备启动的标识（启动远程service）
//                        .build();
//                intent.setOperation(operation);
//                stopAbility(intent);
                disconnectAbility(connection);
                break;
            case ResourceTable.Id_main_title_foreground_text://启动前台服务
                PermissionUtil.getInstance(component.getContext()).requestPermission("ohos.permission.KEEP_BACKGROUND_RUNNING", 0x1002);
                break;
            case ResourceTable.Id_main_title_data_base_db_visit_text:
                intent = new Intent();
                operation = new Intent.OperationBuilder()
                        .withDeviceId("")
                        .withFlags(0)
                        .withBundleName("com.example.harmonyosfirst")
                        .withAbilityName("com.example.harmonyosfirst.OperateVisitDataAbility")
                        .build();
                intent.setOperation(operation);
                startAbility(intent);
                break;
            case ResourceTable.Id_main_title_data_base_db_create_text:

                break;
            default:
                break;
        }
    }
}
