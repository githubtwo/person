package com.zick.XmlTest;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/8.
 */
public class DOMTest {

    public static void main(String[] args) {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse("D:\\File\\IdeaProjects\\Personal\\src\\test\\java\\com\\zick\\XMLTest\\books.xml");
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("book");

            System.out.println("一共有" + bookList.getLength() +"本书");
            //遍历每一个book节点
            for(int i=0;i<bookList.getLength();i++){
                Node book = bookList.item(i);
                //获取book节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                //遍历book的属性
                for(int j= 0;j<attrs.getLength();j++){
                    //通过item(index)方法获取book节点的某一个属性
                    Node attr = attrs.item(j);
                    System.out.println("属性名："+attr.getNodeName() + " " +"属性值:"+attr.getNodeValue());
                }

                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNodes获取每个节点的节点名和节点值
                for(int k=0;k<childNodes.getLength();k++){
                    //区分出text类型的node以及element类型的node
                    if(childNodes.item(k).getNodeType() == Node.ELEMENT_NODE){
                        //获取了element类型节点的节点名和节点值
                        System.out.println("第" + (k+1) + "个节点的节点名 "+childNodes.item(k).getNodeName() + "   节点值  " + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
