package com.zick.XmlTest;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/8/8.
 */
public class DOMTest {
    public DocumentBuilder getDocumentBuilder(){
        // 创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建DocumentBuilder对象
        DocumentBuilder db =null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }

    /**
     * 生成xml
     */
    public void createXML(){
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element bookstore = document.createElement("bookStore");
        //向bookstore根节点中添加子节点book
        Element book = document.createElement("book");
        Element name = document.createElement("name");
//		name.setNodeValue("小王子");
        name.setTextContent("小王子");

        book.appendChild(name);
        book.setAttribute("id", "1");
        //将book节点添加到bookstore根节点中
        bookstore.appendChild(book);
        //将bookstore节点（已经包含了book）添加到dom树中
        document.appendChild(bookstore);
        //创建TransformerFactory对象
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            //创建Transformer对象
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");

            tf.transform(new DOMSource(document),new StreamResult(new File("D:\\\\File\\\\IdeaProjects\\\\Personal\\\\src\\\\test\\\\java\\\\com\\\\zick\\\\XMLTest\\\\books1.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        DOMTest test = new DOMTest();
        test.createXML();

       /* DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

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
        }*/
    }
}
