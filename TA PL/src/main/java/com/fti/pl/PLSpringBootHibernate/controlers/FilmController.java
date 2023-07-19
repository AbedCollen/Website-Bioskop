package com.fti.pl.PLSpringBootHibernate.controlers;

import com.fti.pl.PLSpringBootHibernate.models.Film;
import com.fti.pl.PLSpringBootHibernate.models.JadwalFilm;
import com.fti.pl.PLSpringBootHibernate.models.Studio;
import com.fti.pl.PLSpringBootHibernate.models.Tiket;
import com.fti.pl.PLSpringBootHibernate.repositories.FilmRepository;
import com.fti.pl.PLSpringBootHibernate.repositories.JadwalRepository;
import com.fti.pl.PLSpringBootHibernate.repositories.StudioRepository;
import com.fti.pl.PLSpringBootHibernate.repositories.TiketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "film")
public class FilmController {

    @Autowired
    private FilmRepository _filmRepository;
    @Autowired
    private StudioRepository _studioRepository;
    @Autowired
    private JadwalRepository _jadwalRepository;

    @Autowired
    private TiketRepository _tiketRepository;

    @RequestMapping(path = {"/", "index"})
    public String index(Model model) {
        List<JadwalFilm> jadwalList = _jadwalRepository.findAll();
        model.addAttribute("jadwalList", jadwalList);
        return "film/index";
    }

    //FILM
    @RequestMapping(path = "kelolaFilm")
    public String kelolafilm(Model model) {
        List<Film> filmList = _filmRepository.findAll();
        model.addAttribute("filmList", filmList);
        return "film/kelolaFilm";
    }

    @RequestMapping(path = "addFilm")
    public String addFilm(Model model) {
        Film flm = new Film();
        model.addAttribute("film", flm);
        return "film/formFilm";
    }

    @RequestMapping(path = "doAddFilm", method = RequestMethod.POST)
    public String doAddFilm(Film film){
        film.setStatus("aktif");
        _filmRepository.save(film);
        return "redirect:/film/kelolaFilm";
    }

    @RequestMapping(path = "editFilm")
    public String editFilm(Model model, @RequestParam(name = "idFilm")String idFilm){
        Film flm = _filmRepository.findById(Integer.valueOf(idFilm)).get();
        model.addAttribute("film", flm);
        return "film/formFilm";
    }

    @RequestMapping(path = "aktif")
    public String aktifkan(Model model, @RequestParam(name = "idFilm")String idFilm){
        Film flm = _filmRepository.findById(Integer.valueOf(idFilm)).get();
        flm.setStatus("aktif");
        _filmRepository.save(flm);
        return "redirect:/film/kelolaFilm";
    }

    @RequestMapping(path = "nonaktif")
    public String nonaktifkan(Model model, @RequestParam(name = "idFilm")String idFilm){
        Film flm = _filmRepository.findById(Integer.valueOf(idFilm)).get();
        flm.setStatus("nonaktif");
        _filmRepository.save(flm);
        return "redirect:/film/kelolaFilm";
    }



    //STUDIO
    @RequestMapping(path = "kelolaStudio")
    public String kelolastudio(Model model) {
        List<Studio> studioList = _studioRepository.findAll();
        model.addAttribute( "studioList", studioList);
        return "film/kelolaStudio";
    }

    @RequestMapping(path = "addStudio")
    public String addStudio(Model model) {
        Studio std = new Studio();
        model.addAttribute("studio", std);
        return "film/formStudio";
    }

    @RequestMapping(path = "doAddStudio", method = RequestMethod.POST)
    public String doAddStudio(Studio studio){
        _studioRepository.save(studio);
        return "redirect:/film/kelolaStudio";
    }

    //JADWAL

    @RequestMapping(path = "addJadwal")
    public String addJadwal(Model model) {
        List<Film> filmList = _filmRepository.findByStatus("aktif");
        List<Studio> studioList = _studioRepository.findAll();


        JadwalFilm flm = new JadwalFilm();
        model.addAttribute( "studioList", studioList);
        model.addAttribute("filmList", filmList);
        model.addAttribute("jadwal", flm);
        return "film/jadwalFilm";
    }

    @RequestMapping(path = "doAddJadwal", method = RequestMethod.POST)
    public String doAddJadwal(JadwalFilm jadwal){
        List<JadwalFilm> jdwl = _jadwalRepository.findByTimeAndDate(jadwal.getTime(), jadwal.getDate());
        if (jdwl.isEmpty() ) {
            jadwal.setStatus("aktif");
            _jadwalRepository.save(jadwal);
            return "redirect:/film/";
        }

        else {

            return "film/error";
        }

    }

    @RequestMapping(path = "aktifJdwl")
    public String aktifkanjdwl(Model model, @RequestParam(name = "idJadwal")String idJadwal){
        JadwalFilm jdwl = _jadwalRepository.findById(Integer.valueOf(idJadwal)).get();

        jdwl.setStatus("aktif");
        _jadwalRepository.save(jdwl);
        return "redirect:/film/";
    }

    @RequestMapping(path = "nonaktifJdwl")
    public String nonaktifkanjdwl(Model model, @RequestParam(name = "idJadwal")String idJadwal){
        JadwalFilm jdwl = _jadwalRepository.findById(Integer.valueOf(idJadwal)).get();

        jdwl.setStatus("nonaktif");
        _jadwalRepository.save(jdwl);
        return "redirect:/film/";
    }

    //TIKET

    @RequestMapping(path = "formPembelian")
    public String formPembelian(Model model) {


        List<JadwalFilm> jadwalList = _jadwalRepository.findByStatus("aktif");
        model.addAttribute("jadwalList", jadwalList);
        return "film/formPembelian";
    }
    @RequestMapping(path = "trans")
    public String formPembelian(Model model, @RequestParam(name = "idJadwal")String idJadwal) {
        Tiket tkt = new Tiket();

        tkt.setJadwal(Integer.parseInt(idJadwal));
        model.addAttribute("tiket", tkt);

        return "film/formPembelian2";
    }

    @RequestMapping(path = "doAddTiket", method = RequestMethod.POST)
    public String formPembelian2(Tiket tiket, Model model) {
        JadwalFilm jdwl = _jadwalRepository.findById(Integer.valueOf(tiket.getJadwal())).get();
        Studio std = _studioRepository.findById(Integer.valueOf(jdwl.getStudio())).get();

        if ( tiket.getJumlah_tiket() <= std.getKapasitas() && tiket.getJumlah_tiket() > 1 ) {
            int total = jdwl.getHarga() * tiket.getJumlah_tiket();
            tiket.setTotal(total);
            _tiketRepository.save(tiket);
            model.addAttribute("tiket", tiket);
            model.addAttribute("film", jdwl);
            return "film/formPembelian3";
        }
        else {
            return "film/error";
        }

    }

    @RequestMapping(path = "batal")
    public String batal(@RequestParam(name = "idTiket")String idTiket) {
        _tiketRepository.deleteById(Integer.valueOf(idTiket));
        return "redirect:/film/";
    }

    @RequestMapping(path = "final")
    public String finall () {
        return "redirect:/film/";
    }

}
