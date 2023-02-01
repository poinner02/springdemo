package com.merchen.xml_anaylize.com.merchen.bean;

/**
 * @author MrChen
 * @create 2023-02-01 20:01
 */
public class Point {
    private Integer x;
    private Integer y;
    private String pointName;

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }



    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }



    public Point(Integer x, Integer y, String pointName) {
        this.x = x;
        this.y = y;
        this.pointName = pointName;

    }

    public Point() {
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", pointName='" + pointName + '\'' +
                '}';
    }
}
