package jobs;

import java.util.Date;


import models.Jogo;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import groovyjarjarpicocli.CommandLine.Help.Ansi.Text;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Jogo.count() == 0) {
			
			Jogo castlevâniaSOTN = new Jogo("Castlevania",
					"Lançado em 1997 para PlayStation, e no ano seguinte para Saturn, Castlevania: Symphony of the Night misturou ação, exploração e RPG em um jogo de aventura 2D quando os jogos em três dimensões pareciam ser o futuro. E foi com técnicas do passado, cercadas de inovação e qualidade, que o game se tornou um clássico dos videogames, sendo lembrado até hoje como um dos melhores jogos eletrônicos já produzidos.",
					"/public/images/Castlevânia.jpg");
			castlevâniaSOTN.save();

			Jogo detroitBH = new Jogo("Detroit Become humam",
					"O jogo se passa em 2036 na cidade de Detroit, que foi revitalizada pela invenção e o uso dos androides no nosso dia a dia. Porém, quando os androides começam a se comportar como se tivessem vida, as coisas começam a fugir do controle. Assuma o papel dos três protagonistas controláveis da história, cada um com suas próprias perspectivas, e enfrente esse novo estilo de vida.",
					"/public/images/detroit.jpg");
			detroitBH.save();

			Jogo ZeldaTOF = new Jogo("Zelda: Tears of the Kingdom",
					"Tears of the Kingdom começa imediatamente após a conclusão dos acontecimentos de Breath of the Wild. Após a derrota de Calamity Ganon, Link liberta Zelda e ambos se aventuram dentro do castelo de Hyrule.\r\n"
					+ "\r\n"
					+ "Lá eles encontram um corpo mumificado que remete ao de Ganondorf e, então, uma energia maligna desperta e separa o herói e a princesa. Nesse momento, o castelo de Hyrule se desprende do continente, o que será o primeiro de muitos pedaços do mapa que ficarão suspensos no ar.\r\n"
					+ "\r\n"
					+ "Caberá a Link reencontrar Zelda e impedir a nova ameaça, de modo a reparar Hyrule.",
					"/public/images/zelda.jpg");
			ZeldaTOF.save();
			
		}
	}
}