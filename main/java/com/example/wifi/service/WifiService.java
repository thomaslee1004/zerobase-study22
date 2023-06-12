package com.example.wifi.service;

import com.example.wifi.dto.WifiInfoDto;
import com.example.wifi.repository.WifiInfoDetailModel;
import com.example.wifi.repository.WifiInfoModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WifiService extends SqliteConnection {

    /**
     * 와이파이 정보를 저장
     */
    public int add() throws SQLException {

        // TODO: Service 로직 시작하기 전에 여기서 검사해야 할 것 같아 똑같이 안돌아도 되니까
        // TODO: SQL로 데이터 아무거나 하나 insert시간 구해서 하면 될듯

        WifiInfoModel wifiInfoModel = new WifiInfoModel();

        // 1. total Count
        Gson gson = new Gson();

        WifiApiComponent wifiApiComponent = new WifiApiComponent();
        JsonObject jsonObject = wifiApiComponent.getWipiInfoList(1, 1);

        JsonObject res = (JsonObject) jsonObject.get("TbPublicWifiInfo");
        int totalCount = res.get("list_total_count").getAsJsonPrimitive().getAsNumber().intValue();

        // 2. 1000개 씩 bulk insert (TODO: 나중에 bulk insert로 바꿔)
        for (int i = 1; i < totalCount; i += 1000) {
            int start = i;
            int end = totalCount < i ? totalCount : i + 999;

            // 2.1) get
            jsonObject = wifiApiComponent.getWipiInfoList(start, end);

            res = (JsonObject) jsonObject.get("TbPublicWifiInfo");

            JsonArray rows = (JsonArray) res.get("row");
            Type listType = new TypeToken<ArrayList<WifiInfoDto>>() {}.getType();

            List<WifiInfoDto> list = gson.fromJson(rows.toString(), listType);

            // 2.2) insert
            for (WifiInfoDto wifiInfoDto : list) {
                wifiInfoModel.save(wifiInfoDto);
            }
        }

        // TODO: ... 형 이렇게 개수만 넘기면 안되고 잘 들어갔는지 확인 해야 하는데 ㅜㅜㅜㅜㅜ 이거 괜찮으면 그냥 주석만 지우면댕
        return totalCount;
    }

    /**
     * 와이파이 정보의 목록을 리턴
     */
    public List<WifiInfoDto> getList(WifiInfoModel parameter) {

        throw new RuntimeException("구현해 주세요.");
    }

    /**
     * 오픈API에서 와이파이 정보를 가져오고,
     * 그 내용을 데이터베이스에 저장하고,
     * 최종적으로 저장한 개수를 리턴
     */
    public int saveWifiInfo() {

        throw new RuntimeException("구현해 주세요.");
    }

    /**
     * 와이파이 상세 정보 리턴
     */
    public WifiInfoDto getDetail(WifiInfoDetailModel parameter) {

        throw new RuntimeException("구현해 주세요.");
    }
}
