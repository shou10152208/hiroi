package jp.libroworks.shooters;

import java.awt.geom.Point2D;

import jp.libroworks.GraphicsInfo;
import jp.libroworks.movers.StraightMover;
import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.BulletChara;
import jp.libroworks.supers.Shooter;
import jp.libroworks.supers.Stage;

public class TwinShooter extends Shooter {

	@Override
	public void shoot(GraphicsInfo ginfo, Stage stage, Point2D.Double position) {
		for(int i=0; i<2; i++){
			BulletChara bullet = stage.searchBullet();
			if(bullet == null) return;
			bullet.mover = StraightMover.singleton;
			bullet.position.x =
					position.x -20 + (40 * i);
			bullet.position.y = stage.getEnemy().position.y;
			bullet.vector.x = 0;
			bullet.vector.y = 400;
			bullet.setImage(stage.getBulletImage(Stage1.REDBULLET_E));
			bullet.setVisible(ginfo, true);
		}

	}

	public static TwinShooter singleton = new TwinShooter();

}
