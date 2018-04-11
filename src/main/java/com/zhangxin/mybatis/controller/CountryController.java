package com.zhangxin.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.service.CountryService;
import com.zhangxin.mybatis.service.MemberService;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:15
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private MemberService memberService;

    private String page_list = "index";

    private String redirect_list = "redirect:list";

    @RequestMapping(value = {"list", "index", "index.html"})
    public ModelAndView getList(Member member,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView(page_list);
        List<Member> memberList=memberService.selectAllMember(member, page, rows);
        result.addObject("pageInfo", new PageInfo<Member>(memberList));
        result.addObject("queryParam", member);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(Member member) {
        ModelAndView result = new ModelAndView();
        if (member.getmId() != null) {
        	member = memberService.selectByKey(member.getmId());
        }
        result.addObject("member", member);
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(Member member) {
        ModelAndView result = new ModelAndView(redirect_list);
        if (member.getmId() != null) {
           memberService.updateAll(member);
        } else {
            memberService.save(member);
        }
        return result;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
       memberService.delete(id);
        return redirect_list;
    }

}
