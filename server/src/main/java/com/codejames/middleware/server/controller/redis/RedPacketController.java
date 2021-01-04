package com.codejames.middleware.server.controller.redis;


import com.codejames.middleware.api.enums.StatusCode;
import com.codejames.middleware.api.response.BaseResponse;
import com.codejames.middleware.server.dto.RedPacketDto;
import com.codejames.middleware.server.service.IRedPacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedPacketController {
    public static final Logger log = LoggerFactory.getLogger(RedPacketController.class);

    public static final String prefix = "red/packet";

    @Autowired
    private IRedPacketService redPacketService;

    @RequestMapping(value = prefix+"/hand/out",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse handout(@Validated @RequestBody RedPacketDto dto , BindingResult result){
        if (result.hasErrors()) return new BaseResponse(StatusCode.InvalidParams);

        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            //核心业务逻辑处理服务-最终返回红包全局唯一标识符
            String redId = redPacketService.handOut(dto);

            response.setData(redId);
        }catch (Exception e){
            log.error("发红包发送异常：dto={}",dto,e.fillInStackTrace());
            response = new BaseResponse(StatusCode.Fail.getCode(),e.getMessage());
        }
        return response;
    }
}
