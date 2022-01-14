package org.springframework.samples.petclinic.recoveryroom;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	private static final String VIEWS_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	//private static final String WELCOME = "welcome";
	
	@Autowired
	private RecoveryRoomService recoveryRoomService;
	
	@GetMapping(value="/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		
		return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("recoveryRoom", recoveryRoom);
			return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.recoveryRoomService.save(recoveryRoom);
			model.addAttribute("message", "Room succesfully created");
            return "welcome";
		}
	}

}
