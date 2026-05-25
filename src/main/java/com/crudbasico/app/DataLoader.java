package com.crudbasico.app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.crudbasico.app.entity.*;
import com.crudbasico.app.repository.*;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClubesRepository clubesRepository;
    private final JugadoresRepository jugadoresRepository;
    private final EntrenadoresRepository entrenadoresRepository;
    private final AsociacionesRepository asociacionesRepository;
    private final CompeticionesRepository competicionesRepository;

    public DataLoader(
            ClubesRepository clubesRepository,
            JugadoresRepository jugadoresRepository,
            EntrenadoresRepository entrenadoresRepository,
            AsociacionesRepository asociacionesRepository,
            CompeticionesRepository competicionesRepository) {

        this.clubesRepository = clubesRepository;
        this.jugadoresRepository = jugadoresRepository;
        this.entrenadoresRepository = entrenadoresRepository;
        this.asociacionesRepository = asociacionesRepository;
        this.competicionesRepository = competicionesRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (clubesRepository.count() > 0) {
            return;
        }

        // =========================
        // ENTRENADORES
        // =========================

        Entrenadores pep = new Entrenadores();
        pep.setNombre("Pep Guardiola");
        pep.setNacionalidad("España");

        Entrenadores ancelotti = new Entrenadores();
        ancelotti.setNombre("Carlo Ancelotti");
        ancelotti.setNacionalidad("Italia");

        Entrenadores klopp = new Entrenadores();
        klopp.setNombre("Jurgen Klopp");
        klopp.setNacionalidad("Alemania");

        Entrenadores xavi = new Entrenadores();
        xavi.setNombre("Xavi Hernandez");
        xavi.setNacionalidad("España");

        Entrenadores arteta = new Entrenadores();
        arteta.setNombre("Mikel Arteta");
        arteta.setNacionalidad("España");

        Entrenadores simeone = new Entrenadores();
        simeone.setNombre("Diego Simeone");
        simeone.setNacionalidad("Argentina");

        Entrenadores tenhag = new Entrenadores();
        tenhag.setNombre("Erik Ten Hag");
        tenhag.setNacionalidad("Países Bajos");

        Entrenadores tuchel = new Entrenadores();
        tuchel.setNombre("Thomas Tuchel");
        tuchel.setNacionalidad("Alemania");

        entrenadoresRepository.saveAll(
                Arrays.asList(
                        pep,
                        ancelotti,
                        klopp,
                        xavi,
                        arteta,
                        simeone,
                        tenhag,
                        tuchel));

        // =========================
        // JUGADORES
        // =========================

        Jugadores messi = new Jugadores();
        messi.setNombre("Lionel Messi");
        messi.setPosicion("Delantero");

        Jugadores cristiano = new Jugadores();
        cristiano.setNombre("Cristiano Ronaldo");
        cristiano.setPosicion("Delantero");

        Jugadores mbappe = new Jugadores();
        mbappe.setNombre("Kylian Mbappe");
        mbappe.setPosicion("Delantero");

        Jugadores haaland = new Jugadores();
        haaland.setNombre("Erling Haaland");
        haaland.setPosicion("Delantero");

        Jugadores vinicius = new Jugadores();
        vinicius.setNombre("Vinicius Jr");
        vinicius.setPosicion("Extremo");

        Jugadores pedri = new Jugadores();
        pedri.setNombre("Pedri");
        pedri.setPosicion("Mediocampista");

        Jugadores bellingham = new Jugadores();
        bellingham.setNombre("Jude Bellingham");
        bellingham.setPosicion("Mediocampista");

        Jugadores salah = new Jugadores();
        salah.setNombre("Mohamed Salah");
        salah.setPosicion("Extremo");

        jugadoresRepository.saveAll(
                Arrays.asList(
                        messi,
                        cristiano,
                        mbappe,
                        haaland,
                        vinicius,
                        pedri,
                        bellingham,
                        salah));

        // =========================
        // ASOCIACIONES
        // =========================

        Asociaciones fifa = new Asociaciones();
        fifa.setNombre("FIFA");

        Asociaciones uefa = new Asociaciones();
        uefa.setNombre("UEFA");

        Asociaciones conmebol = new Asociaciones();
        conmebol.setNombre("CONMEBOL");

        asociacionesRepository.saveAll(
                Arrays.asList(
                        fifa,
                        uefa,
                        conmebol));

        // =========================
        // COMPETICIONES
        // =========================

        Competiciones champions = new Competiciones();
        champions.setNombre("Champions League");

        Competiciones premier = new Competiciones();
        premier.setNombre("Premier League");

        Competiciones laliga = new Competiciones();
        laliga.setNombre("La Liga");

        Competiciones seriea = new Competiciones();
        seriea.setNombre("Serie A");

        Competiciones bundesliga = new Competiciones();
        bundesliga.setNombre("Bundesliga");

        Competiciones mundialClubes = new Competiciones();
        mundialClubes.setNombre("Mundial de Clubes");

        competicionesRepository.saveAll(
                Arrays.asList(
                        champions,
                        premier,
                        laliga,
                        seriea,
                        bundesliga,
                        mundialClubes));

        // =========================
        // CLUB 1
        // =========================

        Clubes city = new Clubes();
        city.setNombre("Manchester City");
        city.setEntrenador(pep);
        city.setJugadores(Arrays.asList(
                haaland,
                messi));
        city.setAsociacion(uefa);
        city.setCompeticiones(Arrays.asList(
                champions,
                premier));

        clubesRepository.save(city);

        // =========================
        // CLUB 2
        // =========================

        Clubes madrid = new Clubes();
        madrid.setNombre("Real Madrid");
        madrid.setEntrenador(ancelotti);
        madrid.setJugadores(Arrays.asList(
                mbappe,
                vinicius,
                bellingham));
        madrid.setAsociacion(uefa);
        madrid.setCompeticiones(Arrays.asList(
                champions,
                laliga,
                mundialClubes));

        clubesRepository.save(madrid);

        // =========================
        // CLUB 3
        // =========================

        Clubes liverpool = new Clubes();
        liverpool.setNombre("Liverpool");
        liverpool.setEntrenador(klopp);
        liverpool.setJugadores(Arrays.asList(
                salah,
                cristiano));
        liverpool.setAsociacion(uefa);
        liverpool.setCompeticiones(Arrays.asList(
                premier,
                champions));

        clubesRepository.save(liverpool);

        // =========================
        // CLUB 4
        // =========================

        Clubes barcelona = new Clubes();
        barcelona.setNombre("Barcelona");
        barcelona.setEntrenador(xavi);
        barcelona.setJugadores(Arrays.asList(
                messi,
                pedri));
        barcelona.setAsociacion(uefa);
        barcelona.setCompeticiones(Arrays.asList(
                laliga,
                champions));

        clubesRepository.save(barcelona);

        // =========================
        // CLUB 5
        // =========================

        Clubes arsenal = new Clubes();
        arsenal.setNombre("Arsenal");
        arsenal.setEntrenador(arteta);
        arsenal.setJugadores(Arrays.asList(
                salah,
                haaland));
        arsenal.setAsociacion(uefa);
        arsenal.setCompeticiones(Arrays.asList(
                premier));

        clubesRepository.save(arsenal);
    }
}