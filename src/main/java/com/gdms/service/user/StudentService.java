package com.gdms.service.user;
import com.gdms.model.Student;
import com.gdms.service.common.BaseService;
import com.gdms.vo.AdviseStudentVo;
import com.gdms.vo.GStudentVo;
import com.gdms.vo.StudentInfoVo;
import org.apache.ibatis.annotations.Param;

import javax.persistence.Id;
import java.util.List;

public interface StudentService extends BaseService<Student> {
    Integer insertStudent(Student student);

    List<Student> searchStudentListBySid(String sid,Integer page,Integer rows);

    int updateStudent(Student student);

    List<Student> getStudentList(Student student,Integer page,Integer rows);

    Student queryStudentBySid(String sid);

    int queryIdBySid(String sid);

    int updateNewStudent(Integer adviserid,Integer id);

    List<AdviseStudentVo> queryPageAdviseStudent(String tid, Integer page, Integer rows);

    List<AdviseStudentVo> queryAdviseStudent(String tid);

    Integer queryCountAdviseStudent(String tid);

    StudentInfoVo queryStudentInfoVoBySid(String sid);

    List<AdviseStudentVo> queryPageDistributionStudent(Integer did,Integer page, Integer rows);

    List<AdviseStudentVo> queryDistributionStudent(Integer did);

    Integer queryCountDistributionStudent(Integer did);

    List<GStudentVo> queryPageGStudentVo(Student student,Integer page, Integer rows);

    List<GStudentVo> queryGStudentVo(Student student);

    Integer queryCountGStudentVo(Student student);
}
