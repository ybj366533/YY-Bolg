package com.yebingji.yybolg.service.impl;

import com.yebingji.yybolg.mapper.ArticleMapper;
import com.yebingji.yybolg.mapper.TagMapper;
import com.yebingji.yybolg.service.TagService;
import com.yebingji.yybolg.vo.ArticleCustom;
import com.yebingji.yybolg.vo.Pager;
import com.yebingji.yybolg.vo.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Do
 * @package com.yebingji.yybolg.service.impl
 * @name TagServiceImpl
 * @date 2017/4/13
 * @time 18:56
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagMapper tagMapper;
    @Override
    public List<ArticleCustom> loadArticleByTag(Pager pager, Integer tagId) {
        return articleMapper.loadArticleByTag(pager,tagId);
    }

    @Override
    public int getTagCount() {
        return tagMapper.getTagCount();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public List<Tag> loadTagList(Pager pager, String tagName) {
        pager.setStart(pager.getStart());
        return tagMapper.loadTagList(pager,tagName);
    }

    @Override
    public void saveTag(Tag tag) {
        tagMapper.saveTag(tag);
    }

    @Override
    public boolean checkExist(Tag tag) {
        int count = tagMapper.checkExist(tag);
        if (count>0){
            return true;
        }
        return false;
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }

    @Override
    public void initPage(Pager pager) {
        int count = tagMapper.initPage(pager);
        pager.setTotalCount(count);
    }

    @Override
    public List<Tag> getTagList() {
        return tagMapper.getTagList();
    }



    /**
     * 初始化tag -> article的分页
     * @param pager
     */
    @Override
    public void ArticleTagPage(Pager pager, int tagId) {
        int count =  tagMapper.articleTagPage(tagId);
        pager.setTotalCount(count);
    }

    @Override
    public void deleteTagById(int id) {
        tagMapper.deleteTagById(id);
        tagMapper.deleteArticleTagById(id);
    }
}
