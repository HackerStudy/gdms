package com.gdms.controller.score;

import com.gdms.controller.user.AdminController;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/score")
public class ScoreController {
    private Logger log = Logger.getLogger(ScoreController.class);

}
