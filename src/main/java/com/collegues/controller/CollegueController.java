/**
 * 
 */
package com.collegues.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collegues.entity.Collegue;
import com.collegues.model.ActionIhm;
import com.collegues.model.Avis;
import com.collegues.repository.CollegueRepository;

/**
 * @author Axel B.
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository collegueR;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueR.findAll();
	}

	@RequestMapping(value = "/{pseudo}", method = RequestMethod.PATCH)
	public Collegue modifNote(@PathVariable String pseudo, @RequestBody ActionIhm action) {
		Collegue c1 = new Collegue();
		if (collegueR.existsByPseudo(pseudo)) {
			c1 = collegueR.findCollegueByPseudo(pseudo);

			if (action.getAction().equals(Avis.AIMER) && c1.getNote() < 1000) {
				Integer note = c1.getNote();
				c1.setNote(note += 10);
			}
			if (action.getAction().equals(Avis.DETESTER) && c1.getNote() > -1000) {
				Integer note = c1.getNote();
				c1.setNote(note -= 5);
			}
			this.collegueR.save(c1);

		}
		return c1;
	}

	@RequestMapping(value = "/{pseudo}", method = RequestMethod.GET)
	public Collegue find(@PathVariable String pseudo) {
		return collegueR.findCollegueByPseudo(pseudo);
	}

}
