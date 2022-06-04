package jpalearn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class ErrorController {
    @PostMapping("/error")
    @ResponseBody
    public String error(Model model, HttpServletRequest request, @RequestBody String body) {
        log.error("request.getQueryString():{}", request.getQueryString());
        log.error("request.body:{}", body);
        return "error";
    }
    @GetMapping("/error")
    @ResponseBody
    public String getError(Model model, HttpServletRequest request, @RequestBody String body) {
        log.error("request.getQueryString():{}", request.getQueryString());
        log.error("request.body:{}", body);
        return "error";
    }
}
