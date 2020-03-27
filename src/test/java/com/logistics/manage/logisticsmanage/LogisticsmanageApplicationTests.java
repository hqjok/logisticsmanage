package com.logistics.manage.logisticsmanage;

import com.logistics.manage.entity.po.*;
import com.logistics.manage.mapper.*;
import com.logistics.manage.factory.ServiceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class LogisticsmanageApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private CanteenPOMapper canteenPOMapper;

    @Autowired
    private WindowPOMapper windowPOMapper;

    @Autowired
    private MaintainPOMapper maintainPOMapper;

    @Autowired
    private ShopPOMapper shopPOMapper;

    @Autowired
    private SuggestPOMapper suggestPOMapper;

    @Test
    public void testinsert() {
        String[] arr = {"广东无敌餐饮有限公司", "广东快餐餐饮有限公司", "广东龙剑猪脚饭有限公司", "广东超好吃有限公司"};
        String[] arr1 = {"明星饭堂", "三饭", "四饭", "五饭", "华商街", "商业街"};
        String[] arr5 = {"韩式炸鸡", "茶皇饭后", "叫了只炸鸡", "黯然销魂饭", "华莱士", "黄焖鸡米饭", "鼎鼎香",
                "重庆麻辣香锅", "正新鸡排", "重庆鸡公煲", "益禾堂", "贡茶"};
        String[] arr6 = {"厚德B203", "励志C101", "厚德C401", "厚德B403", "厚德A203", "东十一120", "东八502",
                "西十一319", "西十一317", "羽毛球场", "篮球场"};
        String[] arr7 = {"音响没有声音", "多媒体没有画面", "课室椅子磨损", "水龙头漏水", "保险丝烧坏", "需要换锁", "球网坏了"};
        String[] arr8 = {"明星食堂采购一大堆猪肉", "五饭采购一大堆鸡肉", "宿舍采购一批上床下桌，一套500元", "宿舍采购消防器材200套，每套400元",
                "教学楼采购音响5个，单个300元", "教学楼装修采购瓷砖，单个30元", "教学楼采购空调，每个1000元"};
        String[] arr2 = {"周杰伦", "林俊杰", "华晨宇", "周柏豪", "薛之谦", "吴亦凡", "小乔",
        "邓紫棋", "张靓颖", "豆豆", "铁憨憨", "铜憨憨"};
        Integer[] arr3 = {1, 2, 3};
        String[] arr4 = {"男", "女"};

        String[] arr20 = {"宿舍空间太小了", "宿舍楼道经常有异味，希望卫生部可以处理一下", "宿舍能不能不要断网，一断网信号也没有",
                "食堂经常有蟑螂出没", "食堂阿姨的手是真的抖", "明星饭堂一楼饭菜类型太少了", "食堂能扩建吗，太多人了，顶不住",
                "励志楼什么时候能够安装空调啊", "厚德楼机房电脑经常损坏", "篮球场的篮球架希望修一下",
                "情人坡的草坪都被踩平了，求求你们别再去了", "我只是来打个酱油"};


        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            SuggestPO suggestPO = new SuggestPO();
            suggestPO.setCreateTime(new Date(new Date().getTime() - 120000 * random.nextInt(1000)));
            suggestPO.setUsername(arr2[random.nextInt(arr2.length)]);
            int j =random.nextInt(4) + 8;
            suggestPO.setTypeId(j);
            if (j == 8){
                suggestPO.setContent(arr20[random.nextInt(3)]);
            }else if (j == 9){
                suggestPO.setContent(arr20[random.nextInt(4) + 3]);
            }else if (j == 10){
                suggestPO.setContent(arr20[random.nextInt(2) + 7]);
            }else{
                suggestPO.setContent(arr20[random.nextInt(3) + 9]);
            }
            suggestPOMapper.insertSelective(suggestPO);
        }

//        for (int i = 0; i < 45; i++) {
//            ShopPO shopPO = new ShopPO();
//            shopPO.setCreateTime(new Date(new Date().getTime() - 120000 * random.nextInt(1000)));
//            shopPO.setCountPrice(new BigDecimal(random.nextInt(100000) * i).setScale(2));
//            shopPO.setDirectorName(arr2[random.nextInt(arr2.length)]);
//            shopPO.setDirectorTelphone(random.nextInt(99999999));
//            shopPO.setOrderNum(HouseUtils.getOrderNumber());
//            shopPO.setShopTime(new Date(new Date().getTime() - 1200000 * random.nextInt(1000) * i));
//            int j = random.nextInt(3) + 1;
//            shopPO.setTypeId(arr3[j - 1]);
//            if (j == 1) {
//                shopPO.setOrderContent(arr8[random.nextInt(2)]);
//            } else if (j == 2) {
//                shopPO.setOrderContent(arr8[random.nextInt(2) + 2]);
//            } else {
//                shopPO.setOrderContent(arr8[random.nextInt(3) + 4]);
//            }
//            shopPOMapper.insertSelective(shopPO);
//        }

//        for (int i = 0; i < 45; i++) {
//            MaintainPO maintainPO = new MaintainPO();
//            maintainPO.setCreateTime(new Date(new Date().getTime() - 120000 * random.nextInt(1000)));
//            maintainPO.setStatus(0);
//            maintainPO.setSubmitUsername(arr2[random.nextInt(arr2.length)]);
//            maintainPO.setTelphone(Integer.toString(random.nextInt(999999999)));
//            maintainPO.setTypeId(arr3[random.nextInt(arr3.length)]);
//            String address = arr6[random.nextInt(arr6.length)];
//            if (address.startsWith("厚德") || address.startsWith("励志")) {
//                maintainPO.setAddress(address);
//                maintainPO.setDescription(arr7[random.nextInt(3)]);
//            }
//            if (address.startsWith("东") || address.startsWith("西")) {
//                maintainPO.setAddress(address);
//                maintainPO.setDescription(arr7[random.nextInt(3) + 3]);
//            }
//            if (address.endsWith("场")) {
//                maintainPO.setAddress(address);
//                maintainPO.setDescription(arr7[arr7.length - 1]);
//            }
//            maintainPOMapper.insertSelective(maintainPO);
//        }

    }

//    @Autowired
//    private FloorService floorService;

    @Autowired
    private ServiceFactory serviceFactory;

    @Test
    public void testApi(){
//        List<FloorPO> info = floorService.getInfo();

//        ResultApi resultApi = serviceFactory.get("2");
//
//        List info = resultApi.getInfo(pageNumber, searchName);

    }

}
