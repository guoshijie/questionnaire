package net.shinc.controller.questionnaire;

import net.shinc.common.AbstractBaseController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController extends AbstractBaseController {

	private static Logger logger = LoggerFactory.getLogger(NewsController.class);

	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

}
