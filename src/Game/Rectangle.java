package game;

public class Rectangle {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle() {
        this(new Vector2D(), 1, 1);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * @param other
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(Rectangle other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 hình chữ nhật ở đây
        float x = this.position.x;
        float y = this.position.y;
        float x1 = other.position.x;
        float y1 = other.position.x;
        if (x > x1 && y > y1) {
            if (x1 + other.width > x && y1 + other.height > y) {
                return true;
            }
        }
        if (x > x1 && y < y1) {
            if (x1 + other.width > x && y1 < y + this.height) {
                return true;
            }
        }
        if (x < x1 && y > y1) {
            if (x1 < x + this.width && y1 + other.height > y) {
                return true;
            }
        }
        if (x < x1 && y < y1) {
            if (x1 < x + this.width && y1 < y + this.height) {
                return true;
            }
        }
        return false;
    }

    //TODO: 2. Chạy hàm main này để test
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(5, 5), 3, 3);
        Rectangle rect2 = new Rectangle(new Vector2D(4, 4), 3, 3);
        Rectangle rect3 = new Rectangle(new Vector2D(10, 10), 3, 3);
        System.out.println(String.format("rect1 intersects rect2: %s (correct: true)", rect1.intersects(rect2)));
        System.out.println(String.format("rect2 intersects rect1: %s (correct: true)", rect2.intersects(rect1)));
        System.out.println(String.format("rect1 intersects rect3: %s (correct: false)", rect1.intersects(rect3)));
        System.out.println(String.format("rect3 intersects rect2: %s (correct: false)", rect3.intersects(rect2)));
    }
}
