package com.example.harmonyosfirst.slice;

import com.example.harmonyosfirst.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.components.Text;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

import java.util.Random;

public class MainAbilitySlice extends AbilitySlice {

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

        Text button = (Text) findComponentById(ResourceTable.Id_main_title_text);
        if (button != null) {
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    int position = new Random().nextInt(10);
                    Intent intent = new Intent();//顺序不可变
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withFlags(position%3)
                            .withBundleName("com.example.harmonyosfirst")
                            .withAbilityName("com.example.harmonyosfirst.PageAbility")
                            .build();
                    intent.setOperation(operation);
                    startAbility(intent);
                }
            });
        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
