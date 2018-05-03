package com.xiaomo.travelhelper.service;

import com.xiaomo.travelhelper.commons.ResultMessage;



/**
 * 系统服务类接口
 */
public interface ISysService {

    ResultMessage getSumData();

    ResultMessage getUserData();

    ResultMessage getCommentData();

    ResultMessage getShareData();


}
