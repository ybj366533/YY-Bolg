package com.yebingji.yybolg.service;

import com.yebingji.yybolg.vo.ArticleCustom;
import com.yebingji.yybolg.vo.Pager;
import com.yebingji.yybolg.vo.Tag;

import java.util.List;

/**
 * @author Do
 * @package com.yebingji.yybolg.service
 * @name TagService
 * @date 2017/4/13
 * @time 18:55
 */
public interface TagService {
    /**
     * 获取当前tag下的文章列表
     * @param pager
     * @param tagId
     * @return
     */
    List<ArticleCustom> loadArticleByTag(Pager pager, Integer tagId);

    int getTagCount();

    Tag getTagById(Integer id);

    List<Tag> loadTagList(Pager pager, String tagName);

    void saveTag(Tag tag);

    boolean checkExist(Tag tag);

    void updateTag(Tag tag);

    void initPage(Pager pager);

    List<Tag> getTagList();

    /**
     * 初始化分页
     * @param pager
     * @param tagId
     */
    void ArticleTagPage(Pager pager, int tagId);

    /**
     * 根据id删除标签
     * @param id
     */
    void deleteTagById(int id);
}
