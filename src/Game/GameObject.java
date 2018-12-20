package game;

import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

public class GameObject {
    //static
    public static ArrayList<GameObject> gameObjects
            = new ArrayList<>();

    public static void addGameObject(GameObject object) {
        gameObjects.add(object);
    }

    public static <E extends GameObject> E findInactive(Class<E> clazz) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (!object.active && clazz.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findIntersected(Class<E> clazz, BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (clazz.isAssignableFrom(object.getClass())
                    && object instanceof Physics
                    // cast object thanh physics
                    // kiem tra object.getBoxCollider giao voi boxCollider truyen vao
                    && ((Physics) object).getBoxCollider().intersects(boxCollider)
                    && object.active) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E recycle(Class<E> clazz) {
        E find = findInactive(clazz);
        if (find != null) {
            find.reset();
            return find;
        }
        try {
            E newInstance = clazz.newInstance();
            addGameObject(newInstance);
            return newInstance; // new E()
            // E ~ Background, E ~ Player
        } catch (Exception ex) {
            return null;
        }
    }

    public static void runAll() {
        System.out.println(gameObjects.size());
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    //
    public Renderer renderer;
    public Vector2D position;
    public Vector2D anchor;
    public Vector2D velocity;
    public boolean active;

    public GameObject() {
        this.position = new Vector2D();
        this.anchor = new Vector2D(0.5f, 0.5f);
        this.velocity = new Vector2D();
        this.active = true;
    }

    //logic
    public void run() {
        this.position.addThis(this.velocity);
    }

    //hien thi
    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

    public void destroy() {
        this.active = false;
    }

    public void reset() {
        this.active = true;
    }
}
