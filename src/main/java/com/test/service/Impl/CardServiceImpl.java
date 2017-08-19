package com.test.service.Impl;

import com.test.common.ServerResponse;
import com.test.dao.WaterCardMapper;
import com.test.pojo.WaterCard;
import com.test.service.ICardService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@Service("iCardService")
public class CardServiceImpl implements ICardService {

    @Resource
    private WaterCardMapper waterCardMapper;

    public ServerResponse bind(String code, String password, String remark,String userId){
        WaterCard waterCard = waterCardMapper.selectByCodePassowrd(code,password);
        if(waterCard != null){
            if(waterCard.getUserId() != null){
                return ServerResponse.createByErrorMessage("该卡号已被其他用户绑定");
            }
            waterCard.setStatus(2);
            waterCard.setRemark(remark);
            waterCard.setUserId(userId);
            int rowCount = waterCardMapper.updateByPrimaryKey(waterCard);
            if(rowCount > 0){
                return ServerResponse.createBySuccess("绑定卡成功");
            }
            return ServerResponse.createByErrorMessage("绑定卡失败");
        }
        return ServerResponse.createByErrorMessage("该卡号不存在");

    }

    public ServerResponse setDefault(String code,String userId){
        List<WaterCard> cardList = waterCardMapper.selectByUserId(userId);
        if(CollectionUtils.isNotEmpty(cardList)){
            for (WaterCard card : cardList){
                card.setDef(0);
                waterCardMapper.updateByPrimaryKey(card);
            }
        }

        WaterCard card = waterCardMapper.selectByCode(code);
        if(card !=null){
            card.setDef(1);
            int rowCount = waterCardMapper.updateByPrimaryKey(card);
            if(rowCount > 0){
                return ServerResponse.createBySuccessMessage("设为默认成功");
            }
            return ServerResponse.createByErrorMessage("设为默认失败");
        }
        return ServerResponse.createByErrorMessage("该卡号不存在");
    }

    public boolean getCardNo(String cardNo){
        int rowCount = waterCardMapper.selectByCard(cardNo);
        if(rowCount>0){
            return true;
        }
        return false;

    }
}
