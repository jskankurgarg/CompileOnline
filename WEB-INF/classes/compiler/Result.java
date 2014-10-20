package com.compiler;

import java.io.Serializable;

public class Result implements Serializable {
	public Result(){
		exitValue=1;
		output="";
		resultStatus="";
	}
	private int exitValue;
	private String output;
	private String resultStatus;
	public int getExitValue(){
		return exitValue;
	}
	public void setExitValue(int exitValue){
		this.exitValue=exitValue;
	}
	public String getOutput(){
		return output;
	}
	public void setOutput(String Output){
		this.output=Output;
	}
	public String getResultStatus(){
		return resultStatus;
	}
	public void setResultStatus(String resultStatus){
		this.resultStatus=resultStatus;
	}
	public String toString(){
		return "--------------\n"+getResultStatus()+getOutput()+"\n--------------";
	}
}
