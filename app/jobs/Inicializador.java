package jobs;

import java.util.Date;

import models.Jogo;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Jogo.count() == 0) {
			Jogo castlevâniaSOTN = new Jogo("Castlevânia","muito massa","/public/images/Castlevânia.jpg");
			castlevâniaSOTN.save();
			Jogo detroitBH =  new Jogo("Detroit Become humam","muita musso","/public/images/detroit.jpg");
			detroitBH.save();
			Jogo ZeldaTOF = new Jogo("Zelda: Tears of the Kingdom","ruim, bg3 é melhor", "/public/images/zelda.jpg");
			ZeldaTOF.save();
		}
	}
}