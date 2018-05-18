package com.gdms.service.advise;

import com.gdms.model.Advise;
import com.gdms.model.AdviseTeacher;
import com.gdms.service.common.BaseService;

public interface AdviseTeacherService extends BaseService<AdviseTeacher> {
    AdviseTeacher queryAdviseTeacherByTid(String tid);

    int updateAdviseTeacher(AdviseTeacher adviseTeacher);

    int updateAdviseTeacherByTid(AdviseTeacher adviseTeacher);

    int insertAdviseTeacherByTid(AdviseTeacher adviseTeacher);
}
