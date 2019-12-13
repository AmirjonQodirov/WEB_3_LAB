import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Point")
public class Point implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
    @Column(name = "X") private double X;
    @Column(name = "Y") private double Y;
    @Column(name = "R") private double R;
    @Column(name = "status") private boolean status;

    public Point(double x, double y, double r, boolean status) {
        X = x;
        Y = y;
        R = r;
        this.status = status;
    }

    public Point() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
