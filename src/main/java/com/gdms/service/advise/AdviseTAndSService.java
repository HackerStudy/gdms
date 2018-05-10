package com.gdms.service.advise;

import com.gdms.model.Advise;
import com.gdms.model.AdviseTAndS;
import com.gdms.service.common.BaseService;

public interface AdviseTAndSService extends BaseService<AdviseTAndS> {
    int updateAdviseTAndS(AdviseTAndS adviseTAndS);

    int insertAdviseTAndS(AdviseTAndS adviseTAndS);
}
