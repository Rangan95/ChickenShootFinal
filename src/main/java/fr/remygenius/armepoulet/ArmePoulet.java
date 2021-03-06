package fr.remygenius.armepoulet;

import org.eclipse.jetty.server.Server;

import fr.lordkadoc.launcher.ServerInstance;
import fr.remygenius.arme.Arme;
import fr.remygenius.thread.ThreadRecharge;

/**
 * Classe qui définit les attributs qu'a une arme de poulet
 * @author remy
 *
 */

public class ArmePoulet extends Arme{
	private int tempsSurCarte;
	private int rayonExplosion;
	
	private ServerInstance instance;

	public ArmePoulet(ServerInstance instance,String nom, int degat, int tempsDeRecharge, int munitions, int tempsSurCarte, int rayonExplosion) {
		super(nom, degat, tempsDeRecharge, munitions);
		this.tempsSurCarte = tempsSurCarte;
		this.rayonExplosion = rayonExplosion;
		this.instance = instance;
	}

	public int getRayonExplosion() {
		return rayonExplosion;
	}

	public void setRayonExplosion(int rayonExplosion) {
		this.rayonExplosion = rayonExplosion;
	}

	public int getTempsSurCarte() {
		return tempsSurCarte;
	}

	public void setTempsSurCarte(int tempsSurCarte) {
		this.tempsSurCarte = tempsSurCarte;
	}

	@Override
	public void tirer(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void poser(int x, int y) {
		// TODO Auto-generated method stub
		this.setMunitions(this.getMunitions()-1);
		instance.getCarte().ajouterBombe(new Bombe(x, y, this.getDegat(), this.getTempsSurCarte(), this.rayonExplosion));
		new ThreadRecharge(this.getTempsDeRecharge(), this).start();
	}

}
