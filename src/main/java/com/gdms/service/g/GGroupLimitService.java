package com.gdms.service.g;

import com.gdms.model.GGroupLimit;
import com.gdms.service.common.BaseService;
import com.gdms.vo.LimitVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GGroupLimitService  extends BaseService<GGroupLimit> {
    List<LimitVo> getModelByGroupId(Integer groupId);

    GGroupLimit getModelByGroupIdAndLimitId(int adminid, int id);

    GGroupLimit testGroup(HttpServletRequest request, int i);

    void delByGroupId(Integer integer);

    List<GGroupLimit> getListByGroupId(Integer integer);
}
