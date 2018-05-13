package com.gdms.service.user;

import com.gdms.model.Major;
import com.gdms.service.common.BaseService;

import java.util.List;

public interface MajorService extends BaseService<Major> {
    List<Major> queryAllList();

    Major queryMajorByMid(Integer mid);

}
