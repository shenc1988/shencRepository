package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializationDropDownView();
    }

    // 初始化下拉框
    private void InitializationDropDownView() {

        // 创建一个数组适配器
        ArrayAdapter<String> adapterPlayerKind = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"-", "玩家", "AI"});
        ArrayAdapter<String> adapterPlayerCamp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"1", "2", "3", "4"});// 添加player注意
        ArrayAdapter<String> adapterPlayerCountry = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"随机", "国家1", "国家2"});// 添加country注意
        // 设置下拉列表框的下拉选项样式
        adapterPlayerKind.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPlayerCamp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterPlayerCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 添加player注意
        // 玩家1
        Spinner spinnerPlayerKind1 = findViewById(R.id.spinner_playerKind1);
        InitializationDropDownView_PlayerKind(spinnerPlayerKind1, adapterPlayerKind, 1);
        spinnerPlayerKind1.setVisibility(View.VISIBLE);
        Spinner spinnerPlayerCamp1 = findViewById(R.id.spinner_playerCamp1);
        InitializationDropDownView_PlayerCamp(spinnerPlayerCamp1, adapterPlayerCamp, 1);
        spinnerPlayerCamp1.setVisibility(View.INVISIBLE);
        Spinner spinnerPlayerCountry1 = findViewById(R.id.spinner_playerCountry1);
        InitializationDropDownView_PlayerCountry(spinnerPlayerCountry1, adapterPlayerCountry, 1);
        spinnerPlayerCountry1.setVisibility(View.INVISIBLE);

        // 玩家2
        Spinner spinnerPlayerKind2 = findViewById(R.id.spinner_playerKind2);
        InitializationDropDownView_PlayerKind(spinnerPlayerKind2, adapterPlayerKind, 2);
        spinnerPlayerKind2.setVisibility(View.VISIBLE);
        Spinner spinnerPlayerCamp2 = findViewById(R.id.spinner_playerCamp2);
        InitializationDropDownView_PlayerCamp(spinnerPlayerCamp2, adapterPlayerCamp, 2);
        spinnerPlayerCamp2.setVisibility(View.INVISIBLE);
        Spinner spinnerPlayerCountry2 = findViewById(R.id.spinner_playerCountry2);
        InitializationDropDownView_PlayerCountry(spinnerPlayerCountry2, adapterPlayerCountry, 2);
        spinnerPlayerCountry2.setVisibility(View.INVISIBLE);

        // 玩家3
        Spinner spinnerPlayerKind3 = findViewById(R.id.spinner_playerKind3);
        InitializationDropDownView_PlayerKind(spinnerPlayerKind3, adapterPlayerKind, 3);
        spinnerPlayerKind3.setVisibility(View.VISIBLE);
        Spinner spinnerPlayerCamp3 = findViewById(R.id.spinner_playerCamp3);
        InitializationDropDownView_PlayerCamp(spinnerPlayerCamp3, adapterPlayerCamp, 3);
        spinnerPlayerCamp3.setVisibility(View.INVISIBLE);
        Spinner spinnerPlayerCountry3 = findViewById(R.id.spinner_playerCountry3);
        InitializationDropDownView_PlayerCountry(spinnerPlayerCountry3, adapterPlayerCountry, 3);
        spinnerPlayerCountry3.setVisibility(View.INVISIBLE);

        // 玩家4
        Spinner spinnerPlayerKind4 = findViewById(R.id.spinner_playerKind4);
        InitializationDropDownView_PlayerKind(spinnerPlayerKind4, adapterPlayerKind, 4);
        spinnerPlayerKind4.setVisibility(View.VISIBLE);
        Spinner spinnerPlayerCamp4 = findViewById(R.id.spinner_playerCamp4);
        InitializationDropDownView_PlayerCamp(spinnerPlayerCamp4, adapterPlayerCamp, 4);
        spinnerPlayerCamp4.setVisibility(View.INVISIBLE);
        Spinner spinnerPlayerCountry4 = findViewById(R.id.spinner_playerCountry4);
        InitializationDropDownView_PlayerCountry(spinnerPlayerCountry4, adapterPlayerCountry, 4);
        spinnerPlayerCountry4.setVisibility(View.INVISIBLE);
    }

    // 初始化下拉框（PlayerKind）
    private void InitializationDropDownView_PlayerKind(Spinner spinnerPlayerKind, final ArrayAdapter<String> adapterPlayerKind, final int i) {

        spinnerPlayerKind.setAdapter(adapterPlayerKind);
        // 条目点击事件
        spinnerPlayerKind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private String positions;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positions = adapterPlayerKind.getItem(position);
                if (positions.equals("-")){
                    // 添加player注意
                    if (i == 1){
                        Spinner spinnerPlayerCamp1 = findViewById(R.id.spinner_playerCamp1);
                        spinnerPlayerCamp1.setVisibility(View.INVISIBLE);
                        Spinner spinnerPlayerCountry1 = findViewById(R.id.spinner_playerCountry1);
                        spinnerPlayerCountry1.setVisibility(View.INVISIBLE);
                    }else if (i == 2){
                        Spinner spinnerPlayerCamp2 = findViewById(R.id.spinner_playerCamp2);
                        spinnerPlayerCamp2.setVisibility(View.INVISIBLE);
                        Spinner spinnerPlayerCountry2 = findViewById(R.id.spinner_playerCountry2);
                        spinnerPlayerCountry2.setVisibility(View.INVISIBLE);
                    }else if (i == 3){
                        Spinner spinnerPlayerCamp3 = findViewById(R.id.spinner_playerCamp3);
                        spinnerPlayerCamp3.setVisibility(View.INVISIBLE);
                        Spinner spinnerPlayerCountry3 = findViewById(R.id.spinner_playerCountry3);
                        spinnerPlayerCountry3.setVisibility(View.INVISIBLE);
                    }else if (i == 4){
                        Spinner spinnerPlayerCamp4 = findViewById(R.id.spinner_playerCamp4);
                        spinnerPlayerCamp4.setVisibility(View.INVISIBLE);
                        Spinner spinnerPlayerCountry4 = findViewById(R.id.spinner_playerCountry4);
                        spinnerPlayerCountry4.setVisibility(View.INVISIBLE);
                    }
                    // TODO
                }else if (positions.equals("玩家")){
                    // 添加player注意
                    if (i == 1){
                        Spinner spinnerPlayerCamp1 = findViewById(R.id.spinner_playerCamp1);
                        spinnerPlayerCamp1.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry1 = findViewById(R.id.spinner_playerCountry1);
                        spinnerPlayerCountry1.setVisibility(View.VISIBLE);
                    }else if (i == 2){
                        Spinner spinnerPlayerCamp2 = findViewById(R.id.spinner_playerCamp2);
                        spinnerPlayerCamp2.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry2 = findViewById(R.id.spinner_playerCountry2);
                        spinnerPlayerCountry2.setVisibility(View.VISIBLE);
                    }else if (i == 3){
                        Spinner spinnerPlayerCamp3 = findViewById(R.id.spinner_playerCamp3);
                        spinnerPlayerCamp3.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry3 = findViewById(R.id.spinner_playerCountry3);
                        spinnerPlayerCountry3.setVisibility(View.VISIBLE);
                    }else if (i == 4){
                        Spinner spinnerPlayerCamp4 = findViewById(R.id.spinner_playerCamp4);
                        spinnerPlayerCamp4.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry4 = findViewById(R.id.spinner_playerCountry4);
                        spinnerPlayerCountry4.setVisibility(View.VISIBLE);
                    }
                    // TODO
                }else if (positions.equals("AI")){
                    // 添加player注意
                    if (i == 1){
                        Spinner spinnerPlayerCamp1 = findViewById(R.id.spinner_playerCamp1);
                        spinnerPlayerCamp1.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry1 = findViewById(R.id.spinner_playerCountry1);
                        spinnerPlayerCountry1.setVisibility(View.VISIBLE);
                    }else if (i == 2){
                        Spinner spinnerPlayerCamp2 = findViewById(R.id.spinner_playerCamp2);
                        spinnerPlayerCamp2.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry2 = findViewById(R.id.spinner_playerCountry2);
                        spinnerPlayerCountry2.setVisibility(View.VISIBLE);
                    }else if (i == 3){
                        Spinner spinnerPlayerCamp3 = findViewById(R.id.spinner_playerCamp3);
                        spinnerPlayerCamp3.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry3 = findViewById(R.id.spinner_playerCountry3);
                        spinnerPlayerCountry3.setVisibility(View.VISIBLE);
                    }else if (i == 4){
                        Spinner spinnerPlayerCamp4 = findViewById(R.id.spinner_playerCamp4);
                        spinnerPlayerCamp4.setVisibility(View.VISIBLE);
                        Spinner spinnerPlayerCountry4 = findViewById(R.id.spinner_playerCountry4);
                        spinnerPlayerCountry4.setVisibility(View.VISIBLE);
                    }
                    // TODO
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
                //parent.setVisibility(View.VISIBLE);
            }
        });
    }

    // 初始化下拉框（PlayerCamp）
    private void InitializationDropDownView_PlayerCamp(Spinner spinnerPlayerCamp, final ArrayAdapter<String> adapterPlayerCamp, int i) {

        spinnerPlayerCamp.setAdapter(adapterPlayerCamp);
        // 条目点击事件
        spinnerPlayerCamp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private String positions;

            // 添加player注意
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positions = adapterPlayerCamp.getItem(position);
                if (positions.equals("1")){
                    // TODO
                }else if (positions.equals("2")){
                    // TODO
                }else if (positions.equals("3")){
                    // TODO
                }else if (positions.equals("4")){
                    // TODO
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
                //parent.setVisibility(View.INVISIBLE);
            }
        });
    }

    // 初始化下拉框（PlayerCountry）
    private void InitializationDropDownView_PlayerCountry(Spinner spinnerPlayerCountry, final ArrayAdapter<String> adapterPlayerCountry, int i) {

        spinnerPlayerCountry.setAdapter(adapterPlayerCountry);
        // 条目点击事件
        spinnerPlayerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            private String positions;

            // 添加country注意
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                positions = adapterPlayerCountry.getItem(position);
                if (positions.equals("随机")){
                    // TODO
                }else if (positions.equals("国家1")){
                    // TODO
                }else if (positions.equals("国家2")){
                    // TODO
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO
                //parent.setVisibility(View.INVISIBLE);
            }
        });
    }

    // [标准]按钮事件
    public void Button_standard_onClick(View view){
        LinearLayout layoutStandard = (LinearLayout)findViewById(R.id.layout_standard);
        layoutStandard.setVisibility(View.VISIBLE);
    }

    // [模式2]按钮事件
    public void Button_model2_onClick(View view){
        LinearLayout layoutStandard = (LinearLayout)findViewById(R.id.layout_standard);
        layoutStandard.setVisibility(View.INVISIBLE);
    }

    // [开始]按钮事件
    public void Button_start_onClick(View view){
        // 画面跳转
        Intent intent = new Intent(this, SceneActivity.class);
        startActivity(intent);
    }
}
