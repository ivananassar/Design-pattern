/** "Implementor" */
interface DrawingAPI {
    public void drawCircle(double x, double y, double radius);
}
/** "ConcreteImplementor" 1/2 */
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
    }
}
/** "ConcreteImplementor" 2/2 */
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2.circle at %f:%f radius %f\n", x, y, radius);
    }
}
interface DrawingSAPI {
    public void drawSquare(double x);
}
/** "ConcreteImplementor" 1/2 */
class DrawingsAPI1 implements DrawingSAPI {
    public void drawSquare(double x) {
        System.out.printf("API1.square at %f\n", x);
    }
}
/** "Abstraction" */
         interface Shape {
 public void draw();                                            // low-level
 public void resizeByPercentage(double pct);     // high-level
 }

         /** "Refined Abstraction" */
         class SquareShape implements Shape {
             private double x;
             private DrawingSAPI drawingAPI;

             public SquareShape(double x, DrawingSAPI drawingAPI) {
                 this.x = x;
                 this.drawingAPI = drawingAPI;
             }

             // low-level i.e. Implementation specific
             public void draw() {
                 drawingAPI.drawSquare(x);
             }

             // high-level i.e. Abstraction specific
             public void resizeByPercentage(double pct) {
                 x *= pct;
             }
         }
         class CircleShape implements Shape {
             private double x, y, radius;
             private DrawingAPI drawingAPI;

             public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
                 this.x = x;
                 this.y = y;
                 this.radius = radius;
                 this.drawingAPI = drawingAPI;
             }

             // low-level i.e. Implementation specific
             public void draw() {
                 drawingAPI.drawCircle(x, y, radius);
             }

             // high-level i.e. Abstraction specific
             public void resizeByPercentage(double pct) {
                 radius *= pct;
             }
         }
             /** "Client" */
public class Bridge {
     public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI1());
        shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI2());
        shapes[2] = new SquareShape(5, new DrawingsAPI1());
        for (Shape shape : shapes) {
           shape.resizeByPercentage(2.5);
           shape.draw();
        }
     }
 }



