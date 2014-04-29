package jp.libroworks.supers;

import java.awt.geom.Point2D;

import jp.libroworks.GraphicsInfo;

public abstract class Shooter {
	public abstract void shoot(GraphicsInfo ginfo, Stage stage, Point2D.Double position);

}
