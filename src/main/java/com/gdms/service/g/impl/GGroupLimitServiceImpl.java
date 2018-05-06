package com.gdms.service.g.impl;

import com.gdms.dao.GGroupLimitMapper;
import com.gdms.model.Admin;
import com.gdms.model.GGroupLimit;
import com.gdms.service.common.impl.BaseServiceImpl;
import com.gdms.service.g.GGroupLimitService;
import com.gdms.vo.LimitVo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class GGroupLimitServiceImpl  extends BaseServiceImpl<GGroupLimit> implements GGroupLimitService {
    private Logger log = Logger.getLogger(GGroupLimitServiceImpl.class);

    @Resource
    private GGroupLimitMapper gGroupLimitMapper;

    public List<LimitVo> getModelByGroupId(Integer groupId) {
        return gGroupLimitMapper.getModelByGroupId(groupId);
    }

    public GGroupLimit getModelByGroupIdAndLimitId(int adminid, int id) {
        System.out.println(adminid+"+"+id);
        List<GGroupLimit> gGroupLimits = gGroupLimitMapper.getModelByGroupIdAndLimitId(adminid, id);
        GGroupLimit gGroupLimit = null;
        if(gGroupLimits.size()>0){
            gGroupLimit = gGroupLimits.get(0);
        }

        return gGroupLimit;
    }

    public GGroupLimit testGroup(HttpServletRequest request, int i) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        System.out.println("admin:"+admin.toString());
        List<GGroupLimit> gGroupLimits = gGroupLimitMapper.getModelByGroupIdAndLimitId(admin.getGroupId(), i);
        GGroupLimit gGroupLimit = null;
        if(gGroupLimits.size()>0){
            gGroupLimit = gGroupLimits.get(0);
        }
        return gGroupLimit;
    }

    public void delByGroupId(Integer integer) {
        gGroupLimitMapper.delByGroupId(integer);
    }

    public List<GGroupLimit> getListByGroupId(Integer integer) {
        return gGroupLimitMapper.getListByGroupId(integer);
    }
}
