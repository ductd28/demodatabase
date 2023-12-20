package com.example.demodatabase.Controller;

import java.util.List;

import com.example.demodatabase.Entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demodatabase.DAO.PersonDAO;
import com.example.demodatabase.Entity.Person;

@Controller
public class home {
	
	@Autowired
    private PersonDAO personRepository;
	
	@RequestMapping("/")
	public String welcome(final Model model) {
		model.addAttribute("message", "hello");
		return "index";
	}

	@RequestMapping("/home/{param}")
	@ResponseBody
	public String hello(@PathVariable("param") String param) {
		return "Hellohi" + param;
	}
	
	@RequestMapping("/list")
    public String personList(Model model) {
        List<Person> persons = personRepository.findAll();
        model.addAttribute("person", persons);
        return "listPerson";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.GET)
    public String addPersonForm(Model model, HttpSession session) {

        User user = (User)session.getAttribute("user");
        if (user == null) return "redirect:/login";
        if (user.getRole() != 0){
            return "redirect:/list";
        }
        model.addAttribute("personForm", new Person());
        return "addPerson";
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("personForm") Person personForm) {
        String name = personForm.getName();
        int age = personForm.getAge();
        double salary = personForm.getSalary();

        if (name != null && !name.isEmpty() && age > 0 && salary >= 0) {
            personRepository.save(personForm);
            return "redirect:/list";
        }

        return "redirect:/addPerson";
    }
}
