package com.codejames.middleware.server.util;

import org.springframework.data.redis.core.ListOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacketUtil {

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum){
        //cache small redpacket
        List<Integer> amountList = new ArrayList<>();
        if (totalAmount > 0 && totalPeopleNum >0){
            Integer restAmount = totalAmount;

            Integer restPeopleNum = totalPeopleNum;

            Random random = new Random();

            for (int i=0;i<totalPeopleNum-1;i++){
                int amount = random.nextInt(restAmount / restPeopleNum*2-1) + 1;
                restAmount = restAmount - amount;
                restPeopleNum--;
                amountList.add(amount);
            }
            amountList.add(restAmount);
        }
        return amountList;
    }
}
