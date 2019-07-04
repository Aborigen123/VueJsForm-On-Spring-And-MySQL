package project.with.add.data.Controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import project.with.add.data.entity.FormEntity;
import project.with.add.data.service.FormEntityService;


@Controller
public class BaseController {
	
	@Autowired private FormEntityService formEntityService;

	@GetMapping({"/", "/home"})
	public String home(Model model) {
		model.addAttribute("formEntity",new FormEntity());
		return "home";
	}
	
	@GetMapping("/all")
	public String all(){
		
		return "all";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute("formEntity")  FormEntity formEntity,
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "home";
		}
		
		formEntityService.saveFormEntity(formEntity);
		
		
		return"redirect:/";
	}
	
	@GetMapping("/f")
	public String football() {
		
		return "football";
	}
	
	
	
	@GetMapping("/f2")
	public String football1() {
		
		return "foottest";
	}
	
	@GetMapping("/t")
	public String test() {
		
		return "test";
	}
}
