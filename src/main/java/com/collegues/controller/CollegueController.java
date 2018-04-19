/**
 * 
 */
package com.collegues.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/collegues")
public class CollegueController {

	@Autowired
	private CollegueRepository collegueR;

	@GetMapping
	public List<Collegue> listerCollegues() {
		return this.collegueR.findAll();
	}

	@RequestMapping(value = "/{nom}", method = RequestMethod.PATCH)
	public void modifNote(@PathVariable String nom, @RequestBody ActionIhm action) {
		if (collegueR.existsByNom(nom)) {
			Collegue c1 = collegueR.findCollegueByNom(nom);

			if (action.getAction().equals(Avis.AIMER)) {
				Integer note = c1.getNote();
				c1.setNote(note += 10);
			}
			if (action.getAction().equals(Avis.DETESTER)) {
				Integer note = c1.getNote();
				c1.setNote(note -= 10);
			}
			this.collegueR.save(c1);

		}
	}
}
