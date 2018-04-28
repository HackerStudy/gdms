package com.gdms.service.web.impl;

import com.gdms.dao.WebSettingMapper;
import com.gdms.model.WebSetting;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.web.WebSettingService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class WebSettingServiceImpl extends BaseServiceImpl<WebSetting> implements WebSettingService {
    private Logger log = Logger.getLogger(WebSettingServiceImpl.class);

    @Resource
    private WebSettingMapper webSettingMapper;
}
