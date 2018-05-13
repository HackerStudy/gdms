package com.gdms.controller.reply;


import com.gdms.controller.score.ScoreController;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/reply")
public class ReplyController {
    private Logger log = Logger.getLogger(ReplyController.class);
}
