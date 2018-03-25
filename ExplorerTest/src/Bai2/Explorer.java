package Bai2;

import java.io.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.*;  
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.*;  
/***********************************/  
class Explorer extends JPanel implements ActionListener  
{  
JTextField jtf;  
JTextArea jta;  
JTree tree;  
JTable jtb;  
JScrollPane jsp;  
JScrollPane jspTable;  
//create a menu bar 
JMenuBar mb;    
JMenu file, help, edit, sum, compress;    
JMenu create, copy, rename, delete;   
JMenuItem create_file, copy_file, rename_file, delete_file;   
JMenuItem create_folder, copy_folder, rename_folder, delete_folder;   
JMenuItem edit_file, sum_file, cut_file, compress_file, uncompress_file;

String fileName = null;
String currDirectory=null;  
  
final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};  
String[][]data={{"","","",""}};  
  
/////////////////////////////////  
Explorer(String path)  
{  
  //
create = new JMenu("create");    
copy = new JMenu("copy");    
delete = new JMenu("delete");    
rename =new JMenu("rename");    

create_file = new JMenuItem("create file");    
copy_file = new JMenuItem("copy file");    
delete_file = new JMenuItem("delete file");    
rename_file =new JMenuItem("rename file");  

create_folder = new JMenuItem("create folder");    
copy_folder = new JMenuItem("copy folder");    
delete_folder = new JMenuItem("delete folder");    
rename_folder =new JMenuItem("rename folder");  

edit_file = new JMenuItem("Edit");
sum_file = new JMenuItem("Sum");
cut_file = new JMenuItem("Cut");

compress_file = new JMenuItem("compress");
uncompress_file = new JMenuItem("uncompress");

compress_file.addActionListener(this);
uncompress_file.addActionListener(this);

sum_file.addActionListener(this);
cut_file.addActionListener(this);
edit_file.addActionListener(this);

create_file.addActionListener(this);    
copy_file.addActionListener(this);    
delete_file.addActionListener(this);    
rename_file.addActionListener(this); 

create_folder.addActionListener(this);    
copy_folder.addActionListener(this);    
delete_folder.addActionListener(this);    
rename_folder.addActionListener(this);  
//edit.addActionListener(this);
mb=new JMenuBar();    
file=new JMenu("File");    
help=new JMenu("Help"); 
edit=new JMenu("Edit"); 
sum=new JMenu("Sum");
compress = new JMenu("Compress");

file.add(create);file.add(copy);file.add(delete);file.add(rename);   
create.add(create_file);create.add(create_folder);
rename.add(rename_file);rename.add(rename_folder);
delete.add(delete_file);delete.add(delete_folder);
copy.add(copy_file);copy.add(copy_folder);
mb.add(file);mb.add(help);    mb.add(edit);mb.add(sum);mb.add(compress);
edit.add(edit_file);
sum.add(sum_file);sum.add(cut_file);
compress.add(compress_file);compress.add(uncompress_file);

//add(mb, BorderLayout.EAST);
  //
jtf=new JTextField();  
jta=new JTextArea(5,30);  
  
File temp=new File(path);  
DefaultMutableTreeNode top=createTree(temp);  
  
//if(top!=null)  
  
tree=new JTree(top);  
  
jsp=new JScrollPane(tree);  
  
final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};  
String[][]data={{"","","",""}};  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
  
setLayout(new BorderLayout());  
add(jtf,BorderLayout.NORTH);  
add(jsp,BorderLayout.WEST);  
add(jspTable,BorderLayout.CENTER);  
add(mb,BorderLayout.SOUTH);  

tree.addMouseListener(  
new MouseAdapter()  
{  
public void mouseClicked(MouseEvent me)  
{  
doMouseClicked(me);  
}  
});  
jtf.addActionListener(this);  
//refresh.addActionListener(this);  

}  
///////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
//    if(jtf.getText()==""){
//             jtf.setText("D:\\");
//         }   
    File temp=new File(jtf.getText());  
    DefaultMutableTreeNode newtop=createTree(temp);  
    if(newtop!=null)  
        tree=new JTree(newtop);  
    remove(jsp);  
    jsp=new JScrollPane(tree);  
    setVisible(false);  
    add(jsp,BorderLayout.WEST);  
    tree.addMouseListener(  
    new MouseAdapter()  
    {  
    public void mouseClicked(MouseEvent me)  
    {  
    doMouseClicked(me);  
    }  
    });  

    setVisible(true);  
        //lay chuoi ra co dang de khi tao file co duong dan: D:\\study\\năm 3\\MMT\\MMT_Chat
    ////////////////////////------------------------after: D:\\\\study\\năm 3\\MMT
    String str = jtf.getText();
    StringBuffer buf = new StringBuffer(str);
    if(buf.charAt(2) == '\\' && buf.charAt(3) == '\\'){
    buf.deleteCharAt(2);// xoa bot 1 dau \ sau dau D:\\ khi sau nay thay dau vao de tao file
    }
    //neu text field cuoi cung co dau \ o nhap du thi delete

    if(buf.charAt(buf.length()-1) == '\\') // vd D:\\study\ khi chen se du dau
    {
        //System.out.println("true: " );
        buf.deleteCharAt(buf.length()-1);
    }
    str = buf.toString();
    
    str=str.replace("\\","\\\\");  //thay 1 dau / thanh //
    //int t = str.indexOf('\\');
    
   // str.replaceAll("\\", "\\\\");
    //System.out.println(str);
    ///////////////////////-----------------------------------------------------------
    //menu
   if(ev.getSource()==create_file){
       OutputStream out =  null;
        try {
            String name =  JOptionPane.showInputDialog("input file name(abc.txt): ");
            //System.out.println("-------------tab---------------");
//       System.out.println("name: " + name);
//       System.out.println("link in status bar: " + jtf.getText());
//       System.out.println("after: "+ str);
        name = str + "\\\\" + name;
        System.out.println("name: " + name);
            out = new FileOutputStream(name);
        } catch (FileNotFoundException ex) {
            System.out.println("create file error");
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                System.out.println("create file error");
            }
        }


    }  
    if(ev.getSource()==rename_file){
        String name1 = str + "\\\\" + fileName;
        String name2 = JOptionPane.showInputDialog("input file name to rename EX: abc.txt: ");
        name2 = str + "\\\\" + name2;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name2:  " + name2);

        File srcFolder = new File(name1);        
        File destFolder = new File(name2);
        //make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
//delete
    	//make sure directory exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           System.exit(0);

        }else{

           try{

               delete(srcFolder);

           }catch(IOException e){
               e.printStackTrace();
               System.exit(0);
           }
        }    
    }    
    
    if(ev.getSource()==copy_file){
        String name1 = str + "\\\\" + fileName;
        String name2 = JOptionPane.showInputDialog("input file name to copy(Ex: abc.txt): ");
        name2 = str + "\\\\" + name2;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name2:  " + name2);

        File srcFolder = new File(name1);        
        File destFolder = new File(name2);

    	//make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    }    
    //khi xoa, copy, rename nho chon ben table truoc
    if(ev.getSource()==delete_file){
        String name1 = str + "\\\\" + fileName;
        System.out.println("file name:  " + str + "\\\\" + fileName);
        File directory = new File(name1);
        //System.out.println("File is deleted : " + directory.getAbsolutePath());
        
        //make sure directory exists
    	if(!directory.exists()){

           System.out.println("Directory does not exist.");
           System.exit(0);

        }else{

           try{

               delete(directory);

           }catch(IOException e){
               e.printStackTrace();
               System.exit(0);
           }
        }
    }  
    if(ev.getSource()==create_folder){
        String name =  JOptionPane.showInputDialog("input folder name: ");
        System.out.println(str + "\\\\" + name);
        //tao thu muc
        File files = new File(str + "\\\\" + name);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("directories are created!");
            } else {
                System.out.println("Failed to create directories!");
            }
        }
    }    
    if(ev.getSource()==rename_folder){
        String name1 = str + "\\\\" + fileName;
        String name2 = JOptionPane.showInputDialog("input folder name to rename: ");
        name2 = str + "\\\\" + name2;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name2:  " + name2);

        File srcFolder = new File(name1);        
        File destFolder = new File(name2);
        //make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
//delete
    	//make sure directory exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           System.exit(0);

        }else{

           try{

               delete(srcFolder);

           }catch(IOException e){
               e.printStackTrace();
               System.exit(0);
           }
        }    
    }    
    if(ev.getSource()==copy_folder){
        String name1 = str + "\\\\" + fileName;
        String name2 = JOptionPane.showInputDialog("input folder name to copy: ");
        name2 = str + "\\\\" + name2;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name2:  " + name2);

        File srcFolder = new File(name1);        
        File destFolder = new File(name2);

    	//make sure source exists
    	if(!srcFolder.exists()){

           System.out.println("Directory does not exist.");
           //just exit
           System.exit(0);

        }else{

           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	//error, just exit
                System.exit(0);
           }
        }
    }    
    if(ev.getSource()==delete_folder){
        String name1 = str + "\\\\" + fileName;
        System.out.println("folder name:  " + str + "\\\\" + fileName);
        File directory = new File(name1);
       // System.out.println("File is deleted : " + directory.getAbsolutePath());
                        

    	//make sure directory exists
    	if(!directory.exists()){

           System.out.println("Directory does not exist.");
           System.exit(0);

        }else{

           try{

               delete(directory);

           }catch(IOException e){
               e.printStackTrace();
               System.exit(0);
           }
        }
//
//    	//System.out.println("Done");
    }
     if(ev.getSource()==edit_file){
         
         //neu status bar == null
         Edit e1 = new Edit();
         e1.path = str + "\\\\" + fileName;

         e1.f.setVisible(true);
         //e1.ta.setText(str + "\\\\" + fileName);
         String line = readLineFile(str + "\\\\" + fileName); //hàm đọc file từ tập tin được chọn vào
         e1.ta.setText(line);
         
     }
     //phải chọn truoc 1 file bên table
     //cong 2 file
     if(ev.getSource()==cut_file){
        System.out.println("cut");
        String name1 = str + "\\\\" + fileName;
        String name2 = JOptionPane.showInputDialog("input file name1(abc1.txt): ");
        name2 = str + "\\\\" + name2;
        String name3 = JOptionPane.showInputDialog("input file name2(abc2.txt): ");
        name3 = str + "\\\\" + name3;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name2:  " + name2);
//        System.out.println("file name3:  " + name3);
        cut(name1, name2, name3);
        
     }
     if(ev.getSource()==sum_file){
         FileInputStream fin1 = null;
        try {
            System.out.println("sum");
            String name1 = str + "\\\\" + fileName;
            String name2 = JOptionPane.showInputDialog("input file name2 to sum(Ex: c.txt): ");
            name2 = str + "\\\\" + name2;
            String name3 = JOptionPane.showInputDialog("input parent file name to sum file1 and file2 (Ex: c.txt): ");
            name3 = str + "\\\\" + name3;
//        System.out.println("file name1:  " + name1);
//        System.out.println("file name3:  " + name3);
            fin1 = new FileInputStream(name1);
            FileInputStream fin2 = new FileInputStream(name2);
            FileOutputStream fout = new FileOutputStream(name3);
            SequenceInputStream sis = new SequenceInputStream(fin1, fin2);
            int i;
            while ((i = sis.read()) != -1) {
                fout.write(i);
            }   sis.close();
            fout.close();
            fin2.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("file error");
        } finally {
            
             try {
                 fin1.close();
             } catch (IOException ex) {
                 System.out.println("error");
             }
           
        }

     }
     //khi nen vs giai nen phai chọn duong dan va chon tren table tn file muon nen truoc
     if(ev.getSource()==compress_file){
        // System.out.println("compress");
        String inputDir = str + "\\\\" + fileName;
       String outputZipFile = str+ "\\\\" + fileName + ".zip";
//         System.out.println(inputDir);
//         System.out.println(outputZipFile);
//        File inputDir = new File("D:\\study\\test\\datas");
//        File outputZipFile = new File("D:\\study\\test\\datas.zip");
            File inputDir1 = new File(inputDir);
            File outputZipFile1 = new File(outputZipFile);
            zipDirectory(inputDir1, outputZipFile1);
     }
     if(ev.getSource()==uncompress_file){
       String filePath = str + "\\\\" + fileName;
       String outputFolder = str+ "\\\\" + fileName.replaceAll(".zip", "");
//         System.out.println(filePath);
//         System.out.println(outputFolder);
//         String outputFolder = "D:\\study\\tes\\datas";
//         String filePath = "D:\\study\\tes\\datas.zip";
 
         Uncompress1(filePath, outputFolder);
     }
}  
///////////////
//read file
public static String readLineFile(String fileName) {
        StringBuilder str = new StringBuilder();
        try (FileReader f = new FileReader(fileName); BufferedReader b = new BufferedReader(f)) {
                String line = null;
                while((line = b.readLine())!= null){

                str.append(line);
                str.append("\n");
                //System.out.println(line);
            }
                b.close();
                f.close();
        } catch (FileNotFoundException ex) {
            System.out.println("open file error: file not found");
        } catch (IOException ex) {
             System.out.println("open file error");
        }
        
        return str.toString();
    }
/////////////// 
//write file with buffer: 
//path Ex: D:\\c.txt
  void writeWithBuffer(String data, String path) { 
        try {
            try (FileOutputStream f = new FileOutputStream(path, false) //F là k ghi tiếp
            ) {
                try (BufferedOutputStream b = new BufferedOutputStream(f)) {
                    b.write(data.getBytes());
                    b.flush();
                }
                f.close();
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("file not found!");
        } catch (IOException ex) {
            System.out.println("write file error!");        }
        
    }
//////////////
//cut file 
    public static void cut(String path, String pathSubFile1, String pathSubFile2) {
            StringBuilder str = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
        try (FileInputStream f = new FileInputStream(path)) {
            //System.out.println(f.available()); so ki tu doc vao dk
            int n = f.available()/2;
            int dem = 0;
                int i = 0;
                while((i = f.read())!= -1){
                    if(dem < n){
                        str.append((char)i);
                    }
                    else{
                        str2.append((char)i);
                    }
                    dem++;
            }
                f.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("read file error");
        }
        
        //write to subFile
        writeSubFile(pathSubFile1, str.toString());
        writeSubFile(pathSubFile2, str2.toString());

    }
    //write file
    public static void writeSubFile(String path, String data) {
        try {
            try (FileOutputStream f = new FileOutputStream(path, false) //F là k ghi tiếp
            ) {
                f.write(data.getBytes());
                f.close();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException");
        } catch (IOException ex) {
            System.out.println("write file error");
        }
        
    }  
  
  //////////////
DefaultMutableTreeNode createTree(File temp)  
{  
DefaultMutableTreeNode top=new DefaultMutableTreeNode(temp.getPath());  
if(!(temp.exists() && temp.isDirectory()))  
    return top;  
  
fillTree(top,temp.getPath());  
  
return top;  
}  
///////////////////
//giai nen file
void Uncompress1(String filePath, String outputFolder) {
        // Tạo thư mục Output nếu nó không tồn tại.
        File folder = new File(outputFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // Tạo một buffer (Bộ đệm).
        byte[] buffer = new byte[1024];
 
        ZipInputStream zipIs = null;
        try {
            // Tạo đối tượng ZipInputStream để đọc file từ 1 đường dẫn (path).
            zipIs = new ZipInputStream(new FileInputStream(filePath));
 
            ZipEntry entry = null;
            // Duyệt từng Entry (Từ trên xuống dưới cho tới hết)
            while ((entry = zipIs.getNextEntry()) != null) {
                String entryName = entry.getName();
                String outFileName = outputFolder + File.separator + entryName;
                System.out.println("Unzip: " + outFileName);
 
                if (entry.isDirectory()) {
                    // Tạo các thư mục.
                    new File(outFileName).mkdirs();
                } else {
                    // Tạo một Stream để ghi dữ liệu vào file.
                    FileOutputStream fos = new FileOutputStream(outFileName);
 
                    int len;
                    // Đọc dữ liệu trên Entry hiện tại.
                    while ((len = zipIs.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
 
                    fos.close();
                }
 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                zipIs.close();
            } catch (Exception e) {
            }
        }
    }
///////////////////
//nen file
// Phương thức dùng để nén một thư mục.
    void zipDirectory(File inputDir, File outputZipFile) {
        // Tạo thư mục cha cho file đầu ra (output file).
        outputZipFile.getParentFile().mkdirs();
 
        String inputDirPath = inputDir.getAbsolutePath();
        byte[] buffer = new byte[1024];
 
        FileOutputStream fileOs = null;
        ZipOutputStream zipOs = null;
        try {
 
            java.util.List<File> allFiles = this.listChildFiles(inputDir);
 
            // Tạo đối tượng ZipOutputStream để ghi file zip.
            fileOs = new FileOutputStream(outputZipFile);
            // 
            zipOs = new ZipOutputStream(fileOs);
            for (File file : allFiles) {
                String filePath = file.getAbsolutePath();
 
                System.out.println("Zipping " + filePath);
                // entryName: is a relative path.
                String entryName = filePath.substring(inputDirPath.length() + 1);
 
                ZipEntry ze = new ZipEntry(entryName);
                // Thêm entry vào file zip.
                zipOs.putNextEntry(ze);
                // Đọc dữ liệu của file và ghi vào ZipOutputStream.
                FileInputStream fileIs = new FileInputStream(filePath);
 
                int len;
                while ((len = fileIs.read(buffer)) > 0) {
                    zipOs.write(buffer, 0, len);
                }
                fileIs.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuite(zipOs);
            closeQuite(fileOs);
        }
 
    }
 
   void closeQuite(OutputStream out) {
        try {
            out.close();
        } catch (Exception e) {
        }
    }
 
    // Phương thức này trả về danh sách các file,
    // bao gồm tất cả các file con,.. của thư mục đầu vào.
    java.util.List<File> listChildFiles(File dir) throws IOException {
        java.util.List<File> allFiles = new ArrayList<File>();
 
        File[] childFiles = dir.listFiles();
        for (File file : childFiles) {
            if (file.isFile()) {
                allFiles.add(file);
            } else {
                java.util.List<File> files = this.listChildFiles(file);
                allFiles.addAll(files);
            }
        }
        return allFiles;
    }
//////////////////////////////  
void fillTree(DefaultMutableTreeNode root, String filename)  
{  
File temp=new File(filename);  
  
if(!(temp.exists() && temp.isDirectory()))  
    return;  
//System.out.println(filename);  
File[] filelist=temp.listFiles();  
  
    for (File filelist1 : filelist) {
        if (!filelist1.isDirectory()) {
            continue;
        }
        final DefaultMutableTreeNode tempDmtn = new DefaultMutableTreeNode(filelist1.getName());
        root.add(tempDmtn);
        final String newfilename = filename+"\\" + filelist1.getName();
        Thread t=new Thread()
        {
            @Override
            public void run()
            {
                fillTree(tempDmtn,newfilename);
            }//run
        };//thread  
        if(t==null)
        {System.out.println("no more thread allowed "+newfilename);return;}
        t.start();
    } //for  
}//function  
//////////////////////////////  
void doMouseClicked(MouseEvent me)  
{  
TreePath tp=tree.getPathForLocation(me.getX(),me.getY());  
if(tp==null) return;  
//jtf.setText(tp.toString());  
String s=tp.toString();  
s=s.replace("[","");  
s=s.replace("]","");  
s=s.replace(", ","\\");  
//s=s.replace(" ","");  
//int z=s.lastIndexOf("\"\\\"");  
//s="\'"+s; s=s+"\'";  
jtf.setText(s);  
    //lay chuoi ra co dang de khi tao file co duong dan: D:\\study\\năm 3\\MMT\\MMT_Chat
    ////////////////////////----------------------------------------------------------
    String str = new String(tp.toString());
    str=str.replace("[","");  
    str=str.replace("]","");  
    str=str.replace(", ","\\\\");  
    int t = str.indexOf('\\');
    StringBuffer buf = new StringBuffer(str);
    buf.deleteCharAt(t);
    str = buf.toString();
   // str.replaceAll("\\", "\\\\");
   // System.out.println(str);
    ///////////////////////-----------------------------------------------------------
showFiles(s);  
//java.util.StringTokenizer st=new java.util.StringTokenizer(s,",");  
//jtf.setText(jtf.getText()+"="+s);  
  
}  
////////////////////////////////  
void showFiles(String filename)  
{  
File temp=new File(filename);  
data=new String[][]{{"","","",""}};  
remove(jspTable);  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
setVisible(false);  
add(jspTable,BorderLayout.CENTER);  
setVisible(true);  
  
if(!temp.exists()) return;  
if(!temp.isDirectory()) return;  
  
//System.out.println(filename);  
File[] filelist=temp.listFiles();  
int fileCounter=0;  
data=new String[filelist.length][4];  
//
//thu mục 
for(int i=0; i<filelist.length; i++)  
{  
if(filelist[i].isDirectory()) { 
data[fileCounter][0]=new String(filelist[i].getName());  
data[fileCounter][1]=new String(filelist[i].length()+"");  
data[fileCounter][2]=new String(!filelist[i].canWrite()+"");  
data[fileCounter][3]=new String(filelist[i].isHidden()+"");  
fileCounter++;  
}
}
//
for(int i=0; i<filelist.length; i++)  
{  
if(filelist[i].isDirectory())  
    continue;  
data[fileCounter][0]=new String(filelist[i].getName());  
data[fileCounter][1]=new String(filelist[i].length()+"");  
data[fileCounter][2]=new String(!filelist[i].canWrite()+"");  
data[fileCounter][3]=new String(filelist[i].isHidden()+"");  
fileCounter++;  
}//for  

  
String dataTemp[][]=new String[fileCounter][4];  
for(int k=0; k<fileCounter; k++)  
    dataTemp[k]=data[k];  
data=dataTemp;  
  
//System.out.println(data);  
remove(jspTable);  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
setVisible(false);  
add(jspTable,BorderLayout.CENTER);  
setVisible(true);  

//----------------------------- khi bạn chọn bên list view nó sẽ xử lí-----
jtb.setCellSelectionEnabled(true); ///chọn cột nó hiện lên
            
            ListSelectionModel select= jtb.getSelectionModel();  
            select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
            
            select.addListSelectionListener(new ListSelectionListener() { 
                                
              public void valueChanged(ListSelectionEvent e) {
                  String Data = null;
                  int k = 0;
                int[] row = jtb.getSelectedRows();  
                int[] columns = jtb.getSelectedColumns();  
                int i, j;
                for (i = 0; i < row.length; i++) {  
                  for (j = 0; j < columns.length; j++) { 
                     
                    Data = (String) jtb.getValueAt(row[i], columns[j]);  
                  } 
                }  
               Data = (String) jtb.getValueAt(row[0], 0);  
               if(k%2==0){
                  System.out.println(Data);  
                  fileName = Data; // khi chon ben table se lay dk tennn file 
               }
              k++;
              } 

            });  
//--------------------------------------
}
//copy folder
void copyFolder(File src, File dest)
    	throws IOException{

    	if(src.isDirectory()){

    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		   System.out.println("Directory copied from "
                              + src + "  to " + dest);
    		}

    		//list all the directory contents
    		String files[] = src.list();

    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file); //File(File parent, String child)
    		   File destFile = new File(dest, file);
    		   //recursive copy
    		   copyFolder(srcFile,destFile);
    		}

    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest);

    	        byte[] buffer = new byte[1024];

    	        int length;
    	        //copy the file content in bytes
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }

    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
}
//delete 1 folder
void delete(File file)
    	throws IOException{

    	if(file.isDirectory()){

    		//directory is empty, then delete it
    		if(file.list().length==0){

    		   file.delete();
    		   System.out.println("Directory is deleted : "
                                                 + file.getAbsolutePath());

    		}else{

    		   //list all the directory contents
        	   String files[] = file.list();

        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);

        	      //recursive delete
        	     delete(fileDelete);
        	   }

        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	     System.out.println("Directory is deleted : "
                                                  + file.getAbsolutePath());
        	   }
    		}

    	}else{
    		//if file, then delete it
    		file.delete();
    		System.out.println("File is deleted : " + file.getAbsolutePath());
    	}
        
}
////////////////////////////////  
///////////////////////////////  
}  

