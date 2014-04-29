package jp.libroworks.shooters;

import java.awt.geom.Point2D;

import jp.libroworks.GraphicsInfo;
import jp.libroworks.movers.StraightMover;
import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.BulletChara;
import jp.libroworks.supers.Shooter;
import jp.libroworks.supers.Stage;
import jp.libroworks.supers.Vector2D;

public class WideShooterR extends Shooter {

	private Vector2D v = new Vector2D();

	@Override
	public void shoot(GraphicsInfo ginfo, Stage stage, Point2D.Double position) {
		this.v.x = -240.0;
		this.v.y = 0.0;
		double r = -30.0 / 180.0 * Math.PI;
		this.v.rotateVector(r);
		r = 20.0 / 180.0 * Math.PI;
		for(int i=0; i<4; i++){
			BulletChara bullet = stage.searchBullet();
			if(bullet == null) return;
			bullet.mover = StraightMover.singleton;
			bullet.position.x = position.x;
			bullet.position.y = position.y;
			bullet.vector.x = this.v.x;
			bullet.vector.y = this.v.y;
			bullet.setImage(stage.getBulletImage(Stage1.GREENBULLET_E));
			bullet.setVisible(ginfo, true);
			this.v.rotateVector(r);
		}

	}

	public static WideShooterR singleton = new WideShooterR();

}
