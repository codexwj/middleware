package com.codejames.middleware.server.service.redis;

import com.codejames.middleware.server.dto.RedPacketDto;
import com.codejames.middleware.server.service.IRedPacketService;
import com.codejames.middleware.server.util.RedPacketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RedPacketService implements IRedPacketService {

    public static final Logger log = LoggerFactory.getLogger(RedPacketService.class);

    public static final String keyPrefix="redis:red:packet";

    @Autowired
    RedisTemplate redisTemplate;


    public String handOut(RedPacketDto dto) throws Exception{
        if (dto.getTotal() > 0 && dto.getAmount() > 0){
            List<Integer> list = RedPacketUtil.divideRedPackage(dto.getAmount(),dto.getTotal());

            //生成红包全局唯一标识符
            String timestamp = String.valueOf(System.nanoTime());

            String redId = new StringBuffer(keyPrefix).append(dto.getUserId()).append(":").append(timestamp).toString();

            //将随机金额列表存入缓存List中
            redisTemplate.opsForList().leftPushAll(redId,list);

            String redTotalKey = redId + ":total";

            //red total mounts
            redisTemplate.opsForValue().set(redTotalKey,dto.getTotal());

            return redId;
        }else {
            throw new Exception("系统异常-分发红包-参数不合法！");
        }


    }

    @Override
    public BigDecimal rob(Integer userId, String redId) throws Exception {
        return null;
    }
}
