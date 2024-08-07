package org.gampiot.robok.feature.template.project.model;

import androidx.annotation.DrawableRes;

public class ProjectTemplate {
	
	public String name;
	public boolean javaSupport;
	public boolean kotlinSupport;
	@DrawableRes public int imageResId;
	
	public void setName (String name) {
		this.name = name;
	}

	public void setJavaSupport (boolean javaSupport) {
		this.javaSupport = javaSupport;
	} 
	
	public void setKotlinSupport (boolean kotlinSupport) {
		this.kotlinSupport = kotlinSupport;
	}
	
	public void setImage (@DrawableRes int imageResId) {
		this.imageResId = imageResId;
	}
	
	public String getName () {
		return name;
	}
	
	public boolean isJavaSupport () {
		return javaSupport;
	}
	
	public boolean isKotlinSupport () {
		return kotlinSupport;
	}
}
