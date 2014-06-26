package jp.libroworks;

import java.util.ArrayList;

import javax.sound.sampled.Clip;

import jp.libroworks.movers.StraightMover;
import jp.libroworks.stage.Stage1;
import jp.libroworks.supers.BulletChara;
import jp.libroworks.supers.GameChara;
import jp.libroworks.supers.SoundBox;
import jp.libroworks.supers.Stage;
import jp.libroworks.supers.Vector2D;

public class PlayerChara extends GameChara {
	public static final double SPEED = 200;
	long lastshooting = 0;
	int searchidx = 0;
	int shootcount = 0;
	Vector2D shootvec = new Vector2D(0, -500);
	public boolean life = true;

	public PlayerChara(){
		this.size = 8;
	}

	@Override
	public GameChara draw(GraphicsInfo ginfo, Stage stage) {
		if(this.life == false) return super.draw(ginfo, stage);
		//キー入力
		if(ginfo.keystate[KEY_STATE.LEFT]){
			this.position.x -= PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.RIGHT]){
			this.position.x += PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.UP]){
			this.position.y -= PlayerChara.SPEED * ginfo.frametime;
		}
		if(ginfo.keystate[KEY_STATE.DOWN]){
			this.position.y += PlayerChara.SPEED * ginfo.frametime;
		}
		if(this.position.x < 0) {
			this.position.x = 0;
		}
		if(this.position.x > stage.getWidth()) {
			this.position.x = stage.getWidth();
		}
		if(this.position.y < 0) {
			this.position.y = 0;
		}
		if(this.position.y > stage.getHeight()){
			this.position.y = stage.getHeight();
		}
//		if(ginfo.keystate[KEY_STATE.Z]){
//			if(this.shootcount > 6){
//				if(ginfo.currenttime - this.lastshooting > 500){
//					this.shootcount = 0;
//				}
//			} else if(ginfo.currenttime - this.lastshooting > 50) {
//				BulletChara bullet = this.searchBullet(stage);
//				if(bullet == null) return null;
//				bullet.mover = StraightMover.singleton;
//				bullet.position.x = this.position.x - 8;
//				bullet.position.y = this.position.y - 12;
//				if(this.shootcount % 2 == 0) bullet.position.x += 16;
//				bullet.vector.x = this.shootvec.x;
//				bullet.vector.y = this.shootvec.y;
//				bullet.setImage(stage.getBulletImage(Stage1.BULLET_J));
//				bullet.setVisible(ginfo, true);
//
//				SoundBox.singleton.playOneSHot(2);
//
//				this.lastshooting = ginfo.currenttime;
//				this.shootcount++;
//			}
//		}
		return super.draw(ginfo, stage);
	}

	//空いている弾を探す
//	public BulletChara searchBullet(Stage stage){
//		ArrayList<BulletChara> bullets_j = stage.getBullets_J();
//		int m = bullets_j.size();
		//空き弾を探す
//		for(;this.searchidx < m; this.searchidx++){
//			if(bullets_j.get(this.searchidx).visible == false) {
//				return bullets_j.get(this.searchidx);
//			}
//		}
		//空きがないときはnullを返して発射キャンセル
//		this.searchidx = 0;
//		return null;
//	}

}


