package jp.libroworks.supers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import jp.libroworks.GraphicsInfo;

public abstract class Stage {

	private double width = 800;
	private double height = 720;

	public abstract GameChara getPlayer();
	public abstract void loadMedia() throws IOException;
	public abstract GameChara getEnemy();

	public abstract void draw(GraphicsInfo ginfo);
	public abstract void init(GraphicsInfo ginfo);


	//敵の弾のデータを取得する
	public abstract ArrayList<BulletChara> getBullets_E();

	//自機の弾のデータを取得する
	public abstract ArrayList<BulletChara> getBullets_J();

	//弾の画像を取得する
	public abstract BufferedImage getBulletImage(int type);

	//空いている弾を探す
	protected int searchidx = 0;
	public BulletChara searchBullet(){
		ArrayList<BulletChara> bullets_e = this.getBullets_E();
		int m = bullets_e.size();
		//空き弾を探す
		for(;this.searchidx < m; this.searchidx++){
			if(bullets_e.get(this.searchidx).visible == false) {
				return bullets_e.get(this.searchidx);
			}
		}
		//空きがないときはnullを返して発射キャンセル
		this.searchidx = 0;
		return null;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	public abstract boolean hitTestAll(GraphicsInfo ginfo);
	public abstract boolean isBossLiving();
}
