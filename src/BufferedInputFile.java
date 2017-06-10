import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferedInputFile {
	public static void main(String[] args){
//		System.out.println(testBufferedInputFile("/Users/tiankui/Downloads/BrowserDownload/log.txt"));
//		BufferedInputFile inputFile=new BufferedInputFile();
//		inputFile.testListFile();
//		testDataInputStream();
//		testWriter();
		BufferedInputFile test=new BufferedInputFile();
//		test.testWriteAndReadData();
//		test.testSystemInAndOut();
//		test.testChannel();
		test.testInternet();
	}
	
	public void testInternet(){
		try{
			InetAddress a=InetAddress.getByName(null);
			System.out.println(a);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void testChannel(){
		try{
			FileChannel fileChannel=new FileOutputStream("/Users/tiankui/Downloads/BrowserDownload/log.txt").getChannel();
			fileChannel.write(ByteBuffer.wrap("some thing".getBytes()));
			fileChannel.close();
			fileChannel=new RandomAccessFile("/Users/tiankui/Downloads/BrowserDownload/log.txt","rw").getChannel();
			fileChannel.position(fileChannel.size());
			fileChannel.write(ByteBuffer.wrap("more thing".getBytes()));
			fileChannel.close();
			fileChannel=new FileInputStream("/Users/tiankui/Downloads/BrowserDownload/log.txt").getChannel();
			ByteBuffer buffer=ByteBuffer.allocate(1024);
			fileChannel.read(buffer);
			buffer.flip();
			while(buffer.hasRemaining()){
				System.out.print((char)buffer.get());
			}
		}catch(Exception e){
			
		}
	}
	
	public void testSystemInAndOut(){
		try{
//			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
//			String s;
//			while((s=in.readLine())!=null){
//				System.out.println(s);
//			}
			PrintWriter out=new PrintWriter(System.out,true);
			out.println("yes ,this is a test");
			
		}catch(Exception e){
			
		}
	}
	public void testWriteAndReadData(){
		try{
			DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/Users/tiankui/Downloads/BrowserDownload/testWriter.txt")));
			out.writeDouble(2.500);
			out.writeUTF("I'm a handsome boy.");
			out.writeInt(2);
			out.close();
			
			DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/tiankui/Downloads/BrowserDownload/testWriter.txt")));
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			System.out.println(in.readInt());
		}catch(Exception e){
			
		}
	}
	
	public static String testBufferedInputFile(String name){
		String linedString=null;
		StringBuilder sb=new StringBuilder();
		try{
			BufferedReader in=new BufferedReader(new FileReader(name));
			while((linedString=in.readLine())!=null){
				sb.append(linedString)
				.append("\n");
			}
			in.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return sb.toString();
	}
	
	public static void testStringReader(){
		StringReader stringReader=new StringReader(testBufferedInputFile("/Users/tiankui/Downloads/BrowserDownload/log.txt"));
		int c;
		try{
			while((c=stringReader.read())!=-1){
				System.out.println((char)c);
			}
		}catch(Exception e){
			
		}
	}
	
	public static void testWriter(){
		try{
			BufferedReader in=new BufferedReader(new FileReader("/Users/tiankui/Downloads/BrowserDownload/log.txt"));
			BufferedWriter out=new BufferedWriter(new FileWriter("/Users/tiankui/Downloads/BrowserDownload/testWriter.txt"));
			String s;
			while((s=in.readLine())!=null){
				out.write(s);
			}
			out.close();
		}catch(Exception e){
			
		}
	}
	
	public static void testDataInputStream(){
		try{
			DataInputStream dataInputStream=new DataInputStream(new BufferedInputStream(new FileInputStream("/Users/tiankui/Downloads/BrowserDownload/log.txt")));
		
			while(dataInputStream.available()!=0){
				System.out.println((char)dataInputStream.readByte());
			}
		}catch(Exception e){
			
		}
		
	}
	
	public void testListFile(){
		File dirFile=new File("/Users/tiankui/Library");
//		String[] list=dirFile.list(new FilenameFilter(){
//
//			@Override
//			public boolean accept(File dir, String name) {
////				if(name.toLowerCase().startsWith("s")){
////					return true;
////				}
//				if(new File(dir.getPath()+name).isDirectory()){
//					return true;
//				}
//				return false;
//			}
//			
//		});
		File[] list=dirFile.listFiles(new FileFilter(){

			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory()){
					return true;
				}
				return false;
			}
			
		});
		
		for(int i=0;i<list.length;i++){
			System.out.println(list[i].getName());
		}
		
		System.out.println(dirFile.getAbsolutePath());
		System.out.println(dirFile.getPath());
		
		File newFile=new File("/dd/hhe.txt");
		if(!newFile.getParentFile().exists()){
			newFile.getParentFile().mkdirs();
		}
		System.out.println(newFile.getAbsolutePath());
	}

}
