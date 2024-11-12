package ro.emanuel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class SumController {

	@GetMapping("/sum")
	public String sumPage(Model model) {
		model.addAttribute("s", 40);
		
		return "hello.jsp";
	}
	
	@GetMapping("/sumModel")
	public ModelAndView sumPage() {
		ModelAndView mav = new ModelAndView("sum.jsp");
		
		mav.addObject("s", 50);
		
		return mav;
	}
	
	@RequestMapping(value = "/sumMapping")
	public String sumPageMapping() {
		return "hello.jsp";
	}

}
