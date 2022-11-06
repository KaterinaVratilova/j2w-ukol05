package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {

  @GetMapping("/")
  public ModelAndView formular() {
    ModelAndView modelAndView = new ModelAndView("formular");
    modelAndView.addObject("form", new RegistraceForm());
    return modelAndView;
  }

  @PostMapping("/")
  public Object zaregistrovat(@Valid @ModelAttribute("form") RegistraceForm form, BindingResult bindingResult) {

    {
      if (form.getVek() < 9 || form.getVek() > 15) {
        return "/spatny-vek";
      }

      {
        if (bindingResult.hasErrors()) {
          return "/formular";
        }

        return new ModelAndView("/rekapitulace")
        .addObject("formular", form);

      }
    }
  }
}
