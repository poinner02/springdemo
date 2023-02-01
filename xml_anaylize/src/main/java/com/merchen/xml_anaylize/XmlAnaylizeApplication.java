package com.merchen.xml_anaylize;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.merchen.xml_anaylize.com.merchen.bean.Path;
import com.merchen.xml_anaylize.com.merchen.bean.Point;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class XmlAnaylizeApplication {

    private static List<Point> pointList = null;
    private static List<Path> pathList = null;
    //坐标
    private static Point point = null;
    private static Path path = null;

    public static void getGavs(File file){

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();
            Iterator  iterators = rootElement.elementIterator();
            pointList = new ArrayList<Point>();
            pathList = new ArrayList<Path>();
            while(iterators.hasNext()){
                point = new Point();
                path = new Path();
                Element element = (Element) iterators.next();
                //遍历bookElement的属性
                //point
                if(element.getName().equals("point")){
                    List<Attribute> attributes = element.attributes();
                    for (Attribute attribute : attributes) {
                        if(attribute.getName().equals("y")){
                            String y = attribute.getValue();
                            point.setY(Integer.parseInt(y));
                        }
                        if(attribute.getName().equals("x")){
                            String x = attribute.getValue();
                            point.setX(Integer.parseInt(x));
                        }
                        if(attribute.getName().equals("name")){
                            String name = attribute.getValue();
                            point.setPointName(name);
                        }
                    }
                    pointList.add(point);
                }
                //path
                if(element.getName().equals("path")){
                    List<Attribute> attributes = element.attributes();
                    for (Attribute attribute : attributes) {
                        if(attribute.getName().equals("startpoint")){
                            String startpoint = attribute.getValue();
                            path.setStartPoint(startpoint);
                        }
                        if(attribute.getName().equals("endpoint")){
                            String endpoint = attribute.getValue();
                            path.setEndPoint(endpoint);
                        }
                        if(attribute.getName().equals("name")){
                            String name = attribute.getValue();
                            path.setPathName(name);
                        }
                    }
                    pathList.add(path);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //sout
        System.out.println(pathList);
        System.out.println(pointList);
    }

    public static void main(String[] args) {
        SpringApplication.run(XmlAnaylizeApplication.class, args);
        URL resource  = XmlAnaylizeApplication.class.getClass().getResource("/xml/demo.xml");
        String path = resource.getPath();
        getGavs(new File(path));
    }

}
