package project.with.add.data.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.with.add.data.dto.NameFilter;
import project.with.add.data.entity.FootballEntity;
import project.with.add.data.entity.FormEntity;
import project.with.add.data.repository.FormEntityRepository;
import project.with.add.data.service.FootballService;
import project.with.add.data.service.FormEntityService;

@RestController
@RequestMapping("/api/v1")
public class RestBaseController {
	
	@Autowired private FormEntityService formEntityService;
	@Autowired private FootballService footballService;
	int [] arr;
	
	@GetMapping("/all")
	public List<FormEntity> getCarEntitys(){
		
		return formEntityService.findAll();
	}
	@GetMapping("/all_football")
	public List<FootballEntity> getFootball(){
		
		return footballService.allFootball();
	}
	
	@GetMapping("/delete")
	public ResponseEntity<FormEntity> deleteFormEntity(@RequestParam("formid")String formid){
		int id = Integer.valueOf(formid);
		formEntityService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> createFormEntity(@RequestBody FormEntity formEntity ){ //@RequestBody for string

		formEntityService.saveFormEntity(formEntity);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@GetMapping("/out")
	public ResponseEntity<FormEntity> outFormEntity(@RequestParam ("id") String idString){ //@RequestBody for string
int id = Integer.valueOf(idString);
	FormEntity formEntity =	formEntityService.findFormById(id);
		
		return  new ResponseEntity<>(formEntity,HttpStatus.OK);
	}
	
	@PostMapping("/change")
	public ResponseEntity<FormEntity> changeFormEntity(@RequestBody FormEntity formEntity ){ //@RequestBody for string
		formEntityService.saveFormEntity(formEntity);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/delete_selected")
	public ResponseEntity<Boolean> deleteSelected(@RequestBody int [] arr){
		for(int i = 0; i<arr.length; i++) {
			formEntityService.deleteById(arr[i]);
		}
		return new ResponseEntity<>(true,HttpStatus.OK) ;
	}
	/*@GetMapping("/search")
	public ResponseEntity<FormEntity> search(@PageableDefault Pageable pageable, @RequestParam("name") String name){
		
		Page<FormEntity> page = formEntityService.findByName(pageable, new  NameFilter(name));
		return new ResponseEntity<>(HttpStatus.OK);
	}*/
}
