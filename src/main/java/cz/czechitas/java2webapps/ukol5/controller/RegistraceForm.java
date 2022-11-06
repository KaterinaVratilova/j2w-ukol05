package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

// Zde jsou údaje, které se zadávají ve formuláři
// Zde nastavím validace
public class RegistraceForm {

 @Size(min = 2, max = 200)
 @NotBlank
  private String jmenoUcastnika;
 @Size(min = 2, max = 300)
 @NotBlank
 private String prijmeniUcastnika;

 //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) - funguje, ale datum se musí zadat ve formátu YYYY-MM-DD
 //@NotNull - nefunguje (???)
 @DateTimeFormat(pattern = "d.M.yyyy")
 private LocalDate datumNarozeni;
 @NotNull
 private String pohlavi;
 @NotBlank
 private String turnus;
 @Email
 private String email;
  private String telefon;

  public String getJmenoUcastnika() {
    return jmenoUcastnika;
  }

  public void setJmenoUcastnika(String jmenoUcastnika) {
    this.jmenoUcastnika = jmenoUcastnika;
  }

  public String getPrijmeniUcastnika() {
    return prijmeniUcastnika;
  }

  public void setPrijmeniUcastnika(String prijmeniUcastnika) {
    this.prijmeniUcastnika = prijmeniUcastnika;
  }

  public LocalDate getDatumNarozeni() {
    return datumNarozeni;
  }

  public void setDatumNarozeni(LocalDate datumNarozeni) {
    this.datumNarozeni = datumNarozeni;
  }

  public String getPohlavi() {
    return pohlavi;
  }

  public void setPohlavi(String pohlavi) {
    this.pohlavi = pohlavi;
  }

  public String getTurnus() {
    return turnus;
  }

  public void setTurnus(String turnus) {
    this.turnus = turnus;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefon() {
    return telefon;
  }

  public void setTelefon(String telefon) {
    this.telefon = telefon;
  }

  public int getVek(){
    Period period = datumNarozeni.until(LocalDate.now());
    int vek = period.getYears();
    return period.getYears();
  }
}


