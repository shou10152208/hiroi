package jp.libroworks.shooters;

import java.awt.geom.Point2D;

import jp.libroworks.GraphicsInfo;
import jp.libroworks.movers.StraightMover;
import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.BulletChara;
import jp.libroworks.supers.Shooter;
import jp.libroworks.supers.Stage;

public class SplatterShooter extends Shooter {

	@Override
	public void shoot(GraphicsInfo ginfo, Stage stage, Point2D.Double position) {
		double r = (Math.random() * 60 - 30.0)  / 180.0 * Math.PI;
		BulletChara bullet = stage.searchBullet();
		if(bullet == null) return;
		bullet.mover = StraightMover.singleton;
		bullet.position.x = position.x;
		bullet.position.y = position.y;
		bullet.vector.x = 0.0;
		bullet.vector.y = 120.0;
		bullet.vector.rotateVector(r);
		bullet.setImage(stage.getBulletImage(Stage1.BLUEBULLET_E));
		bullet.setVisible(ginfo, true);

	}

	public static SplatterShooter singleton = new SplatterShooter();

}
