import org.hibernate.Session;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.LinkedList;

@ManagedBean(name = "point")
@ApplicationScoped
public class PointBean implements Serializable {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Web3");
    double x = 0;
    double y = 0;
    double r = 4;
    boolean status;
    LinkedList<Point> points = new LinkedList<>();


    public void isArea() {
        if ((x >= 0) && (y <= 0) && (y >= (2 * x - r))) {
            status = true;
        } else {
            if ((x <= 0) && (y >= 0) && ((x * x + y * y) <= r * r)) {
                status = true;
            } else {
                if ((x >= 0) && (y >= 0) && (x <= r) && (y <= r / 2)) {
                    status = true;
                } else {
                    status = false;
                }
            }
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isStatus() {
        isArea();
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

    public void setPoints(LinkedList<Point> points) {
        this.points = points;
    }

    public void addPoint() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Point point = new Point(getX(), getY(), getR(),isStatus());
        entityManager.persist(point);
        entityManager.getTransaction().commit();
        points.add(point);
        entityManager.close();
    }


    public void clearList(){
        points.clear();
    }



}




