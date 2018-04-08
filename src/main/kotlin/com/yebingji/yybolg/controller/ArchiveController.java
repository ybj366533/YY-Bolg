package com.yebingji.yybolg.controller;

import com.yebingji.yybolg.service.CategoryService;
import com.yebingji.yybolg.vo.ArticleCustom;
import com.yebingji.yybolg.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章归档的controller
 * FILE: com.yebingji.yybolg.controller.ArchiveController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/5/8
 * TIME: 15:15
 */
@Controller
public class ArchiveController {

    @Resource
    private CategoryService categoryService;

    /**
     * 文章归档列表
     *
     * 2017.5.29 fixed bug 归档的标题错误问题
     * 设置名称出错
     * @param createTime
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/archive/load/{createTime}")
    public String categoryList(@PathVariable String createTime, Pager pager, Model model){
        List<ArticleCustom> articleList = categoryService.loadArticleByArchive(createTime,pager);
        if (articleList != null && !articleList.isEmpty()) {
            model.addAttribute("articleList", articleList);
            model.addAttribute("pager", pager);
            model.addAttribute("createTime", createTime);
        }
        return "blog/part/archiveSummary";
    }
}