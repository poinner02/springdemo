package com.merchen.xml_anaylize.com.merchen.bean;

/**
 * @author MrChen
 * @create 2023-02-01 20:40
 */
public class Path {
    private String startPoint;
    private String endPoint;
    private String pathName;

    public Path(String startPoint, String endPoint, String pathName) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.pathName = pathName;
    }

    public Path() {
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public String toString() {
        return "Path{" +
                "startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", pathName='" + pathName + '\'' +
                '}';
    }
}
