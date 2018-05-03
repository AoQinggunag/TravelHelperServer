package com.xiaomo.travelhelper.service;

import com.xiaomo.travelhelper.commons.ResultMessage;
import com.xiaomo.travelhelper.pojo.Share;

/**
 * 分享服务类接口
 */
public interface IShareService {

    ResultMessage saveShare(Share share);

    ResultMessage listShares();

    ResultMessage listSharesByPage(Integer pageSize,Integer pageNo);

}
