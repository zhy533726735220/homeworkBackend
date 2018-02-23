package com.zhy.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 请求的URI
        String uri = httpServletRequest.getRequestURI();


        // uri中包含back时才过滤
        if (uri.indexOf("back/news") != -1) {
            Object obj = httpServletRequest.getSession().getAttribute("username");
            System.out.println("Filter:" + obj);
            if (null == obj) {
                // 如果session中不存在登录者实体，则弹出框提示重新登录
                // 设置request和response的字符集，防止乱码
                httpServletRequest.setCharacterEncoding("UTF-8");
                httpServletResponse.setCharacterEncoding("UTF-8");
                PrintWriter out = httpServletResponse.getWriter();
                String loginPage = "....";
                StringBuilder builder = new StringBuilder();
                builder.append("<script type=\"text/javascript\">");
                builder.append("alert('hahahah');");
                builder.append("window.top.location.href='");
                builder.append(loginPage);
                builder.append("';");
                builder.append("</script>");
                out.print(builder.toString());

            }else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        }else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }
}
