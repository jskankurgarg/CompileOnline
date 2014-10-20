package com.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSystem {
	public static final String compileResultFile="compile_result";
	public static final char sp=File.separatorChar;
	public static File dir = new File(".");
	public static String appRoot;
	private static String currentDir;
	static{
		try{
			currentDir=dir.getCanonicalPath();
		}catch(IOException e){
			e.printStackTrace();
		}
		appRoot=currentDir+sp+"webapps"+sp+"test";
	}
	@SuppressWarnings("finally")
	public String generateFile(String code,String fileName){
		FileOutputStream fos = null;
		try {
			String compilerDirPath=FileSystem.appRoot+sp+"compiler";
			File dir=new File(compilerDirPath);
			if(dir.isDirectory()==false){
					dir.mkdir();
			}
			File file=new File(dir,fileName);
			fos = new FileOutputStream(file);
			fos.write(code.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return fileName;
		}
	}

/*	public void generateCompilationResult(String result){
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream(compileResultFile);
			fos.write(result.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/

	/*
	 * deprecated
	 */
/*	public boolean  removeFile(String fileName) {
		// TODO Auto-generated method stub
		boolean result=false;
		File dir=new File("compiler");
		File file=new File(dir,fileName);
		System.out.println("verifying file......");
		if(file.isFile()){
			result=file.delete();
			if(result){
				System.out.println(fileName+" succesfully deleted.....");
			}else{
				System.out.println(fileName+" cannot be deleted.....");
			}
		}
		else{
			System.out.println("file does not exists.....");
		}
		return result;
	}
*/
	public void removeFiles() {
		// TODO Auto-generated method stub
		try {
			char sc=File.separatorChar;
			String target="webapps"+sc+"test"+sc+"compiler"+sc;

			final String WINDOWS_DEL_CMD="cmd /c del "+target+"*.class "+target+"Main.java "+target+"input.txt";

			System.out.println(WINDOWS_DEL_CMD);
			Process  pro=null;
			pro=Runtime.getRuntime().exec(WINDOWS_DEL_CMD);
			System.out.println("exit value : "+pro.waitFor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String...asd){
		new FileSystem().removeFiles();
	}
}
