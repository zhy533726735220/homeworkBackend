package com.zhy.service;

import com.zhy.vo.HomeworkType;

import java.util.List;

public interface IHomeworkTypeService {
    /**
     * 添加报课类型
     * @return
     */
    public boolean doCreateHomeworkType(HomeworkType vos);

    /**
     * 查看报课类型
     * @param vo
     * @return
     */
    public List<HomeworkType> selectHomeworkType(HomeworkType vo);

    /**
     * 根据报课类型的typeId查询报课所有类型下的所有用户
     *
     * @param typeId
     * @return
     */
    public HomeworkType findHomeworkTypeDetailsBytypeId(String typeId);

    /**
     * 通过报课的类型查看类型的id值
     * @param typeContent
     * @return
     */
    public HomeworkType findTypeContentBytypeId(String typeContent);
}
