package jp.libroworks.shooters;

import java.awt.geom.Point2D;

import jp.libroworks.GraphicsInfo;
import jp.libroworks.movers.StraightMover;
import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.BulletChara;
import jp.libroworks.supers.Shooter;
import jp.libroworks.supers.Stage;
import jp.libroworks.supers.Vector2D;

public class TargetShooter extends Shooter {

	private Vector2D v = new Vector2D();

	@Override
	public void shoot(GraphicsInfo ginfo, Stage stage, Point2D.Double position) {
		BulletChara bullet = stage.searchBullet();
		if(bullet == null) return;
		bullet.mover = StraightMover.singleton;
		bullet.position.x = position.x;
		bullet.position.y = position.y;
		bullet.vector.x = stage.getPlayer().position.x;
		bullet.vector.y = stage.getPlayer().position.y;
		v.x = bullet.position.x;
		v.y = bullet.position.y;
		bullet.vector.subVector(v);
		bullet.vector.normalize();
		bullet.vector.x *= 500;
		bullet.vector.y *= 500;
		double r = bullet.vector.angle();
		bullet.angle = r / Math.PI * 180.0;
		bullet.setImage(stage.getBulletImage(Stage1.REDBULLET_E));
		bullet.setVisible(ginfo, true);
	}

	public static TargetShooter singleton = new TargetShooter();
}
