package unittests;

import org.junit.Test;
import elements.*;
import geometries.*;
import primitives.*;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

/**
 * Test rendering a basic image
 * 
 * @author Dan
 */
public class RenderTests {

	/**
	 * Produce a scene with basic 3D model and render it into a jpeg image with a
	 * grid
	 */
	@Test
	public void basicRenderTwoColorTest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
		scene.set_screenDistance(100);
		scene.set_background(new Color(75, 127, 90));
		scene.set_ambientLight(new AmbientLight(new Color(255, 191, 191), 1.0));

		scene.addGeometry(new Sphere(50, new Point3D(0, 0, 100)));

		scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100)),
				new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100)),
				new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100)),
				new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100)));

		ImageWriter imageWriter = new ImageWriter("base render test", 500, 500, 500, 500,true);
		// imageWriter.writeToImage();

		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50, java.awt.Color.YELLOW);
		render.writeToImage();

		/**
		 * Produce a scene with basic 3D model and render it into a jpeg image with a
		 * grid
		 */
		scene = new Scene("Test scene");
		scene.set_camera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
		scene.set_screenDistance(100);
		scene.set_background(new Color(75, 127, 90));
		scene.set_ambientLight(new AmbientLight(new Color(255, 191, 191), 1));

		scene.addGeometry(new Sphere(50, new Point3D(0, 0, 100)));

		scene.addGeometry(new Triangle(new Point3D(100, 0, 100), new Point3D(0, 100, 100), new Point3D(100, 100, 100)),
				new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100)),
				new Triangle(new Point3D(-100, 0, 100), new Point3D(0, 100, 100), new Point3D(-100, 100, 100)),
				new Triangle(new Point3D(-100, 0, 100), new Point3D(0, -100, 100), new Point3D(-100, -100, 100)));

		imageWriter = new ImageWriter("base render test", 500, 500, 500, 500,true);
		render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50, java.awt.Color.YELLOW);
		render.writeToImage();
	}

	@Test
	public void basicRenderMultiColorTest() {
		Scene scene = new Scene("Test scene");
		scene.set_camera(new Camera(Point3D.ZERO, new Vector(0, 0, 1), new Vector(0, -1, 0)));
		scene.set_screenDistance(100);
		scene.set_background(Color.BLACK);
		scene.set_ambientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.2));

		scene.addGeometry(new Sphere(50, new Point3D(0, 0, 100)));
		scene.addGeometry(
				new Triangle(new Color(java.awt.Color.BLUE), new Point3D(100, 0, 100), new Point3D(0, 100, 100),
						new Point3D(100, 100, 100)), // lower right
				new Triangle(new Point3D(100, 0, 100), new Point3D(0, -100, 100), new Point3D(100, -100, 100)), // upper
																												// right
				new Triangle(new Color(java.awt.Color.RED), new Point3D(-100, 0, 100), new Point3D(0, 100, 100),
						new Point3D(-100, 100, 100)), // lower left
				new Triangle(new Color(java.awt.Color.GREEN), new Point3D(-100, 0, 100), new Point3D(0, -100, 100),
						new Point3D(-100, -100, 100))); // upper left

		ImageWriter imageWriter = new ImageWriter("color render test", 500, 500, 500, 500,true);
		Render render = new Render(imageWriter, scene);

		render.renderImage();
		render.printGrid(50, java.awt.Color.WHITE);
		render.writeToImage();
	}
}