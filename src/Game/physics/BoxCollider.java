package game.physics;
import game.Vector2D;

public class BoxCollider {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    Vector2D anchor;
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public BoxCollider() {
        this(new Vector2D(),new Vector2D(), 1, 1);
    }

    public BoxCollider(Vector2D position, Vector2D anchor, int width, int height) {
        this.position = position;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    /**
     * @param
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public float top() {
        return this.position.y - this.anchor.y*this.height;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x - this.anchor.x*this.width;
    }

    public float right() {
        return this.left() + this.width;
    }

    public boolean intersects(BoxCollider other) {
        return this.left() <= other.right()
                && other.left() <= this.right()
                && this.top() <= other.bot()
                && other.top() <= this.bot();

    }
}

