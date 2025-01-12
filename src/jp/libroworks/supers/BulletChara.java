package jp.libroworks.supers;

import jp.libroworks.GraphicsInfo;

public class BulletChara extends GameChara {

	public BulletMover mover = null;
	protected long starttime;
	public Vector2D vector = new Vector2D();

	public BulletChara(){
		this.visible = false;
		this.size = 12;
	}

	@Override
	public GameChara draw(GraphicsInfo ginfo, Stage stage) {
		if(this.mover != null){
			this.mover.move(ginfo, stage, this);
		}
		return super.draw(ginfo, stage);
	}

	public void setVisible(GraphicsInfo ginfo, boolean b){
		this.visible = b;
		if(b == true){
			starttime = ginfo.currenttime;
		}
	}
	public long getStartTime(){
		return this.starttime;
	}
}
